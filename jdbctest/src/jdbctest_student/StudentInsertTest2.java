package jdbctest_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentInsertTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
				//3. preparedStatement 객체 생성 //preparedStatement 인터페이스!!
				String sql = "insert into stuinfo values(?,?,?)";
				PreparedStatement pst = null ;
				try {
					
					pst = con.prepareStatement(sql);
					System.out.println("preparedStatement 객체 생성");
					/*pst.setString(1, "987654");
					pst.setString(2, "junjunjun");
					pst.setString(3, "여");*/
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//4. SQL문 전송 //별도의 설정이 없다면 자동commit
				int result = 0;
				try {
					Scanner sc = new Scanner(System.in);
					String snum = sc.nextLine();
					String sname = sc.nextLine();
					String sex = sc.nextLine();
					pst.setString(1, snum);
					pst.setString(2, sname);
					pst.setString(3, sex);
					result = pst.executeUpdate(); //매개변수가 없다!
					//ResultSet s = pst.executeQuery();
					System.out.println("SQL문 전송 성공");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//5. 결과 처리
				if(result == 0)
					System.out.println(" 결과 처리 실패");
				else
					System.out.println(" 결과 처리 성공");
				//6. 데이터베이스 서버 연결 해제 //DB서버를 관리하기 위해 켰던 것들은 전부 close해주어야 한다!
				try {
					pst.close();
					con.close();
					System.out.println(" 데이터베이스 서버 연결 해제 성공");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(" 데이터베이스 서버 연결 해제 실패");

				}
	}

}
