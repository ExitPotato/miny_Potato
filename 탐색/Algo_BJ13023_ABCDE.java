package 탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Algo_BJ13023_ABCDE {

    static int N,M,V, answer, result;
    static boolean[] isVisited;
    static ArrayList<ArrayList<Integer>> graph;
    /*
    인접 행렬로 풀었다가 시간초과 나서 망했어요~~
    그러니까 우리 꼭 인접리스트로 풀기로 해요~~ㅠㅠ
    겸사겸사 어레이리스트 어떻게 하는지도 알아두기!!
    0 - 2
    1 - 2 - 4
    2 - 3
    3 - 0 - 1
    어레이리스트는 이런 느낌
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //int[][] map = new int[N][N];    // 사람 수 만큼 배열 만들어주기
        answer=0;
        result = 0;
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<N;i++){
            graph.add(new ArrayList<>());
        }
        // 친구 관계 배열 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph.get(s).add(t);
            graph.get(t).add(s);

        }

        isVisited = new boolean[N]; // 한번 탐색하면 다시 탐색 안해
        // v는 시작점
        for(int i=0;i<N;i++){
            if(result==1)
                break;
            // 맨 처음에 들어가는 노드는 따로 방문했다고 해 줘야 해
            isVisited[i]=true;
            dfs(graph, i,0);
            isVisited[i]=false;
        }

        System.out.println(result);
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int v, int depth){
        // 사람이 5명 연속해서 친구라면 정답을 1로 하고 탈출하기
        if(depth==4){
            result = 1;
            return;
        }
        // 백트래킹
        for(int i=0;i<graph.get(v).size();i++){
            if(!isVisited[graph.get(v).get(i)]){
                isVisited[graph.get(v).get(i)] = true;
                dfs(graph, graph.get(v).get(i), depth +1);
                isVisited[graph.get(v).get(i)]=false;
            }
        }
    }
}
