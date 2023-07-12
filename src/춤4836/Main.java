package 춤4836;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        String[] input;

        while ((line = br.readLine()) != null){
            input = line.split(" ");

            if(input == null)
                break;

            int hopcnt = 0;
            int dipcnt = 0;
            boolean twirl = false;
            int[] dippos = new int[input.length];
            int[] error = new int[6];
            for (int i = 0; i < input.length; i++) {
                if(input[i].equals("dip")){
                    dipcnt++;
                    if( (i>0 && input[i-1].equals("jiggle")) || (i>1 && input[i-2].equals("jiggle")) || ((i+1)<input.length && input[i+1].equals("twirl"))){

                    }else{
                        error[1]++;
                        dippos[i] = 1;
                    }
                }else if(input[i].equals("hop")){
                    hopcnt++;
                }else if(input[i].equals("twirl")){
                    twirl = true;
                }

                if(i == 0 && input[i].equals("jiggle")){
                    error[4]++;
                }

                if(i == input.length-1){
                    if((i>1 && input[i-2].equals("clap")) && (i>0 && input[i-1].equals("stomp")) && input[i].equals("clap")){

                    }else{
                        error[2]++;
                    }
                }
            }
            if(dipcnt == 0)
                error[5]++;

            if(twirl && hopcnt == 0)
                error[3]++;

            StringBuilder sb = new StringBuilder();
            int errocnt = 0;
            for (int i = 1; i < error.length; i++) {
                if(error[i] != 0){
                    errocnt++;
                }
            }

            if(0 != errocnt){
                int errcntcopy = errocnt;
                if(errocnt == 1)
                    sb.append("form error ");
                else
                    sb.append("form errors ");
                for (int i = 1; i < error.length; i++) {
                    if(error[i] != 0){

                        if(errcntcopy == 1){
                            if(errocnt == 1)
                                sb.append(i + ": ");
                            else
                                sb.append(" and " + i + ": ");
                        }
                        else if(errcntcopy == errocnt){
                            sb.append(i);
                        }else{
                            sb.append(", " + i);
                        }

                        errcntcopy--;
                    }


                }

            }
            else
                sb.append("form ok: ");

            for (int i = 0; i < input.length; i++) {

                if(input[i].equals("dip") && dippos[i] == 1){
                    if(i == input.length-1)
                        sb.append(input[i].toUpperCase());
                    else
                        sb.append(input[i].toUpperCase() + " ");
                }else{
                    if(i == input.length-1)
                        sb.append(input[i]);
                    else
                        sb.append(input[i] + " ");
                }

            }

            System.out.println(sb.toString());
        }
    }
}
