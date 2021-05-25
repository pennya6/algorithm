/*
 *  201958008 김시연
 *  ospf 구현 과제
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ospf_test1 {

	public static void main(String[] args) {
		BufferedReader inputStream = null;
		String line[] = new String[100];
		String s[] = null;
		int node_num = 0;
		int i = 0;
		try {
			inputStream = new BufferedReader(new FileReader("C:/algorithm/init.ospf.txt"));
			StringTokenizer st = new StringTokenizer(inputStream.readLine());
			node_num=Integer.parseInt(st.nextToken());
			System.out.print("노드의 개수 : ");
			System.out.println(node_num);
			System.out.println();
			System.out.println("그래프에 대한 정보  ");
			// j -> 1 2 3 4 5 6 7 
			for(int j=1;j<node_num+1;j++) {
				while((line[j]=inputStream.readLine())!=null){
					System.out.println(line[j]);
				}
			}
			inputStream.close();

		} catch (IOException e) {
			System.err.println("File Error");
			System.exit(1);
		}
	
		Graph g=new Graph(node_num);
		
		
		// i -> 1 2 3 4 5 6 7 
		// line[i] -> 1 2 3 4 5 6 7 8
		  for(i=1;i<node_num;i++) { 
			 // String[] tmp=line[i].split("  ");
			  }
		 
		
		for(int h=1;h<node_num+1;h++) {
			for(int b=0;b<node_num;b++) {
				//String[] tmp=line[b].split("  ");
				//System.out.println(tmp[b]);
			}
		
			//int tmp2[]=Integer.parseInt(tmp);
			//for(int p=1;p<node_num+1;p++) {
				//g.input(h, p, Integer.parseInt(tmp[i]));
			//}
		}
		
		//g.dijkstra(1);
	}
	
	public void change_gragh() {
		
		
	}

}
