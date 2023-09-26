package 백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BJ6987_월드컵 {

    static int[] ans;

    public static void main(String[] args) throws Exception {

//        int wscore = 0;
//        int sscore = 0;
//        int lscore = 0;
        ans = new int[4];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            // 점수 입력받기
            st = new StringTokenizer(br.readLine());
            int[] win = new int[6];
            int[] same = new int[6];
            int[] lose = new int[6];
            for (int j = 0; j < 6; j++) {
                win[j] = Integer.parseInt(st.nextToken());
                same[j] = Integer.parseInt(st.nextToken());
                lose[j] = Integer.parseInt(st.nextToken());

            }
            ans[i] = 1;
            int wscore = 0;
            int sscore = 0;
            int lscore = 0;

            for (int j = 0; j < 6; j++) {
                // 총 시합의 수가 15가 아닐 경우
                wscore += win[j];
                sscore += same[j];
                lscore += lose[j];

                if (wscore > 15 || lscore > 15) {
                    ans[i] = 0;
                    break;
                }
            }
            // 무승부 계산
            for (int s = 0; s < 5; s++) {
                for (int k = s + 1; k < 6; k++) {
                    if (same[s] != 0 && same[k] != 0) {
                        same[s]--;
                        same[k]--;
                    }
                }
                if(same[s]!=0){
                    ans[i]=0;
                    break;
                }
            }
            if(same[5]!=0){
                ans[i]=0;
            }
            // 전체 승점 패점 계산
            if ((wscore + sscore / 2) != 15 || (lscore + sscore / 2) != 15) {
                ans[i] = 0;
            }
//            else {
//                ans[i] = 1;
//            }

        }
        for (int i = 0; i < 4; i++) {
            System.out.print(ans[i] + " ");
        }

    }
}
