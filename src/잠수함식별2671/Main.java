package 잠수함식별2671;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Pattern p = Pattern.compile("(100+1+|01)+");
        Matcher m = p.matcher(input);

        if (m.matches()) {
            System.out.println("SUBMARINE");
        } else {
            System.out.println("NOISE");
        }

    }
}
