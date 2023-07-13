package Zero만들기7490;

import java.io.*;
import java.util.*;
public class Main {

    static ArrayList<String> answer = new ArrayList<>();
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            //숫자9개
            //연산자3개 //0, 1, 2 == +,-,""
            int[] arr = new int[n+n-1];
            boolean[] visit = new boolean[n+1];

            dfs(n+1, 0, arr, visit);
            Collections.sort(answer);
            for(String str:answer)
                System.out.println(str);
            System.out.println();
            answer.clear();
        }

        //System.out.println(sb.toString());
    }

    public static void dfs(int len, int depth, int[] arr, boolean[] visit){
        if(depth == arr.length){

            StringBuilder temp = new StringBuilder();

            int[] arrcopy = Arrays.copyOf(arr, arr.length);

            int b = 0;
            int op = 0;
            for (int i = 0; i < arrcopy.length; i++) {
                if(i == 0){
                    temp.append(arrcopy[i]);
                }
                else if(i % 2 == 0){
                    b = arrcopy[i];
                    if(op == 0){
                        temp.append("+");
                    }else if(op == 1){
                        temp.append("-");
                    }else{

                        int sub = 2;
                        while(true){//" " 이 여러개 뭉쳐있을경우

                            if(arrcopy[i-sub]!=0){
                                arrcopy[i-sub] = arrcopy[i-sub]*10+arrcopy[i];
                                break;
                            }else
                                sub+=2;
                        }

                        arrcopy[i] = 0;
                        temp.append(" ");
                    }
                    temp.append(b);
                }else{
                    op = arrcopy[i];
                }

            }

            int sum = 0;
            for (int i = 0; i < arrcopy.length; i++){
                if(i == 0){
                    sum = arrcopy[i];
                }
                else if(i % 2 == 0){
                    b = arrcopy[i];
                    if(op == 0){
                        sum = sum + b;
                    }else if(op == 1){
                        sum = sum - b;
                    }else{
                        sum = sum + b;
                    }
                }else{
                    op = arrcopy[i];
                }
            }

            if(sum == 0){
                answer.add(temp.toString());
            }

            return;
        }

        for (int i = 1; i < len; i++) {

            if(depth>=2 && arr[depth-2] >= i)
                continue;

            if(visit[i] == false){

                visit[i] = true;
                arr[depth] = i;
                if(depth == arr.length-1){
                    dfs(len, depth+1, arr, visit);
                }else{
                    for (int j = 0; j < 3; j++) {

                        arr[depth+1] = j;
                        dfs(len, depth+2, arr, visit);
                    }
                }


                visit[i] = false;
            }

        }
    }
}
