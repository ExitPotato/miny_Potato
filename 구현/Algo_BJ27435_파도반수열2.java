package 구현;

import java.util.Scanner;

public class Algo_BJ27435_파도반수열2 {
    /*
    친구들아 감사합니다아아....
     */

    /*
    파도반수열이란?
    나선에 있는 정삼각형의 변의 길이를 말함.
    P(1)~P(3)을 제외하고
    P(n) = P(n-2) + P(n-2) 의 형식을 띄는 점화식으로 만들 수 있음
    이때 P(1) = P(2) = P(3) = 1
     */

    static long mod = 998244353;
    static long[][] base =  // 기본행렬 (Q 행렬)
            {
                    {0, 1, 1},
                    {1, 0, 0},
                    {0, 1, 0}
            };

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            long N = scan.nextLong();
            long answer = 0;
            if (N <= 3) {   // P(1) ~ P(3) 의 값은 1이기 때문에
                answer = 1;
            } else {
                long[][] pado = power(base, N-3); // 연산 결과가 저장될 배열
                answer = (pado[0][0] + pado[0][1] + pado[0][2]) % mod;
            }
            System.out.println(answer);
        }
    }

    static long[][] matrix(long[][] a, long[][] b) {    // 행렬을 곱하는 함수
        long[][] pado = new long[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    pado[i][j] += a[i][k] * b[k][j];
                }
                pado[i][j] %= mod;
            }
        }
        return pado;
    }

    static long[][] power(long[][] a, long count) {
        long[][] pado = new long[3][3];
        for (int i = 0; i < 3; i++) {
            pado[i][i] = 1;  // 곱할 행렬 만들어주기
        }
        while (count > 0) {
            if (count % 2 == 1) {   // 홀수개일 경우 하나 더 곱해주기
                pado = matrix(pado, a);
            }
            a = matrix(a, a);
            count /= 2;
        }
        return pado;
    }
}
