import java.util.Scanner;
public class Fib4 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = scan.nextInt();
		long result = multiply(n-1);
		System.out.println("Fibonacci("+n+") :"+result);
		scan.close();
	}
	static long multiply(int x) {
		if(x == 1) {
			return 0L;
		}
		long array[][] = new long[2][2];
		array[0][0] = 1;
		array[0][1] = 1;
		array[1][0] = 0;
		array[1][1] = 1;
		for(int i=1;i<x;i++) {
			long a = 1*array[0][0]+1*array[1][0];
			long b = 1*array[0][1]+1*array[1][1];
			long c = 1*array[0][0]+0*array[1][0];
			long d = 1*array[0][1]+0*array[1][1];
			array[0][0] = a;
			array[0][1] = b;
			array[1][0] = c;
			array[1][1] = d;
		}
		return array[0][0];
	}
}
