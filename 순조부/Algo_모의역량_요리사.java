package 순조부;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_모의역량_요리사 {

    static int N;
    static int best = 0;
    static int[][] food;
    static int line;
    static int[] isSelected;
    static int a=0;
    static int b=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test_case = Integer.parseInt(st.nextToken());

        for (int r = 1; r <= test_case; r++) {
            st = new StringTokenizer(br.readLine());
            line = Integer.parseInt(st.nextToken());
            N = line / 2;
            isSelected = new int[line];
            food = new int[line][line];
            for (int i = 0; i < line; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < line; j++) {
                    food[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    // 음식 조합을 했을 때
    public static void makeCombination(int count, int start, int[] isSelected) {
        if (count == N) {
            // 경우의 수 생성 후(fooda를 다 골랐으면)
            // isSelected가 1이면 a에, 0이면 b에 음식을 넣어주고 그 이후로 계산하는 이중포문도 여기서 돌려주기!

            int[] foodb = new int[N];
            int here = 0;
//            for(int i=0;i<N;i++){
//                if((i+1))
//            }

        }
        for (int i = start; i < line; i++) {
            isSelected[i]=1;
            makeCombination(count + 1, i + 1, isSelected);
            isSelected[i]=0;
        }
    }
}
