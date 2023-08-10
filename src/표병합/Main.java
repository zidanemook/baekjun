package 표병합;

import java.util.*;

class Solution {
    public String[] solution(String[] commands) {

        String[][] map = new String[51][51];
        for (int i = 0; i <= 50; i++) {
            Arrays.fill(map[i], "");
        }

        ArrayList<String> answer = new ArrayList<>();

        for(String com : commands)
        {
            String[] part = com.split(" ");

            if(part[0].equals("UPDATE") && part.length == 4)
            {
                int r = Integer.parseInt(part[1]);
                int c = Integer.parseInt(part[2]);
                String val = part[3];

                //자식 이면 root 찾아서 갱신해야함
                if(map[r][c].isEmpty() == false)
                {
                    String[] temp = map[r][c].split(" ");
                    if(temp[0].equals("!"))
                    {
                        r = Integer.parseInt(temp[1]);
                        c = Integer.parseInt(temp[2]);
                    }
                }

                map[r][c] = val;
            }
            else if(part[0].equals("UPDATE") && part.length == 3)
            {
                String find = part[1];
                String val = part[2];

                for (int i = 1; i <= 50; i++) {
                    for (int j = 1; j <= 50; j++) {
                        if(map[i][j].equals(find)){

                            //자식이면 root 찾아서 갱신해야함
                            int icopy = i;
                            int jcopy = j;
                            if(map[icopy][jcopy].isEmpty() == false)
                            {
                                String[] temp = map[icopy][jcopy].split(" ");
                                if(temp[0].equals("!"))
                                {
                                    icopy = Integer.parseInt(temp[1]);
                                    jcopy = Integer.parseInt(temp[2]);
                                }
                            }

                            map[icopy][jcopy] = val;
                        }
                    }
                }
            }
            else if(part[0].equals("MERGE"))
            {
                int r1 = Integer.parseInt(part[1]);
                int c1 = Integer.parseInt(part[2]);

                int r2 = Integer.parseInt(part[3]);
                int c2 = Integer.parseInt(part[4]);

                if(r1 == r2 && c1 == c2)
                    continue;

                //자식이면 root 찾아서 병합 해야함
                if(map[r1][c1].isEmpty() == false)
                {
                    String[] temp = map[r1][c1].split(" ");
                    if(temp[0].equals("!"))
                    {
                        r1 = Integer.parseInt(temp[1]);
                        c1 = Integer.parseInt(temp[2]);
                    }
                }

                StringBuilder sb = new StringBuilder();

                //병합대상이 자식일 경우 root 찾기
                if(map[r2][c2].isEmpty() == false && map[r2][c2].charAt(0) == '!')
                {
                    String[] temp = map[r2][c2].split(" ");
                    r2 = Integer.parseInt(temp[1]);
                    c2 = Integer.parseInt(temp[2]);
                }


                for (int i = 1; i <= 50; i++) {
                    for (int j = 1; j <= 50; j++) {

                        if(map[i][j].isEmpty() == false)
                        {
                            String[] temp = map[i][j].split(" ");
                            if(temp[0].equals("!")
                                    && r2 == Integer.parseInt(temp[1]) && c2 == Integer.parseInt(temp[2]))
                            {
                                map[i][j] = "!" + " " + r1 + " " + c1;
                            }
                        }
                    }
                }




                if(map[r1][c1].isEmpty() && map[r2][c2].isEmpty())
                {
                    sb.append("!" + " " + r1 + " " + c1);
                    map[r2][c2] = sb.toString();
                }
                else if(false == map[r1][c1].isEmpty() && map[r2][c2].isEmpty())
                {
                    sb.append("!" + " " + r1 + " " + c1);
                    map[r2][c2] = sb.toString();
                }
                else if(map[r1][c1].isEmpty() && false == map[r2][c2].isEmpty())
                {
                    map[r1][c1] = map[r2][c2];
                    sb.append("!" + " " + r1 + " " + c1);
                    map[r2][c2] = sb.toString();
                }
                else
                {
                    sb.append("!" + " " + r1 + " " + c1);
                    map[r2][c2] = sb.toString();
                }
            }
            else if(part[0].equals("UNMERGE"))
            {
                int r = Integer.parseInt(part[1]);
                int c = Integer.parseInt(part[2]);

                int rootr = r;
                int rootc = c;
                //자식 이면 root 찾기
                if(map[r][c].isEmpty() == false)
                {
                    String[] temp = map[r][c].split(" ");
                    if(temp[0].equals("!"))
                    {
                        rootr = Integer.parseInt(temp[1]);
                        rootc = Integer.parseInt(temp[2]);
                    }
                }

                String temp = map[r][c];
                map[r][c] = map[rootr][rootc];
                map[rootr][rootc] = temp;

                for (int i = 1; i <= 50; i++) {
                    for (int j = 1; j <= 50; j++) {

                        if(i == r && j == c)
                            continue;

                        if(map[i][j].isEmpty() == false)
                        {
                            String[] check = map[i][j].split(" ");
                            if(check[0].equals("!")
                                    && rootr == Integer.parseInt(check[1]) && rootc == Integer.parseInt(check[2]))
                            {
                                map[i][j] = "";
                            }
                        }

                    }
                }

            }
            else if(part[0].equals("PRINT"))
            {
                int r = Integer.parseInt(part[1]);
                int c = Integer.parseInt(part[2]);

                //자식 이면 root 찾아서 출력 해야함

                if(map[r][c].isEmpty() == false)
                {
                    String[] temp = map[r][c].split(" ");
                    if(temp[0].equals("!"))
                    {
                        r = Integer.parseInt(temp[1]);
                        c = Integer.parseInt(temp[2]);
                    }
                }

                if(map[r][c].isEmpty())
                    answer.add("EMPTY");
                else
                    answer.add(map[r][c]);
            }
        }

        return answer.toArray(new String[0]);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] input = {"UPDATE 1 1 A", "UPDATE 2 2 B", "UPDATE 3 3 C", "UPDATE 4 4 D", "MERGE 1 1 2 2", "MERGE 3 3 4 4", "MERGE 1 1 4 4", "UNMERGE 3 3", "PRINT 1 1", "PRINT 2 2", "PRINT 3 3", "PRINT 4 4"};
        String[] answer = sol.solution(input);

        for(String str : answer)
            System.out.println(str);
    }

}
