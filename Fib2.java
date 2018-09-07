import java.util.Scanner;
public class Fib2 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number:");
		int n = scan.nextInt();
		while(n<1) {
			System.out.println("Enter any value: ");
			n = scan.nextInt();
		}
		long result;
		long memo[] = new long[n+1];
		scan.close();
		result = fib(n,memo);
		System.out.println("Fibonacci("+n+"): "+result);
	}

	static long fib(int n, long memo[]) {
		long result;
		if(memo[n]!=0L) {
			return memo[n];
		}else {
			if(n == 1) {
				result = 0L;
			}else if(n == 2) {
				result = 1L;
			}else {
				result = fib(n-1,memo)+fib(n-2,memo);
			}
		} 
		memo[n] = result;
		return result;
	}
}
