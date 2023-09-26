package 백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo_BJ1759_암호만들기 {

    static String[] key, answer;
    static int L, C;
    static int[] isSelected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        key = br.readLine().split(" ");
        answer = new String[L];
        isSelected = new int[C];
        Arrays.sort(key);
        makeCombi(0, 0);
    }

    public static void makeCombi(int count, int start) {
        if (count == L) {  // L만큼 다 뽑으면
            // 자음이랑 모음 확인해주기
            int ja = 0;
            int mo = 0;
            for (int i = 0; i < L; i++) {
                if (answer[i].equals("a") || answer[i].equals("e") ||
                        answer[i].equals("i") || answer[i].equals("o") || answer[i].equals("u")) {
                    mo++;
                } else {
                    ja++;
                }
            }
            if (ja >= 2 && mo >= 1) {   // 조건을 충족하면
                for (int j = 0; j < L; j++) {
                    System.out.print(answer[j]);
                }
                System.out.println();
            }
            return;
        }
        for (int i = start; i < C; i++) {
            answer[count] = key[i];
            makeCombi(count + 1, i + 1);
        }
    }
}
