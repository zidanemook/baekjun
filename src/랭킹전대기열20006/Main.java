package 랭킹전대기열20006;

import java.io.*;
import java.util.*;

class Player implements Comparable<Player>{
    int l;
    String n;
    Player(int l, String n)
    {
        this.l = l;
        this.n = n;
    }

    public int compareTo(Player o)
    {
        return this.n.compareTo(o.n);
    }
}

class Room{
    int l;
    List<Player> member;

    boolean started;

    Room(int l)
    {
        this.l = l;
        member = new ArrayList<>();
        started = false;
    }
}

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int p = Integer.parseInt(st.nextToken());//플레이어수
        int m = Integer.parseInt(st.nextToken());//정원

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int l = Integer.parseInt(st.nextToken());//레벨
            String n = st.nextToken();//닉네임

            boolean added = false;
            //적합한 방 찾기
            for (int j = 0; j < rooms.size(); j++) {
                Room cur = rooms.get(j);

                int diff = Math.abs(cur.l - l);

                //레벨체크, 방 정원 체크
                if(diff <= 10 && cur.member.size() < m) {
                    cur.member.add(new Player(l, n));
                    added = true;

                    if(cur.member.size() >= m)
                        cur.started = true;

                    break;
                }
            }

            //적합한 방 못 찾은 경우
            if(false == added) {
                Room newRoom = new Room(l);
                newRoom.member.add(new Player(l, n));
                rooms.add(newRoom);
            }

        }

        for (int i = 0; i < rooms.size(); i++) {
            Room cur = rooms.get(i);
            if(cur.member.size() >= m)
                System.out.println("Started!");
            else
                System.out.println("Waiting!");

            Collections.sort(cur.member);

            for (int j = 0; j < cur.member.size(); j++) {
                Player player = cur.member.get(j);
                System.out.println(player.l + " " + player.n);
            }

        }
    }
}
