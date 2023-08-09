package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BJ16935_배열돌리기3 {

	static int[][] result;
	static int[][] sec;

	public static void main(String[] args) throws Exception {

		int N, M, R; // 세로줄, 가로줄, 연산횟수
		int[][] first, answer;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로줄 받기
		M = Integer.parseInt(st.nextToken()); // 가로줄 받
		R = Integer.parseInt(st.nextToken()); // 회전 횟수 받기
		first = new int[N][M];


		// 배열에 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				first[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// result가 정답을 담을 배열
		// sec가 이전 배열을 담고 있는 배열
		result = first;
		sec = first;
		// 회전 횟수만큼 어떤거 할지 입력받기
		int howto;
		st = new StringTokenizer(br.readLine());
		for (int r = 0; r < R; r++) {
			howto = Integer.parseInt(st.nextToken());

			// 1번의 경우(상하 반전)
			if (howto == 1) {
				answer = new int[result.length][result[0].length]; // 매번 새로 만들어주기
				for (int i = 0; i < result.length; i++) {
					for (int j = 0; j < result[0].length; j++) {
						answer[i][j] = sec[result.length - 1 - i][j];
					}
				}
				result = answer;
				sec = answer;
			}

			// 2번의 경우(좌우 반전)
			else if (howto == 2) {
				answer = new int[result.length][result[0].length];
				for (int i = 0; i < result.length; i++) {
					for (int j = 0; j < result[0].length; j++) {
						answer[i][j] = sec[i][result[0].length - 1 - j];
					}
				}
				result = answer;
				sec = answer;
			}
			// 3번의 경우(오른쪽 90도 회전)
			else if (howto == 3) {
				answer = new int[result[0].length][result.length];
				for (int i = 0; i < result.length; i++) { // 6.8
					for (int j = 0; j < result[0].length; j++) {
						answer[j][result.length - 1 - i] = sec[i][j];
					}
				}
				result = answer;
				sec = answer;
			}

			// 4번의 경우(왼쪽 90도 회전)
			else if (howto == 4) {
				answer = new int[result[0].length][result.length];
				for (int i = 0; i < result.length; i++) { // 6.8
					for (int j = 0; j < result[0].length; j++) {
						answer[result[0].length - 1 - j][i] = sec[i][j];
					}
				}
				result = answer;
				sec = answer;
			}

			// 1 2
			// 3 4
			
			// 5번의 경우
			else if (howto == 5) {
				int row = result.length / 2;
				int col = result[0].length / 2;
				answer = new int[result.length][result[0].length];
				// 1번을 2번으로 옮기는 부분
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						answer[i][col + j] = sec[i][j];
					}
				}
				// 2번을 3번으로 옮기는 부분
				for (int i = 0; i < row; i++) {
					for (int j = col; j < result[0].length; j++) {
						answer[row + i][j] = sec[i][j];
					}
				}
				// 3번을 4번으로 옮기는 부분
				for (int i = row; i < result.length; i++) {
					for (int j = col; j < result[0].length; j++) {
						answer[i][j - col] = sec[i][j];
					}
				}
				// 4번을 1번으로 옮기는 부분
				for (int i = row; i < result.length; i++) {
					for (int j = 0; j < col; j++) {
						answer[i - row][j] = sec[i][j];
					}
				}
				result = answer;
				sec = answer;
			}

			// 6번의 경우
			else if (howto == 6) {
				int row = result.length / 2;
				int col = result[0].length / 2;
				answer = new int[result.length][result[0].length];

				// 1번을 4번으로 옮기는 부분
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						answer[i + row][j] = sec[i][j];
					}
				}
				// 4번을 3번으로 옮기는 부분
				for (int i = row; i < result.length; i++) {
					for (int j = 0; j < col; j++) {
						answer[i][j + col] = sec[i][j];
					}
				}
				// 3번을 2번으로 옮기는 부분
				for (int i = row; i < result.length; i++) {
					for (int j = col; j < result[0].length; j++) {
						answer[i - row][j] = sec[i][j];
					}
				}
				// 2번을 1번으로 옮기는 부분
				for (int i = 0; i < row; i++) {
					for (int j = col; j < result[0].length; j++) {
						answer[i][j - col] = sec[i][j];
					}
				}
				result = answer;
				sec = answer;
			}
		}
		// 정답출력
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}
}
