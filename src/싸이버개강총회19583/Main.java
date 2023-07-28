package 싸이버개강총회19583;

import java.io.*;
import java.util.*;

class Time{
    int hour;
    int min;

    Time(int hour, int min){
        this.hour = hour;
        this.min = min;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] input = st.nextToken().split(":");
        Time start = new Time(Integer.parseInt(input[0]), Integer.parseInt(input[1]));

        input = st.nextToken().split(":");
        Time end = new Time(Integer.parseInt(input[0]), Integer.parseInt(input[1]));

        input = st.nextToken().split(":");
        Time stend = new Time(Integer.parseInt(input[0]), Integer.parseInt(input[1]));

        String line;
        HashMap<String, Integer> check = new HashMap<>();

        int answer = 0;

        while((line = br.readLine()) != null){

            st = new StringTokenizer(line);

            input = st.nextToken().split(":");

            int hour = Integer.parseInt(input[0]);
            int min = Integer.parseInt(input[1]);
            String id = st.nextToken();
            Time chattime = new Time(hour, min);

            if(-1 == timecompare(chattime, start) || 0 == timecompare(chattime, start)){
                check.put(id, 0);
            }else if( (1 == timecompare(chattime, end) || 0 == timecompare(chattime, end))
            && (-1 == timecompare(chattime, stend) || 0 == timecompare(chattime, stend))) {
                if(check.containsKey(id) && 0 == check.get(id)){
                    check.put(id, 1);
                    answer++;
                }

            }

        }

        System.out.println(answer);
    }

    public static int timecompare(Time a, Time b){

        int amin = a.hour * 60 + a.min;
        int bmin = b.hour * 60 + b.min;

        return amin == bmin ? 0 : (amin < bmin ? -1 : 1);
    }
}
