package 내선물을받아줘2_15886;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();
        char[] map = new char[N];
        for (int i = 0; i < N; i++) {
            map[i] = input.charAt(i);
        }

        boolean[] visit = new boolean[N];

        ArrayList<HashSet<Integer>> nodes = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            nodes.add(new HashSet<Integer>());
            int cur = i;
            nodes.get(i).add(cur);
            visit[cur] = true;
            while(true){

                if (map[cur] == 'W') {
                    cur--;
                } else if (map[cur] == 'E') {
                    cur++;
                }

                if(visit[cur] == false){
                    visit[cur] = true;
                    nodes.get(i).add(cur);
                }else{
                    break;
                }

            }

            for(int j = 0; j < N; j++) {
                visit[j] = false;
            }
        }

        for(int j = 0; j < N; j++) {
            visit[j] = false;
        }


        int answer = 0;
        for (int i = 0; i < N; i++) {
            HashSet<Integer> node = nodes.get(i);
            if(visit[i] == true)
                continue;

            visit[i] = true;
            for (int j = 1; j < N; j++) {
                HashSet<Integer> next = nodes.get(j);

                if(visit[j] == true)
                    continue;

                for(Integer num : next){
                    if(node.contains(num)){
                        visit[j] = true;
                        break;
                    }
                }
            }
            answer++;
        }

        System.out.println(answer);
    }
}
