package 패션왕신해빈9375;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            Map<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken();
                String sort = st.nextToken();

                map.put(sort, map.getOrDefault(sort, 1)+1);
            }

            int answer = 1;
            Set<String> keys = map.keySet();
            for(String key : keys){
                answer *= map.get(key);
            }

            System.out.println(answer-1);
        }
    }
}
