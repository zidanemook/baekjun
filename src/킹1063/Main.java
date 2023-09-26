package 킹1063;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String kinginput = st.nextToken();
        String stoneinput = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int[] king = new int[2];
        king[0] = kinginput.charAt(0) - 'A';
        king[1] = kinginput.charAt(1) - '0' -1;

        int[] stone = new int[2];
        stone[0] = stoneinput.charAt(0) - 'A';
        stone[1] = stoneinput.charAt(1) - '0' -1;

        for (int i = 0; i < N; i++) {

            String move = br.readLine();
            int nc = king[0];
            int nr = king[1];
            if(move.contains("T")){
                nr++;
            }
            if(move.contains("B")){
                nr--;
            }
            if(move.contains("L")){
                nc--;
            }
            if(move.contains("R")){
                nc++;
            }

            if(nr < 0 || nr >= 8 || nc < 0 || nc >= 8)
                continue;

            int snc = stone[0];
            int snr = stone[1];
            if(stone[0] == nc && stone[1] == nr)
            {
                if(move.contains("T")){
                    snr++;
                }
                if(move.contains("B")){
                    snr--;
                }
                if(move.contains("L")){
                    snc--;
                }
                if(move.contains("R")){
                    snc++;
                }

                if(snr < 0 || snr >= 8 || snc < 0 || snc >= 8)
                    continue;

                stone[0] = snc;
                stone[1] = snr;
            }

            king[0] = nc;
            king[1] = nr;

        }

        StringBuilder sb = new StringBuilder();
        sb.append((char)(king[0]+'A'));
        sb.append((char)(king[1]+'0'+1));
        sb.append("\n");
        sb.append((char)(stone[0]+'A'));
        sb.append((char)(stone[1]+'0'+1));
        System.out.println(sb);
    }
}
