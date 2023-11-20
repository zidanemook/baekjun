package 마법사상어와비바라기21610;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] cld = new int[N+1][N+1];

        cld[N][1] = 1;
        cld[N][2] = 1;
        cld[N-1][1] = 1;
        cld[N-1][2] = 1;

        int[][] dir = {{0, 0},{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int D = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            //구름이동 및 바구니 물의양 1 증가
            ArrayList<int[]> movelist = new ArrayList<>();
            for (int j = 1; j < N+1; j++) {
                for (int k = 0; k < N + 1; k++) {
                    if(cld[j][k] == 0)
                        continue;

                    int nr = j + dir[D][0]*S;
                    int nc = k + dir[D][1]*S;

                    if(nr < 1) nr = nr%(N)+N;
                    else if(nr > N) nr = nr% N;
                    if(nr == 0) nr = N;

                    if(nc < 1) nc = nc%(N)+N;
                    else if(nc > N) nc = nc% N;
                    if(nc == 0) nc = N;

                    //구름이동
                    cld[j][k] = 0;
                    //cld[nr][nc] = 1;
                    movelist.add(new int[]{nr, nc});

                    //바구니 물의 양 증가
                    map[nr][nc]++;

                }
            }

            for(int[] move : movelist){
                cld[move[0]][move[1]] = 1;
            }

            ArrayList<int[]> inc = new ArrayList<>();

            for (int j = 1; j < N+1; j++) {
                for (int k = 0; k < N + 1; k++) {
                    if(cld[j][k] == 0)
                        continue;

                    int amount = 0;
                    //물복사버그 처리
                    //좌상
                    int copyr = j-1;
                    int copyc = k-1;
                    if( copyr > 0 && copyr <= N && copyc > 0 && copyc <= N && map[copyr][copyc]>0){
                        amount++;
                    }
                    //우상
                    copyc = k+1;
                    if(copyr > 0 && copyr <= N && copyc > 0 && copyc <= N && map[copyr][copyc]>0){
                        amount++;
                    }
                    //우하
                    copyr = j+1;
                    if(copyr > 0 && copyr <= N && copyc > 0 && copyc <= N && map[copyr][copyc]>0){
                        amount++;
                    }
                    //좌하
                    copyc = k-1;
                    if(copyr > 0 && copyr <= N && copyc > 0 && copyc <= N && map[copyr][copyc]>0){
                        amount++;
                    }

                    inc.add(new int[]{j, k, amount});
                    cld[j][k] = -1;//구름제거 된곳 저장

                }
            }

            for(int[] ele : inc){
                map[ele[0]][ele[1]] += ele[2];
            }

            //바구니 물 2이상 인곳 중에서 구름제거된곳 제외하고 구름 생성
            for (int j = 1; j < N+1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    if(map[j][k] >= 2 && cld[j][k] != -1){
                        cld[j][k] = 1;
                        map[j][k] -= 2;
                    }

                    //구름 제거된곳 초기화
                    if(cld[j][k] == -1)
                        cld[j][k] = 0;
                }
            }


        }

        //물의 양 합계 출력
        int answer = 0;
        for (int j = 1; j < N+1; j++) {
            for (int k = 0; k < N + 1; k++) {
                answer += map[j][k];
            }
        }

        System.out.println(answer);
    }

}
