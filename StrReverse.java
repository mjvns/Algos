import java.util.Scanner;
class StrReverse {
    private int maxSize;
    private int top;
    private char StackArray[];

    StrReverse(int size){
        maxSize = size;
        StackArray = new char[size];
        top = -1;
    }

    public void push(char data){
        if(!isFull()) {
            StackArray[++top] = data;
        }else{
            System.out.println("Stack is out of space.\nRemove some items.");
        }
    }

    public char pop(){
        if(isEmpty()){
            System.out.println("Stack is already empty!!");
            return '\0';
        }
        return StackArray[top--];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == StackArray.length-1;
    }

    public void display(){
        System.out.println("Reverse string is:");
        while(!isEmpty()){
            System.out.printf("%s", pop());
        }
    }

    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your String:");
        String str = scan.nextLine();
        int size = str.length();

        StrReverse strev = new StrReverse(size);

        for(int i=0;i<size;i++){
            strev.push(str.charAt(i));
        }
        strev.display();
    }
}
