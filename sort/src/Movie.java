
import java.util.Comparator;
public class Movie {
	 private String name;
	 private int year;
	
	public Movie(String name,int year) {
		this.name=name;
		this.year=year;
	}

	//�ڹٿ����� 
	//Object vs genertic
	//<movie> genertic <- Ÿ���� �Է�
	//�������� �������� �񱳱�
	public static class YearOrder implements Comparator<Movie>{
		//�������̵�
		public int compare(Movie m1,Movie m2) {
			if(m1.year<m2.year) return -1;
			if(m1.year>m2.year) return 1;
			return 0;
		}
	}
	public String toString() {
		return name+"("+year+")";
	}
	//��ȭ���� �����ټ� �񱳱�
	//�ڹ�   ���ڿ�1.compareTo(���ڿ�2)
	public static class NameOrder implements Comparator<Movie>{
		public int compare(Movie m1, Movie m2) {
			return m1.name.compareTo(m2.name);
		}
	}
}
