package work2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class HashTableTest1 {

	public static void main(String[] args) {
		HashTable ht=new HashTable(15);
		//ht.put("QR", "Qatar Airways (Q.C.S.C)");
		BufferedReader inputStream =null;
		String line;
		try {
			inputStream =new BufferedReader(new FileReader("C:/algorithm/CARRIERS.txt"));
			while((line=inputStream.readLine())!=null) {
				ht.put(line.split("\t")[0], line.split("\t")[1]);
			}
			inputStream.close();
			
		}catch (IOException e) {
			System.err.println("File Error");
			System.exit(1);
		}
		Scanner s=new Scanner(System.in);
		for(int i=0;i<5;i++) {
			System.out.print("code:");
			String a=s.next();
			System.out.println(ht.get(a));
		}
	}

}
