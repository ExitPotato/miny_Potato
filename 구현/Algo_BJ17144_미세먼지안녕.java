package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BJ17144_미세먼지안녕 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] room, room2;
        int R, C, T, air[], cnt;
        R = Integer.parseInt(st.nextToken()); // 방의 세로길이
        C = Integer.parseInt(st.nextToken()); // 방의 가로길이
        T = Integer.parseInt(st.nextToken()); //초

        room = new int[R][C];
        air = new int[2];
        cnt = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int result = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1) {
                    air[cnt] = i;
                    cnt++;
                }
            }
        }   // room 입력받기, 공기청정기 위치 입력받기
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                System.out.print(room[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        System.out.println();
        int air1 = air[0];
        int air2 = air[1];

        for (int t = 0; t < T; t++) {
            room2 = new int[R][C];

            // 미세먼지 퍼져나가는거 계산
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (room[i][j] >= 5) {
                        int munji = room[i][j] / 5;
                        int spread = 0;
                        for (int k = 0; k < 4; k++) {
                            int ny = i + dy[k];
                            int nx = j + dx[k];
                            if (nx >= 0 && ny >= 0 && nx < C && ny < R && room[ny][nx] != (-1)) {  // 범위 내고 공기청정기 위치가 아니라면
                                room2[ny][nx] += munji; // 먼지더해주기
                                spread++;
                            }
                        }
                        room[i][j] -= (munji * spread); // 퍼진 만큼 원래 위치에서 감소시켜주기
                    }
                }
            }

            // 미세먼지 퍼진거 더해주기
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    room[i][j] += room2[i][j];
                }
            }

            // 공기청정기 작동 계산
            // 위쪽 방향 돌리기
            for (int i = air1 - 1; i > 0; i--) {
                room[i][0] = room[i - 1][0];
            }
            for (int i = 0; i < C - 1; i++) {
                room[0][i] = room[0][i + 1];
            }
            for (int i = 0; i < air1; i++) {
                room[i][C - 1] = room[i + 1][C - 1];
            }
            for (int i = C - 1; i > 1; i--) {
                room[air1][i] = room[air1][i - 1];
            }
            room[air1][1] = 0;

            // 아래쪽 방향 공기청정기 돌리기
            for (int i = air2 + 1; i < R - 1; i++) {
                room[i][0] = room[i + 1][0];
            }
            for (int i = 0; i < C - 1; i++) {
                room[R - 1][i] = room[R - 1][i + 1];
            }
            for (int i = R - 1; i > air2; i--) {
                room[i][C - 1] = room[i - 1][C - 1];
            }
            for (int i = C - 1; i > 1; i--) {
                room[air2][i] = room[air2][i - 1];
            }
            room[air2][1] = 0;

        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
//                System.out.print(room[i][j] + " ");
                result += room[i][j];
            }
//            System.out.println();
        }
        System.out.println(result + 2);
    }
}
