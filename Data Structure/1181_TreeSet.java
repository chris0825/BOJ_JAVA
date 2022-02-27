/**
  백준 1181번 - 단어 정렬
  https://www.acmicpc.net/problem/1181
  
  알고리즘 분류
    1. 문자열
    2. 정렬
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sN = Integer.parseInt(br.readLine());
	TreeSet<String> list = new TreeSet<>(new Comparator<String>() {
		@Override
		public int compare(String s1, String s2) {
			if(s1.length() == s2.length())
				return s1.compareTo(s2);
			return s1.length()- s2.length();
            	}
        });
        while(sN-- > 0)
		list.add(br.readLine());
	for(String str : list)
		bw.write(str+"\n");
        bw.close();
    }
}
