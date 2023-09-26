package 영단어암기는괴로워;

import java.io.*;
import java.util.*;

class Word implements Comparable<Word>{
    String contents;
    int cnt;

    public Word(String input, int cnt)
    {
        this.contents = input;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Word w)
    {
        int ret = 0;
        if(this.cnt != w.cnt)
            ret = this.cnt > w.cnt ? -1 : 1;
        else if(this.contents.length() != w.contents.length())
            ret = this.contents.length() > w.contents.length() ? -1 : 1;
        else
            ret = this.contents.compareTo(w.contents);

        return ret;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Word> map = new HashMap<>();
        for (int i = 0; i < N; ++i)
        {
            String input = br.readLine();
            if(input.length() >= M)
            {
                if(map.containsKey(input))
                {
                    map.get(input).cnt++;
                }
                else
                {
                    map.put(input, new Word(input, 1));
                }
            }
        }

        Set<String> keys = map.keySet();
        ArrayList<Word> arr = new ArrayList<>();
        for(String key : keys)
        {
            arr.add(map.get(key));
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.size(); ++i)
        {
            sb.append(arr.get(i).contents).append("\n");
        }

        System.out.println(sb);
    }
}
