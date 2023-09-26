package 줄세우기2631;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, 1);  // 모든 위치에서의 LIS의 길이의 최소값은 자기 자신

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // 현재 위치의 값이 이전 위치의 값보다 크고,
                // 현재 위치까지의 LIS의 길이가 이전 위치까지의 LIS의 길이 + 1보다 작은 경우
                // LIS의 길이를 갱신
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();  // LIS의 길이 중 최대값을 찾기
        System.out.println(N - max);  // 아이들의 최소 이동 횟수는 전체 아이들의 수에서 LIS의 길이를 뺀 값
    }
}
