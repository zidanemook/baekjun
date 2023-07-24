package 물건팔기1487;

import java.io.*;
import java.util.*;

class Buyer{
    int price;
    int cost;

    public Buyer(int price, int cost){
        this.price = price;
        this.cost = cost;
    }
}
public class Main {
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Buyer[] buyers = new Buyer[n];

        String[] input;

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");

            buyers[i] = new Buyer(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        int maxprofit = 0;
        int maxindex = 0;
        for (int i = 0; i < n; i++) {
            int profit = 0;
            for (int j = 0; j < n; j++) {
                if(buyers[i].price <= buyers[j].price){
                    int temp = buyers[i].price-buyers[j].cost;
                    if(temp > 0)
                        profit+=temp;
                }

            }

            if(maxprofit < profit){
                maxprofit = profit;
                maxindex = i;
            }else if(maxprofit == profit){
                if(buyers[maxindex].price > buyers[i].price)
                {
                    maxprofit = profit;
                    maxindex = i;
                }
            }
        }

        if(maxprofit == 0){
            System.out.println(0);
        }else{
            System.out.println(buyers[maxindex].price);
        }

    }
}
