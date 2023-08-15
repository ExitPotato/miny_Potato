package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo_BJ17406_배열돌리기4 {

    // 조합을 시도해 해보려다 가열차게 실패했기 때문에...
    // 선생님 코드로 이해하고 다시 해보기!!!

    static class Rect{
        int row;
        int col;
        int size;

        public Rect(int row, int col, int size){
            super();
            this.row=row;
            this.col=col;
            this.size = size;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Rect [row=");
            builder.append(row);
            builder.append(", col=");
            builder.append(col);
            builder.append(", size=");
            builder.append(size);
            builder.append("]");
            return builder.toString();
        }
    }

    static int N;//행
    static int M;//열
    static int K;//회전연산의 개수

    static int[][] map;//초기데이터 저장
    static int[][] mapClone;//초기 맵 복사(실행결과 저장)

    static Rect[] rects;// 회전정보 : 초기 위치(행, 열, 크기)
    static Rect[] rectsPerm; //순열 결과(순서) 저장

    static int[] dy = { 1,  0, -1,  0 };//행인덱스
    static int[] dx = { 0,  1,  0, -1 };//열인덱스
    //하, 우, 상, 좌
    //=>상->하, 좌->우, 하->상, 우->좌

    static boolean[] visited;
    static int min;//회전 후 최소값
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//행
        M = Integer.parseInt(st.nextToken());//열
        K = Integer.parseInt(st.nextToken());//회전 연산

        //입력된 데이터와 배열인덱스 맞추기
        map      = new int[N + 1][M + 1];
        mapClone = new int[N + 1][M + 1];
        rects     = new Rect[K];
        rectsPerm = new Rect[K];
        visited = new boolean[K];

        //배열 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //연산 데이터 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            rects[i] = new Rect(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        //연산 순열
        result = Integer.MAX_VALUE;
        min = Integer.MAX_VALUE;
        perm(0);
        System.out.println(result);
        br.close();
    }

    private static void perm(int depth) {

        if(depth == K) {
            for(int i=1; i<=N; i++) {
                System.arraycopy(map[i], 1, mapClone[i], 1, M);
            }
            //회전시키기
            startRotate();
            result = Math.min(result, min);
            return;
        }//순열 생성

        for(int i=0; i<K; i++) {
            if(!visited[i]) {
                visited[i]=true;
                rectsPerm[depth] = rects[i];
                perm(depth+1);
                visited[i]=false;
            }
        }
    }

    private static void startRotate() {

        min = Integer.MAX_VALUE;

        for (int i = 0; i < rectsPerm.length; i++) {
            arrRotate(rectsPerm[i]);
        }

        // 배열을 다 돌린 후의 각 행의 최소값 찾기
        int sum = 0;
        for (int j = 1; j <= N; j++) {
            sum = 0;
            for (int k = 1; k <= M; k++) {
                sum += mapClone[j][k];
            }
            min = Math.min(sum, min);
        }
    }

    private static void arrRotate(Rect rect) {
        int R = rect.row;
        int C = rect.col;
        int S = rect.size;

        for (int i = 0; i < S; i++) {
            int dir = 0;//하 우 상 좌
            //=>상->하, 좌->우, 하->상, 우->좌
            int sy = R-S+i; //회전 시작 위치 행
            int sx = C-S+i; //회전 시작 위치 열
            int value = mapClone[sy][sx];
            while (dir < 4) {
                int ny = sy + dy[dir];
                int nx = sx + dx[dir];
                if (ny >= R-S+i && nx >= C-S+i && ny<=R+S-i && nx <= C+S-i) { //둘 다 범위 안이면
                    mapClone[sy][sx] = mapClone[ny][nx];
                    sy = ny;
                    sx = nx;
                } else {
                    dir++;
                }
            }
            mapClone[R-S+i][C-S+i+1] = value;
        }
    }


//    static int R;
//    static int[] isSelected;
//    static int[] howrotate;
//    static int[][] arr;
//    static String[] rotate;
//    static StringTokenizer st;
//
//    public static void main(String[] args) throws Exception {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        st = new StringTokenizer(br.readLine());
//
//        int N, M, K;    // 배열 크기, 연산횟수 K
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//        arr = new int[N + 1][M + 1];
//        rotate = new String[K];
//        // 0번째 인덱스를 써 주지 않을거라 일부러 이렇게 받음
//        // 배열 받기
//        R = K;
//        isSelected = new int[K];
//        howrotate = new int[K];
//        for (int i = 1; i <= N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 1; j < M; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        // 회전 수 만큼의 String배열로 받기
//        for (int i = 0; i < K; i++) {
//            rotate[i] = br.readLine();
//        }
//        makePermutation(0);
//    }
//
//    public static void makePermutation(int count) {
//        if (count == R) {
//            // 순열 생성하면 계산해주기
//            System.out.println(Arrays.toString(howrotate));
////            for(int i=0;i<R;i++){   // 회전수만큼
////
////            }
//            return;
//        }
//        for (int i = 0; i < R; i++) {
//            if (isSelected[i] != 1) {
//                howrotate[count] = i;
//                isSelected[i] = 1;
//                makePermutation(count + 1);
//                isSelected[i] = 0;
//            }
//        }
//    }
}
