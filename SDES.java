import java.util.Scanner;
public class SDES {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int key[] = new int[10];
        int plaintext[] = new int[8];

        System.out.println("Enter the plaintext:");
        for(int i=0;i<8;i++){
            plaintext[i] = scan.nextInt();
        }

        for(int i=0;i<1024;i++){
            String x = Integer.toBinaryString(i);
            int len  = x.length();
            int diff = 10-len;
            for(int j=0;j<diff;j++){
                key[j] = 0;
            }
            for(int j=0;j<len;j++){
                key[diff++] = Character.getNumericValue(x.charAt(j));
            }

            applyDES(plaintext,key);
        }
    }

    public static void applyDES(int p[],int k[]){
        int leftpart[] = new int[5];
        int rightpart[] = new int[5];
        int leftshift[] = new int[5];
        int rightshift[] = new int[5];
        int ls2left[] = new int[5];
        int ls2right[] = new int[5];
        int combined[] = new int[10];
        int combined2[] = new int[10];
        int key1[] = new int[8];
        int key2[] = new int[8];
        int p10[] = new int[10];
        int ip[] = new int[8];
        int ep[] = new int[8];
        int step1[] = new int[8];
        int combinedtupple[] = new int[4];
        int p4tuple[] = new int[4];
        int firstoutput[] = new int[4];
        int firstfinal[] = new int[8];

        p10[0] = k[2];
        p10[1] = k[4];
        p10[2] = k[1];
        p10[3] = k[6];
        p10[4] = k[3];
        p10[5] = k[9];
        p10[6] = k[0];
        p10[7] = k[8];
        p10[8] = k[7];
        p10[9] = k[5];

        for(int x=0;x<5;x++){
            leftpart[x] = p10[x];
        }
        for(int x=5;x<10;x++){
            rightpart[x-5] = p10[x];
        }

        leftshift[0] = leftpart[1];
        leftshift[1] = leftpart[2];
        leftshift[2] = leftpart[3];
        leftshift[3] = leftpart[4];
        leftshift[4] = leftpart[0];
        rightshift[0] = rightpart[1];
        rightshift[1] = rightpart[2];
        rightshift[2] = rightpart[3];
        rightshift[3] = rightpart[4];
        rightshift[4] = rightpart[0];

        combined[0] = leftshift[0];
        combined[1] = leftshift[1];
        combined[2] = leftshift[2];
        combined[3] = leftshift[3];
        combined[4] = leftshift[4];
        combined[5] = rightshift[0];
        combined[6] = rightshift[1];
        combined[7] = rightshift[2];
        combined[8] = rightshift[3];
        combined[9] = rightshift[4];

        key1[0] = combined[5];
        key1[1] = combined[2];
        key1[2] = combined[6];
        key1[3] = combined[3];
        key1[4] = combined[7];
        key1[5] = combined[4];
        key1[6] = combined[9];
        key1[7] = combined[8];

        ls2left[0] = combined[2];
        ls2left[1] = combined[3];
        ls2left[2] = combined[4];
        ls2left[3] = combined[0];
        ls2left[4] = combined[1];
        ls2right[0] = combined[7];
        ls2right[1] = combined[8];
        ls2right[2] = combined[9];
        ls2right[3] = combined[5];
        ls2right[4] = combined[6];

        combined2[0] = ls2left[0];
        combined2[1] = ls2left[1];
        combined2[2] = ls2left[2];
        combined2[3] = ls2left[3];
        combined2[4] = ls2left[4];
        combined2[5] = ls2right[0];
        combined2[6] = ls2right[1];
        combined2[7] = ls2right[2];
        combined2[8] = ls2right[3];
        combined2[9] = ls2right[4];

        key2[0] = combined2[5];
        key2[1] = combined2[2];
        key2[2] = combined2[6];
        key2[3] = combined2[3];
        key2[4] = combined2[7];
        key2[5] = combined2[4];
        key2[6] = combined2[9];
        key2[7] = combined2[8];


        ip[0] = p[1];
        ip[1] = p[5];
        ip[2] = p[2];
        ip[3] = p[0];
        ip[4] = p[3];
        ip[5] = p[7];
        ip[6] = p[4];
        ip[7] = p[6];

        ep[0] = ip[7];
        ep[1] = ip[4];
        ep[2] = ip[5];
        ep[3] = ip[6];
        ep[4] = ip[5];
        ep[5] = ip[6];
        ep[6] = ip[7];
        ep[7] = ip[4];

        for(int a=0;a<8;a++){
            step1[a] = (ep[a] == key1[a])?0:1;
        }

        int s0[][] = new int[4][4];
        int s1[][] = new int[4][4];

        s0[0][0] = 1;
        s0[0][1] = 0;
        s0[0][2] = 3;
        s0[0][3] = 2;
        s0[1][0] = 3;
        s0[1][1] = 2;
        s0[1][2] = 1;
        s0[1][3] = 0;
        s0[2][0] = 0;
        s0[2][1] = 2;
        s0[2][2] = 1;
        s0[2][3] = 3;
        s0[3][0] = 3;
        s0[3][1] = 1;
        s0[3][2] = 3;
        s0[3][3] = 2;

        s1[0][0] = 0;
        s1[0][1] = 1;
        s1[0][2] = 2;
        s1[0][3] = 3;
        s1[1][0] = 2;
        s1[1][1] = 0;
        s1[1][2] = 1;
        s1[1][3] = 3;
        s1[2][0] = 3;
        s1[2][1] = 0;
        s1[2][2] = 1;
        s1[2][3] = 0;
        s1[3][0] = 2;
        s1[3][1] = 1;
        s1[3][2] = 0;
        s1[3][3] = 3;

        int rownum1 = 2*step1[0]+1*step1[3];
        int colnum1 = 2*step1[1]+1*step1[2];

        int left = s0[rownum1][colnum1];

        int rownum2 = 2*step1[4]+1*step1[7];
        int colnum2 = 2*step1[5]+1*step1[6];

        int right = s1[rownum2][colnum2];

        if(left == 0){
            combinedtupple[0] = 0;
            combinedtupple[1] = 0;
        }else if(left == 1){
            combinedtupple[0] = 0;
            combinedtupple[1] = 1;
        }else if(left == 2){
            combinedtupple[0] = 1;
            combinedtupple[1] = 0;
        }else{
            combinedtupple[0] = 1;
            combinedtupple[1] = 1;
        }

        if(right == 0){
            combinedtupple[2] = 0;
            combinedtupple[3] = 0;
        }else if(right == 1){
            combinedtupple[2] = 0;
            combinedtupple[3] = 1;
        }else if(right == 2){
            combinedtupple[2] = 1;
            combinedtupple[3] = 0;
        }else{
            combinedtupple[2] = 1;
            combinedtupple[3] = 1;
        }

        p4tuple[0] = combinedtupple[1];
        p4tuple[1] = combinedtupple[3];
        p4tuple[2] = combinedtupple[2];
        p4tuple[3] = combinedtupple[0];

        for(int a=0;a<4;a++){
            firstoutput[a] = (ip[a] == p4tuple[a])?0:1;
        }

        firstfinal[0] = firstoutput[0];
        firstfinal[1] = firstoutput[1];
        firstfinal[2] = firstoutput[2];
        firstfinal[3] = firstoutput[3];
        firstfinal[4] = ip[4];
        firstfinal[5] = ip[5];
        firstfinal[6] = ip[6];
        firstfinal[7] = ip[7];

        int swaplist[] = new int[8];

        swaplist[0] = firstfinal[4];
        swaplist[1] = firstfinal[5];
        swaplist[2] = firstfinal[6];
        swaplist[3] = firstfinal[7];
        swaplist[4] = firstfinal[0];
        swaplist[5] = firstfinal[1];
        swaplist[6] = firstfinal[2];
        swaplist[7] = firstfinal[3];

        int ep2[] = new int[8];

        ep2[0] = swaplist[7];
        ep2[1] = swaplist[4];
        ep2[2] = swaplist[5];
        ep2[3] = swaplist[6];
        ep2[4] = swaplist[5];
        ep2[5] = swaplist[6];
        ep2[6] = swaplist[7];
        ep2[7] = swaplist[4];

        int step2[] = new int[8];

        for(int a=0;a<8;a++){
            step2[a] = (ep2[a] == key2[a])?0:1;
        }

        int secrownum1 = 2*step2[0]+1*step2[3];
        int seccolnum1 = 2*step2[1]+1*step2[2];

        int secleft = s0[secrownum1][seccolnum1];

        int secrownum2 = 2*step2[4]+1*step2[7];
        int seccolnum2 = 2*step2[5]+1*step2[6];

        int secright = s1[secrownum2][seccolnum2];
        int seccombinedtupple[] = new int[4];

        if(secleft == 0){
            seccombinedtupple[0] = 0;
            seccombinedtupple[1] = 0;
        }else if(secleft == 1){
            seccombinedtupple[0] = 0;
            seccombinedtupple[1] = 1;
        }else if(secleft == 2){
            seccombinedtupple[0] = 1;
            seccombinedtupple[1] = 0;
        }else{
            seccombinedtupple[0] = 1;
            seccombinedtupple[1] = 1;
        }

        if(secright == 0){
            seccombinedtupple[2] = 0;
            seccombinedtupple[3] = 0;
        }else if(secright == 1){
            seccombinedtupple[2] = 0;
            seccombinedtupple[3] = 1;
        }else if(secright == 2){
            seccombinedtupple[2] = 1;
            seccombinedtupple[3] = 0;
        }else{
            seccombinedtupple[2] = 1;
            seccombinedtupple[3] = 1;
        }

        int secp4tuple[] = new int[4];

        secp4tuple[0] = seccombinedtupple[1];
        secp4tuple[1] = seccombinedtupple[3];
        secp4tuple[2] = seccombinedtupple[2];
        secp4tuple[3] = seccombinedtupple[0];

        int secondoutput[] = new int[4];

        for(int a=0;a<4;a++){
            secondoutput[a] = (swaplist[a] == secp4tuple[a])?0:1;
        }

        int secondfinal[] = new int[8];

        secondfinal[0] = secondoutput[0];
        secondfinal[1] = secondoutput[1];
        secondfinal[2] = secondoutput[2];
        secondfinal[3] = secondoutput[3];
        secondfinal[4] = swaplist[4];
        secondfinal[5] = swaplist[5];
        secondfinal[6] = swaplist[6];
        secondfinal[7] = swaplist[7];

        int ciphertext[] = new int[8];

        ciphertext[0] = secondfinal[3];
        ciphertext[1] = secondfinal[0];
        ciphertext[2] = secondfinal[2];
        ciphertext[3] = secondfinal[4];
        ciphertext[4] = secondfinal[6];
        ciphertext[5] = secondfinal[1];
        ciphertext[6] = secondfinal[7];
        ciphertext[7] = secondfinal[5];

        if(ciphertext[0] == 0 && ciphertext[1] == 1 && ciphertext[2] == 1 && ciphertext[3] == 1 && ciphertext[4] == 1 && ciphertext[5] == 1 && ciphertext[6] == 1 && ciphertext[7] == 1){
            System.out.println("The possible key is:");
            for(int q=0;q<10;q++){
                System.out.print(k[q]+" ");
            }
        }
    }
}
