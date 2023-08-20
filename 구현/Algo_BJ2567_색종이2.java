package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BJ2567_색종이2 {
    /*
    색종이가 보드 가장자리랑 맞닿아 있는 경우를 생각해 주지 않아서 틀렸었음
    문제의 조건을 꼼꼼하게 따져주자!!!
     */

    static int[] dx = {0, 0, -1, 1};   // 상하좌우
    static int[] dy = {-1, 1, 0, 0};  // 상하좌우
    static int[][] map = new int[100][100];
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        // 색종이 색 넣어주기
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = (99 - y); j > (99 - y - 10); j--) {
                for (int k = x; k < x + 10; k++) {
                    map[j][k] += 1;
                }
            }
        }
        // 100X100 돌아가며 확인해주기
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] != 0) {  // 색종이 영역이라면
                    for (int k = 0; k < 4; k++) {
                        // 색종이가 가장자리에 있지 않으면
                        if (dx[k] + j >= 0 && dx[k] + j < 100 && dy[k] + i >= 0 && dy[k] + i < 100) {
                            // 옆에가 빈 칸(흰색)일 경우 정답 추가
                            if (map[dy[k] + i][dx[k] + j] == 0)
                                answer += 1;
                        } else{ // 가장자리에 닿아 있는 경우 생각해주기
                            answer+=1;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
