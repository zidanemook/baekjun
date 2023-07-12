package 진우의민트초코우유20208;

import java.io.*;
import java.util.*;

class Milk{
    int r;
    int c;
    Milk(int r, int c){
        this.r = r;
        this.c = c;
    }
}
public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int h = Integer.parseInt(input[2]);

        int[] start = new int[2];
        ArrayList<Milk> arrmilk = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(input[j]);
                if(value == 2){
                    arrmilk.add(new Milk(i, j));
                }else if(value == 1){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        int len = arrmilk.size();
        Milk[] milks = new Milk[len+1];
        boolean[] visit = new boolean[len+1];
        milks[0] = new Milk(start[0], start[1]);
        dfs(m, h, 1, len+1, milks, visit, arrmilk);

        System.out.println(answer-1);
    }

    public static void dfs(int m, int h, int depth, int len, Milk[] milks, boolean[] visit, ArrayList<Milk> arrmilk){

        if(depth > answer){
            int dist = Math.abs(milks[0].r - milks[depth-1].r)+Math.abs(milks[0].c - milks[depth-1].c);
            if(m>=dist)
                answer = depth;
        }

        if(depth == len){

            return;
        }

        int curm = m;
        int dist = 0;
        for (int i = 0; i < len-1; i++) {

            Milk pre = milks[depth-1];
            Milk milk = arrmilk.get(i);
            dist = Math.abs(pre.r - milk.r)+Math.abs(pre.c - milk.c);

            if(visit[i] == false && m >= dist){

                visit[i] = true;
                milks[depth] = milk;
                dfs(m+h-dist, h, depth+1, len, milks, visit, arrmilk);
                visit[i] = false;
            }

        }
    }
}
