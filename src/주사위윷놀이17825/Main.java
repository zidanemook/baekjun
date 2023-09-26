package 주사위윷놀이17825;

import java.io.*;
import java.util.*;

class Node {
    int score;
    Node next;  // 다음에 이동할 칸
    Node shortcut;  // 파란색 화살표를 타고 이동할 경우 다음 칸

    public Node(int score) {
        this.score = score;
        this.next = null;
        this.shortcut = null;
    }
}

public class Main {

    static int[] dice = new int[10];
    static Node[] horses = new Node[4];
    static int maxScore = 0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        dice = new int[10];

        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        Node start = buildBoard();

        for (int i = 0; i < 4; i++) {
            horses[i] = start;
        }
        simulate(0, 0);
        System.out.println(maxScore);

    }

    public static void simulate(int turn, int score) {
        if (turn == 10) {
            maxScore = Math.max(maxScore, score);
            return;
        }

        for (int i = 0; i < 4; i++) {
            Node prev = horses[i];
            Node curr = prev;
            int steps = dice[turn];

            for (int j = 0; j < steps; j++) {
                if (j == 0 && curr.shortcut != null) {
                    curr = curr.shortcut;
                } else {
                    if(curr.next == null)
                        break;
                    curr = curr.next;
                }
            }

            if (isValidMove(curr)) {
                horses[i] = curr;
                simulate(turn + 1, score + curr.score);
                horses[i] = prev;
            }
        }
    }

    public static boolean isValidMove(Node target) {
        if (target.score == 0) {
            return true;
        }
        for (Node horse : horses) {
            if (horse == target) {
                return false;
            }
        }
        return true;
    }

    public static Node buildBoard() {
        Node start = new Node(0);
        Node current = start;

        int[] mainScores = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40};
        Node[] mainNodes = new Node[mainScores.length];

        // 기본 경로 구성
        for (int i = 0; i < mainScores.length; i++) {
            Node newNode = new Node(mainScores[i]);
            mainNodes[i] = newNode;
            current.next = newNode;
            current = newNode;
        }

        // 도착 지점
        Node end = new Node(0);
        current.next = end;

        Node twentyfive = new Node(25);

        // 첫 번째 파란색 화살표 경로
        Node blue1 = new Node(13);
        mainNodes[4].shortcut = blue1;  // Node(10) -> Node(13)
        blue1.next = new Node(16);
        blue1 = blue1.next;
        blue1.next = new Node(19);
        blue1 = blue1.next;
        blue1.next = twentyfive;

        // 두 번째 파란색 화살표 경로
        Node blue2 = new Node(22);
        mainNodes[9].shortcut = blue2;  // Node(20) -> Node(22)
        blue2.next = new Node(24);
        blue2 = blue2.next;
        blue2.next = twentyfive;

        // 세 번째 파란색 화살표 경로
        Node blue3 = new Node(28);
        mainNodes[14].shortcut = blue3;  // Node(30) -> Node(28)
        blue3.next = new Node(27);
        blue3 = blue3.next;
        blue3.next = new Node(26);
        blue3 = blue3.next;
        blue3.next = twentyfive;


        twentyfive.next = new Node(30);  // Node(25) 연결
        twentyfive.next.next = new Node(35);  // Node(25) 연결
        twentyfive.next.next.next = new Node(40);
        twentyfive.next.next.next.next = end;  // Node(40)에서 도착까지 연결

        return start;
    }
}
