package midterm;

public class test1 {

	public static void main(String[] args) {
		
		System.out.println(S(10,5));
	}
	static int S(int n, int m) {
		if(n==m || m==1) return 1;
		return S(n-1,m-1)+m*S(n-1,m);
	}

}
