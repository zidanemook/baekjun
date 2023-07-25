package 샘터18513;

import java.io.*;
import java.util.*;

class Zip implements Comparable<Zip>{
    int pos;
    int dist;
    Zip(int pos, int dist){
        this.pos = pos;
        this.dist = dist;
    }

    @Override
    public int compareTo(Zip o){
        return this.dist < o.dist ? -1 : 1;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        PriorityQueue<Zip> pq = new PriorityQueue<>();
        HashSet<Integer> visit = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(input[i]);
            pq.add(new Zip(temp, 0));
            visit.add(temp);
        }

        long answer = 0;
        int zipcnt = k;
        while(zipcnt > 0){

            Zip cur = pq.poll();

            int neighbor = 0;
            for (int i = 0; i < 2; i++) {

                if(i == 0)
                    neighbor = cur.pos-1;
                else
                    neighbor = cur.pos+1;

                if(visit.contains(neighbor))
                    continue;

                visit.add(neighbor);
                zipcnt--;
                answer += cur.dist+1;
                pq.add(new Zip(neighbor, cur.dist+1));

                if(zipcnt <= 0)
                    break;
            }
        }

        System.out.println(answer);

    }

}
