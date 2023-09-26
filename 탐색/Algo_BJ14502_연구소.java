package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algo_BJ14502_연구소 {

    static int[][] map, copymap;
    static int N, M;
    static List<Point> blankList;
    static Point[] wallPoints;

    static int safeZone;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    // 너비 우선 탐색으로 바이러스가 퍼지는거 구하기
    // 조합으로 어디에 벽을 세울 것인지 알기
    //
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 지도의 세로
        M = Integer.parseInt(st.nextToken());     // 지도의 가로
        map = new int[N][M];
        blankList=new ArrayList<>();

        wallPoints=new Point[3];    // 벽이 3개

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]==0){  // 벽이라면
                    blankList.add(new Point(i, j));
                }
            }
        }
        // copy map 초기화


    }

    // 맵 내용 복사
    static void initCopyMap(){
        copymap=new int[N][M];
        for (int i=0;i<N;i++){
            System.arraycopy(map[i], 0, copymap[i], 0, M);
        }
    }

    // 바이러스 확산
    static void spreadVirus(){
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (map[i][j]==2){  // 바이러스라면
                    bfs(i, j);

                }
            }
        }
    }

    private static void bfs(int r, int c){

    }

    static class Point{
        int row, col;
        public Point(int row, int col){
            super();
            this.row=row;
            this.col=col;
        }
    }
}
