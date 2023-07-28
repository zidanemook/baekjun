package 학부연구생민상21922;

import java.util.*;
import java.io.*;

class Node{
    int r;
    int c;

    int dir;//0, 1, 2, 3

    Node(int r, int c, int dir){
        this.r = r;
        this.c = c;
        this.dir = dir;
    }
}
public class Main {

    static int n;
    static int m;

    static int[][] lab;

    static boolean[][] visit;

    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        lab = new int[n][m];

        ArrayList<Node> startlist = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(input[j]);

                if(lab[i][j] == 9){
                    startlist.add(new Node(i, j, 0));
                }

            }
        }

        visit = new boolean[n][m];


        for(Node start : startlist){
            bfs(start.r, start.c);
        }


        System.out.println(answer);
    }

    public static void bfs(int sr, int sc){


        Queue<Node> que = new LinkedList();

        if(visit[sr][sc] == false){
            visit[sr][sc] = true;
            answer++;
        }

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 0; i < 4; i++) {
            int nr = sr + dir[i][0];
            int nc = sc + dir[i][1];

            if(nr < 0 || nr >= n || nc < 0 || nc >= m)
                continue;

            int nd = i;
            if(lab[nr][nc] == 1){
                if(i == 1)
                    nd = 3;
                else if(i == 3)
                    nd = 1;
            }else if(lab[nr][nc] == 2){
                if(i == 0){
                    nd = 2;
                }else if(i == 2)
                    nd = 0;
            } else if(lab[nr][nc] == 3){
                if(i == 0){
                    nd = 1;
                }else if(i == 1){
                    nd = 0;
                }else if(i == 2){
                    nd = 3;
                }else if(i == 3){
                    nd = 2;
                }
            } else if(lab[nr][nc] == 4){
                if(i == 0){
                    nd = 3;
                }else if(i == 1){
                    nd = 2;
                }else if(i == 2){
                    nd = 1;
                }else if(i == 3){
                    nd = 0;
                }
            }

            que.add(new Node(nr, nc, nd));

            if(visit[nr][nc] == false){
                visit[nr][nc] = true;
                answer++;
            }
        }

        while(que.isEmpty() == false){

            Node cur = que.poll();

            int nr = cur.r + dir[cur.dir][0];
            int nc = cur.c + dir[cur.dir][1];

            if(nr < 0 || nr >= n || nc < 0 || nc >= m)
                continue;

            if(lab[nr][nc] >=0 && lab[nr][nc] <= 4 && false == visit[nr][nc])
                answer++;

            if(lab[nr][nc] == 0){
                que.add(new Node(nr, nc, cur.dir));
                visit[nr][nc] = true;
            }else if(lab[nr][nc] == 1){
                int nd = cur.dir;
                if(cur.dir == 1){
                    nd = 3;
                }else if(cur.dir == 3)
                    nd = 1;

                que.add(new Node(nr, nc, nd));
                visit[nr][nc] = true;
            }
            else if(lab[nr][nc] == 2){
                int nd = cur.dir;
                if(cur.dir == 0){
                    nd = 2;
                }else if(cur.dir == 2)
                    nd = 0;

                que.add(new Node(nr, nc, nd));
                visit[nr][nc] = true;
            }
            else if(lab[nr][nc] == 3){
                int nd = cur.dir;
                if(cur.dir == 0){
                    nd = 1;
                }else if(cur.dir == 3)
                    nd = 2;
                else if(cur.dir == 1)
                    nd = 0;
                else if(cur.dir == 2)
                    nd = 3;

                que.add(new Node(nr, nc, nd));
                visit[nr][nc] = true;

            }else if(lab[nr][nc] == 4){
                int nd = cur.dir;
                if(cur.dir == 0){
                    nd = 3;
                }else if(cur.dir == 1)
                    nd = 2;
                else if(cur.dir == 2)
                    nd = 1;
                else if(cur.dir == 3)
                    nd = 0;

                que.add(new Node(nr, nc, nd));
                visit[nr][nc] = true;
            }


        }
    }


}
