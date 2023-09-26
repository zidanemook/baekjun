package z1074;

import java.io.*;
import java.util.*;

public class Main {

    static int len = 1;
    static int r = 0;
    static int c = 0;

    static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            len *= 2;
        }

        dfs(0, 0, len, 0);

        System.out.println(answer);
    }

    public static boolean dfs(int sr, int sc, int len, int cnt) {

        int er = sr + len-1;
        int ec = sc + len-1;

        if(sr <= r && er >= r && sc <= c && ec >= c) {

            if(len <= 2)
            {
                boolean found = false;
                for (int i = sr; i < sr+2; i++) {
                    for (int j = sc; j < sc+2; j++) {
                        if(i == r && j == c)
                        {
                            found = true;
                            break;
                        }

                        cnt++;
                    }
                    if(found)
                        break;
                }

                answer = cnt;
                return true;
            }

        }
        else
            return false;

        int sublen = len/2;
        int pos = 0;//0 좌상, 1 우상, 2 좌하, 3 우하
        for (int i = sr; i < sr+len; i+=sublen) {
            for (int j = sc; j < sc+len; j+=sublen) {
                if(dfs(i, j, sublen,cnt + sublen*sublen*pos))
                    return true;
                pos++;
            }
        }

        return false;
    }
}
