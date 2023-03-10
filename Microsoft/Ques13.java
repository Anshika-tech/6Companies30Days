/*n passengers board an airplane with exactly n seats. The first passenger has lost the ticket and picks a seat randomly. But after that, the rest of the passengers will:

Take their own seat if it is still available, and
Pick other seats randomly when they find their seat occupied
Return the probability that the nth person gets his own seat.

 

Example 1:

Input: n = 1
Output: 1.00000
Explanation: The first person can only get the first seat.
Example 2:

Input: n = 2
Output: 0.50000
Explanation: The second person has a probability of 0.5 to get the second seat (when first person gets the first seat).
 

Constraints:

1 <= n <= 105
*/

import java.util.*;
public class Ques13 {
    public static double nthPersonGetsNthSeat(int n) {
        if(n==1){
          return 1.0;
      }
      else
           return 0.5;
  }
 public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      System.out.println(nthPersonGetsNthSeat(n));
 }
 }