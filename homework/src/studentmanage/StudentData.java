package studentmanage;


public class StudentData /*implements Comparable<StudentData>*/{
	///필드선언 및 게터와 세터
	private int num;
	private String name;
	private int kor;
	private int math;
	private int eng;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSum() {
		int sum = this.kor+this.math+this.eng;
		return sum;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	   
	   public StudentData(int num, String name ,int kor, int eng, int math) {
	      super();
	      this.num = num;
	      this.name = name;
	      this.kor = kor;
	      this.eng = eng;
	      this.math = math;
	   }
	   

	   
	   @Override
	   public String toString() {
		   return "StudentData [num=" + num + ", name=" + name + ", kor=" + kor + ", math=" + math + ", eng=" + eng + "]";
	   }
	@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			StudentData other = (StudentData) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		
	   
	   /*@Override
		public int compareTo(StudentData o) {
		   
			return o.name;
		}*/
	   

}