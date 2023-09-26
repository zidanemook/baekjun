package 청소년상어19236;

import java.io.*;
import java.util.*;

class Fish {
    int num;
    int dir;
    Fish(int num, int dir)
    {
        this.num = num;
        this.dir = dir;
    }
}

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;

        Fish[][] map = new Fish[4][4];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 4; j++) {

                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                map[i][j] = new Fish(num, dir);
            }
        }

        dfs(new int[]{0, 0}, 0, 0, map);

        System.out.println(answer);
    }

    public static void dfs(int[] shark, int sharkdir, int score, Fish[][] map)
    {
        Fish[][] copymap = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copymap[i][j] = new Fish(map[i][j].num, map[i][j].dir);
            }
        }

        //상어 먹이먹음
        //방향
        sharkdir = copymap[shark[0]][shark[1]].dir;
        //점수
        score += copymap[shark[0]][shark[1]].num;
        answer = Math.max(answer, score);
        //빈곳처리
        copymap[shark[0]][shark[1]].num = 0;
        copymap[shark[0]][shark[1]].dir = 0;

        //물고기 이동처리 낮은 번호부터
        int idx = 1;
        while(idx <= 16)
        {
            boolean swap = false;
            for (int i = 0; i < copymap.length; i++) {
                for (int j = 0; j < copymap[0].length; j++) {

                    if( idx == copymap[i][j].num)
                    {
                        Fish fish = copymap[i][j];

                        int dir = fish.dir;

                        for (int k = 0; k < 8; k++) {
                            int nr = i;
                            int nc = j;
                            if(dir == 1)
                                nr--;
                            else if(dir == 2){
                                nr--; nc--;
                            }
                            else if(dir == 3)
                                nc--;
                            else if(dir == 4){
                                nr++; nc--;
                            }
                            else if(dir == 5)
                                nr++;
                            else if(dir == 6){
                                nr++; nc++;
                            }
                            else if(dir == 7)
                                nc++;
                            else if(dir == 8){
                                nr--; nc++;
                            }

                            if(nr < 0 || nr >= 4 || nc < 0 || nc >= 4)
                            {
                                dir++;
                                if(dir > 8)
                                    dir -= 8;
                                continue;
                            }


                            if(nr == shark[0] && nc == shark[1])
                            {
                                dir++;
                                if(dir > 8)
                                    dir -= 8;
                                continue;
                            }

                            //자리교체
                            fish.dir = dir;
                            Fish temp = new Fish(fish.num, fish.dir);
                            fish.num = copymap[nr][nc].num;
                            fish.dir = copymap[nr][nc].dir;
                            copymap[nr][nc].num = temp.num;
                            copymap[nr][nc].dir = temp.dir;
                            swap = true;
                            break;
                        }
                    }
                    if(swap) break;
                }
                if(swap) break;
            }

            if(swap)
                swap = false;

            idx++;
        }

        //상어 이동가능한곳 찾기
        ArrayList<int[]> nextlist = new ArrayList<>();
        if(sharkdir == 1)
        {
            int nr = shark[0]-1;
            int nc = shark[1];

            while(nr >= 0)
            {
                if(copymap[nr][nc].num != 0)//물고기 있는칸
                    nextlist.add(new int[]{nr, nc});

                nr--;
            }
        }
        else if(sharkdir == 2)
        {
            int nr = shark[0]-1;
            int nc = shark[1]-1;

            while(nr >= 0 && nc >= 0)
            {
                if(copymap[nr][nc].num != 0)//물고기 있는칸
                    nextlist.add(new int[]{nr, nc});

                nr--;
                nc--;
            }
        }
        else if(sharkdir == 3)
        {
            int nr = shark[0];
            int nc = shark[1]-1;
            while(nc >= 0)
            {
                if(copymap[nr][nc].num != 0)//물고기 있는칸
                    nextlist.add(new int[]{nr, nc});

                nc--;
            }
        }
        else if(sharkdir == 4)
        {
            int nr = shark[0]+1;
            int nc = shark[1]-1;
            while(nr < 4 && nc >= 0)
            {
                if(copymap[nr][nc].num != 0)//물고기 있는칸
                    nextlist.add(new int[]{nr, nc});
                nr++;
                nc--;
            }
        }
        else if(sharkdir == 5)
        {
            int nr = shark[0]+1;
            int nc = shark[1];
            while(nr < 4)
            {
                if(copymap[nr][nc].num != 0)//물고기 있는칸
                    nextlist.add(new int[]{nr, nc});
                nr++;
            }
        }
        else if(sharkdir == 6)
        {
            int nr = shark[0]+1;
            int nc = shark[1]+1;
            while(nr < 4 && nc < 4)
            {
                if(copymap[nr][nc].num != 0)//물고기 있는칸
                    nextlist.add(new int[]{nr, nc});
                nr++;
                nc++;
            }
        }
        else if(sharkdir == 7)
        {
            int nr = shark[0];
            int nc = shark[1]+1;
            while(nc < 4)
            {
                if(copymap[nr][nc].num != 0)//물고기 있는칸
                    nextlist.add(new int[]{nr, nc});
                nc++;
            }
        }
        else if(sharkdir == 8)
        {
            int nr = shark[0]-1;
            int nc = shark[1]+1;
            while(nr >= 0 &&  nc < 4)
            {
                if(copymap[nr][nc].num != 0)//물고기 있는칸
                    nextlist.add(new int[]{nr, nc});
                nr--;
                nc++;
            }
        }

        for(int[] ele : nextlist)
        {
            dfs(ele, sharkdir, score, copymap);
        }

    }
}
