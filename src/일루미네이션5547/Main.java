package 일루미네이션5547;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] connection;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int w = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);

        int[][] map = new int[h+1][w+1];
        connection = new int[h+1][w+1];
        for (int i = 1; i < h+1; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j < w+1; j++) {
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        //막힌곳은 건물로 변경
        for (int i = 1; i < h+1; i++) {
            for (int j = 1; j < w+1; j++) {
                if(map[i][j] == 1)
                    continue;

                if(false == bfs(i, j, w, h, map)){
                    map[i][j] = 1;
                }else
                    connection[i][j] = 1;//바깥연결된곳 표시
            }
        }

        int answer = 0;
        //0 이나 지도바깥 접한 면
        int nx = 0;
        int ny = 0;
        for (int i = 1; i < h+1; i++) {
            for (int j = 1; j < w+1; j++) {
                if(map[i][j] == 1){

                    for (int k = 0; k < 6; k++) {
                        nx = i;
                        ny = j;

                        //왼위
                        if(k == 0){
                            if(i % 2 == 0){
                                nx = i -1;
                                ny = j -1;
                            }
                            else{
                                nx = i -1;
                            }

                        }
                        //오위
                        else if(k == 1){
                            if(i % 2 == 0){
                                nx = i -1;
                            }else{
                                nx = i -1;
                                ny = j +1;
                            }
                        }
                        //오
                        else if(k == 2){
                            ny = j +1;
                        }
                        //오아
                        else if(k == 3){
                            if(i % 2 == 0){
                                nx = i +1;
                            }else{
                                nx = i +1;
                                ny = j +1;
                            }
                        }
                        //왼아
                        else if(k == 4){
                            if(i % 2 == 0){
                                nx = i +1;
                                ny = j -1;
                            }else{
                                nx = i+1;
                            }
                        }
                        //왼
                        else if(k == 5){
                            ny = j -1;
                        }

                        if(nx < 1 || nx > h || ny < 1 || ny > w){
                            answer++;
                            continue;
                        }

                        if(map[nx][ny] == 0){
                            answer++;
                        }
                    }

                }
            }
        }

        System.out.println(answer);
    }

    //경계 밖에 연결되는가?
    static boolean bfs(int sx, int sy, int w, int h, int[][] map){
        class Node{
            int x;
            int y;
            Node(int x, int y){
                this.x = x;
                this.y = y;
            }
        }

        boolean[][] visit = new boolean[h+1][w+1];
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(sx, sy));
        visit[sx][sy] = true;

        while(que.isEmpty() == false){

            Node cur = que.poll();

            int nx = cur.x;
            int ny = cur.y;
            for (int i = 0; i < 6; i++) {

                nx = cur.x;
                ny = cur.y;

                //왼위
                if(i == 0){
                    if(cur.x % 2 == 0){
                        nx = cur.x -1;
                        ny = cur.y -1;
                    }
                    else{
                        nx = cur.x -1;
                    }

                }
                //오위
                else if(i == 1){
                    if(cur.x % 2 == 0){
                        nx = cur.x -1;
                    }else{
                        nx = cur.x -1;
                        ny = cur.y +1;
                    }
                }
                //오
                else if(i == 2){
                    ny = cur.y +1;
                }
                //오아
                else if(i == 3){
                    if(cur.x % 2 == 0){
                        nx = cur.x +1;
                    }else{
                        nx = cur.x +1;
                        ny = cur.y +1;
                    }
                }
                //왼아
                else if(i == 4){
                    if(cur.x % 2 == 0){
                        nx = cur.x +1;
                        ny = cur.y -1;
                    }else{
                        nx = cur.x+1;
                    }
                }
                //왼
                else if(i == 5){
                    ny = cur.y -1;
                }

                if(nx < 1 || nx > h || ny < 1 || ny > w)
                    return true;

                if(visit[nx][ny] == true)
                    continue;

                if(map[nx][ny] == 1)
                    continue;

                if(connection[nx][ny] == 1){
                    return true;
                }

                visit[nx][ny] = true;
                que.add(new Node(nx, ny));
            }
        }

        return false;
    }
}
