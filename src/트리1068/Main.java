package 트리1068;

import java.io.*;
import java.util.*;

public class Main
{
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    static int[] leafCount;

    static int rootId;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; ++i)
            tree.add(new ArrayList<>());

        rootId = 0;
        int[] arrP = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i)
        {
            int C = i;
            int P = Integer.parseInt(input[i]);

            if(P == -1)
            {
                rootId = C;
                continue;
            }

            tree.get(P).add(C);
            tree.get(C).add(P);
            arrP[i] = P;
        }

        leafCount = new int[N];

        recur_makeCount(-1, rootId);

        int delId = Integer.parseInt(br.readLine());

        if(delId == rootId)
        {
            System.out.println(0);
            return;
        }

        ArrayList<Integer> PofDel = tree.get(arrP[delId]);
        if(arrP[delId] == rootId)
        {
            if(1 < PofDel.size())//부모가 루트이고 자식 2개
                System.out.println(leafCount[rootId] - leafCount[delId]);
            else
                System.out.println(1);
        }
        else
        {
            if(2 < PofDel.size())//부모가 자식 2개 (1개는 부모의 부모)
                System.out.println(leafCount[rootId] - leafCount[delId]);
            else
                System.out.println(leafCount[rootId] - leafCount[delId] + 1);
        }

    }

    public static int recur_makeCount(int parent, int nodeId)
    {
        ArrayList<Integer> curNode = tree.get(nodeId);

        if(nodeId == rootId )
        {
            if(curNode.isEmpty() == true)
                leafCount[nodeId] = 1;
        }
        else
        {
            if(curNode.size() == 1)
                leafCount[nodeId] = 1;
        }


        for(int child : curNode)
        {
            if(child == parent)
                continue;
            leafCount[nodeId] += recur_makeCount( nodeId, child);
        }

        return leafCount[nodeId];
    }
}
