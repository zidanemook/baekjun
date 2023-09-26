package 상어초등학교21608;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<HashSet<Integer>> studentlist = new ArrayList<>();

        for (int i = 0; i < (N * N)+1; i++) {

            studentlist.add(new HashSet<>());
        }

        StringTokenizer st = null;
        ArrayList<Integer> input = new ArrayList<>();
        for (int i = 1; i < (N * N)+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int stid = Integer.parseInt(st.nextToken());

            input.add(stid);

            for (int j = 0; j < 4; j++) {
                studentlist.get(stid).add(Integer.parseInt(st.nextToken()));
            }

        }

        int[][] map = new int[N+1][N+1];

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 0; i < (N * N); i++) {
            int stid = input.get(i);

            //비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.

            int like = 0;
            ArrayList<int[]> best = new ArrayList<>();
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if(map[j][k] == 0)
                    {
                        int temp = 0;
                        for (int l = 0; l < 4; l++) {

                            int nr = j + dir[l][0];
                            int nc = k + dir[l][1];

                            if(nr < 1 || nr > N || nc < 1 || nc > N)
                                continue;

                            if(studentlist.get(stid).contains(map[nr][nc]))
                                temp++;
                        }
                        if(temp >= like)
                        {
                            if(temp > like){
                                best.clear();
                                best.add(new int[]{j, k});
                            }
                            else{
                                best.add(new int[]{j, k});
                            }

                            like = temp;
                        }
                    }
                }
            }

            //만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
            if(best.size() > 1)
            {
                ArrayList<int[]> ret = new ArrayList<>();

                int max = 0;
                for(int[] ele : best){
                    int temp = 0;
                    for (int j = 0; j < 4; j++) {
                        int nr = ele[0] + dir[j][0];
                        int nc = ele[1] + dir[j][1];

                        if(nr < 1 || nr > N || nc < 1 || nc > N)
                            continue;

                        if(map[nr][nc] == 0)
                            temp++;
                    }
                    if(temp >= max)
                    {
                        if(temp > max){
                            ret.clear();
                            ret.add(ele);
                        }else{
                            ret.add(ele);
                        }
                        max = temp;
                    }
                }

                best.clear();
                for(int[] ele : ret)
                    best.add(ele);
            }

            //만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
            if(best.size() > 1)
            {
                ArrayList<int[]> ret = new ArrayList<>();

                int minrow = 1000000;
                for(int[] ele : best){

                    if(minrow >= ele[0]){
                        if(minrow > ele[0]){
                            ret.clear();
                            ret.add(ele);
                        }else {
                            ret.add(ele);
                        }

                        minrow = ele[0];
                    }
                }

                best.clear();
                for(int[] ele : ret)
                    best.add(ele);
            }

            if(best.size() > 1)
            {
                ArrayList<int[]> ret = new ArrayList<>();

                int mincol = 1000000;
                for(int[] ele : best){

                    if(mincol >= ele[1]){
                        if(mincol > ele[1]){
                            ret.clear();
                            ret.add(ele);
                        }else {
                            ret.add(ele);
                        }
                        mincol = ele[1];
                    }
                }

                best.clear();
                for(int[] ele : ret)
                    best.add(ele);
            }

            int[] pos = best.get(0);
            map[pos[0]][pos[1]] = stid;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                int cnt = 0;
                int stid = map[i][j];

                for (int k = 0; k < 4; k++) {
                    int nr = i + dir[k][0];
                    int nc = j + dir[k][1];

                    if(nr < 1 || nr > N || nc < 1 || nc > N)
                        continue;

                    if(studentlist.get(stid).contains(map[nr][nc]))
                        cnt++;
                }

                if(cnt == 1)
                    answer+=1;
                else if(cnt == 2)
                    answer+=10;
                else if(cnt == 3)
                    answer+=100;
                else if(cnt == 4)
                    answer+=1000;
            }
        }

        System.out.println(answer);
    }
}
