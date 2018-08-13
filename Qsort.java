class Qsort{
    static int array[] = {1,1,1,1,1};
    public static void main(String args[]){
        int start = 0;
        int end = array.length - 1;
        quicksort(array,start,end);
        System.out.println("The sorted list is:");
        for (int a: array) {
            System.out.print(a+" ");
        }
    }

    static int partition(int array[], int start, int end){
        int pivot = array[start];
        int x = end;
        int right = end+1;
        while(x>start){
            if(pivot<array[x]){
                right--;
                int temp = array[x];
                array[x] = array[right];
                array[right] = temp;
            }
            x--;
        }
        int temp = array[start];
        array[start] = array[right-1];
        array[right-1] = temp;
        return right-1;
    }

    static void quicksort(int array[], int start, int end){
        if(start>=end)
            return;
        int i = partition(array, start, end);
        quicksort(array, start, i-1);
        quicksort(array, i+1, end);
    }
}