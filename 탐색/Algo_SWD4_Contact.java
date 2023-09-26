package 탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_SWD4_Contact {

    static int count, start;
    static int size = 101;
    static int[] isVisited;
    static int[][] graph;
    static Queue<Integer> q;

    public static void main(String[] args) throws Exception {

        // 이거는 BFS로 구해줘야해
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test = 1; test <= 10; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph = new int[size][size];
            q = new LinkedList<>();
            isVisited = new int[size];

            count = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < count / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from][to]=1;
            }
            System.out.print("#"+test+" ");
            bfs(start);
        }
    }
    public static void bfs(int v){
        q.offer(v);
        isVisited[v]=1;
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while(!q.isEmpty()){
            int qSize = q.size();
            max = 0;
            for (int t=0;t<qSize;t++){
                int now = q.poll();
                for(int i=1;i<size;i++){
                    if (graph[now][i]==1 && isVisited[i]==0){
                        q.offer(i);
                        isVisited[i]=1;
                        max=Math.max(max, i);
                    }
                }
            }
            list.add(max);
        }
        System.out.println(list.get(list.size()-2));
    }
}
