package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Algo_SW1767_프로세서연결하기 {

    /*
    좌표중에 하나라도 0이라면 그 코어는 고려하지 않기로 한다
    room에 넣을 때 좌표가 하나라도 0이거나 마지막일 경우에는 전체 코어 수에 추가 한 채로 계산
    어레이리스트에 코어의 좌표값 넣어주기
    dfs로 탐색하면서 찾기
    코어의 수가 젤 많은거 저장...
     */

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] room;
    static int min, max, core, N;
    static ArrayList<Integer> locatex;
    static ArrayList<Integer> locatey;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            room = new int[N][N];
            int core = 0;   // 코어의 개수를 저장
            locatex = new ArrayList<>();
            locatey = new ArrayList<>();

            for (int i = 0; i < N; i++) {   // room에 좌표와 빈 공간 입력하기
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                    if (room[i][j] == 1) { // 코어가 있을 때
                        if (i == 0 || j == 0 || i >= N - 1 || j >= N - 1) {   // 가장자리에 위치해 있으면
                            core++;    // 코어의 수 추가해주기, 얘들은 굳이 좌표 저장 할 필요 없음
                        } else {
                            // 코어의 좌표값 저장해주기
                            locatex.add(j);
                            locatey.add(i);
                        }
                    }
                }
            }
            //System.out.println(core);
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            dfs(0, 0, 0);
            System.out.println("#" + t +" "+ min);
        }

    }

    public static void dfs(int index, int count, int len) {  // 돌릴 코어의 인덱스, 최대 코어의 카운트, 전선의 길이
        if (index == locatex.size()) {    // 탈출조건
            if (count > max) {
                max = count;
                min = len;
            } else if (count == max) {
                if (min>len) min = len; // 전선의 개수가 더 작은 것을 저장
            }
            return; // 탈출
        }
        // 상하좌우 봐주면서 반복 시작
        int x = locatex.get(index); // x좌표 가져오기
        int y = locatey.get(index); // y좌표 가져오기

        for (int dir = 0; dir < 4; dir++) {
            int originx = x;
            int originy = y;
            int nx = x;
            int ny = y;
            int calcul = 0; // 코어 계산할거

            while (true) {
                nx += dx[dir];  // 상하좌우 중에 어디로 갈건지
                ny += dy[dir];
                if (ny < 0 || nx < 0 || nx >= N || ny >= N) {   // 벽을 만나면
                    break;  // break
                }
                if (room[ny][nx] == 1) {    // 갈 수 없는 곳이면
                    calcul = 0;
                    break;
                }
                calcul++;
            }
            for (int i = 0; i < calcul; i++) {
                originx += dx[dir];
                originy += dy[dir];

                room[originy][originx] = 1; // 위치 1로 바꿔주면서 이동
            }
            if (calcul == 0) { // 이동할 곳이 없는 상태였다면
                dfs(index + 1, count, len);
            }
            else {   // 전선 연결을 했다면
                dfs(index + 1, count + 1, len + calcul);

                originy = y;
                originx = x;

                for (int i = 0; i < calcul; i++) {
                    originy += dy[dir];
                    originx += dx[dir];
                    room[originy][originx] = 0; // 바꿔준 위치 다시 되돌려주기
                }
            }
        }

    }
}
