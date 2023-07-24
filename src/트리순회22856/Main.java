package 트리순회22856;

import java.io.*;
import java.util.*;


class Node{

    Node left;
    Node right;
    Node(){

    }
}

public class Main {
    static int answer = 0;
    static int stopper = 0;

    static int n = 0;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String[] input;

        HashMap<Integer, Node> nodes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");

            int val = Integer.parseInt(input[0]);
            int left = Integer.parseInt(input[1]);
            int right = Integer.parseInt(input[2]);

            if(left != -1 && nodes.containsKey(left) == false)
                nodes.put(left, new Node());
            if(right != -1 && nodes.containsKey(right) == false)
                nodes.put(right, new Node());

            if(nodes.containsKey(val) == false){

                Node cur = new Node();
                if(left != -1){
                    cur.left = nodes.get(left);
                }
                if(right != -1){
                    cur.right = nodes.get(right);
                }
                nodes.put(val, cur);
            }else{
                Node cur = nodes.get(val);
                if(left != -1){
                    cur.left = nodes.get(left);
                }
                if(right != -1){
                    cur.right = nodes.get(right);
                }
            }
        }

        answer = dfs(nodes.get(1), 0);

        System.out.println(answer);
    }

    public static int dfs(Node parent, int count){


        if(parent.left != null)
            count = dfs(parent.left, count+1);

        stopper++;

        if(parent.right!= null)
            count = dfs(parent.right, count+1);


        if(stopper == n){
            return count;
        }else{
            return count+1;
        }
    }
}
