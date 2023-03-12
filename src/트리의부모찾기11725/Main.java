package 트리의부모찾기11725;

import java.io.*;
import java.util.*;

public class Main
{
    static int testcount = 0;//testcode

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] parent = new int[N+1];//인덱스는 자녀노드, 값은 부모노드
        boolean[] visit = new boolean[N+1];
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i = 0; i < N+1; ++i)
            tree.add(new ArrayList<>());

        String[] input;
        for(int i = 0; i < N-1; ++i)
        {
            input = br.readLine().split(" ");
            tree.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
            tree.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
        }

        dfs(1, tree, visit, parent);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < parent.length; ++i)
        {
            if(i > 1)
                sb.append(parent[i] + "\n");
        }

        System.out.println(sb);
        System.out.println(testcount);
    }

    private static void dfs(int root, ArrayList<ArrayList<Integer>> tree, boolean[] visit, int[] parent)
    {
        Stack<Integer> stack = new Stack<>();

        stack.push(root);
        visit[root] = true;

        while(stack.isEmpty() == false)
        {
            int cur = stack.peek();
            ArrayList<Integer> curNode = tree.get(cur);
            boolean noVisit = true;
            for(int element : curNode)
            {
                if(visit[element] == false)
                {

                    testcount++;
                    parent[element] = cur;

                    visit[element] = true;
                    stack.push(element);
                    noVisit = false;
                    break;
                }
            }
            if(noVisit)
                stack.pop();
        }
    }
}
