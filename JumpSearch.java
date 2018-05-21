class JumpSearch {
    void search(int val,int a[]){
        int i,min,prev=0;
        int block = (int)Math.floor(Math.sqrt(a.length));
        for(i=0;i<a.length;i+=block){
            prev = i;
            if(a[i]>=val){
                min = (int)Math.min(block,i);
                for(int j=i;j>=i-min;j--){
                    if(a[j] == val){
                        System.out.println("Element found at index "+j);
                        return;
                    }
                }
            }
        }
        for(i=a.length-1;i>prev;i--){
            if(a[i] == val){
                System.out.println("Element found at index "+i);
                return;
            }
        }
        System.out.println("Element does not exist.");
    }
    public static void main(String args[]){
       int array[] = new int[36];
       for(int i=0;i<36;i++){
           array[i] = i;
       }
       JumpSearch obj = new JumpSearch();
       obj.search(13,array);
    }
}
