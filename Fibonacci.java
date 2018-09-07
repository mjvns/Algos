import java.util.Scanner;
class Fibonacci {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = scan.nextInt();
		System.out.printf("fibonacci("+n+") :"+fib(n));
		scan.close();
	}

	static long fib(int n) {
		if(n == 1) {
			return 0L;
		}else if(n == 2) {
			return 1L;
		}else {
			return fib(n-1)+fib(n-2);
		}
	}
}
