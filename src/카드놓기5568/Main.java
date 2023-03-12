package 카드놓기5568;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int K = Integer.parseInt(br.readLine());

        ArrayList<String> cardList = new ArrayList<>();
        ArrayList<String> assemble = new ArrayList<>();
        for(int i = 0; i < N; ++i)
        {
            cardList.add(br.readLine());
            assemble.add("");
        }

        HashSet<String> answer = new HashSet<>();
        boolean[] visited = new boolean[cardList.size()];
        StringBuilder sb = new StringBuilder();
        search(0, K, cardList, assemble, answer, visited, sb);

        System.out.println(answer.size());
        //System.out.println(sbTest.toString());
    }

    //static StringBuilder sbTest = new StringBuilder();
    static void search(int depth, int K, ArrayList<String> card, ArrayList<String> assemble, HashSet<String> answer, boolean[] visited, StringBuilder sb)
    {
        if(depth == K)
        {
            sb.setLength(0);
            for(int i = 0; i < K; ++i)
            {
                sb.append(assemble.get(i));
            }
            answer.add(sb.toString());

            //sbTest.append("\n");

            return;
        }
        for(int i = 0; i < card.size(); ++i)
        {
            if(visited[i] == false)
            {
                //sbTest.append(i);

                visited[i] = true;
                assemble.set(depth, card.get(i));
                search(depth+1, K, card, assemble, answer, visited, sb);
                visited[i] = false;
            }
        }
    }
}
