package 단체사진찍기;

class Condition
{
    Character start;
    Character end;
    int gap;
    Character operator;
}

public class Solution
{
    public static void main(String[] args)
    {
        String[] data = {"N~F=0", "R~T>2"};
        solution(2, data);
    }

    static public int solution(int n, String[] data) {
        int answer = 0;

        Character[] element = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        int len = element.length;

        Character[] cand = new Character[len];
        boolean[] visit = new boolean[len];

        Condition[] con = new Condition[n];

        for (int i = 0; i < n; i++)
        {
            con[i] = new Condition();
            con[i].start = data[i].charAt(0);
            con[i].end = data[i].charAt(2);
            con[i].operator = data[i].charAt(3);
            con[i].gap = Integer.parseInt(String.valueOf(data[i].charAt(4)));
        }

        answer = dfs(len, 0, element, cand, visit, n, con);

        return answer;
    }

    static public int dfs(int len, int level, Character[] element, Character[] cand, boolean[] visit, int n, Condition[] con)
    {
        if(level == len)
        {
            int startidx = 0;
            int endidx = 0;
            boolean satisfy = true;
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < len; j++)
                {
                    if(cand[j] == con[i].start)
                        startidx = j;
                    else if(cand[j] == con[i].end)
                        endidx = j;
                }

                if(con[i].operator =='=')
                {
                    if(Math.abs(startidx-endidx) == (con[i].gap +1))
                    {

                    }
                    else
                    {
                        satisfy = false;
                        break;
                    }
                }
                else if(con[i].operator =='<')
                {
                    if(Math.abs(startidx-endidx) < (con[i].gap +1))
                    {

                    }
                    else
                    {
                        satisfy = false;
                        break;
                    }
                }
                else// '>'
                {
                    if(Math.abs(startidx-endidx) > (con[i].gap +1))
                    {

                    }
                    else
                    {
                        satisfy = false;
                        break;
                    }
                }
            }

            if(satisfy)
            {
                return 1;
            }

            return 0;
        }

        int ret = 0;

        for (int i = 0; i < len; i++)
        {
            cand[level] = element[i];

            if(visit[i] == false)
            {
                visit[i] = true;
                ret += dfs(len, level+1, element, cand, visit, n, con);
                visit[i] = false;
            }
        }

        return ret;
    }
}
