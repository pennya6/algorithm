package work1;

public class six {

	public int mcss_bfs(int a[],int n) {
		int max=0;
		int sum=0;
		
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				sum+=(int)a[i];
				if(sum>max) max=sum;
			}
		}
		return max;
	}

}
