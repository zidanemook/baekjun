package 양과늑대;

import java.util.*;

class Solution {

    int maxsheep = 0;
    public int solution(int[] info, int[][] edges) {

        List<Integer>[] tree = new List[info.length];
        for(int i = 0; i < info.length; ++i)
            tree[i] = new ArrayList<>();

        for(int i = 0; i < edges.length; ++i){
            int a = edges[i][0];
            int b = edges[i][1];

            tree[a].add(b);
        }

        List<Integer> next = new ArrayList<>();
        next.add(0);

        dfs(info, tree, next, 0, 0, 0);

        return maxsheep;
    }

    public void dfs(int[] info, List<Integer>[] tree, List<Integer> Node, int root, int sheep, int wolf){

        if(info[root] == 0)
        {
            sheep++;
        }
        else
            wolf++;

        if(wolf >= sheep)
            return;

        if(maxsheep < sheep)
            maxsheep = sheep;

        List<Integer> next = new ArrayList<>(Node);

        if(tree[root].isEmpty() == false){
            next.addAll(tree[root]);
        }
        next.remove(Integer.valueOf(root));

        for(int n : next){
            dfs(info, tree, next, n, sheep, wolf);
        }

    }
}

public class Main {
    public static void main(String[] args) {

        int[] info ={0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};

        Solution sol = new Solution();
        System.out.println(sol.solution(info, edges));
    }
}
