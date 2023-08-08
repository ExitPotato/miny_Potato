package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_D3_한빈이와SpotMart {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase =Integer.parseInt(br.readLine());


        for(int i=1;i<=testcase;i++) {
            // 기본값을 -1로 설정
            int total = -1;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] snack = new int[N];
            //기본 과자 무게 받기
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                snack[j]=Integer.parseInt(st.nextToken());
            }
            // 비교를 통해 가장 많이 나가는 무게 찾기(없으면 초기화값인 -1 반환)
            for(int j=0;j<N-1;j++) {
                for(int k=j+1;k<N;k++) {
                    int max = snack[j]+snack[k];
                    if(max<=M && max>total) {
                        total = max;
                    }
                }
            }
            System.out.println("#"+i+" "+total);
        }


    }

}
