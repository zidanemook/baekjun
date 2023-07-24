package 오리12933;

import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");

        Character[] voice = new Character[input.length];
        for (int i = 0; i < input.length; i++) {

            voice[i] = input[i].charAt(0);
        }


//        HashMap<Character, Integer> cnt = new HashMap<>();
//
//        for (int i = 0; i < voice.length; i++) {
//            char cur = voice[i];
//
//            cnt.put(cur, cnt.getOrDefault(cur, 1)+1);
//        }


        String check = "quack";
        List<StringBuilder> ori = new LinkedList<>();

        int answer = 0;
        for (int i = 0; i < voice.length; i++) {

            char cur = voice[i];

            boolean process = false;
            if(cur == 'q'){
                ori.add(new StringBuilder("q"));
                process = true;
                answer = Math.max(answer, ori.size());
            }
            else{
                int del = -1;
                for(int j = 0; j < ori.size(); ++j){
                    StringBuilder sb = ori.get(j);

                    if(sb.charAt(sb.length()-1) == check.charAt(check.indexOf(cur)-1)){
                        sb.append(cur);
                        process = true;
                        if(cur == 'k')
                            del = j;
                        break;
                    }
                }
                if(del != -1)
                    ori.remove(del);
            }

            if(false == process){
                System.out.println(-1);
                return;
            }

        }

        if(ori.isEmpty() == false){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }
}
