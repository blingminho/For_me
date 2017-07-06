package jdbctest_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentInsertTest {

	public static void main(String[] args) {
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
		//3. Statement ��ü ���� //Statement �������̽�!!
		Statement st = null;
		try {
			st = con.createStatement();
			System.out.println("Statement ��ü ���� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement ��ü ���� ����");
		}
		//4. SQL�� ���� //������ ������ ���ٸ� �ڵ�commit
		int result = 0;
		Scanner sc = new Scanner(System.in);
		String snum = sc.nextLine();
		String sname = sc.nextLine();
		String sex = sc.nextLine();
		try {
			String sql = "insert into stuinfo values('" +snum+ "','"+sname+"','"+sex+"')";
			System.out.println(sql);
			result = st.executeUpdate(sql); //executeUpdate()�޼ҵ��� ��ȯ���� int�̴�!
			//insert,delete,update����� ������� ��� ���� ��������� ������ ����
			//st.executeQuery(sql);
			System.out.println(result); 
			System.out.println(" SQL�� ���� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" SQL�� ���� ����");
		}
		//5. ��� ó��
		if(result == 0)
			System.out.println(" ��� ó�� ����");
		else
			System.out.println(" ��� ó�� ����");
		//6. �����ͺ��̽� ���� ���� ���� //DB������ �����ϱ� ���� �״� �͵��� ���� close���־�� �Ѵ�!
		try {
			st.close();
			con.close();
			System.out.println(" �����ͺ��̽� ���� ���� ���� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" �����ͺ��̽� ���� ���� ���� ����");

		}
	}

}
