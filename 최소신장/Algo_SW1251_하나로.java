package 최소신장;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Algo_SW1251_하나로 {
    /*
    자료형을 잘 정해주어야 합니다
    int로 하면 엄청난 overflow를 볼 수 있어요
    마지막에 double로 바꾸지 마세요
    저도 알고싶지 않았어요...
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());    // 총 테스트케이스 횟수

        for (int T = 1; T <= test_case; T++) {
            int N = Integer.parseInt(br.readLine());    // 총 섬의 개수 입력받기
            long[][] input = new long[N][N];
            int[][] locate = new int[N][2];     // 섬의 좌표 위치를 받을 변수
            boolean[] visited = new boolean[N]; // 방문했는지 알아보기 위해
            long[] minEdge = new long[N];

            StringTokenizer st, st2;
            st = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {  // 섬의 좌표 입력받기
                locate[i][0] = Integer.parseInt(st.nextToken());    // 섬의 X 위치
                locate[i][1] = Integer.parseInt(st2.nextToken());    // 섬의 Y 위치
            }
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    long a, b;
                    a = Math.abs(locate[i][0] - locate[j][0]);
                    b = Math.abs(locate[i][1] - locate[j][1]);
                    input[i][j] = (a*a) + (b*b);   // 두 섬 간 거리의 제곱
                }
                minEdge[i] = Long.MAX_VALUE;
            }  // 모든 섬에서 섬까지의 거리를 배열에 저장

            int minVertex = 0;
            long min, result = 0;
            minEdge[0] = 0; // 임의의 시작점 비용 0 셋팅

            for (int c = 0; c < N; c++) {   // 모든 섬의 수 만큼 반복
                min = Long.MAX_VALUE;    // 초기값으로 최대치를 주고 시작
                minVertex = 0;

                for (int i = 0; i < N; i++) {
                    if (!visited[i] && min > minEdge[i]) {  // 방문 한 적이 없고 최대치보다 더 작은 값이라면
                        min = minEdge[i];
                        minVertex = i;

                    }
                }
                result += min;
                visited[minVertex] = true;  // 방문체크

                for (int i = 0; i < N; i++) {
                    if (!visited[i] && input[minVertex][i] != 0 && minEdge[i] > input[minVertex][i]) {
                        // 방문 한 적이 없고 섬 사이의 거리가 0이 아니면서(자기 자신으로 돌아간게 아니면서)
                        // 비용값이 현재보다 크다면
                        minEdge[i] = input[minVertex][i]; // 값 갱신해주기
                    }
                }
            }   // 섬 사이의 거리 계산 종료
            double tariff = Double.parseDouble(br.readLine());
            System.out.println("#" + T + " " + Math.round(result * tariff));
        }
        // 우선순위 큐를 사용하면 더 빨리 풀 수 있습니다~~
    }

}
