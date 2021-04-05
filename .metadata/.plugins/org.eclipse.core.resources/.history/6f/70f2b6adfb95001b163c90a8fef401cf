package work1;

import java.util.Comparator;

public class quickSort {
	public static int partition(Object []a,int low, int high, Comparator comparators) {
		int i=low;
		int j=high+1;
		Object x=a[low];
		while(true) {
			while(comparators.compare(a[++i],x)<0)
				if(i==high) break;
			while(comparators.compare(x,a[--j])<0)
				if(i==low) break;
			if(i>=j) break;
			int t=0;
			a[i]=t;
			a[i]=a[j];
			a[j]=t;
		}
		return j;
	}
	public static void quickSort(Object []a,int low, int high,Comparator comparators) {
		if(low>=high) return ;
		int pivot;
		pivot=partition(a,low,high,comparators);
		quickSort(a,low,pivot-1,comparators);
		quickSort(a,pivot+1,high,comparators);
	}

}
