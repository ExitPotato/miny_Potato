package 큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_BJ2164_카드2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();  // 큐 배열 선언해주기

        // 큐에 숫자 넣어주기
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        for(int i=0;i<N-1;i++){
            queue.remove(); // 첫번째 숫자 바닥에 버리기
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
