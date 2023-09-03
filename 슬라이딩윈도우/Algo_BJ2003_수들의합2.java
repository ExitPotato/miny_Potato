package 슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BJ2003_수들의합2 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N + 1];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        num[0] = 0;
        //num[1] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N+1; i++) {
            num[i] = num[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int i = N; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (num[i] - num[j] == M) {
                    //System.out.println(num[i] + "-" + num[j]);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
