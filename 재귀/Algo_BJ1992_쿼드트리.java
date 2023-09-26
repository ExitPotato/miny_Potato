package 재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Algo_BJ1992_쿼드트리 {

    public static int[][] mov;
    public static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        mov=new int[N][N];

        for(int i=0;i<N;i++){
            String line=br.readLine();

            for (int j=0;j<N;j++){
                mov[i][j]=line.charAt(j)-'0';
            }
        }
        Tree(0,0,N);
        System.out.println(sb);
    }

    public static void Tree(int x, int y, int size){
        if (isPossible(x,y,size)){  // 되면 하나만 써줘
            sb.append(mov[x][y]);
            return;
        }
        // 다르면 나눠서 다시 검색
        int newSize=size/2;
        sb.append('(');

        Tree(x,y,newSize);
        Tree(x,y+newSize,newSize);
        Tree(x+newSize,y,newSize);
        Tree(x+newSize,y+newSize,newSize);
        sb.append(')');
    }

    public static boolean isPossible(int x, int y, int size){
        if(size==1){
            return true;
        } else{
            // 2개 이상 검색의 경우 첫번째 값 기준으로 나머지랑 비교
            int color = mov[x][y];
            for(int i=x;i<x+size;i++){
                for(int j=y;j<y+size;j++){
                    if(mov[i][j]!=color){   // 다른색인 경우
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
