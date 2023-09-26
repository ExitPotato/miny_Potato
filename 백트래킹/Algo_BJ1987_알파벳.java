package 백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BJ1987_알파벳 {

    //static String[][]map;
    static int answer, R, C;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        answer = 0;

        // 맵 입력받기
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }
        dfs(0, map, 0, 0);
        System.out.println(answer);

    }

    public static void dfs(int count, int[][] map, int x, int y) {
        if (visited[map[x][y]]) {  // 이미 방문한 알페벳이면(이제 뒤로 가야 하니까)
            answer = Math.max(answer, count);   // 둘 중 더 큰거
            return; // 탈출
        } else {
            visited[map[x][y]] = true;  // 여기 방문했음
            for (int i = 0; i < 4; i++) {   // 싱하좌우
                int x1 = x + dx[i];
                int y1 = y + dy[i];

                if (x1 >= 0 && y1 >= 0 && x1 < R && y1 < C) {   // 맵의 범위 안에 있으면
                    dfs(count + 1, map, x1, y1);
                }
            }
            visited[map[x][y]] = false;   // 방문취소
        }
    }
}
