package 탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Algo_BJ10026_적록색약 {

    public static void main(String[] args) throws Exception {
        // 일반인이랑 색맹이랑 따로 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        char[][] map = new char[T][T];

        for (int i = 0; i < T; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int count = 0;
        boolean[][] isVisited = new boolean[T][T];

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for (int i=0;i<T;i++){
            for (int j=0;j<T;j++){
                if(isVisited[i][j]){    // 이미 방문했던 곳이면
                    continue;
                }
                count +=1;
                Queue<int[]> q = new ArrayDeque<>();
                isVisited[i][j]=true;
                char color = map[i][j];

                q.offer(new int[] {i,j});

                while(!q.isEmpty()){    // 비어있지 않으면
                    int[] pos = q.poll();
                    int row = pos[0];
                    int col = pos[1];

                    for (int k=0;k<4;k++){
                        int nr = row+dr[k];
                    }
                }
            }
        }
    }
}
