package studentmanage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListMake{
	
	   private static List<StudentData> list = new ArrayList<>();

	   public void add(StudentData data) {
	      list.add(data);
	      System.out.println(list);
	      
	   }
	   
	   public static void sortUp(){
		   Collections.sort(list, new Comparator<StudentData>() {
				@Override
				public int compare(StudentData o1, StudentData o2) {
				return o1.getName().compareTo(o2.getName()); // ���ڿ� �������� 
				//���ڿ� �� �޼ҵ� compareTo : public int compareTo(String anotherString)
				}
			});
		   
		   System.out.println("sort : "+ list); 
	   }
	   
	   public static void getData(String inpname){
		   int choicereturn = 0;
		   //System.out.println("size��" + list.size());
		   for(int i = 0 ; i < list.size() ; i++) {
			   StudentData data = list.get(i);
			   //System.out.println("getname : " + data.getName());
			   if(data.getName().equals(inpname)) {
				   System.out.println("�Է��Ͻ� �̸��� �й� : "+ data.getNum());
				   choicereturn = 1;
			   }
		   }
		   if(choicereturn == 0)
			   System.out.println("�Է��Ͻ� �̸��� �й��� �������� �ʽ��ϴ�"); 
	   }
	   
	   public static void delete(String delname) {
		   for(int i = 0 ; i < list.size() ; i++) {
			   StudentData data = list.get(i);
			   if(data.getName().equals(delname)) {
				   System.out.println("���ŵǴ� �й��� �̸� : "+ data.getNum() +", " +data.getName() );
				   int listindex = i;
				   System.out.println("���ŵǴ� listindex : "+ listindex);
				   list.remove(listindex); //remove(index) : index�� �´� list�� ��ü�� ����
				   System.out.println("���ŵǾ����ϴ�.");
			   }
		   }
		   
	   }
	   public static int sum() {
		   for(int i = 0 ; i < list.size() ; i++) {
			   StudentData data = list.get(i);
			   System.out.println(data.getSum());
			   //data.getSum();
		   }
		return 0;
	   }
	   
	   

	   @Override
	   public String toString() {
	      return "StudentList [list=" + list + "]";
	   }
}