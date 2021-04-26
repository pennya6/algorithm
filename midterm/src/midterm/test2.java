package midterm;

public class test2 {

	public static void main(String[] args) {
		Idol[] hits=new Idol[10];
		hits[0]=new Idol("BTS",2013 );
		hits[1]=new Idol("ATEEZ", 2018);
		hits[2]=new Idol("EXO", 2012);
		hits[3]=new Idol("SEVENTEEN", 2015);
		hits[4]=new Idol("STRAY KIDS",2017 );
		hits[5]=new Idol("TXT",2019 );
		hits[6]=new Idol("BLACKPINK", 2016);
		hits[7]=new Idol("TWICE", 2015);
		hits[8]=new Idol("ITZY", 2019);
		hits[9]=new Idol("OMYGIRL",2015 );
	
		
		System.out.println("데뷔연도순 정렬");
		Insertion.sort(hits, new Idol.YearOrder());
		for(Idol m:hits)
			System.out.println(m);

	}

}
