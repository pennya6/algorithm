package work1;
//?ٽ? ?Ұ? 
public class six_c {
	public int max(int a,int b,int c) {
		int m=a;
		if(a<b) m=b;
		if(b>c) m=b;
		if(a<c)m=c;
		return m;
	}
	public int mcss_rec(int low, int high) {
		int a[] = new int[] {};
		int left_sum=0;
		int right_sum=0;
		int two_sided_sum=0;
		if(low==high) return a[low];
		int mid = 0;
		mid=(mid+high)/2;
		left_sum=mcss_rec(low,mid);
		right_sum=mcss_rec(mid+1, high);
		
		int lsum=0;
		int sum=0;
		lsum=sum=a[mid];
		for(int i=mid-1;i>mid;i--) {
			sum+=a[i];
			if(sum>lsum) lsum=sum;
		}
		int rsum=0;
		rsum=sum=a[mid];
		for(int i=mid+1;i<high;i++) {
			sum+=a[i];
			if(sum<rsum) rsum=sum;
		}
		two_sided_sum=lsum+rsum;
		return max(left_sum,right_sum,two_sided_sum);
	}
}
