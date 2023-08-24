package 슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Algo_BJ15961_회전초밥 {

    /*
    임의 위치부터 연속해서 k개 먹을 경우 할인된 정액 가격으로 제공
    초밥의 전체 수 만큼 돌아야 할 듯
    밀면서 옆으로 하나씩 가면서 초밥의 종류 확인하기
    초밥 가짓수의 max를 저장해주기
    만약 max가 같을 경우에는 추가로 주는 초밥을 포함하고 있는지 확인해주기
    근데 전체 초밥의 가짓수는 왜 필요한 것? ==> 시간초과나서요...

    배열로 그냥 푸니까 시간초과 나버림...
    때문에 투포인터를 사용해서... 움직이면 앞에서 하나 빼고 뒤에서 하나 더하는 식으로 해야함...
     */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 벨트에 놓인 접시의 수
        int d = Integer.parseInt(st.nextToken());   // 전체 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken());   // 한번에 먹을 접시의 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호(초밥 번호)

        int[] sushi = new int[N];   // 초밥 순서
        ArrayList<Integer> eat;   // 내가 픽할 초밥
        int total = 0;  // 내가 고른 초밥의 가짓수
        int result = 0;
        int event = 0;  // 이벤트까지 고려해서 먹을 초밥의 가짓수
        eat = new ArrayList<Integer>(); // 픽할 초밥을 담을 리스트
        int[] pick = new int[d + 1];  // 0번 초밥은 없으므로(먹었는지 확인하기 위해)

        for (int i = 0; i < N; i++) {   // 접시 개수만큼 입력받기
            sushi[i] = Integer.parseInt(br.readLine());    // 초밥 순서대로 배열 입력받기
        }
        int start = 0;  // 시작은 0번부터
        int end = k - 1;  // 배열의 몇 번째를 추가해줄건지
        for (int i = 0; i < k; i++) {   // 초기 초밥 값 입력해주기
//            if (!eat.contains(sushi[i]))    // 안들어있으면 넣어주기
//                eat.add(sushi[i]);

            if (pick[sushi[i]] == 0)
                total++;
            pick[sushi[i]]++;   // 픽한 초밥 위치의 개수 추가해주기
        }
        event = total;
        if (pick[c] == 0) // 이벤트 초밥 안먹었으면 먹은 종류에 추가해주기
            event++;
        result = event;
        //System.out.println(result);

        for (int i = 0; i < N; i++) {  // 마지막까지 계산해주기
            pick[sushi[i]]--;    // 맨 앞에거 하나 빼주기
            if (pick[sushi[i]] == 0)   // 한번만 먹었던 초밥이면
                total-=1;
            if (pick[sushi[(k + i ) % N]] == 0)  // 뒤에 먹을게 한번도 안먹은거면
                total+=1;
            pick[sushi[(k + i) % N]]++;     // 뒤에 추가할거 더해주기
           // System.out.println(Arrays.toString(pick));

            if (pick[c]==0){    // 이벤트 초밥 안먹었으면
                result = Math.max(result, total+1);
            } else{ // 이미 먹었던 초밥이라면
                result = Math.max(result, total);
            }
            //System.out.println(result);
        }
        // 시간초과 났던 코드들
//        // 받은 배열의 0번째부터 하나씩 이동하면서 확인해주기
//        for (int i = 0; i < N; i++) {  // 전체 초밥 다 돌기
//            eat = new ArrayList<Integer>();
//            int count = 0;
//            for (int j = 0; j < k; j++) {   // 내가 선택한 초밥 개수만큼 돌아주기
//                if (!eat.contains(sushi[(i + j) % N]))    // 내가 고른 초밥이 리스트에 없으면
//                    eat.add(sushi[(i + j) % N]);    // 리스트에 추가해주기
//            }
//            if (eat.size() == k && !eat.contains(c)) {
//                total = eat.size() + 1;
//                break;
//            }
//            // 지금 초밥이 최선의 경우인지 생각해보기
//            if (eat.contains(c))    // 초밥에 쿠폰 번호가 포함되어있으면
//                count = eat.size(); // 선택한 사이즈만큼만
//            else    // 아니면
//                count = eat.size() + 1; // 초밥의 가짓수도 추가해주기
//            total = Math.max(count, total); // total과 count 중 큰 것을 total로 설정해주기
//        }
        System.out.println(result);
    }
}
