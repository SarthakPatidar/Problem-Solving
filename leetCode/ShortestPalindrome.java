package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShortestPalindrome {
  public String shortestPalindrome(String s) {
    String rev = (new StringBuilder(s)).reverse().toString();
    String str1 = "";
    int len = s.length();
    
    for(int i=len-1; i>=0; i--)
    {
        if((s.substring(0,i+1)).equals(rev.substring(len-i-1)))
            break;
        else
            str1 += s.charAt(i);
    }
    
    return str1+s;        
  }
  
	public static String stringToString(String input) {
    return JsonArray.readFrom("[" + input + "]").get(0).asString();
	}
	
	public static void main(String[] args) throws IOException {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String line;
	    while ((line = in.readLine()) != null) {
	        String s = stringToString(line);
	        
	        String ret = new ShortestPalindrome().shortestPalindrome(s);
	        
	        String out = (ret);
	        
	        System.out.print(out);
	    }
	}
}
