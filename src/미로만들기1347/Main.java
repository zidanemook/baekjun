package 미로만들기1347;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());  // 입력 문자열의 길이 (이 변수는 사용되지 않지만 문제의 입력 형식을 따르기 위해 포함되었습니다)
        String movements = br.readLine();
        br.close();

        char[][] maze = new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                maze[i][j] = '#';  // 초기에 모든 칸을 벽으로 설정
            }
        }

        int x = 50, y = 50;
        int direction = 2;  // 0: 북, 1: 동, 2: 남, 3: 서
        maze[x][y] = '.';  // 시작 위치는 이동할 수 있는 칸

        for (char movement : movements.toCharArray()) {
            switch (movement) {
                case 'F':
                    switch (direction) {
                        case 0: x--; break;
                        case 1: y++; break;
                        case 2: x++; break;
                        case 3: y--; break;
                    }
                    maze[x][y] = '.';
                    break;
                case 'L':
                    direction = (direction + 3) % 4;  // 왼쪽으로 90도 회전
                    break;
                case 'R':
                    direction = (direction + 1) % 4;  // 오른쪽으로 90도 회전
                    break;
            }
        }

        int minX = 100, minY = 100, maxX = 0, maxY = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (maze[i][j] == '.') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
