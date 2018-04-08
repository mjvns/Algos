import java.util.Scanner;
public class LinearSearch {
    public static void main(String args[]){
        int length;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of input:");
        length = scan.nextInt();
        int array[] = new int[length];
        System.out.println("Enter the elements one by one:");
        for(int i=0;i<length;i++){
            array[i] = scan.nextInt();
        }
        System.out.println("Enter the value that you want to search:");
        int n = scan.nextInt();

        for(int i=0;i<length;i++){
            if(array[i] == n){
                System.out.println("Element found at index:" + i);
                break;
            }
            if(i == length-1){
                System.out.println("Element not found!!");
            }
        }

    }
}
