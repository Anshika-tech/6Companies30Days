/*You are given two 0-indexed integer arrays nums1 and nums2, each of size n, and an integer diff. Find the number of pairs (i, j) such that:

0 <= i < j <= n - 1 and
nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff.
Return the number of pairs that satisfy the conditions.

 

Example 1:

Input: nums1 = [3,2,5], nums2 = [2,2,1], diff = 1
Output: 3
Explanation:
There are 3 pairs that satisfy the conditions:
1. i = 0, j = 1: 3 - 2 <= 2 - 2 + 1. Since i < j and 1 <= 1, this pair satisfies the conditions.
2. i = 0, j = 2: 3 - 5 <= 2 - 1 + 1. Since i < j and -2 <= 2, this pair satisfies the conditions.
3. i = 1, j = 2: 2 - 5 <= 2 - 1 + 1. Since i < j and -3 <= 2, this pair satisfies the conditions.
Therefore, we return 3.
Example 2:

Input: nums1 = [3,-1], nums2 = [-2,2], diff = -1
Output: 0
Explanation:
Since there does not exist any pair that satisfies the conditions, we return 0.
 

Constraints:

n == nums1.length == nums2.length
2 <= n <= 105
-104 <= nums1[i], nums2[i] <= 104
-104 <= diff <= 104
*/

import java.util.*;
public class Ques9{
    public static long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        List<Integer> diffList = new ArrayList<>();
        long res = 0;
        for (int i = 0; i < n; i++) {
            int curDiff = nums1[i] - nums2[i];
            int target  = curDiff + diff; 
            res += countSmallerEqual(diffList, target);
            diffList.add((int) countSmallerEqual(diffList, curDiff), curDiff);
        }
        return res;
    }
    
    private static long countSmallerEqual(List<Integer> diffList, int target) {
        int left = 0, right = diffList.size(); 
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (diffList.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (long)left;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
     int[] arr1=new int[n];
     for(int i=0;i<n;i++){
        arr1[i]=sc.nextInt();
     }
     int m=sc.nextInt();
     int[] arr2=new int[m];
     for(int i=0;i<m;i++){
        arr2[i]=sc.nextInt();
     }
     int diff=sc.nextInt();
     System.out.println(numberOfPairs(arr1,arr2,diff));
    }
}