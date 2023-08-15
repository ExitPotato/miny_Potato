package 재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algo_D3_규영이와인영이의카드게임 {

    static int[] mine, yours;
    static int R = 2;
    static int n = 0;


    public static void main(String[] args) throws Exception {
        /*
        생각... 조합을 사용하면 되지 않을까?
        근데? 각자 뽑아야 하는 리스트가 다르니까...그걸 생각해줘서 뽑아보자(?)
         */
        int lose = 0;
        int result = 0;
        mine = new int[9];
        yours = new int[9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test_case = Integer.parseInt(st.nextToken());
        int[] arr;

        for (int i = 0; i < test_case; i++) {
            arr = new int[19];
            for (int j = 1; j <= 18; j++) {
                arr[j]=j;
            }
            int mywin = 0;
            int yourwin = 0;
            result = 0;
            lose = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                yours[j] = Integer.parseInt(st.nextToken());
                arr[yours[j]]=0;
            }
            int count = 0;
            for (int j = 1; j <= 18; j++) {
                if(arr[j]!=0){
                    mine[count]=arr[j];
                    count++;
                }
            }
            // 정렬해주기
            Arrays.sort(mine);
            int calcul = 0;
            // 순열을 아용한 처리 해주기
            do {
                for (int j = 0; j < 9; j++) {
                    if (mine[j] > yours[j])
                        mywin += mine[j] + yours[j];    // 총점
                    else
                        yourwin += mine[j] + yours[j];
                }
                calcul += 1;
                if (mywin > yourwin)
                    result += 1;
                else if (mywin < yourwin)
                    lose += 1;
                mywin = 0;
                yourwin = 0;
            } while (np(mine));
            System.out.println("#" + (i+1)+ " " + lose + " " + result);
        }


    }

    private static boolean np(int[] p) {
        int N = p.length;
        int i = N - 1;
        while (i > 0 && p[i - 1] >= p[i])
            --i;

        if (i == 0)
            return false;

        int j = N - 1;
        while (p[i - 1] >= p[j])
            --j;

        swap(p, i - 1, j);

        int k = N-1;
        while (i < k) {
            swap(p, i++, k--);
        }
        return true;
    }

    private static void swap(int[] p, int a, int b) {
        int temp = p[a];
        p[a] = p[b];
        p[b] = temp;
    }
}
