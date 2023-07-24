package 영재의시험19949;

import java.io.*;
import java.util.*;
public class Main {

    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> inputArr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            inputArr.add(Integer.parseInt(st.nextToken()));
        }

        arr = new int[inputArr.size()];

        search(0, inputArr);

        System.out.println(answer);
    }

    public static void search(int depth, ArrayList<Integer> inputArr){
        if(depth == arr.length){

            int score = 0;
            for (int i = 0; i < arr.length; i++) {
                if(inputArr.get(i) == arr[i])
                    score++;
            }

            if(score >= 5)
                answer++;
            return;
        }

        for (int i = 1; i <= 5; i++) {

            if(depth >= 2 && (arr[depth-1] == i) && (arr[depth-2] == i))
                continue;

            arr[depth] = i;
            search(depth+1, inputArr);
        }
    }
}
