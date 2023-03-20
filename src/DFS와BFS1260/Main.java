package DFS와BFS1260;

import java.io.*;
import java.util.*;
public class Main
{
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N;
    static int V;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);

        for(int i = 0; i < N+1; ++i)
            graph.add(new ArrayList<>());

        for(int i = 0; i < M; ++i)
        {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 0; i < N+1; ++i)
            Collections.sort(graph.get(i));

        dfs();
        bfs();
    }

    public static void dfs()
    {
        Stack<Integer> stack = new Stack<>();
        boolean[] visit = new boolean[N+1];
        StringBuilder sb = new StringBuilder();

        stack.push(V);
        visit[V] = true;
        sb.append(V + " ");

        while(stack.isEmpty() == false)
        {
            int cur = stack.peek();

            boolean noGo = true;
            ArrayList<Integer> adjList = graph.get(cur);
            for (Integer adj : adjList) {

                if(visit[adj] == true)
                    continue;

                stack.push(adj);
                sb.append(adj + " ");
                noGo = false;
                visit[adj] = true;
                break;
            }
            if(noGo)
                stack.pop();

        }

        sb.delete(sb.length()-1, sb.length()-1);
        System.out.println(sb);
    }

    public static void bfs()
    {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visit = new boolean[N+1];
        StringBuilder sb = new StringBuilder();

        que.add(V);
        visit[V] = true;
        sb.append(V + " ");


        while (que.isEmpty() == false)
        {
            int cur = que.poll();

            ArrayList<Integer> adjList = graph.get(cur);
            for (Integer adj : adjList)
            {
                if(visit[adj] == true)
                    continue;

                que.add(adj);
                sb.append(adj + " ");
                visit[adj] = true;
            }
        }

        sb.delete(sb.length()-1, sb.length()-1);
        System.out.println(sb);
    }
}




















//public class Main
//{
//    public static void main(String[] args) throws IOException
//    {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] input = br.readLine().split(" ");
//
//        int n = Integer.parseInt(input[0]);
//        int m = Integer.parseInt(input[1]);
//        int v = Integer.parseInt(input[2]);
//
//        int[][] edge = new int[m][2];
//
//        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
//        for(int i = 0; i < n+1; ++i)
//        {
//            arr.add(new ArrayList<>());
//        }
//
//        for(int i = 0; i < m; ++i)
//        {
//            input = br.readLine().split(" ");
//            edge[i][0] = Integer.parseInt(input[0]);
//            edge[i][1] = Integer.parseInt(input[1]);
//        }
//
//        for(int i = 0; i < m; ++i)
//        {
//            ArrayList<Integer> temp = arr.get(edge[i][0]);
//            temp.add(edge[i][1]);
//        }
//
//        for(int i = 0; i < m; ++i)
//        {
//            ArrayList<Integer> temp = arr.get(edge[i][1]);
//            temp.add(edge[i][0]);
//        }
//
//        for(int i = 0; i < m; ++i)
//        {
//            ArrayList<Integer> temp = arr.get(edge[i][0]);
//            Collections.sort(temp);
//        }
//        StringBuilder sb = new StringBuilder();
//        ArrayList<Integer> ans = new ArrayList<>();
//        dfs(v, arr, ans);
//        for(int i = 0; i < ans.size(); ++i)
//        {
//            if(i != ans.size()-1)
//                sb.append(ans.get(i) + " ");
//            else
//                sb.append(ans.get(i) + "\n");
//        }
//        ans.clear();
//        bfs(v, arr, ans);
//
//        for(int i = 0; i < ans.size(); ++i)
//        {
//            if(i != ans.size()-1)
//                sb.append(ans.get(i) + " ");
//            else
//                sb.append(ans.get(i) + "\n");
//        }
//
//        System.out.print(sb);
//    }
//
//    public static void dfs(int start, ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> ans)
//    {
//        Stack<Integer> stack = new Stack<>();
//
//        stack.add(start);
//
//        boolean[] check = new boolean[arr.size()];
//        check[start] = true;
//        ans.add(start);
//
//        while(stack.isEmpty() == false)
//        {
//            int cur = stack.peek();
//
//            ArrayList<Integer> temp = arr.get(cur);
//
//            boolean allChecked = true;
//            for(int i = 0; i < temp.size(); ++i)
//            {
//                int adj = temp.get(i);
//                if(false == check[adj])
//                {
//                    stack.push(adj);
//                    check[adj] = true;
//                    ans.add(adj);
//                    allChecked = false;
//                    break;
//                }
//            }
//            if(allChecked)
//                stack.pop();
//        }
//
//    }
//
//    public static void bfs(int start, ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> ans)
//    {
//        Queue<Integer> que = new LinkedList<>();
//
//        que.add(start);
//
//        boolean[] check = new boolean[arr.size()];
//        check[start] = true;
//        ans.add(start);
//
//        while(que.isEmpty() == false)
//        {
//            int cur = que.poll();
//
//            ArrayList<Integer> temp = arr.get(cur);
//
//            for(int i = 0; i < temp.size(); ++i)
//            {
//                int adj = temp.get(i);
//                if(false == check[adj])
//                {
//                    que.add(adj);
//                    check[adj] = true;
//                    ans.add(adj);
//                }
//            }
//        }
//
//    }
//}
