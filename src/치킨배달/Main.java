package 치킨배달;

import java.io.*;
import java.util.*;

class Position {
    int x, y;
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static ArrayList<Position> houses = new ArrayList<>();
    static ArrayList<Position> chicken = new ArrayList<>();
    static int N, M;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    houses.add(new Position(i, j));
                } else if (value == 2) {
                    chicken.add(new Position(i, j));
                }
            }
        }

        dfs(0, 0, new ArrayList<>());
        System.out.println(answer);

    }

    public static int calculateDistance(ArrayList<Position> selected) {
        int totalDistance = 0;
        for (Position house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (Position ch : selected) {
                int distance = Math.abs(house.x - ch.x) + Math.abs(house.y - ch.y);
                minDistance = Math.min(minDistance, distance);
            }
            totalDistance += minDistance;
        }
        return totalDistance;
    }

    public static void dfs(int start, int count, ArrayList<Position> selected) {
        if (count == M) {
            answer = Math.min(answer, calculateDistance(selected));
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            selected.add(chicken.get(i));
            dfs(i + 1, count + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

}
