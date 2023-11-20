package 한국이그리울땐서버에접속하지9996;

import java.io.*;
import java.util.*;

public class Main {
    static String pat;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();

        String prefix, suffix;

        if (pattern.startsWith("*")) {
            suffix = pattern.substring(1);

            for (int i = 0; i < N; i++) {
                String fileName = br.readLine();

                if (fileName.endsWith(suffix)) {
                    System.out.println("DA");
                } else {
                    System.out.println("NE");
                }
            }

        } else if (pattern.endsWith("*")) {
            prefix = pattern.substring(0, pattern.length() - 1);

            for (int i = 0; i < N; i++) {
                String fileName = br.readLine();

                if (fileName.startsWith(prefix)) {
                    System.out.println("DA");
                } else {
                    System.out.println("NE");
                }
            }

        } else {
            int asteriskIndex = pattern.indexOf("*");
            prefix = pattern.substring(0, asteriskIndex);
            suffix = pattern.substring(asteriskIndex + 1);

            for (int i = 0; i < N; i++) {
                String fileName = br.readLine();

                if (fileName.length() < pattern.length() - 1) {
                    System.out.println("NE");
                    continue;
                }

                if (fileName.startsWith(prefix) && fileName.endsWith(suffix)) {
                    System.out.println("DA");
                } else {
                    System.out.println("NE");
                }
            }
        }
    }

}
