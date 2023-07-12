package 랭퍼든수열쟁이야15918;

import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    static int counter = 0;//testcode
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        int y = Integer.parseInt(input[2]);

        int len = n*2+1;

        int[] arr = new int[len];
        boolean[] visit = new boolean[n+1];

        arr[x] = arr[y] = y-x-1;//간격이 정해지면 숫자를 알 수 있다. 1과 5이면 간격이3 이므로 3을 넣어주면된다
        visit[y-x-1] = true;

        search(len, 1, arr, visit, x, y, n);

        System.out.println(answer);
        System.out.println(counter);//testcode
    }
    public static void search(int len, int depth, int[] arr, boolean[] visit, int x, int y, int n) {

        counter++;//testcode

        if (depth == len) {
            answer++;
            return;
        }


        if (arr[depth] != 0) {
            search(len, depth + 1, arr, visit, x, y, n);
        } else {
            for (int i = 1; i <= n ; i++) {
                if (false == visit[i] && (depth + i + 1) < len && arr[depth + i + 1] == 0) {
                    visit[i] = true;
                    arr[depth] = i;
                    arr[depth + i + 1] = i;
                    search(len, depth + 1, arr, visit, x, y, n);
                    visit[i] = false;
                    arr[depth] = 0;
                    arr[depth + i + 1] = 0;
                }
            }
        }
    }
}
