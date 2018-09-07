import java.util.Scanner;
public class Fib3 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while(n<1) {
			System.out.println("Invalid Entry, please enter a valid one:");
			n = scan.nextInt();
		}
		long memo[] = new long[n+1];
		memo = generatememo(n+1);
		System.out.println("Fibonacci("+n+") :"+memo[n]);
		scan.close();
	}

	static long[] generatememo(int i) {
		long array[] = new long[i+1];
		array[1] = 0L;
		array[2] = 1L;
		for(int j=3;j<i+1;j++) {
			array[j] = array[j-1]+array[j-2];
		}
		return array;
	}
}
