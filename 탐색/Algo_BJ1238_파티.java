package 탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Algo_BJ1238_파티 {
    /*
    최단거리를 찾는거기 때문에 다익스트라 알고리즘으로 구현하기

    왜 틀렸나요? : 다익스트라가 최단거리인건 알지만 다익스트라를 잘 몰라서...
    결론 => 다익스트라를 공부 해 봅시다
     */
    static int N, M, X, answer;
    static int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] adjList, reverseList;
    static class Node implements Comparable<Node>{
        int dest, cost;
        public Node(int dest, int cost){
            this.dest=dest;
            this.cost=cost;
        }
        public int compareTo(Node o){
            return this.cost-o.cost;    // cost기준 오름차순
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        answer = 0;

        adjList=new ArrayList[N+1]; // 원래 방향 인접 리스트
        reverseList=new ArrayList[N+1]; // 역방향 인접 리스트

        // 인접 리스트 초기화
        for (int i=0;i<N+1;i++){
            adjList[i]=new ArrayList<>();
            reverseList[i]=new ArrayList<>();
        }

        for (int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine());
            int start =Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int time=Integer.parseInt(st.nextToken());

            adjList[start].add(new Node(end,time)); // 원래 방향 인접 리스트 셋팅
            reverseList[end].add(new Node(start, time));    // 역방향 인접 리스트 셋팅
        }

        // 시작점을 X로 잡고 adjList 기준으로 최단거리 구하면 각 마을 -> X까지 최단 거리를 구할 수 있음
        // 시작점을 X로 잡고 reverseList 기준으로 최단거리 구하면 X -> 각 마을 까지 최단 거리 구할 수 있음
        int[] cost=dijkstra(X,adjList); // 마을 -> X(파티장) 까지 최단거리 배열
        int[] reverseCost = dijkstra(X, reverseList);   // X(파티장) -> 각 마을까지 최단거리 배열

        // 인접 리스트 초기화
        for (int i=1;i<N+1;i++){
            answer = Math.max(answer, cost[i]+reverseCost[i]);
        }
        System.out.println(answer);

    }

    static int[] dijkstra(int start, ArrayList<Node>[] list){
        // 최저비용 기준 탐색경로 저장 위한 우선순위큐
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] tempCost = new int[N+1];
        boolean[] visited=new boolean[N+1];
        Arrays.fill(tempCost,INF);  // 거리(cost) 저장 위한 배열 INF로 초기화
        Arrays.fill(visited, false);    // 방문여부 체크 배열 false로 초기화

        tempCost[start]=0;  // 시작점이기 때문에 거리 0으로 셋팅
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if (visited[now.dest])continue; // 방문했던 정점이면 스킵
            visited[now.dest]=true; // 미방문이면 방문으로 셋팅하고 for문 처리

            // 간선 탐색
            for (Node next:list[now.dest]){
                if (tempCost[next.dest]>next.cost+now.cost){
                    tempCost[next.dest]=next.cost+now.cost;
                    pq.add(new Node(next.dest, tempCost[next.dest]));
                }
            }
        }
        return tempCost;
    }
}
