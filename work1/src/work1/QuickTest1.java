package work1;

import java.util.Scanner;

public class QuickTest1 {

	public static void main(String[] args) {
		movie[] hits=new movie[5];
		hits[0]=new movie("��","���ѹ�",2014,17615039);
		hits[1]=new movie("��������","�̺���",2019,16264864);
		hits[2]=new movie("�����","����ȣ",2019,10080442);
		hits[3]=new movie("��������","������",2014,14260790);
		hits[4]=new movie("�λ���","����ȣ",2016,11564345);
		
		System.out.println("1) ��ȭ���� �����ټ�");
		System.out.println("2) ���� �����ټ�");
		System.out.println("3) �������� �ֽż�");
		System.out.println("4) �������� �����ȼ�");
		System.out.println("5) ������ ��������");
		System.out.println("6) ������ ��������");
		System.out.println("���ı��� ��ȣ �Է� :");
		
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
