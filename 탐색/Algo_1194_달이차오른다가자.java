package 탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_1194_달이차오른다가자 {

    static int N,M;
    static String[][] maze;

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze=new String[N][M];
        for (int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
        }
    }
}
