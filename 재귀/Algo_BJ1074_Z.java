package 재귀;

import java.util.Scanner;

public class Algo_BJ1074_Z {

    static int N, r, c;
    static int[] arr;
    static int result;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        divide(0, 0, (int) Math.pow(2, N), 0);
        System.out.println(result);
    }

    static void divide(int y, int x, int size, int num) {
        if (r == y && c == x) {   // 탈출할 기저조건
            result = num;
            return;
        }

        int halfSize = size / 2;  // 반으로 뿌라기
        int midY = y + halfSize;
        int midX = x + halfSize;

        int nextY = 0, nextX = 0;

        if (midY > r && midX > c) { // 2사분면 계산
            nextY = y;
            nextX = x;
        } else if (midY > r && midX <= c) { // 1사분면 계산
            nextY = y;
            nextX = midX;
            num += halfSize * halfSize;
        } else if (midY <= r && midX > c) { // 3사분면 계산
            nextY = midY;
            nextX = x;
            num += halfSize * halfSize * 2;
        } else if (midY <= r && midX <= c) { // 4사분면 계산
            nextY = midY;
            nextX = midX;
            num += halfSize * halfSize * 3;
        }

        divide(nextY, nextX, halfSize, num);
    }
}
