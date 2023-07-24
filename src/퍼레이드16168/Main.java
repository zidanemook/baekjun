package 퍼레이드16168;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        boolean[] visit = new boolean[v+1];
        visit[1] = true;
        if(v != (1 + connected(arr, 1, visit))){
            System.out.println("NO");
            return;
        }

        int odd = 0;
        int even = 0;
        for (int i = 1; i <= v; i++) {
            if(arr.get(i).size() %2 == 0)
                even++;
            else
                odd++;
        }

        if(even == v || odd == 2){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

    static int connected(ArrayList<ArrayList<Integer>> arr, int parent, boolean[] visit){

        ArrayList<Integer> cur = arr.get(parent);
        int count = 0;
        for (int i = 0; i < cur.size(); i++) {
            int child = cur.get(i);

            if (visit[child] == false) {
                visit[child] = true;
                count += connected(arr, child, visit) + 1;
                //visit[child] = false;
            }

        }

        return count;
    }
}
