package 기적의매매법20546;

import java.io.*;
import java.util.*;

class Stock{
    int cnt;
    Stock(int cnt){
        this.cnt = cnt;
    }
}

class Human{
    int money;
    ArrayList<Stock> asset = new ArrayList<>();
    Human(int money){
        this.money = money;
    }
}
public class Main {
    public static void main(String[] sdf)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] chart = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            chart[i] = Integer.parseInt(input[i]);
        }

        Human sm = new Human(money);
        Human jh = new Human(money);

        int upcnt = 0;
        int dncnt = 0;
        int pre = chart[0];

        for(int cur : chart){

            if(cur <= jh.money){
                jh.asset.add(new Stock(jh.money / cur));
                jh.money = jh.money % cur;
            }

            if(pre < cur){
                upcnt++;
                dncnt = 0;
            }else if(pre > cur){
                dncnt++;
                upcnt = 0;
            }else{
                upcnt = 0;
                dncnt = 0;
            }
            pre = cur;

            if(upcnt >= 3){//sell
                if(sm.asset.isEmpty() == false){
                    for (Stock st : sm.asset){
                        sm.money += cur*st.cnt;
                    }
                    sm.asset.clear();
                }
            }else if(dncnt >= 3 && cur <= sm.money){

                sm.asset.add(new Stock(sm.money/cur));
                sm.money = sm.money % cur;

            }
        }

        int smtotal = sm.money;
        for(Stock st : sm.asset){
            smtotal += chart[chart.length-1]*st.cnt;
        }

        int jhtotal = jh.money;
        for(Stock st : jh.asset){
            jhtotal += chart[chart.length-1]*st.cnt;
        }

        if(smtotal > jhtotal){
            System.out.println("TIMING");
        }else if(smtotal < jhtotal){
            System.out.println("BNP");
        }else{
            System.out.println("SAMESAME");
        }
    }
}
