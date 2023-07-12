package 사이클게임20040;


import java.io.*;
import java.util.*;
public class Main {

    static int[] parent;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);//3 ~ 500000
        int M = Integer.parseInt(input[1]);//3 ~ 1000000

        parent = new int[N];
        for(int i = 0; i < N; i++) parent[i] = i;

        int answer = 0;
        for (int i = 1; i <= M; i++) {
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            if(find(a) == find(b)){
                answer = i;
                break;
            }

            union(a, b);
        }

        System.out.println(answer);
    }

    public static int find(int num){
        if(parent[num] == num)
            return num;
        else
            return parent[num] = find(parent[num]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
}
