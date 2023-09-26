package 가희와키워드22233;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; ++i)
        {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), ",");

            while(st.hasMoreTokens())
            {
                String str = st.nextToken();

                if(set.contains(str))
                    set.remove(str);
            }

            System.out.println(set.size());
        }
    }
}
