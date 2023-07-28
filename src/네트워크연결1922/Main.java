package 네트워크연결1922;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int depa;
    int dest;
    int cost;

    Edge(int depa, int dest, int cost){
        this.depa = depa;
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        return this.cost < o.cost ? -1 : 1;
    }
}
public class Main {

    static int n;
    static int m;

    static int[] parent;
    //static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        String[] input;

        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            pq.add(new Edge(a, b, c));
        }

        int answer = 0;
        while(pq.isEmpty() == false){

            Edge edge = pq.poll();

            if(find(edge.depa) != find(edge.dest)){
                union(edge.depa, edge.dest);
                answer += edge.cost;
            }
        }

        System.out.println(answer);
    }

    public static void union(int a, int b){

        a = find(a);
        b = find(b);

        if(a < b){
            parent[b] = find(a);
        }else{
            parent[a] = find(b);
        }
    }

    public static int find(int a){

        if(parent[a] == a)
            return a;

        return parent[a] = find(parent[a]);
    }
}
