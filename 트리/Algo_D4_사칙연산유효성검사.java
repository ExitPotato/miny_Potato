package 트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_D4_사칙연산유효성검사 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count;

        for (int i = 1; i <= 10; i++) {
            boolean answer = true;

            int N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                if (answer == true) {
                    count = Integer.parseInt(st.nextToken());
                    String second = st.nextToken();
                    if (second.equals("-") || second.equals("+") || second.equals("/") || second.equals("*")) {
                        if (st.hasMoreTokens()) {

                        } else {
                            answer = false;
                        }
                    } else {
                        if (st.hasMoreTokens()==true) {
                            answer = false;
                        }
                    }
                }
            }
            if (answer == true) {
                System.out.println("#" + i + " 1");
            } else {
                System.out.println("#" + i + " 0");
            }
        }
    }
}
