package studentmanage;
import java.util.Scanner;


public class StudentManegeTest {

	 public static void main(String[] args) {
	      // TODO Auto-generated method stub
		 
	       Scanner sc = new Scanner(System.in);
	       ListMake list = new ListMake();
	       
	       
	       while(true) {
	    	   System.out.println("1. 학생 정보 추가");
	    	   System.out.println("2. 학생 정보 출력");
	    	   System.out.println("3. 종료");
	    	   System.out.println("4. 학생검색");
	    	   System.out.println("5. 학생 정보 제거");
	    	   System.out.println("6. 전체 총점");
	    	   System.out.println("7. 최고 점수");
	    	   System.out.println("8. 최저 점수");
	    	   System.out.println("숫자를 입력해주세요");
	    	   String message = sc.nextLine();

	    	   if(message.equals("1")) {
	    		   
	    		   System.out.println("학번,이름,국어,영어,수학 성적을 입력하세요");
	    		   StudentData data = new StudentData(Integer.parseInt(sc.nextLine()),sc.nextLine(),Integer.parseInt(sc.nextLine()),Integer.parseInt(sc.nextLine()),Integer.parseInt(sc.nextLine()));
	    		   //System.out.println(data);
	    		   list.add(data);
	    		   System.out.println("list값 : "+list);
	    	   }
	    	   else if(message.equals("2")) {
	    		   ListMake.sortUp();
	    		   //StudentData.compareTo(list);

	    	   }
	    	   else if(message.equals("3")) {
	    		   System.out.println("끝!!");
	    		   System.exit(0);
	    	   }
	    	   else if(message.equals("4")) {
	    		   System.out.println("찾고자하는 이름을 입력하세요");
	    		   String serchname = sc.nextLine();
	    		   ListMake.getData(serchname);
	    	   }
	    	   
	    	   else if(message.equals("5")) {
	    		   System.out.println("지우고자 하는 이름을 입력하세요");
	    		   String delname = sc.nextLine();
	    		   ListMake.delete(delname);
	    	   }
	    	   else if(message.equals("6")) { //전체 총점
	    		   System.out.println("전체 학생의 국영수 전체 총점은");
	    		   ListMake.sum();//한 학생의 총점
	    	   }
	    	   
	    	   else if(message.equals("7")) { //최고점수
	    		   System.out.println("국영수 총점이 제일 높은 사람은");
	    		   
	    	   }
	    	   
	    	   else if(message.equals("8")) { //최저점수
	    		   System.out.println("국영수 총점이 제일 낮은 사람은");
	    		   
	    	   }
	    	   else
	    		   System.out.println("잘못입력!!");
	       }
	 }
}


	/*List<Student> list = new ArrayList<>();

	for(int i=0;i<4;i++) {
	    Student a= new Student(Integer.parseInt(sc.nextLine()),sc.nextLine());
	    list.add(a);
	    System.out.println("list값3 : "+list);
	    //System.out.println(list.hashCode());
	}*/