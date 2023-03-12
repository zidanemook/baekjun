package 문제추천시스템21939;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> pmap = new HashMap<>();//Problem, Level
        TreeMap<Integer, TreeSet<Integer>> lmap = new TreeMap<>();//Level, Problem //내림차순// Level은 여러개의 Problem 을 가질 수 있다

        String[] input;
        int P,L;
        for(int i = 0; i < N; ++i)
        {
            input = br.readLine().split(" ");
            P = Integer.parseInt(input[0]);
            L = Integer.parseInt(input[1]);

            putTopmaplmap(pmap, lmap, P, L);
        }

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; ++i)
        {
            input = br.readLine().split(" ");

            if(input[0].equals("add"))
            {
                P = Integer.parseInt(input[1]);
                L = Integer.parseInt(input[2]);
                putTopmaplmap(pmap, lmap, P, L);
            }
            else if(input[0].equals("recommend"))
            {
                if(input[1].equals("-1"))
                {
                    sb.append(lmap.get(lmap.firstKey()).first() + "\n");
                }
                else if(input[1].equals("1"))
                {
                    sb.append(lmap.get(lmap.lastKey()).last() + "\n");
                }
            }
            else if(input[0].equals("solved"))
            {
                int Problem = Integer.parseInt(input[1]);
                int Level = pmap.remove(Problem);
                TreeSet<Integer> tree = lmap.get(Level);
                tree.remove(tree.floor(Problem));
                if(tree.isEmpty())
                {
                    lmap.remove(Level);
                }
            }
        }

        System.out.println(sb.toString());
    }

    private static void putTopmaplmap(HashMap<Integer, Integer> pmap,
                                      TreeMap<Integer, TreeSet<Integer>> lmap,
                                      int P,
                                      int L)
    {
        pmap.put(P, L);

        if(lmap.containsKey(L))
        {
            lmap.get(L).add(P);
        }
        else
        {
            TreeSet<Integer> tree = new TreeSet<>();
            tree.add(P);
            lmap.put(L, tree);
        }
    }
}
