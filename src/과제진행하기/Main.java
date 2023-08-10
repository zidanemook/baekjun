package 과제진행하기;

import java.util.*;

class Solution {

    class Subject{
        int start;
        int cost;

        String name;
        Subject(int start, int cost, String name){
            this.start = start;
            this.cost = cost;
            this.name = name;
        }
    }
    final int max = 24 * 60;
    public String[] solution(String[][] plans) {

        TreeMap<Integer, Subject> tmap = new TreeMap<>();

        for(int i = 0; i < plans.length; ++i){

            String[] time = plans[i][1].split(":");
            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            tmap.put(h*60 + m, new Subject(h*60 + m, Integer.parseInt(plans[i][2]), plans[i][0]));
        }


        Set<Integer> keys = tmap.keySet();
        Stack<Subject> stack = new Stack<>();
        for(int key : keys){

            Subject subject = tmap.get(key);

            stack.add(subject);
        }

        Collections.reverse(stack);

        Stack<Subject> ingstack = new Stack<>();
        int now = 0;
        Subject sub = null;

        List<String> answer = new ArrayList<>();
        while (stack.isEmpty() == false || sub != null || ingstack.isEmpty() == false){

            if(stack.isEmpty() == false && now == stack.peek().start) {
                if(sub != null){

                    if(sub.cost == 0)
                        answer.add(sub.name);
                    else
                        ingstack.add(sub);
                }

                sub = stack.pop();
            }
            else if(sub != null && sub.cost == 0){

                answer.add(sub.name);

                if(ingstack.isEmpty() == false){
                    sub = ingstack.pop();
                }
                else
                    sub = null;
            }

            if(sub != null)
                sub.cost--;

            now++;

        }

        String[] strings = answer.toArray(new String[0]);

        return strings;
    }
}

public class Main {
    public static void main(String[] args) {


        String[][] plans = {
                {"korean", "11:40", "30"},
                {"english", "12:10", "20"},
                {"math", "12:30", "40"}
        };


        Solution sol = new Solution();
        String[] answer = sol.solution(plans);
        Arrays.stream(answer).forEach(s -> System.out.println(s));
    }
}
