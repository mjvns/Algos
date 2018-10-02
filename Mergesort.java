import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class Mergesort {
	public static void main(String args[]) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(bf.readLine());
		int array[] = new int[len];
		for(int q=0;q<len;q++) {
			array[q] = Integer.parseInt(bf.readLine());
		}
		Mergesort m = new Mergesort();
		m.mergeSort(array,0,len-1);
		for(int q=0;q<len;q++) {
			System.out.println(array[q]);
		}
	}
	
	void mergeSort(int a[], int low, int high) {
		if(low == high)
			return;
		int mid = (high+low)/2;
		mergeSort(a,low,mid);
		mergeSort(a,mid+1,high);
		merge(a,low,mid,high);
	}
	
	void merge(int a[],int low,int mid,int high) {
		int left = mid-low+1;
		int right = high-mid;
		int l[] = new int[left];
		int r[] = new int[right];
		for(int i=0;i<left;i++) {
			l[i] = a[low+i];
		}
		for(int i=0;i<right;i++) {
			r[i] = a[mid+1+i];
		}
		
		int k=low;
		int y=0,z=0;
		
		while(y<left && z<right) {
			if(l[y]<r[z]) {
				a[k++] = l[y++];
			}else {
				a[k++] = r[z++];
			}
		}
		
		while(y<left) {
			a[k++] = l[y++];
		}
		
		while(z<right) {
			a[k++] = r[z++];
		}
		
	}
}
