package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BJ1629_곱셈 {

    /*
    반례 예시
    99999 99999 100000 를 넣은 경우
    99999가 나와야 함

    시간초과가 나기 때문에 분할정복으로 계산해 줘야 함
    지수가 1이 될 때 까지 계속 쪼개서 계산해야 한다
    -> 지수가 홀수인 경우와 짝수인 경우를 나눠서 계산해주어야 한다
    지수 법칙 : a^b = a^(b/2) * a^(b/2)
    나머지 법칙 : (a*b)%c = (a%c * a%c) % c

     */
    /*
     * 지수 법칙에 의해
     * 시간 복잡도 : O(logN)
     * b = 1     , a^b = a
     * b % 2 == 0, a^b = a^(b/2) * a^(b/2)
     * b % 2 == 1, a^b = a * a^(b-1)
     * */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long plus = 0;
        long half;
        long answer;

//        if (b%2==1){    // b가 홀수면
//            plus = (b-1)/2;
//            half =(long) (Math.pow(a, plus));
//            answer = (half%c)*(half%c)*(a%c)%c;
//        } else{
//            plus = b/2;
//            half = (long) (Math.pow(a, plus));
//            answer = (half%c)*(half%c)%c;
//        }
        // 위에처럼 했다가 반례에서 망함
        System.out.println(div(a,b,c));

    }

    public static long div(long a, long b, long c){
        if (b == 1){
            // 지수가 1이면 바로 나머지 구하기
            return a%c;
        }
        else{   // 지수가 1 이상이면 지수를 반으로 나눠서 계산, 다시 나머지 구하기
            long halfv = div(a, b/2, c);
            if(b%2==1){
                return (halfv*halfv%c)*a%c;
            }
            return halfv*halfv%c;
        }
    }
}
