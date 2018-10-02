import java.util.Scanner;
class permutate {
	int count = 0;
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		char sarray[] = s.toCharArray();
		permutate p = new permutate();
		p.permutate(sarray,0,s.length()-1);
		System.out.println(p.count);
	}

	void permutate(char sarray[],int i,int j) {
		if(i>j) {
			for(char x:sarray) {
				System.out.print(Character.toString(x));
			}
			count++;
			System.out.println();
			return;
		}
			for(int b=i;b<=j;b++) {
				char c = sarray[i];
				sarray[i] = sarray[b];
				sarray[b] = c;
				permutate(sarray,i+1,j);
				c = sarray[i];
				sarray[i] = sarray[b];
				sarray[b] = c; 
			}
	}
}
