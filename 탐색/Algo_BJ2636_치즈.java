package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_BJ2636_치즈 {

    static int R, C;
    static int[][] cheese;

    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        // BFS로 0인 부분만 큐에 넣고 상하좌우 확인하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cheese = new int[R][C];
        int total = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if (cheese[i][j]==1) total+=1;
            }
        }   // cheese 입력받기

        int time=0;
        int result=0;
        while (total!=0){   // 치즈가 다 안녹았다면 계속 해주기
            time+=1;
            result=total;   // 왜냐면 녹기 1시간 전꺼가 궁금하니까
            total=bfs(cheese, new boolean[R][C], total);
        }

        System.out.println(time);
        System.out.println(result);

    }

    // BFS 구현해주기
    public static int bfs(int[][] cheese, boolean[][] isVisited, int count) {
        // BFS는 큐가 비어있지 않을 때 계속 해 주는 것이기 때문에 구냥 돌려도 돼(새로 함수로)
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        isVisited[0][0] = true;   // 첫 시작은 방문처리를 해 줘야 해

        // 현재가 0이면(공기중이면) 상하좌우 보면서 치즈 있는지 봐주고 치즈면 0으로 해주기
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!queue.isEmpty()) {   // 큐가 비어있지 않을 경우 계속 해 주기
            int[] pos = queue.poll();
            int row = pos[0];   // 행
            int col = pos[1];   // 열

            for (int i = 0; i < 4; i++) {   // 상하좌우 돌면서 확이해주기
                int nr = dr[i] + row;
                int nc = dc[i] + col;

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) {   // 범위 넘어가면 무시하기
                    continue;
                }
                if (isVisited[nr][nc]) { // 이미 방문했던 곳이어도 무시해주기
                    continue;
                }
                isVisited[nr][nc] = true;

                if (cheese[nr][nc] == 0) { // 공기층이면 해당 위치 큐에 넣어주기
                    queue.offer(new int[]{nr, nc});
                } else {
                    count -= 1; // 치즈 녹았으니까 하나 줄여주고
                    cheese[nr][nc] = 0; // 녹은건 접시 보이게 해 주기
                }

            }
        }
        return count;
    }
}
