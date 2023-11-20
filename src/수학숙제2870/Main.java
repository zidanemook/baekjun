package 수학숙제2870;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> allNumbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            StringBuilder numberBuilder = new StringBuilder();

            for (char ch : line.toCharArray()) {
                if (Character.isDigit(ch)) {
                    numberBuilder.append(ch);
                } else if (numberBuilder.length() > 0) {
                    allNumbers.add(removeLeadingZeros(numberBuilder.toString()));
                    numberBuilder.setLength(0);
                }
            }

            if (numberBuilder.length() > 0) {
                allNumbers.add(removeLeadingZeros(numberBuilder.toString()));
            }
        }

        // 숫자의 크기를 기준으로 정렬
        Collections.sort(allNumbers, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return new BigInteger(s1).compareTo(new BigInteger(s2));
            }
        });

        for (String number : allNumbers) {
            System.out.println(number);
        }
    }

    private static String removeLeadingZeros(String number) {
        int startIndex = 0;
        while (startIndex < number.length() && number.charAt(startIndex) == '0') {
            startIndex++;
        }
        return startIndex == number.length() ? "0" : number.substring(startIndex);
    }
}