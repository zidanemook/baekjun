package 이진검색트리5639;

import java.io.*;

class Node
{
    int val;
    Node left;
    Node right;

    public Node() {
    }
    public Node(int val) {
        this.val = val;
    }

    public void add(Node newNode)
    {
        if(newNode.val < this.val)
        {
            if(null != left)
                left.add(newNode);
            else
                left = newNode;
        }
        else
        {
            if(null != right)
                right.add(newNode);
            else
                right = newNode;
        }
    }
}

public class Main
{

    static int rootVal;
    static Node root;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException
    {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            rootVal = Integer.parseInt(br.readLine());
            root = new Node(rootVal);

            while (true) {
                int temp = Integer.parseInt(br.readLine());
                root.add(new Node(temp));
            }
        }
        catch(Exception e)
        {

        }

        recur_PostOrder(root);

        System.out.println(sb);
    }

    public static void recur_PostOrder(Node node)
    {
        Node left = node.left;
        if(left != null)
        {
            recur_PostOrder(left);
        }

        Node right = node.right;
        if(right != null)
        {
            recur_PostOrder(right);
        }

        sb.append(node.val+"\n");
    }
}
