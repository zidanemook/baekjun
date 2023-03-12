package 도영이가만든맛있는음식2961;

import java.io.*;
import java.util.*;

public class Main {

    static class Ingredient
    {
        int ingID;//재료의 고유번호. 최적화 위해 필요.
        int bitter;//쓴맛
        int sour;//신맛

        public Ingredient(int sour, int bitter, int ingID) {
            this.sour = sour;
            this.bitter = bitter;
            this.ingID = ingID;
        }
    }

    static int IngredientCnt;
    static ArrayList<Ingredient> list = new ArrayList<>();
    static boolean[] checked = new boolean[10];
    static Ingredient[] food = new Ingredient[10];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        IngredientCnt = Integer.parseInt(br.readLine());

        String[] input;
        for(int i =0; i < IngredientCnt; ++i)
        {
            input = br.readLine().split(" ");
            list.add(new Ingredient(Integer.parseInt(input[0]), Integer.parseInt(input[1]), i));
        }


        int answer = Integer.MAX_VALUE;
        for(int i = 1; i < IngredientCnt+1; ++i)
        {
            clearFood(i);
            answer = Math.min(answer, search(0, i));
        }

        System.out.println(answer);

    }

    static void clearFood(int targetlevel)//초기화하지 않으면 탐색이 비정상적으로 진행됨
    {
        for(int i = 0; i < targetlevel; ++i)
        {
            food[i] = null;
        }
        food[0] = list.get(0);//search 함수 for문 일단 시작하기위해 세팅
    }

    static int search(int level, int targetlevel)
    {
        if(level == targetlevel)
        {
            int sour = 1;
            int bitter = 0;

            for(int i =0; i < level; ++i)
            {
                sour *= food[i].sour;
                bitter += food[i].bitter;
            }

            return Math.abs(sour-bitter);
        }

        int diff = Integer.MAX_VALUE;
        //이전에 테스트케이스에 선택된 재료 제외하기위해. food에서 사용된것보다 높은 id의 재료사용 예) 123, 132 는 중복이다
        for(int i = food[level==0? level:level-1].ingID; i < IngredientCnt; ++i)
        {
            if(checked[i] == false)
            {
                checked[i] = true;
                food[level] = list.get(i);
                diff = Math.min(diff, search(level+1, targetlevel));
                checked[i] = false;
            }
        }

        return diff;
    }
}
