/*Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
 */

import java.util.*;
public class Ques10{
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length, beg = -1, end = -2, min = nums[n-1], max = nums[0];
  for (int i=1;i<n;i++) {
    max = Math.max(max, nums[i]);
    min = Math.min(min, nums[n-1-i]);
    if (nums[i] < max) end = i;
    if (nums[n-1-i] > min) beg = n-1-i; 
  }
  return end - beg + 1;
  }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
     int[] s=new int[n];
     for(int i=0;i<n;i++){
        s[i]=sc.nextInt();
     }
     System.out.println(findUnsortedSubarray(s));
    }
}