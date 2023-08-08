package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BJ16926_배열돌리기1 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로, 세로, 회전수 입력받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        // 배열 만들어주기
        int[][] arr = new int[N][M];


        // 회전수는 어차피 N과 M중 작은 것의 회전수를 따라가기 때문에...
        int maximum = Math.min(N, M) / 2;

        for (int i = 0; i < N; i++) { // 배열 입력받기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 회전 돌려주기
        //int save = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < maximum; j++) {
                // 맨 왼쪽 윗 값 빼주기
                int save = arr[j][j];
                // 맨 위
                for (int k = 0 + j; k < M - j-1; k++) {
                    arr[j][k] = arr[j][k + 1];
                }
                // 오른쪽
                for (int k = 0 + j; k < N - j - 1; k++) {
                    arr[k][M-j-1] = arr[k + 1][M-j-1];
                }
                // 아래
                for (int k = 0 + j; k < M - j - 1; k++) {
                    arr[N - 1 - j][M - 1 - k] = arr[N - 1 - j][M - 1 - k - 1];
                }
                // 왼쪽
                for (int k = 0 + j; k < N - j-1; k++) {
                    arr[N-1-k][j]=arr[N-1-k-1][j];
                }
                arr[j+1][j]=save;
            }
        }
        for (int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
