package 수학적호기심9094;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] input;
        int ans = 0;
        for(int i = 0; i < T; ++i)
        {
            input = br.readLine().split(" ");

            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            for(int j = 1; j < n; ++j)
            {
                for(int k = j+1; k < n; ++k)
                {
                    double temp = (double)(Math.pow(j, 2) + Math.pow(k, 2) + m) / (double)(j*k);

                    if(temp % 1 == 0)
                        ans++;
                }
            }

            System.out.println(ans);
            ans = 0;
        }
    }
}
