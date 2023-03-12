import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        //int n = 5;
        //int[] goal = {5, 4, 3, 2, 1};

        int n = 4;
        int[] goal = {1, 2, 4, 5, 3};

        System.out.println(solution.solution(n, goal));
    }
}

class Solution
{
    public long solution(int n, int[] goal)
    {
        long answer = 0;

        for(int i = 0; i < goal.length; ++i)
        {
            for(int j = i; j < goal.length; ++j)
            {
                if(goal[i] > goal[j])
                {
                    answer++;

                    int temp = goal[i];
                    goal[i] = goal[j-1];
                    goal[j-1] = temp;
                }

            }
        }

        return answer;
    }

}








//public class Main
//{
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String str = "baabaa";
//        System.out.println(solution.solution(str));
//    }
//}
//
//class Solution
//{
//    public int solution(String s)
//    {
//        int answer = 0;
//
//        Stack<Character> stack = new Stack<>();
//
//        Character c = '?';
//        for(int i = 0; i < s.length(); ++i)
//        {
//            Character cur = s.charAt(i);
//
//            if(false == c.equals(cur))
//            {
//                c = cur;
//                stack.push(cur);
//            }
//            else
//            {
//                stack.pop();
//                if(stack.isEmpty() == false)
//                    c = stack.peek();
//                else
//                    c = '?';
//            }
//        }
//
//        if(stack.isEmpty() == true)
//            answer = 1;
//
//        return answer;
//    }
//}



//public class Main
//{
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//
//        int h = 0;
//        int k = 0;
//
//        int[] arr = {2, 3, 6, 7, 8, 10, 11};
//        h = 12;
//        k = 3;
//
//        System.out.println(solution.solution(h, k, arr));
//    }
//}
//
//class Solution
//{
//    public int solution(int h, int k, int[] boxes)
//    {
//        Arrays.sort(boxes);
//
//        int answer = 0;
//        int cur = 0;
//
//        if( (cur+k) >= h)
//            return 0;
//
//        for(int i = 0; i < boxes.length; ++i)
//        {
//            if( (cur+k) >= boxes[i])
//            {
//                if((i+1) == boxes.length)
//                {
//                    if(cur+k >= h)
//                    {
//                        cur = h;
//                    }
//                    else
//                    {
//                        cur = boxes[i];
//                        answer++;
//                    }
//                }
//                else
//                {
//                    if((cur+k) >= boxes[i+1])
//                    {
//
//                    }
//                    else
//                    {
//                        cur = boxes[i];
//                        answer++;
//                    }
//                }
//            }
//        }
//
//        if((cur+k) < h)
//            answer = -1;
//
//        return answer;
//    }
//}













//public class Main
//{
//    public static void main(String[] args) throws IOException
//    {
//        Solution solution = new Solution();
//        //int[] cards = {11, 10, 0, 3, 0, 0, 10, 10, 11, 11};
//        int[] cards = {11, 0, 0, 2, 2};
//        System.out.println(solution.solution(cards));
//    }
//}
//
////3, 1  2, 2
//class Solution
//{
//    public int solution(int[] cards)
//    {
//        int answer = 0;
//        int[] count = new int[14];
//        int joker = 0;
//
//        for(int i = 0; i < cards.length; ++i)
//        {
//            int curNum = cards[i];
//            if(curNum == 0)
//                joker++;
//            else
//                count[curNum]++;
//
//            if(check(count, joker))
//            {
//                answer++;
//                Arrays.fill(count, 0);
//                joker = 0;
//            }
//        }
//
//        return answer;
//    }
//
//    public boolean check(int[] arr, int joker)
//    {
//        int max = 0;
//        int smax = 0;
//
//        for(int i = 0; i < arr.length; ++i)
//        {
//           if(arr[i] > smax)
//           {
//               if(arr[i] > max)
//               {
//                   smax = max;
//                   max = arr[i];
//               }
//               else if(arr[i] > smax)
//                   smax = arr[i];
//
//           }
//        }
//
//        boolean ret = false;
//        if((max+joker) >= 3)
//        {
//            ret = true;
//            if(max < 3)
//                joker -= (3 - max);
//        }
//
//        if(ret && (smax+joker) >= 2)
//        {
//            ret = true;
//        }
//        else
//            ret = false;
//
//        return ret;
//    }
//}