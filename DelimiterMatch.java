import java.util.Scanner;
class DelimiterMatch{
    public static void main(String args[]){
        int i;
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        Stack stk = new Stack(str.length());

        for(i=0;i<str.length();i++){
            if(str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '('){
                stk.push(str.charAt(i));
            }
            if(str.charAt(i) == ']' || str.charAt(i) == '}' || str.charAt(i) == ')'){
               char c = (char)stk.pop();
               if(str.charAt(i) == ']' && c!='['){
                   System.out.println("Parenthesis match failed "+']');
               }else if(str.charAt(i) == '}' && c!='{'){
                   System.out.println("Parenthesis match failed "+'}');
               }else if(str.charAt(i) == ')' && c!='('){
                   System.out.println("Parenthesis match failed "+')');
               }
            }
        }
        if(i == str.length()){
        if(!stk.isEmpty()){
            System.out.println("Error in matching parenthesis "+(char)stk.pop());
        }else{
            System.out.println("All the parenthesis have been matched successfully!!");
        }}
    }
}