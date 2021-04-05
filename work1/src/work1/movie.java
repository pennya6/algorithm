//201958008 ��ÿ�
//�������� �̿��� movie.txt ����
package work1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

public class movie {
	
		 private String name;
		 private String dir;
		 private int year;
		 private int sum_p;
		
		public movie(String name,String dir,int year,int sum_p) {
			this.name=name;
			this.dir=dir;
			this.year=year;
			this.sum_p=sum_p;
		}
		public String toString() {
			return name+"("+dir+"/"+year+"/"+sum_p+")";
		}
		//��ȭ���� �����ټ� ��
		public static class NameOrder implements Comparator<movie>{
			public int compare(movie i1, movie i2) {
				return i1.name.compareTo(i2.name);
			}
		}
		//��ȭ���� �����ټ� ��
		public static class dirNameOrder implements Comparator<movie>{
			public int compare(movie i1,movie i2) {
				return i1.dir.compareTo(i2.dir);
			}
		}
		//�������� �ֽż�
		public static class YearOrder implements Comparator<movie>{
			public int compare(movie i1,movie i2) {
				if(i1.year>i2.year) return -1;
				if(i1.year<i2.year) return 1;
				return 0;
			}
		}
		//������ ��������
		public static class PSum implements Comparator<movie>{
			public int compare(movie i1, movie i2) {
				if(i1.sum_p<i2.sum_p) return -1;
				if(i1.sum_p>i2.sum_p) return 1;
				return 0;
			}
		}
		//������ ��������
		public static class PSum2 implements Comparator<movie>{
			public int compare(movie i1, movie i2) {
				if(i1.sum_p>i2.sum_p) return -1;
				if(i1.sum_p<i2.sum_p) return 1;
				return 0;
			}
		}
	}
	
	
    
	

