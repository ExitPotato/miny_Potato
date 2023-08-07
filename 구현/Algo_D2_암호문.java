package 구현;

import java.util.LinkedList;
import java.util.Scanner;

public class Algo_D2_암호문 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String start = "";
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int count = 0; count < 1; count++) {
            list.clear();
            // 암호문 길이 넣어주기
            int how = sc.nextInt();
            //int[] qr = new int[how];
            // 원본 배열 넣어주기
            for (int i = 0; i < how; i++) {
                list.add(sc.nextInt());
            }
            // 명령어 개수 받기
            int plus = sc.nextInt();   // 몇개 추가할지
            for (int k = 0; k < plus; k++) {
                start = sc.next();  // I 받기
                int index = sc.nextInt();  // 시작위치
                int go = sc.nextInt();  // 몇번 받을지
                for (int i = index; i < index + go; i++) {
                    list.add(i, sc.nextInt());
                }
            }
            System.out.print("#" + (count + 1) + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
