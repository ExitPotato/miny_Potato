package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_1194_달이차오른다가자 {

    //  최소거리 찾기 = BFS로 해 주기
    // 획득/미획득 2가지 경우의 키가 6개가 있으므로 모든 경우의 수는 2의 6승 => 64개
    // 3차원 배열!!!
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new ArrayDeque<>();
        int[][][] isVisited = new int[64][N][M];   // 2의 6승이기 때문에 64
        char[][] maze = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = s.charAt(j);
                if (maze[i][j] == '0') {
                    queue.add(new int[]{i, j, 0, 0});
                    isVisited[0][i][j] = 1;
                }
            }
        }
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int answer = -1;
        // bfs 시작
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int row = info[0];
            int col = info[1];
            int keys = info[2];
            int count = info[3];

            if (maze[row][col] == '1') {
                answer = count;
                break;
            }

            for (int j = 0; j < 4; j++) {  // 사방탐색
                int nr = row + dr[j];
                int nc = col + dc[j];

                if (nc < 0 || nr >= N || nc < 0 || nc >= M) {   // 범위 안이면
                    continue;
                }

                if (maze[nr][nc] == '#') {
                    continue;
                }

                if (isVisited[keys][nr][nc] == 0) {
                    char command = maze[nr][nc];
                    if (command == '.' || command == '0' || command == '1') {
                        isVisited[keys][nr][nc] = count + 1;
                        queue.offer(new int[]{nr, nc, keys, count + 1});
                    } else if ('a' <= command && command <= 'f') {
                        int newkey = 1 << (command - 'a');  // 아스키코드값
                        newkey |= keys;
                        if (isVisited[keys][nr][nc] == 0) {
                            isVisited[keys][nr][nc] = count + 1;
                            isVisited[newkey][nr][nc] = count + 1;
                            queue.offer(new int[]{nr, nc, newkey, count + 1});
                        }
                    } else if ('A' <= command && command <= 'F') {
                        if ((keys & (1 << (command - 'A'))) != 0) {
                            isVisited[keys][nr][nc] = count + 1;
                            queue.offer(new int[]{nr, nc, keys, count + 1});
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
