
public class InsertionTest {

	public static void main(String[] args) {
		Movie[] hits = new Movie[5];
		hits[0] = new Movie("명량",2014) ;
		hits[1] = new Movie("극한직업",2019) ;
		hits[2] = new Movie("기생충",2019) ;
		hits[3] = new Movie("국제시장",2014) ;
		hits[4] = new Movie("부산행",2016) ;
		System.out.println(hits[0]);
		
		//movie에 정의되어있는 yearorder 객체 만들어줌
		Insertion.sort(hits,new Movie.NameOrder());
		for(Movie m:hits)
			System.out.println(m);
	}

}
