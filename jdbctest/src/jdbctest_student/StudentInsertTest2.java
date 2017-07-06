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
				//1. JDBC ����̹� �ε�
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//���� �����Ϸ��� �ϴ� Ŭ������ �Ű������� �Է�
					//��Ű����.Ŭ�����̸�
					System.out.println("JDBC ����̹� �ε� ����");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("JDBC ����̹� �ε� ����");
				} 
				//2. �����ͺ��̽� �������� //Connection �������̽�
				Connection con = null;//���������� ���� ������� �ݵ�� �ʱ�ȭ
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","test","1234"); //����URL,�����̸�,��й�ȣ
					//jdbc:oracle:thin:@IP:port��ȣ //SID:xe == thin
					System.out.println("�����ͺ��̽� �������� ����");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("�����ͺ��̽� �������� ����");
				}
				//3. preparedStatement ��ü ���� //preparedStatement �������̽�!!
				String sql = "insert into stuinfo values(?,?,?)";
				PreparedStatement pst = null ;
				try {
					
					pst = con.prepareStatement(sql);
					System.out.println("preparedStatement ��ü ����");
					/*pst.setString(1, "987654");
					pst.setString(2, "junjunjun");
					pst.setString(3, "��");*/
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//4. SQL�� ���� //������ ������ ���ٸ� �ڵ�commit
				int result = 0;
				try {
					Scanner sc = new Scanner(System.in);
					String snum = sc.nextLine();
					String sname = sc.nextLine();
					String sex = sc.nextLine();
					pst.setString(1, snum);
					pst.setString(2, sname);
					pst.setString(3, sex);
					result = pst.executeUpdate(); //�Ű������� ����!
					//ResultSet s = pst.executeQuery();
					System.out.println("SQL�� ���� ����");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//5. ��� ó��
				if(result == 0)
					System.out.println(" ��� ó�� ����");
				else
					System.out.println(" ��� ó�� ����");
				//6. �����ͺ��̽� ���� ���� ���� //DB������ �����ϱ� ���� �״� �͵��� ���� close���־�� �Ѵ�!
				try {
					pst.close();
					con.close();
					System.out.println(" �����ͺ��̽� ���� ���� ���� ����");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(" �����ͺ��̽� ���� ���� ���� ����");

				}
	}

}
