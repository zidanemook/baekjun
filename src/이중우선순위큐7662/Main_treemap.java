package 이중우선순위큐7662;

import java.io.*;
import java.util.*;
public class Main_treemap {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> tmap = new TreeMap<>();

        String[] input;
        for (int i = 0; i < T; i++) {

            int Q = Integer.parseInt(br.readLine());

            for (int j = 0; j < Q; j++) {

                input = br.readLine().split(" ");

                String com = input[0];
                int val = Integer.parseInt(input[1]);

                if(com.equals("I")){
                    tmap.put(val, tmap.getOrDefault(val, 0)+1);
                }else if(tmap.isEmpty() == false){
                    int key = 0;
                    if(val == -1){
                        key = tmap.firstKey();

                    }else{
                        key = tmap.lastKey();
                    }

                    val = tmap.get(key)-1;
                    if(val <= 0)
                        tmap.remove(key);
                    else
                        tmap.put(key, val);
                }
            }

            if(tmap.isEmpty())
                System.out.println("EMPTY");
            else{
                System.out.println(tmap.lastKey() + " " + tmap.firstKey());
            }

            tmap.clear();
        }
    }
}
