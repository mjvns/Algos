import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class div3{
	public static void main(String args[])throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		System.out.println(isMultipleof3(num));
	}
	static boolean isMultipleof3(int x) {
		int even_count = 0,odd_count = 0;
		if(x<0) {
			x = -x;
		}
		if(x == 0)
			return true;
		if(x == 1)
			return false;
		
		while(x != 0) {
			if((x&1) == 1) {
				odd_count++;
			}
			x = x>>1;
			if((x&1) == 1) {
				even_count++;
			}
			x = x>>1;
		}
		
		return isMultipleof3(even_count-odd_count);
	}
}