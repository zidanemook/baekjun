package 불5427;

import java.io.*;
import java.util.*;

class Node{
    int r;
    int c;
    Node(int r, int c){
        this.r = r;
        this.c = c;
    }
}
public class Main {

    //static int counter = 0; //testcode

    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        String[] input;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {

            input = br.readLine().split(" ");

            int col = Integer.parseInt(input[0]);
            int row = Integer.parseInt(input[1]);

            char[][] map = new char[row][col];
            ArrayList<Node> fires = new ArrayList<>();

            int sangeunR = 0;
            int sangeunC = 0;
            for (int j = 0; j < row; j++) {
                input = br.readLine().split("");
                for (int k = 0; k < col; k++) {
                    char cur = input[k].charAt(0);
                    map[j][k] = cur;
                    if(cur == '@'){
                        sangeunR = j;
                        sangeunC = k;
                    }else if(cur == '*'){
                        fires.add(new Node(j, k));
                    }
                }
            }

            //불을 퍼트리고 걸린 시간을 기록한다
            int[][] fmap = new int[row][col];
            for (int j = 0; j < row; j++) {
                Arrays.fill(fmap[j], Integer.MAX_VALUE);
            }

            firebfs(fires, row, col, map, fmap);

            //불시간보다 상근이의 시간이 작을때 이동한다

            int ret = pathbfs(sangeunR, sangeunC, row, col, map, fmap);
            if(ret == -1)
                sb.append("IMPOSSIBLE\n");
            else
                sb.append(ret+"\n");

        }
        System.out.println(sb.toString());
        //System.out.println(counter);
    }

    static int pathbfs(int sr, int sc, int rsize, int csize, char[][] map, int[][] fmap){
        boolean[][] visit = new boolean[rsize][csize];
        Queue<Node> que = new LinkedList();
        que.add(new Node(sr, sc));
        visit[sr][sc] = true;
        int time = 1;

        while (que.isEmpty() == false){

            int size = que.size();
            for (int i = 0; i < size; i++) {

                Node cur = que.poll();
                int nr = 0;
                int nc = 0;
                for (int j = 0; j < 4; j++) {

                    nr = cur.r + dir[j][0];
                    nc = cur.c + dir[j][1];

                    if(nr < 0 || nr >= rsize || nc < 0 || nc >= csize)
                        return time;//현재위치가 외곽이므로 +1

                    if(map[nr][nc] != '.')
                        continue;

                    if(visit[nr][nc] == true)
                        continue;

                    if(fmap[nr][nc] <= time)
                        continue;

                    if(nr == 0 || nr == rsize-1 || nc == 0 || nc == csize-1)
                        return time+1;//외곽 한칸 전 이므로 +1, 외곽에서 나가야 하므로 +1

                    visit[nr][nc] = true;

                    que.add(new Node(nr, nc));
                }
            }
            time++;

        }

        return -1;
    }
    static void firebfs(ArrayList<Node> fires, int rsize, int csize, char[][] map, int[][] fmap){

        boolean[][] visit = new boolean[rsize][csize];
        Queue<Node> que = new LinkedList();
        for (Node fire : fires) {
            que.add(fire);
            visit[fire.r][fire.c] = true;
            fmap[fire.r][fire.c] = 0;
        }

        while (que.isEmpty() == false){

            Node cur = que.poll();

            int nr = 0;
            int nc = 0;
            for (int i = 0; i < 4; i++) {

                //counter++;//testcode

                nr = cur.r + dir[i][0];
                nc = cur.c + dir[i][1];

                if(nr < 0 || nr >= rsize || nc < 0 || nc >= csize)
                    continue;

                if(map[nr][nc] != '.' && map[nr][nc] != '@')
                    continue;

                if(visit[nr][nc] == true)
                    continue;

                int curTime = fmap[cur.r][cur.c];
                if(curTime < fmap[nr][nc]){
                    fmap[nr][nc] = fmap[cur.r][cur.c]+1;
                }else
                    continue;

                visit[nr][nc] = true;

                que.add(new Node(nr, nc));
            }
        }
    }
}
