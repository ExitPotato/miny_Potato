package 슬라이딩윈도우;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Algo_BJ12891_DNA비밀번호 {

    static int S, P;
    private static int pwdKindCnt;
    static int[] minOccurs;

    public static void main(String[] args) throws Exception {

        // map과 재귀를 사용해야 하는 문제
        // DNA문자열 ==> 'A', 'C', 'G', 'T' 문자로만 구성된 문자열

        Scanner sc = new Scanner(System.in);
        S = sc.nextInt();   // DNA 문자열 길이
        P = sc.nextInt();   // 비밀번호로 사용할 부분분자열 길이
        String DNAStr = sc.next();  // DNA 문자열

        minOccurs = new int[4];   // 'A', 'C', 'G', 'T'의 최소 출현횟수 저장

        // 최소 넣어줘야 하는 개수 넣어주기
        for (int i = 0; i < 4; i++) {
            minOccurs[i] = sc.nextInt();
        }

        // 각 문자가 0번 이상 발생할 수 있으므로 각 문자 키값에 기본값 0 입력
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);

        // 윈도우 시작
        for (int i = 0; i < P; i++) {
            map.put(DNAStr.charAt(i), map.get(DNAStr.charAt(i)) + 1);
            // map에 현재 위치의 문자열 개수 추가해주기
        }

        if (validCheck(map)) pwdKindCnt++;

        // 윈도우 밀기
        for (int i=1;i+P<=S;i++){
            char delKey=DNAStr.charAt(i-1); // 제거 할 인덱스 찾기
            char addKey = DNAStr.charAt(i-1+P); // 추가 할 인덱스 찾기

            map.put(delKey, map.get(delKey)-1); // 제거할 문자 카운트 1 감소 후 수정
            map.put(addKey, map.get(addKey)+1); // 추가할 문자 카운트 1 증가 후 수정

            if (validCheck(map)) pwdKindCnt++;  // true면 패스워드 종류 추가해주기
        }
        System.out.println(pwdKindCnt); // 총 개수 출력
        sc.close();

        // map 사용!
        // key값은 유니크해

        // 하나하나 뽑으면 map에서 뭔가가 걸리기 때문에? 그걸로 알 수 있음!

        // validCheck에 정보 있어
        // 발생해야 하는 최솟값보다 작으면 fail 리턴해주기

        // 윈도우 밀기가 슬라이딩윈도우야

    }

    private static boolean validCheck(Map<Character, Integer> map) {

        for (Character key : map.keySet()) {
            if (key == 'A') {  // key가 A라면
                if (map.get(key) < minOccurs[0]) return false;
                // 최소 요구되는 정도보다 작다면 틀리다고 반환해주기
            } else if (key == 'C') {
                if (map.get(key) < minOccurs[1]) return false;
            } else if (key == 'G') {
                if (map.get(key) < minOccurs[2]) return false;
            } else if (key == 'T') {
                if (map.get(key) < minOccurs[3]) return false;
            }
        }
        return true;
        // 최소 요구 갯수를 모두 충족하면 맞다고 반환
    }
}