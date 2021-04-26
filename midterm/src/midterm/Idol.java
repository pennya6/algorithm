package midterm;

import java.util.Comparator;

public class Idol {
	private String group;
	private int year;
	
	public Idol(String group, int year) {
		this.group=group;
		this.year=year;
	}
	
	public static class YearOrder implements Comparator<Idol>{
		//오버라이딩
		public int compare(Idol m1,Idol m2) {
			if(m1.year<m2.year) return -1;
			if(m1.year>m2.year) return 1;
			if(m1.year==m2.year) return m1.group.compareTo(m2.group);
			return 0;
		}
	}
	public String toString() {
		return group+"("+year+")";
	}

}
