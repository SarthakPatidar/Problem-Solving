package hackerEarth.augustEasy19.splitHouses;

import java.util.*;

class MagicalWorld {
    
    public static boolean isPrime(int n){
        if(n<=1) return false;
        if(n<=3) return true;
        
        if(n%2 == 0 || n%3 == 0)
            return false;
            
        for(int i=5;i*i<=n;i+=6){
            if(n%i == 0 || n%(i+2) == 0)
                return false;
        }
        
        return true;
    }
    
    public static boolean isValidAscii(int num){
        if((num >= 65 && num <=90) || (num >= 97 && num <=122))
            return true;
        return false;
    }
    
    public static int nearest_prime(int lesser, int greater){
        
        if(isPrime(lesser) && isValidAscii(lesser))
            return lesser;
        else if(isPrime(greater) && isValidAscii(greater))
            return greater;
            
        return nearest_prime(lesser-1,greater+1);
    }
    
    public static void main(String args[] ) throws Exception {

        // Write your code here
        Scanner s = new Scanner(System.in);
        int t,ascii_value;
        String word;
        
        t = s.nextInt();
        while(t > 0){
            word = s.next();
            String result = "";
            
            for(char x: word.toCharArray()){
               ascii_value = (int)x;
               //System.out.print(nearest_prime(ascii_value,ascii_value)+" ");
               result += (char)nearest_prime(ascii_value,ascii_value);                 
            }
            
            System.out.println(result);    
            
            t--;
        }
        
        s.close();
    }
}
