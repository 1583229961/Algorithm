package i.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reverse {
public static void main(String []args) {
	Scanner scanner=new Scanner(System.in);
	String string=scanner.nextLine();
	int num=scanner.nextInt();
	char []a=string.toCharArray();
		Map<Character, Integer> hashMap=new HashMap<Character, Integer>();
	for (char c : a) {
		if(hashMap.containsKey(c))
		{
			hashMap.put(c, hashMap.get(c)+1);
		}
		else {
			hashMap.put(c, 1);
		}
	}
	
	 for(Character key:hashMap.keySet()) {
         if(hashMap.get(key)==num) {
             System.out.println(key);
         }
     }
}
}
