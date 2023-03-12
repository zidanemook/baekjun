package 전공책16508;

import java.io.*;
import java.util.Arrays;

class Book
{
    String name;
    int price;

    int[] alphabetCnt;
    public Book(int price, String name) {
        this.name = name;
        this.price = price;

        alphabetCnt = new int[26];

        for(int i = 0; i < name.length(); ++i)
        {
            alphabetCnt[name.charAt(i) - 'A']++;
        }
    }
}

public class Main {

    static Book[] books;
    static int[] bookSelect;

    static boolean[] checked;

    static int N;

    static String T;

    static int[] needAlphabetCnt = new int[26];

    static int minPrice = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = br.readLine();

        for(int i = 0; i < T.length(); ++i)
        {
            needAlphabetCnt[T.charAt(i) - 'A']++;
        }

        N = Integer.parseInt(br.readLine());
        books = new Book[N];
        bookSelect = new int[N];
        checked = new boolean[N];

        String[] input;
        for(int i = 0; i < N; ++i)
        {
            input = br.readLine().split(" ");
            books[i] = new Book(Integer.parseInt(input[0]), input[1]);
        }

        //책의 조합을 만드는 함수. 완전탐색. DFS
        search(0, 1);

        if(Integer.MAX_VALUE == minPrice)//실패!
        {
            System.out.println(-1);
        }
        else
            System.out.println(minPrice);
    }

    static void search(int depth, int targetDepth)
    {
        if(depth == targetDepth)
        {

//            for(int i = 0; i < depth; ++i)
//            {
//                System.out.print(bookSelect[i]);
//            }
//            System.out.println();

            canMakeSentence(depth);

            return;
        }

        for(int i = bookSelect[depth==0?depth:depth-1]; i < N; ++i)
        {
            if(checked[i])
                continue;

            checked[i] = true;
            bookSelect[depth] = i;
            search(depth+1, targetDepth);
            search(depth+1, targetDepth+1);
            checked[i] = false;
        }
    }

    static void canMakeSentence(int curDepth)
    {
        int[] alphabetCnt = new int[26];

        int price = 0;

        for(int i = 0; i < curDepth; ++i)
        {
            price += books[bookSelect[i]].price;
            for(int j =0; j < 26; ++j)
            {
                alphabetCnt[j] += books[bookSelect[i]].alphabetCnt[j];
            }

        }

        for(int i = 0; i < 26; ++i)
        {
            if(needAlphabetCnt[i] > alphabetCnt[i])
            {
                return;
            }
        }

        minPrice = Math.min(minPrice, price);

    }
}
