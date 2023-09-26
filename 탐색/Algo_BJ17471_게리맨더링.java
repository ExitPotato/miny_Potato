package 탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Algo_BJ17471_게리맨더링 {

    static int N, answer1, answer2, result;
    static int[] people;    // 구역 당 사람 수 넣어줄 배열
    static ArrayList<ArrayList<Integer>> ground;    // 선거구와 인접한 지역 넣어 줄 배열
    static ArrayList<Integer> pick1, pick2;
    static boolean[] isVisited, isSelected; // 방문 했는지 넣어 줄 배열


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 총 사람 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        people = new int[N];
        ground = new ArrayList<ArrayList<Integer>>();
        pick1 = new ArrayList<>();
        pick2 = new ArrayList<>();

        ground.add(new ArrayList<>());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken()); // 구역 당 사람 수 넣어주기
            ground.add(new ArrayList<>());  // 인접한 구역 넣을 배열 만들어주기
        }
        // 인접한 구역 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            if (count != 0) {
                for (int j = 0; j < count; j++) {
                    int s = Integer.parseInt(st.nextToken());
                    ground.get(i).add(s);
                }
            }
        }

        isVisited = new boolean[N]; // 한번 탐색 하면 다시 뒤로 안돌아갈거야
        subSet(0);
        System.out.println(result);
    }

    // 멱집합 구하기(근데 공집합과 모든 원소가 다 있는 것은 제외해줘야해)
    public static void subSet(int count) {
        if (count == N) {
            for (int i = 0; i < N; i++) {
                if (isVisited[i] == true)
                    pick1.add(i);   // 선거구 1에 넣기
                else
                    pick2.add(i);   // 선거구 2에 넣기
            }
            // 넣은 선거구로 dfs 돌려주기
            System.out.println(pick1);
            isSelected = new boolean[N ];
            dfs1(pick1, pick1.get(0), 0);
            isSelected = new boolean[N ];
            dfs2(pick2, pick2.get(0), 0);
            if (Math.abs(answer1 - answer2) < result || result == -1)
                result = Math.abs(answer1 - answer2);
            pick1.clear();
            pick2.clear();
            return;
        }
        isVisited[count] = false;
        subSet(count + 1);
        isVisited[count] = true;
        subSet(count + 1);
    }

    public static void dfs1(ArrayList<Integer> pick, int v, int depth) {
        if (depth == pick.size()) {
            answer1 = 0;
            for (int i = 0; i < pick.size(); i++) {
                answer1 += people[pick.get(i)];
                return;
            }
        }
        // 백트래킹
        for (int i = 0; i < ground.get(v).size(); i++) {
            if (!isSelected[ground.get(v).get(i)]) {
                isSelected[ground.get(v).get(i)] = true;
                dfs1(pick1, i, depth + 1);
            }
        }
    }

    public static void dfs2(ArrayList<Integer> pick, int v, int depth) {
        if (depth == pick.size()) {
            answer2 = 0;
            for (int i = 0; i < pick.size(); i++) {
                answer2 += people[pick.get(i)];
                return;
            }
        }
        // 백트래킹
        for (int i = 0; i < ground.get(v).size(); i++) {
            if (!isSelected[ground.get(v).get(i)]) {
                isSelected[ground.get(v).get(i)] = true;
                dfs1(pick, pick.get(0), depth + 1);
                isSelected[ground.get(v).get(i)] = false;
            }
        }
    }
}






