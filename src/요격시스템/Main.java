package 요격시스템;
import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int s;
    int e;
    Node(int s, int e){
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Node o){
        return this.s == o.s ? Integer.compare(this.e, o.e) : Integer.compare(this.s, o.s);
    }
}


class Solution {
    public int solution(int[][] targets) {
        ArrayList<Node> arr = new ArrayList<>();
        for (int[] target : targets) {
            arr.add(new Node(target[0], target[1]));
        }

        Collections.sort(arr);

        int answer = 1;
        int missile = arr.get(0).e - 1; // 첫 개구간의 끝에서 -1 한 지점에서 요격

        for (int i = 1; i < arr.size(); i++) {
            if (missile >= arr.get(i).s) {
                missile = Math.min(missile, arr.get(i).e - 1); // 공통 부분에서 요격
            } else {
                missile = arr.get(i).e - 1; // 새로운 요격 미사일 발사
                answer++;
            }
        }

        return answer;
    }
}

class Main{

    public static void main(String[] args) {

        int[][] target = {{3, 6}, {2, 4}, {5, 6},{1,3}};

        Solution solution = new Solution();
        System.out.println(solution.solution(target));
    }
}

