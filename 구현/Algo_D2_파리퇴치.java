package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_D2_파리퇴치 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        int kill = 0;   // 가장 많이 죽인 파리의 수
        int[][] fly;    // 파리 배열
        int total = 0;  // 현재 위치에서 죽인 파리의 수

        for (int count = 0; count < test_case; count++) {   // 테스트 케이스만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 파리 배열 길이
            int M = Integer.parseInt(st.nextToken());   // 파리채 길이
            fly = new int[N][N];
            for (int i = 0; i < N; i++) {   // 파리 배열 넣어주기
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    fly[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            kill = 0;   // 가장 많이 죽인 파리의 수 초기화
            for (int i = 0; i <= N - M; i++) { // 세로줄
                for (int j = 0; j <= N - M; j++) { // 가로줄
                    total = 0;

                    for (int k = i; k < i+M; k++) {   // 파리채 세로줄
                        for (int l = j; l < j+M; l++) {   // 파리채 가로줄
                            total += fly[k][l];
                        }
                    }
                    // 현재 잡은 파리의 수가 더 많으면 가장 많이 죽인 파리의 수 없데이트
                    if (total > kill)
                        kill = total;
                }
            }
            System.out.printf("#%d %d", (count+1), kill);
            System.out.println();
            // 더 좋은 방법이 있는지 찾아보았으나 다들 4중 포문 사용!
        }
    }
}
