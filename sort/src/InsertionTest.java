
public class InsertionTest {

	public static void main(String[] args) {
		Movie[] hits = new Movie[5];
		hits[0] = new Movie("��",2014) ;
		hits[1] = new Movie("��������",2019) ;
		hits[2] = new Movie("�����",2019) ;
		hits[3] = new Movie("��������",2014) ;
		hits[4] = new Movie("�λ���",2016) ;
		System.out.println(hits[0]);
		
		//movie�� ���ǵǾ��ִ� yearorder ��ü �������
		Insertion.sort(hits,new Movie.NameOrder());
		for(Movie m:hits)
			System.out.println(m);
	}

}
