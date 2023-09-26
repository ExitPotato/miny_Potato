package 백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BJ10971_외판원순회2 {

    static int N;
    static int[][] W;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0]=true;
        dfs(0,0,0);

        System.out.println(answer);
    }

    public static void dfs(int now, int cost, int count) {
        if (count == N-1){
            if(W[now][0]!=0){
                answer =Math.min(answer, cost+W[now][0]);
                return;
            }
        }
        for (int i=1;i<N;i++){
            if(!visited[i]&&W[now][i]!=0){
                visited[i]=true;
                dfs(i,cost+W[now][i], count+1);
                visited[i]=false;
            }
        }
    }
}
