package 탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Algo_BJ3040_백설공주와일곱난쟁이 {

    static int[] hobbit;
    static int[] answer;
    static boolean find;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        hobbit = new int[9];
        answer = new int[7];

        // 난쟁이 입력받기
        for (int i = 0; i < 9; i++) {
            hobbit[i] = Integer.parseInt(br.readLine());
        }
        // 난쟁이 계산하기
        find = false;
        makeHobbit(0, 0, new int[7]);

    }

    public static void makeHobbit(int count, int start, int[] answer2) {
        if (count == 7) {
            // 난쟁이 계산하기
            result = 0;
            for (int i = 0; i < 7; i++) {
                result += answer2[i];
            }
            if (result == 100) {
                for (int i = 0; i < 7; i++) {
                    System.out.println(answer2[i]);
                    find = true;
                }
            }
            return;
        }
        if (find == false) {
            for (int i = start; i < 9; i++) {
                answer2[count] = hobbit[i];
                makeHobbit(count + 1, i + 1, answer2);
            }
        }
    }
}
