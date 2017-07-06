package jdbctest_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TakeClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. JDBC 드라이버 로드
		Connection con = null;
		PreparedStatement pst = null ;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로드 성공");
			//2. 데이터베이스 서버연결 //Connection 인터페이스
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","test","1234");
			System.out.println("데이터베이스 서버연결 성공");
			String sql = "insert into takeclass values(?,?,?,default)";
			pst = con.prepareStatement(sql);
			System.out.println("preparedStatement 객체 생성");
			int result = 0;
			Scanner sc = new Scanner(System.in);
			String snum = sc.nextLine();
			String subjuectcode = sc.nextLine();
			int grade = Integer.parseInt(sc.nextLine());
			pst.setString(1, snum);
			pst.setString(2, subjuectcode);
			pst.setInt(3, grade);
			result = pst.executeUpdate(); //매개변수가 없다!
			//ResultSet s = pst.executeQuery();
			System.out.println("SQL문 전송 성공");
			if(result == 0)
				System.out.println(" 결과 처리 실패");
			else
				System.out.println(" 결과 처리 성공");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBC 드라이버 로드 실패");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("데이터베이스 서버연결 실패");
		}
		finally {
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}
	}
}
