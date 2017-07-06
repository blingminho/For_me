package jdbctest_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentInsertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. JDBC 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//내가 연결하려고 하는 클래스를 매개변수로 입력
			//패키지명.클래스이름
			System.out.println("JDBC 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBC 드라이버 로드 실패");
		} 
		//2. 데이터베이스 서버연결 //Connection 인터페이스
		Connection con = null;//지역변수로 선언만 했을경우 반드시 초기화
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","test","1234"); //연결URL,계정이름,비밀번호
			//jdbc:oracle:thin:@IP:port번호 //SID:xe == thin
			System.out.println("데이터베이스 서버연결 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("데이터베이스 서버연결 실패");
		}
		//3. Statement 객체 생성 //Statement 인터페이스!!
		Statement st = null;
		try {
			st = con.createStatement();
			System.out.println("Statement 객체 생성 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement 객체 생성 실패");
		}
		//4. SQL문 전송 //별도의 설정이 없다면 자동commit
		int result = 0;
		Scanner sc = new Scanner(System.in);
		String snum = sc.nextLine();
		String sname = sc.nextLine();
		String sex = sc.nextLine();
		try {
			String sql = "insert into stuinfo values('" +snum+ "','"+sname+"','"+sex+"')";
			System.out.println(sql);
			result = st.executeUpdate(sql); //executeUpdate()메소드의 반환형은 int이다!
			//insert,delete,update실행시 결과값이 몇개의 행이 진행됬는지 나오기 때문
			//st.executeQuery(sql);
			System.out.println(result); 
			System.out.println(" SQL문 전송 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" SQL문 전송 실패");
		}
		//5. 결과 처리
		if(result == 0)
			System.out.println(" 결과 처리 실패");
		else
			System.out.println(" 결과 처리 성공");
		//6. 데이터베이스 서버 연결 해제 //DB서버를 관리하기 위해 켰던 것들은 전부 close해주어야 한다!
		try {
			st.close();
			con.close();
			System.out.println(" 데이터베이스 서버 연결 해제 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" 데이터베이스 서버 연결 해제 실패");

		}
	}

}
