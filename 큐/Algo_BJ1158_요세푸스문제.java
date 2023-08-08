package 큐;

import java.util.*;

public class Algo_BJ1158_요세푸스문제 {

    public static void main(String[] args){
        Queue<Integer> q = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder st = new StringBuilder();
        // 버퍼로 추가해주기
        int num = sc.nextInt();
        int end = sc.nextInt();
        int count=0;
        // 큐에 수 추가
        st.append("<");
        for(int i=1;i<=num;i++){
            q.add(i);
        }
        // 큐가 빌 때 까지 뽑아주기
        while(!q.isEmpty()){
            count++;
            // 빼야 할 수면 빼주기
            if(count==end){
                st.append(q.poll());
                st.append(", ");
                count = 0;
            } else {
                // 아니라면 다시 큐에 넣어주기
                q.add(q.poll());
            }
        }
        st.deleteCharAt(st.length() - 1);
        st.deleteCharAt(st.length() - 1);
        st.append(">");
        System.out.println(st.toString());
    }
}
