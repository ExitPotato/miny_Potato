package 스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algo_BJ2493_탑 {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        // 탑 위치 받기
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!stack.empty()) {
                if (stack.peek()[1] > height) {
                    sb.append(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }
            if (stack.empty()) {
                sb.append("0 ");
            }
            stack.push(new int[]{i, height});

        }
        System.out.println(sb.toString());
//        answer[0]=0;
//        //int count = 0;
//        for(int i =1;i<T;i++){
//            //count = i-1;
//            for(int k=i-1;k>=0;k--){
//                if(miss[i]<=miss[k]){
//                    answer[i]=k+1;
//                    break;
//                }
//            }
////            while(count>=0){
////                if (miss[i]<=miss[count]){
////                    answer[i]=count+1;
////                    break;
////                }
////                count--;
////            }
//        }
//        for(int i=0;i<T;i++){
//            System.out.print(answer[i] + " ");
//        }
    }
}
