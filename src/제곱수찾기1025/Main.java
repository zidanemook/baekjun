package 제곱수찾기1025;

import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static int result = -1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[10][10];

        for (int i = 0; i < n; i++) {
            String s1 = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s1.charAt(j)));
            }
        }
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                for (int mi = -n; mi < n; ++mi)
                    for (int mj = -m; mj < m; ++mj)
                    {
                        if (mi == 0 && mj == 0) { // 둘다 움직이지 않을 때
                            continue;
                        }

                        int t = 0;
                        int newI = i;
                        int newJ = j;
                        while (newI >= 0 && newI < n && newJ >= 0 && newJ < m) // 위치가 0>= && <범위를 설정해줍니다.
                        {
                            t = 10 * t + arr[newI][newJ]; // 기존에 담긴 숫자가 있다면 *10해주고 더해줍니다.
                            if (Math.abs(Math.sqrt(t) - (int)Math.sqrt(t)) < 1e-10){ // 완전 제곱수인지 판별합니다.
                                result = Math.max(result, t);
                            }
                            newI += mi;
                            newJ += mj;
                        }

                    }
        System.out.println(result);
    }


}
