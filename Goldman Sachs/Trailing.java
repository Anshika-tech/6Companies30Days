import java.util.*;
public class Trailing{
    public static int trailingZeroes(int n) {
        int c=0;
        while(n!=0){
            int t=n/5;
            c+=t;
            n=t;
            
        } 
        return c;
    }
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       System.out.println(trailingZeroes(n));
    }
}