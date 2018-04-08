import java.util.Scanner;
public class BinarySearch {
    public static void main(String args[]){
        int length;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of input:");
        length = scan.nextInt();
        int array[] = new int[length];
        System.out.println("Enter the elements in sorted order one by one:");
        for(int i=0;i<length;i++){
            array[i] = scan.nextInt();
        }
        System.out.println("Enter the value that you want to search:");
        int n = scan.nextInt();
        BinarySearch obj = new BinarySearch();
        obj.binsearch(array,n,0,length-1);
    }

    void binsearch(int array[],int n,int low,int high){
        if(low>high) {
            System.out.println("Element not found!!");
            return;
        }
        int mid =low + (high-low)/2;
        int val = array[mid];
        if(val == n){
            System.out.println("Element found at index: "+mid);
        }else{
            if(val>n){
                high = mid-1;
            }else{
                low = mid+1;
            }
            binsearch(array,n,low,high);
        }
    }
}
