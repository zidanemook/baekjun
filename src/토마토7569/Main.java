package 토마토7569;

import java.io.*;
import java.util.*;

class Node{
    int i;
    int j;
    int k;

    public Node(int i, int j, int k){
        this.i = i;
        this.j = j;
        this.k = k;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int H = Integer.parseInt(input[2]);

        int[][][] map = new int[H][N][M];

        Queue<Node> pq = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                input = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    int temp = Integer.parseInt(input[k]);
                    map[i][j][k] = temp;
                    if(1 == temp)
                        pq.add(new Node(i,j,k));
                }
            }
        }

        int answer = 0;
        int zerocheck = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(0 == map[i][j][k])
                        zerocheck++;
                }
            }
        }
        if(zerocheck == 0){
            System.out.println(0);
            return;
        }

        answer = bfs(pq, map, M, N, H);

        zerocheck = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (0 == map[i][j][k])
                        zerocheck++;
                }
            }
        }

        if(zerocheck != 0)//막힌게 있음
            answer = -1;

        System.out.println(answer);
    }

    public static int bfs(Queue<Node> pq, int[][][] map, int M, int N, int H){

        int count = 0;
        int[][] dir = { {0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0} };

        while(pq.isEmpty() == false){
            int size = pq.size();
            count++;

            for (int l = 0; l < size ; l++) {
                Node cur = pq.poll();
                for (int m = 0; m < 6; m++) {
                    int ni = cur.i + dir[m][0];
                    int nj = cur.j + dir[m][1];
                    int nk = cur.k + dir[m][2];

                    if(ni < 0 || ni >= H)
                        continue;
                    if(nj < 0 || nj >= N)
                        continue;
                    if(nk < 0 || nk >= M)
                        continue;
                    if(map[ni][nj][nk] != 0)
                        continue;

                    map[ni][nj][nk] = 1;
                    pq.add(new Node(ni, nj, nk));
                }
            }
        }

        return count-1;
    }
}
