package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    /*
    0인 부분 갯수가 안전영역 크기
    벽 세우는 작업을 백트래킹으로 수행
    3개를 다 세웠으면 그때 dfs로 바이러스 퍼뜨리기
     */
    static int n, m;
    static int[][] map;
    static int[][] copy;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans; // 안전영역 최댓값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makeWall(0);
        System.out.println(ans);
    }
    static void makeWall(int wall) { // 벽 세우기
        if (wall == 3) { // 벽 3개
            vis = new boolean[n][m];
            copy = copyMap(map); // 현재 지도 복사
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copy[i][j] == 2) {
                        spread(i, j);
                    }
                }
            }
            // 안전영역 계산
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copy[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            ans = Math.max(ans, cnt);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    static void spread(int x, int y) { // 바이러스 퍼뜨리기
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return;
        }
        if (vis[x][y] || copy[x][y] != 0) {
            return;
        }
        vis[x][y] = true;
        copy[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            spread(nx, ny);
        }
    }
    static int[][] copyMap(int[][] map) { // 배열 복사
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }
}
