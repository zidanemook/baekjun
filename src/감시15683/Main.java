package 감시15683;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M; // 사무실의 세로와 가로 크기
    static int[][] board; // 사무실의 상태를 저장하는 2차원 배열
    static List<int[]> cctvs = new ArrayList<>(); // CCTV의 위치와 종류를 저장하는 리스트
    // 각 CCTV의 방향을 나타내는 배열
    static int[][] directions = {
            {},
            {0, 1, 2, 3},
            {0, 1},
            {0, 1, 2, 3},
            {0, 1, 2, 3},
            {0, 1, 2, 3}
    };
    // 상, 하, 좌, 우 방향을 나타내는 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        // 사무실의 상태 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                // CCTV의 위치와 종류 저장
                if (1 <= board[i][j] && board[i][j] <= 5) {
                    cctvs.add(new int[]{i, j, board[i][j]});
                }
            }
        }

        // 사각 지대의 최소 크기 출력
        System.out.println(dfs(0, board));
    }

    // DFS를 사용하여 모든 CCTV의 방향을 설정하고 사각 지대의 크기를 반환
    static int dfs(int idx, int[][] prevBoard) {
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.copyOf(prevBoard[i], M);
        }

        // 모든 CCTV의 방향을 설정한 경우
        if (idx == cctvs.size()) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        int[] cctv = cctvs.get(idx);
        int x = cctv[0], y = cctv[1], type = cctv[2];
        int min = Integer.MAX_VALUE;

        // 현재 CCTV의 모든 방향에 대해 탐색
        for (int dir = 0; dir < 4; dir++) {
            //if (type == 2 && dir > 1) break;
            int[][] tempBoard = new int[N][M];
            for (int i = 0; i < N; i++) {
                tempBoard[i] = Arrays.copyOf(board[i], M);
            }
            watch(x, y, tempBoard, type, dir);
            min = Math.min(min, dfs(idx + 1, tempBoard));
        }

        return min;
    }

    // CCTV의 방향에 따라 감시 영역을 업데이트
    static void watch(int x, int y, int[][] board, int type, int dir) {
        switch (type) {
            case 1:
                update(x, y, board, dir);
                break;
            case 2:
                update(x, y, board, (dir*2)% 4);
                update(x, y, board, (dir*2 + 1)% 4);
                break;
            case 3:
                update(x, y, board, dir);
                int sdir = 0;
                if(dir == 0)
                    sdir = 3;
                else if(dir == 3)
                    sdir = 1;
                else if(dir == 1)
                    sdir = 2;
                else if(dir == 2)
                    sdir = 0;
                update(x, y, board, sdir);
                break;
            case 4:
                update(x, y, board, dir);
                update(x, y, board, (dir + 1) % 4);
                update(x, y, board, (dir + 2) % 4);
                break;
            case 5:
                update(x, y, board, dir);
                update(x, y, board, (dir + 1) % 4);
                update(x, y, board, (dir + 2) % 4);
                update(x, y, board, (dir + 3) % 4);
                break;
        }
    }

    // 주어진 방향으로 감시 영역을 업데이트
    static void update(int x, int y, int[][] board, int dir) {
        int nx = x, ny = y;
        while (true) {
            nx += dx[dir];
            ny += dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == 6) {
                break;
            }
            if (board[nx][ny] == 0) {
                board[nx][ny] = -1;
            }
        }
    }
}