package N과M5_15654;

import java.io.*;
import java.util.*;

public class Main {

    static int N;//1~8
    static int M;//1~8
    static Integer[] arr;
    static ArrayList<String> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    //static int count = 0; //testcode

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        ArrayList<Integer> arrInput = new ArrayList<>();
        for(int i = 0; i < N; ++i){
            arrInput.add(Integer.parseInt(input[i]));
        }

        Collections.sort(arrInput);
        boolean visit[] = new boolean[N];
        arr = new Integer[M];

        dfs(0, arrInput, visit);

        answer.stream().forEach( (s)->{
            System.out.println(s);
        });
    }

    public static void dfs(int depth, ArrayList<Integer> arrInput, boolean visit[]){

        //count++;

        sb.setLength(0);
        if(depth == M){
            for (int i = 0; i < arr.length; ++i) {
                if(i == arr.length - 1)
                    sb.append(arr[i]);
                else
                    sb.append(arr[i] + " ");
            }

            answer.add(sb.toString());

            return;
        }

        for(int i = 0; i < N; ++i){

            if(visit[i] == false){
                arr[depth] = arrInput.get(i);
                visit[i] = true;
                dfs(depth+1, arrInput, visit);
                visit[i] = false;
            }
        }
    }
}
