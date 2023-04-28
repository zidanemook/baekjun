package NQueen;

public class Main
{
    public static void main(String[] args)
    {

        Solution solu = new Solution();
        System.out.println(solu.solution(12));
    }

}

class Solution {

    static int[] arr = {};
    static boolean[] visit = {};

    public int solution(int n) {
        int answer = 0;

        arr = new int[n];
        visit = new boolean[n];

        answer = dfs(0, n);

        return answer;
    }

    public static int dfs(int level, int n)
    {
        if(level == n)
        {
            return 1;
        }

        int ret = 0;
        for(int i = 0; i < n; ++i)
        {
            if(visit[i] == false)
            {
                arr[level] = i;
                visit[i] = true;
                if(false == CrossCol(level+1))
                    ret += dfs(level+1, n);
                visit[i] = false;
            }

        }

        return ret;
    }

    public static boolean CrossCol(int n)
    {
        if(n == 0)
            return false;

        for(int i = 0; i < n; ++i)
        {
            for(int j = i; j < n; ++j)
            {
                if(i == j)
                    continue;

                int rowa = i;
                int cola = arr[i];
                int rowb = j;
                int colb = arr[j];

                if((rowa + cola) == (rowb + colb))
                    return true;

                if((rowa-cola) == (rowb - colb))
                    return true;
            }
        }

        return false;
    }
}