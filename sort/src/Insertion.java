import java.util.Comparator;

public class Insertion {
	public static void sort(Object []a,Comparator comparator) {
		int n=a.length;
		for(int i=1;i<n;i++) {
			Object x=a[i];
			int j=i-1;
			while(j>=0 && comparator.compare(a[j], x)>0) {
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=x;
		}
	}

}
