package 탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Algo_BJ17281_야구 {
    /*
    4번째 선수는 무조건 1번
    1번은 4번째로 고정, 다른 선수들의 순서를 다 돌려본다...? ==> 이게 맞더라
    그라운드에 있는 선수는 큐로, 선수의 순서는 배열로
     */
    static int[][] score;
    static int[]  people;   // 선수의 순서 넣을 배열
    static boolean[] isSelected = new boolean[9];

    /*
    deque를 사용하면 queue보다 성능이 좋아~
    Permutation(순열)을 사용해서 선수 뽑기(4번째 타자는 1번 고정)
    그라운드에 있는 선수를 queue로 저장하고, 맨 처음에 0을 세개 넣어주기
     */

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int round = Integer.parseInt(br.readLine());
        isSelected[0]=true; // 4번째 선수는 1번으로 정해져 있으므로
        score = new int[round][9];  // 라운드마다 9명의 점수 기록

        for (int t = 0; t < round; t++) {

        }

    }

    public static void makePermu(int count) {
        if (count==9){  // 선수만큼 다 뽑았으면
            // 점수 비교해주기

        }
        for (int i=0;i<9;i++){
            if(count==3){
                people[count]=0;
                continue;
            }
            if(isSelected[i]){
                people[count] = 0;
                isSelected[i]=true;
                makePermu(count+1);
            }
        }
    }
}
