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
		//1. JDBC ����̹� �ε�
		Connection con = null;
		PreparedStatement pst = null ;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC ����̹� �ε� ����");
			//2. �����ͺ��̽� �������� //Connection �������̽�
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","test","1234");
			System.out.println("�����ͺ��̽� �������� ����");
			String sql = "insert into takeclass values(?,?,?,default)";
			pst = con.prepareStatement(sql);
			System.out.println("preparedStatement ��ü ����");
			int result = 0;
			Scanner sc = new Scanner(System.in);
			String snum = sc.nextLine();
			String subjuectcode = sc.nextLine();
			int grade = Integer.parseInt(sc.nextLine());
			pst.setString(1, snum);
			pst.setString(2, subjuectcode);
			pst.setInt(3, grade);
			result = pst.executeUpdate(); //�Ű������� ����!
			//ResultSet s = pst.executeQuery();
			System.out.println("SQL�� ���� ����");
			if(result == 0)
				System.out.println(" ��� ó�� ����");
			else
				System.out.println(" ��� ó�� ����");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JDBC ����̹� �ε� ����");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�����ͺ��̽� �������� ����");
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
