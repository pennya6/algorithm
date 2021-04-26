package work1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class QuickTest2 {

	public static void main(String[] args) {
		BufferedReader inputStream=null;
		String line[]=new String[100];
		int i=0;
		try {
			inputStream =new BufferedReader(new FileReader("C:/algorithm/movie.txt"));
			while((line[i]=inputStream.readLine())!=null) {
				i++;
			}
			inputStream.close();
		}catch(IOException e) {
			System.err.println("FileError!");
			System.exit(1);
		}
		int n=i;
		movie[] hits=new movie[n];
		for(i=0;i<n;i++) {
			String[] tmp=line[i].split("\t");
			hits[i]=new movie(tmp[0],tmp[1],Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]));
		}
		System.out.println(i);
		System.out.println("1)영화제목 가나다순");
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
