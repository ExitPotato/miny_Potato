package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_SWEA8458_원점으로집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] dist;
        int[] rest;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            dist = new int[N];
            rest = new int[N];
            int answer = 0;
            int max = 0;
            int idx = 0;
            int total = 0;
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                dist[n] = Math.abs(x) + Math.abs(y);    // 거리가 필요한거기 때문에 절대값만 필요
                rest[n] = dist[n] % 2;
                max = Math.max(max, dist[n]);
            }
            // 모두 홀수이거나 모두 짝수일때만 가능하기 때문에 가/불가 여부 판단해주기
            for (int i = 0; i < N - 1; i++) {
                if (rest[i] != rest[i + 1]) {
                    answer = -1;
                    break;
                }
            }
            if (max==0){
                answer = 0;
            }
            else if (answer==-1){
                // 안되는 것이기 때문에 -1 출력
            }
            else{   // max값만 받아와서 계산해주기
                while (total<max){
                    idx++;
                    total += idx;
                }
                if (total == max){
                    answer = idx;
                }
                else{
                    total-=idx;
                    //System.out.println(total+" "+idx);
                    if ((max-total)%2!=idx%2){ // 둘의 홀짝이 다르면
                        if (idx%2==0){
                            answer=idx+1;
                        }
                        else{
                            answer=idx+2;
                        }
                    } else{
                        answer = idx;
                    }
                }
            }
            System.out.printf("#%d %d", t, answer);
            System.out.println();
        }
    }
}
