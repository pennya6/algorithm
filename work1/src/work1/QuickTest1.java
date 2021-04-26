package work1;

import java.util.Scanner;

public class QuickTest1 {

	public static void main(String[] args) {
		movie[] hits=new movie[5];
		hits[0]=new movie("명량","김한민",2014,17615039);
		hits[1]=new movie("극한직업","이병헌",2019,16264864);
		hits[2]=new movie("기생충","봉준호",2019,10080442);
		hits[3]=new movie("국제시장","윤제균",2014,14260790);
		hits[4]=new movie("부산행","연상호",2016,11564345);
		
		System.out.println("1) 영화제목 가나다순");
		System.out.println("2) 감독 가나다순");
		System.out.println("3) 개봉연도 최신순");
		System.out.println("4) 개봉연도 오래된순");
		System.out.println("5) 관객수 오름차순");
		System.out.println("6) 관객수 내림차순");
		System.out.println("정렬기준 번호 입력 :");
		
		Scanner s=new Scanner(System.in);
		int choice=s.nextInt();
		
		switch(choice) {
		case 1: Quick.sort(hits, new movie.NameOrder());
		break;
		case 2: Quick.sort(hits, new movie.dirNameOrder());
		break;
		case 3: Quick.sort(hits, new movie.YearOrder());
		break;
		case 4: Quick.sort(hits, new movie.YearOrder2()); break;
		case 5: Quick.sort(hits, new movie.PSum()); break;
		case 6: Quick.sort(hits, new movie.PSum2()); break;
		}
		for(movie m:hits)
			System.out.println(m);
	}

}
