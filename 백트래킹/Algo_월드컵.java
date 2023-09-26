package 백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_월드컵 {
    static int answer;

    public static void dfs(int[][] match, int[][] game, int[][] teams, int round) {
        if (answer == 1) {
            return; // 정답이 있으면 난 뭣도 안하겠다
        }
        if (round == 15) {    // 라운드만큼 돌았을 때
            for (int i = 0; i < 6; i++) {  // 6개 나라의
                for (int j = 0; j < 3; j++) {   // 승,무,패 비교해주기 근데 이제 다르다면의 경우로
                    if (match[i][j] != game[i][j]) { // 다르면
                        return; // 더 볼 것도 없이 탈출
                    }
                }
            }
            answer = 1; // 다 똑같다면 정답처리 해 주기
            return; // 탈출!!!
        }

        int team1 = teams[round][0];
        int team2 = teams[round][1];

        // 1번이 이기는 경우
        if (game[team1][0] < match[team1][0] && game[team2][2] < match[team2][2]) {
            // 1이 이긴 횟수와 2가 진 횟수가 정답보다 작아야 하므로 미리 비교
            game[team1][0] += 1; // 1번 승점 1점 추가
            game[team2][2] += 1; // 2번 실점 1점 추가
            dfs(match, game, teams, round + 1);   // 재귀를 통해 다음 라운드로 가기
            game[team2][2] -= 1;
            game[team1][0] -= 1;
        }
        // 1번이 2번이랑 비기는 경우
        if (game[team1][1] < match[team1][1] && game[team2][1] < match[team2][1]) {
            game[team1][1] += 1;
            game[team2][1] += 1;
            dfs(match, game, teams, round + 1);
            game[team1][1] -= 1;
            game[team2][1] -= 1;
        }
        // 1번이 지는 경우
        if (game[team1][2] < match[team1][2] && game[team2][0] < match[team2][0]) {
            game[team1][2] += 1;
            game[team2][0] += 1;
            dfs(match, game, teams, round + 1);
            game[team1][2] -= 1;
            game[team2][0] -= 1;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] match = new int[6][3];  // 각 6팀, 승무패 의 3가지 경우
        int[][] game = new int[6][3];   // 예상 결과니까 각 6팀, 승무패 3가지 경우
        int[][] teams = new int[15][2]; // 15번 경기, 2팀씩

        int index = 0;
        for (int j = 0; j < 5; j++) {
            for (int j2 = j + 1; j2 < 6; j2++) {
                teams[index][0] = j;
                teams[index][1] = j2;
                index += 1;
            }
        }
        for (int i = 0; i < 4; i++) {
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                match[j][0] = Integer.parseInt(st.nextToken());
                match[j][1] = Integer.parseInt(st.nextToken());
                match[j][2] = Integer.parseInt(st.nextToken());
            }
            dfs(match, game, teams, 0);
            sb.append(answer).append(" ");
        }
        System.out.println(sb.toString());
    }
}
