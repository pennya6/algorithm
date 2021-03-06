package work1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import work1.movie.NameOrder;

public class quickSortTest {

	public static void main(String[] args) throws IOException, FileNotFoundException,ArrayStoreException {
		String str;
		BufferedReader in=new BufferedReader(new FileReader("C:/algorithm/movie.txt"));
		int n=0;
		ArrayList<String> list = new ArrayList();
		while((str=in.readLine())!=null) {
			n++;
			list.add(str);
		}
		movie[] hits=new movie[n];
		for(int i=0;i<n;i++) {
			String tok=list.get(i);
			String []token=tok.split("	");
			//System.out.println(token[0]);
			//System.out.println(token[1]);
			//System.out.println(token[2]);
			//System.out.println(token[3]);
			hits[i]=new movie(token[0],token[1],Integer.parseInt(token[2]),Integer.parseInt(token[3]));	

		}
		//for(int i=0;i<n;i++) {
			//System.out.println(hits[i]);
		//}
		//quickSort.quickSort(hits, 0, hits.length-1, new movie.NameOrder());
		//Insertion.sort(hits, new movie.NameOrder());
		//Insertion.sort(hits, new movie.dirNameOrder());
		//Insertion.sort(hits, new movie.YearOrder());
		//Insertion.sort(hits, new movie.YearOrder2());
		//Insertion.sort(hits, new movie.PSum());
		Insertion.sort(hits, new movie.PSum2());
		for(movie m:hits)
			System.out.println(m);	
		in.close();
	}
}
