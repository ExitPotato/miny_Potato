package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo_SW1873_상호의배틀필드 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int H, W, N;
            String[] round;
            int[] now = new int[2];
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            String[][] field = new String[H][W];
            for (int h = 0; h < H; h++) {
                field[h] = br.readLine().split("");
            }
            N = Integer.parseInt(br.readLine());
            round = br.readLine().split("");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (field[i][j].equals("<") || field[i][j].equals("^") || field[i][j].equals("v")
                            || field[i][j].equals(">")) {
                        now[0] = i;
                        now[1] = j;
                    }
                }
            }
            // 명령 수행에 따라 시작
            for (int i = 0; i < N; i++) {
                if (round[i].equals("U")) { // 위를 향할 때
                    if ((now[0] - 1) >= 0 && field[now[0] - 1][now[1]].equals(".")) { // 갈 수 있으면
                        field[now[0]][now[1]] = ".";
                        field[now[0] - 1][now[1]] = "^";
                        now[0] -= 1;
                    } else {
                        field[now[0]][now[1]] = "^";
                    }
                } else if (round[i].equals("D")) {  // 아래를 향할 때
                    if ((now[0] + 1) < H && field[now[0] + 1][now[1]].equals(".")) { // 갈 수 있으면
                        field[now[0]][now[1]] = ".";
                        field[now[0] + 1][now[1]] = "v";
                        now[0] += 1;
                    } else {
                        field[now[0]][now[1]] = "v";
                    }
                } else if (round[i].equals("L")) {  // 왼쪽을 향할 때
                    if ((now[1] - 1) >= 0 && field[now[0]][now[1] - 1].equals(".")) { // 갈 수 있으면
                        field[now[0]][now[1]] = ".";
                        field[now[0]][now[1] - 1] = "<";
                        now[1] -= 1;
                    } else {
                        field[now[0]][now[1]] = "<";
                    }
                } else if (round[i].equals("R")) {  // 오른쪽을 향할 때
                    if ((now[1] + 1) < W && field[now[0]][now[1] + 1].equals(".")) { // 갈 수 있으면
                        field[now[0]][now[1]] = ".";
                        field[now[0]][now[1] + 1] = ">";
                        now[1] += 1;
                    } else {
                        field[now[0]][now[1]] = ">";
                    }
                } else if (round[i].equals("S")) {    // 슛 쏠 때
                    int count = 1;
                    if (field[now[0]][now[1]].equals("^")) {
                        while ((now[0] - count) >= 0) {   // 칸 안에서
                            if (field[now[0] - count][now[1]].equals("#")) {  // 강철벽이면
                                break;
                            } else if (field[now[0] - count][now[1]].equals("*")) {  // 흙벽이면
                                field[now[0] - count][now[1]] = ".";
                                break;
                            }
                            // 위를 보는데 물이거나 평지라면
                            count++;
                        }
                    } else if (field[now[0]][now[1]].equals("v")) {   // 아래쪽 슛
                        while ((now[0] + count) < H) {   // 칸 안에서
                            if (field[now[0] + count][now[1]].equals("#")) {  // 강철벽이면
                                break;
                            } else if (field[now[0] + count][now[1]].equals("*")) {  // 흙벽이면
                                field[now[0] + count][now[1]] = ".";
                                break;
                            }
                            // 아래를 보는데 물이거나 평지라면
                            count++;
                        }
                    } else if (field[now[0]][now[1]].equals("<")) {   // 왼쪽 슛
                        while ((now[1] - count) >= 0) {   // 칸 안에서
                            if (field[now[0]][now[1] - count].equals("#")) {  // 강철벽이면
                                break;
                            } else if (field[now[0]][now[1] - count].equals("*")) {  // 흙벽이면
                                field[now[0]][now[1] - count] = ".";
                                break;
                            }
                            // 아래를 보는데 물이거나 평지라면
                            count++;
                        }
                    } else if (field[now[0]][now[1]].equals(">")) {   // 오른쪽 슛
                        while ((now[1] + count) < W) {   // 칸 안에서
                            if (field[now[0]][now[1] + count].equals("#")) {  // 강철벽이면
                                break;
                            } else if (field[now[0]][now[1] + count].equals("*")) {  // 흙벽이면
                                field[now[0]][now[1] + count] = ".";
                                break;
                            }
                            // 아래를 보는데 물이거나 평지라면
                            count++;
                        }
                    }
                }
            }
            // 결과물 출력
            for (int i = 0; i < H; i++) {
                if(i==0){
                    System.out.print("#"+(t+1)+" ");
                }
                for (int j = 0; j < W; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
        }
    }

}
