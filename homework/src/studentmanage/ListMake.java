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
				return o1.getName().compareTo(o2.getName()); // 문자열 오름차순 
				//문자열 비교 메소드 compareTo : public int compareTo(String anotherString)
				}
			});
		   
		   System.out.println("sort : "+ list); 
	   }
	   
	   public static void getData(String inpname){
		   int choicereturn = 0;
		   //System.out.println("size값" + list.size());
		   for(int i = 0 ; i < list.size() ; i++) {
			   StudentData data = list.get(i);
			   //System.out.println("getname : " + data.getName());
			   if(data.getName().equals(inpname)) {
				   System.out.println("입력하신 이름의 학번 : "+ data.getNum());
				   choicereturn = 1;
			   }
		   }
		   if(choicereturn == 0)
			   System.out.println("입력하신 이름의 학번이 존재하지 않습니다"); 
	   }
	   
	   public static void delete(String delname) {
		   for(int i = 0 ; i < list.size() ; i++) {
			   StudentData data = list.get(i);
			   if(data.getName().equals(delname)) {
				   System.out.println("제거되는 학번과 이름 : "+ data.getNum() +", " +data.getName() );
				   int listindex = i;
				   System.out.println("제거되는 listindex : "+ listindex);
				   list.remove(listindex); //remove(index) : index에 맞는 list의 객체값 제거
				   System.out.println("제거되었습니다.");
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