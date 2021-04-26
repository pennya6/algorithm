package midterm;

public class Mcss {
	private static int bruteForce1(int []a) {
		int n=a.length;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int sum=0;
				for(int k=i;k<=j;k++)
					sum+=a[k];
				if(sum>max)
					max=sum;
			}
		}
		return max;
	}
	private static int max3(int x,int y,int z) {
		return Math.min(Math.min(x, y),z);
	}
	private static int dc_rec(int [] a,int low,int high) {
		int left_sum,right_sum,two_sided_sum;
		int mid,sum,lsum,rsum;
		
		if(low==high) return a[low];
		mid=(low+high)/2;
		
		left_sum=dc_rec(a, low, mid);
		right_sum=dc_rec(a, mid+1, high);
		
		lsum=sum=a[mid];
		for(int i=mid-1;i>=low;--i) {
			sum+=a[i];
			if(sum<lsum) lsum=sum;
		}
		rsum=sum=a[mid+1];
		for(int j=mid+2;j<=high;j++) {
			sum+=a[j];
			if(sum<rsum) rsum=sum;
		}
		two_sided_sum=lsum+rsum;
		
		return max3(left_sum,right_sum,two_sided_sum);
	}
	private static int divideConquer(int [] a) {
		return dc_rec(a, 0, a.length-1);
	}
	public static void main(String[] args) {
		int score[]= {1,0,-1,2,0,-1,-1,3,1,2,0,2,-1,0,-2,-1,0,1};
		System.out.println(Mcss.divideConquer(score));

	}

}
