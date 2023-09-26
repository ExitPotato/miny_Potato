package 정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Algo_BJ1755_숫자놀이 {

    static String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        LinkedList<String> list = new LinkedList<>();   // 영어 넣을거
        LinkedList<Integer> list2 = new LinkedList<>(); // 숫자 넣을거

        for(int i=M;i<=N;i++){
            int ten = i/10;
            int one = i%10;
            if(ten==0){
                list.add(number[one]);
                continue;
            }
            list.add(number[ten]+" "+number[one]);  // 두자리 숫자일 경우
        }
        list.sort(null);    // 사전순 정렬

        // 리스트에서 뽑아내서 계산하기
        while(!list.isEmpty()){
            String num = list.poll();   // 맨 앞꺼 하나 뽑아내기
            if(num.contains(" ")){  // 공백이 있으면(두자리 숫자면)
                st = new StringTokenizer(num);
                int ten = findeng(st.nextToken());
                int one = findeng(st.nextToken());
                list2.add(ten*10+one);
            } else{
                list2.add(findeng(num));
            }
        }
        while(!list2.isEmpty()){
            for(int i=0;i<10;i++){
                if(list2.isEmpty())
                    return;
                System.out.print(list2.poll()+" ");
            }
            System.out.println();
        }
    }

    static int findeng(String eng){
        for(int i=0;i<=9;i++){
            if(eng.equals(number[i])){
                return i;
            }
        }
        return 0;
    }
}
