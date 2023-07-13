package 도시건설21924;

import java.io.*;
import java.util.*;

class Road{
    int cost;
    int start;
    int end;


    Road(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}
public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);//건물개수
        int m = Integer.parseInt(input[1]);//도로개수

        ArrayList<Road> roads = new ArrayList<>();

        long sumcost = 0;
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            roads.add(new Road(start, end, cost));
            sumcost+=cost;
        }

        Collections.sort(roads, (a, b) ->{
            return a.cost < b.cost ? -1 : 1;
        });


        parent = new int[n+1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        long answer = 0;
        int ecount = 0;
        for (int i = 0; i < roads.size(); i++) {
            int start = roads.get(i).start;
            int end = roads.get(i).end;
            int cost = roads.get(i).cost;

            if(find(start) != find(end)){
                union(start, end);
                answer+=cost;
                ecount++;
            }else{
                continue;
            }

            if(ecount == n-1)
                break;
        }

        if(ecount == n-1)
            System.out.println(sumcost-answer);
        else
            System.out.println(-1);
    }
    public static void union(int a, int b){

        int roota = find(a);
        int rootb = find(b);

        if(roota < rootb){
            parent[rootb] = roota;
        }else{
            parent[roota] = rootb;
        }
    }

    public static int find(int num){
        if(parent[num] == num)
            return num;

        return parent[num] = find(parent[num]);
    }
}
