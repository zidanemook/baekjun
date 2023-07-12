package 소셜네트워킹어플리케이션7511;

import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {

            sb.append("Scenario " + (i+1) + ":" + "\n");

            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            parent = new int[n];
            for (int j = 0; j < n; j++) {
                parent[j] = j;
            }

            String[] input;
            for (int j = 0; j < k; j++) {
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                union(a, b);
            }

            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                if(find(a) == find(b)){
                    sb.append(1 + "\n");
                }else{
                    sb.append(0 + "\n");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int find(int num){
        if(parent[num] == num){
            return num;
        }else{
            return parent[num] = find(parent[num]);//union 에서 find 호출할때 경로압축이 되도록 필요 없으면 시간복잡도 상승
        }
    }
    public static void union(int a, int b){

        int rootA = find(a);
        int rootB = find(b);

        if(rootA < rootB){
            parent[rootB] = rootA;
        }else{
            parent[rootA] = rootB;
        }
    }

}
