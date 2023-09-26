package 빌런호석22251;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        //N500 이라면 현재 층이 400층이고 최대 5개의 LED를 반전시킬 수 있다면, 1층부터 500층까지 중에서 400층의 LED 표시와 5개 이하의 LED만을 반전시켜 일치시킬 수 있는 층들의 개수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());//층수
        int K = Integer.parseInt(st.nextToken());//디스플레이 자리수
        int P = Integer.parseInt(st.nextToken());//반전개수
        int X = Integer.parseInt(st.nextToken());//멈춰있는 층


        int[][] ledNumbers = {
                {1, 1, 1, 0, 1, 1, 1},  // 0
                {0, 0, 1, 0, 0, 1, 0},  // 1
                {1, 0, 1, 1, 1, 0, 1},  // 2
                {1, 0, 1, 1, 0, 1, 1},  // 3
                {0, 1, 1, 1, 0, 1, 0},  // 4
                {1, 1, 0, 1, 0, 1, 1},  // 5
                {1, 1, 0, 1, 1, 1, 1},  // 6
                {1, 0, 1, 0, 0, 1, 0},  // 7
                {1, 1, 1, 1, 1, 1, 1},  // 8
                {1, 1, 1, 1, 0, 1, 1}   // 9
        };


        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            if (countTotalLedDifferences(i, X, ledNumbers) <= P) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static int countLedDifferences(int num1, int num2, int[][] ledNumbers) {
        int differences = 0;

        int[] ledNum1 = ledNumbers[num1];
        int[] ledNum2 = ledNumbers[num2];

        for (int i = 0; i < 7; i++) {
            if (ledNum1[i] != ledNum2[i]) {
                differences++;
            }
        }

        return differences;
    }

    //num1 >> num2 로 변환하는데 필요한 반전 개수
    public static int countTotalLedDifferences(int num1, int num2, int[][] ledNumbers) {
        int totalDifferences = 0;

        while (num1 > 0 || num2 > 0) {
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;

            totalDifferences += countLedDifferences(digit1, digit2, ledNumbers);

            num1 /= 10;
            num2 /= 10;
        }

        return totalDifferences;
    }
}
