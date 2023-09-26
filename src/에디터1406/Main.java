package 에디터1406;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            leftStack.add(input.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            String firstcm = st.nextToken();

            if(firstcm.equals("P")) {
                String text = st.nextToken();
                leftStack.push(text.charAt(0));
            }
            else if(firstcm.equals("L")){
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            }
            else if(firstcm.equals("D")){
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            }
            else if(firstcm.equals("B")){
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb.toString());
    }
}
