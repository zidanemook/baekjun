package 비밀번호발음하기4659;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            String input = br.readLine();

            if(input.equals("end"))
                break;

            if(false == input.contains("a") && false == input.contains("e") && false == input.contains("i") && false == input.contains("o") && false == input.contains("u")){

                System.out.println("<" + input + ">" + "is not acceptable.");
                continue;
            }

            int mcnt = 0;
            int jcnt = 0;

            int seq = 0;

            String moeum = "aeiou";

            boolean good = true;
            for (int i = 0; i < input.length(); i++) {

                Character cc = input.charAt(i);

                if(moeum.contains(cc.toString())){
                    mcnt++;
                    jcnt = 0;
                }else{
                    mcnt = 0;
                    jcnt++;
                }

                if(mcnt >= 3 || jcnt >= 3){
                    good = false;
                    break;
                }

                if(i > 0 && input.charAt(i-1) == cc){
                    if(input.charAt(i-1) == 'e' && cc == 'e'){

                    }else if(input.charAt(i-1) == 'o' && cc == 'o'){

                    }
                    else{
                        good = false;
                        break;
                    }
                }
            }
            if(good == false){
                System.out.println("<" + input + ">" + "is not acceptable.");
                continue;
            }

            System.out.println("<" + input + ">" + "is acceptable.");
        }
    }
}
