package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BJ17143_낚시왕 {

    static int R, C, M;
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = {1,2,3};
        int[] arr2 = arr1;
        int[] arr3 = arr1.clone();
        arr3[0]=23;
        System.out.println(arr1);
        System.out.println(arr2);
        System.out.println(arr3);
    }
}
