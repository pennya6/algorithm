
import java.util.Comparator;
public class Movie {
	 private String name;
	 private int year;
	
	public Movie(String name,int year) {
		this.name=name;
		this.year=year;
	}

	//자바에서는 
	//Object vs genertic
	//<movie> genertic <- 타입형 입력
	//개봉연도 오름차순 비교기
	public static class YearOrder implements Comparator<Movie>{
		//오버라이딩
		public int compare(Movie m1,Movie m2) {
			if(m1.year<m2.year) return -1;
			if(m1.year>m2.year) return 1;
			return 0;
		}
	}
	public String toString() {
		return name+"("+year+")";
	}
	//영화제목 가나다순 비교기
	//자바   문자열1.compareTo(문자열2)
	public static class NameOrder implements Comparator<Movie>{
		public int compare(Movie m1, Movie m2) {
			return m1.name.compareTo(m2.name);
		}
	}
}
