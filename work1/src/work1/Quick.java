package work1;

import java.util.Comparator;

public class Quick {
	private static void swap(Object[] a, int i, int j) {
		Object tmp=a[i];
		a[i]=a[j];
		a[j]=tmp;
	}
	private static int partition(Object[] a, int low,int high, Comparator comparator) {
		int i=low, j=high+1;
		while(true) {
			while(comparator.compare(a[++i], a[low])<0) {
				if(i==high) break;
			}
			while(comparator.compare(a[low], a[--j])<0) {
				if(j==low) break;
			}
			if(i>=j) break;
			swap(a,i,j);
		}
		swap(a,low,j);
		return j;
	}
	
	public static void sort(Object[] a, int low, int high, Comparator comparator) {
		if(low>=high) return;
		int pivot=partition(a,low,high,comparator);
		sort(a,low,pivot-1,comparator);
		sort(a,pivot+1,high,comparator);
	}
	public static <T> void sort(Object[] a, Comparator comparator) {
		sort(a,0,a.length-1,comparator);
	}

}
