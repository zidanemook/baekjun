package 방금그곡;

import java.util.*;

public class Main
{

    public static void main(String[] args) {


        //"DF", ["6:20,6:50,TEST,DDF"] -> "TEST"

        String m = "C#C";
        String[] musicinfos = {
                "12:00,12:06,HELLO,C#C#CC#",
        };
        Solution solution = new Solution();
        System.out.println(solution.solution(m, musicinfos));

    }

}

class Music
{
    String start;
    String end;
    String title;
    String sheet;
}

class Answer implements Comparable<Answer> {
    int playtime;
    String title;
    int id;

    public Answer(int id, int playtime, String title) {
        this.id = id;
        this.playtime = playtime;
        this.title = title;
    }

    @Override
    public int compareTo(Answer o) {
        if(this.playtime != o.playtime)
            return this.playtime > o.playtime ? -1 : 1;
        else
            return this.id < o.id ? -1 : 1;
    }
}

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        Music[] music = new Music[musicinfos.length];
        for(int i = 0; i < musicinfos.length; ++i)
        {
            String[] temp = musicinfos[i].split(",");

            music[i] = new Music();
            music[i].start = temp[0];
            music[i].end = temp[1];
            music[i].title = temp[2];
            music[i].sheet = translator(temp[3]);
        }

        String mcopy = translator(m);

        PriorityQueue<Answer> pq = new PriorityQueue<>();

        for(int i = 0; i < musicinfos.length; ++i)
        {
            int playtime = getPlaytime(music[i].start, music[i].end);

            if(playtime == 0)
                break;

            int min = 0;
            int sheetlen = music[i].sheet.length();
            int sidx = 0;
            int midx = 0;

            while(min < playtime)
            {
                char curm = mcopy.charAt(midx);
                char curs = music[i].sheet.charAt(sidx);

                if(curm != curs)
                {
                    midx = 0;
                    curm = mcopy.charAt(midx);
                    if(curm == curs)
                        continue;
                }
                else
                {
                    midx++;
                    if(midx >= mcopy.length())
                    {
                        pq.add(new Answer(i, playtime, music[i].title));
                        break;
                    }

                }

                sidx++;
                if(sidx >= sheetlen)
                    sidx = 0;
                min++;
            }
        }

        if(pq.isEmpty() == false)
            answer = pq.poll().title;

        return answer;
    }

    public static int getPlaytime(String start, String end)
    {
        String[] input = start.split(":");
        int stH = Integer.parseInt(input[0]);
        int stM = Integer.parseInt(input[1]);

        input = end.split(":");
        int edH = Integer.parseInt(input[0]);
        int edM = Integer.parseInt(input[1]);

        if(edM < stM)
        {
            edM += 60;
            edH--;
        }

        int diffH = edH - stH;
        int diffM = edM - stM;

        int ret = diffH*60 + diffM;
        return ret;
    }

    public static String translator(String input)
    {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input.length(); ++i)
        {
            if((i+1)<input.length() && input.charAt(i+1) =='#')
            {
                if(input.charAt(i) == 'C')
                    sb.append('b');
                else if(input.charAt(i) == 'D')
                    sb.append('d');
                else if(input.charAt(i) == 'F')
                    sb.append('g');
                else if(input.charAt(i) == 'G')
                    sb.append('i');
                else if(input.charAt(i) == 'A')
                    sb.append('k');
            }
            else
            {
                if(input.charAt(i) == 'C')
                    sb.append('a');
                else if(input.charAt(i) == 'D')
                    sb.append('c');
                else if(input.charAt(i) == 'E')
                    sb.append('e');
                else if(input.charAt(i) == 'F')
                    sb.append('f');
                else if(input.charAt(i) == 'G')
                    sb.append('h');
                else if(input.charAt(i) == 'A')
                    sb.append('j');
                else if(input.charAt(i) == 'B')
                    sb.append('l');
            }

        }

        return sb.toString();
    }
}
