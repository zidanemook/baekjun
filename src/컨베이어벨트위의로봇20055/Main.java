package 컨베이어벨트위의로봇20055;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);//2~100
        int K = Integer.parseInt(input[1]);//1~2N
        int maxlen = 2*N;

        input = br.readLine().split(" ");
        int[] dura = new int[maxlen+1];
        for (int i = 1; i < maxlen+1; i++){
            dura[i] = (Integer.parseInt(input[i-1]));
        }

        int takeon = 1;
        int takeoff = N;

        int[] convey = new int[N+1];
        int answer = 0;

        while(true){

            //벨트회전
            takeon--;
            takeoff--;
            if(takeon < 1)
                takeon = maxlen;
            if(takeoff < 1)
                takeoff = maxlen;

            for (int i = convey.length-1; i >= 0 ; i--) {
                if(convey[i] == 1){
                    if(i == convey.length-1)
                        convey[i] = 0;
                    else{
                        convey[i] = 0;
                        convey[i+1] = 1;
                    }

                }
            }

            //박스이동
            for (int i = convey.length-1; i >= 1 ; i--) {
                if(convey[i] == 1){
                    int durapos = i + takeon;//이동하려는 위치의 내구성 인덱스
                    if(durapos > maxlen)
                        durapos -= maxlen;

                    if(i == convey.length-1)
                        convey[i] = 0;
                    else if(convey[i+1] == 0 && dura[durapos] > 0){
                        convey[i] = 0;
                        convey[i+1] = 1;
                        dura[durapos]--;
                    }

                }
            }

            //박스올리기
            if(dura[takeon] > 0 && convey[1] == 0){
                convey[1] = 1;
                dura[takeon]--;
            }


            //내구도검사
            int dcount = 0;
            for (int i = 1; i < dura.length; i++) {
                if(dura[i] == 0){
                    dcount++;
                }
            }

            answer++;
            if(dcount >= K)
                break;
        }

        System.out.println(answer);
    }
}
