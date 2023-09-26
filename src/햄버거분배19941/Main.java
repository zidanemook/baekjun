package 햄버거분배19941;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] input = br.readLine().split("");
        ArrayList<String> arr = new ArrayList<>();

        for(int i = 0; i < n; ++i)
        {
            arr.add(input[i]);
        }

        int answer = 0;
        for(int i = 0; i < n; ++i)
        {
            if(arr.get(i).equals("P"))
            {
                for(int j = Math.max(0, i-k); j <= Math.min(i+k, n-1); ++j)
                {
                    if(arr.get(j).equals("H"))
                    {
                        arr.set(j, "");
                        answer++;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
