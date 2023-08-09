package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BJ2563_색종이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        // 색종이 배열 생성
        int[][] colorpapaer = new int[101][101];
        int result = 0;

        // 색종이 배열 받기
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            for (int j = row; j < row + 10; j++) {
                for (int k = col; k < col + 10; k++) {
                    colorpapaer[j][k] += 1;
                }
            }
        }
        // 총 까만 부분 추가해주기, 때문에 0이 아니기만 하면 됨
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (colorpapaer[i][j] != 0)
                    result += 1;
            }
        }
        System.out.println(result);

        // --이하 한번 망했던 풀이
        // --왜 망했는가? 에 대한 고찰
        //int total = 100*count;
        // 배열 생성
        //int[][] paper = new int[count][2];

        // --아래처럼 색종이를 전부 배열에 넣은 후에 겹치는 부분이 있는지 확인하고 전체에서 빼주려고 했음
        // 횟수만큼 배열에 넣기
//        for (int i = 0; i < count; i++) {
//            st = new StringTokenizer(br.readLine());
//            paper[i][0] = Integer.parseInt(st.nextToken());   // 가로로 떨어진 길이
//            paper[i][1] = Integer.parseInt(st.nextToken());   // 세로로 떨어진 길이
//        }
        // 비교해주기
        // --하지만 이렇게 할 경우? 겹치는 부분이 엄청 많을 경우에 대한 계산이 이상해지는거같음...ㅠㅜ
//        for (int i = 0; i < count-1; i++) {
//            for (int j=i+1;j<count;j++){    // i의 다음것부터 비교
//                // 색종이가 겹치는 경우
//                if(Math.abs(paper[i][0]-paper[j][0])<10 && Math.abs(paper[i][1]-paper[j][1])<10){
//                    total -= (10-(Math.abs(paper[i][0]-paper[j][0])))*(10-(Math.abs(paper[i][1]-paper[j][1])));
//                }
//            }
//        }
//        System.out.println(total);
    }
}
