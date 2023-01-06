/*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
*/

import java.util.*;
public class Ques7{
   
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        int[][] p= prerequisites;
          List<List<Integer>> nm=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            nm.add(new ArrayList<>());
        }
        for(int i=0;i<p.length;i++)
        {
            nm.get(p[i][0]).add(p[i][1]);
        }
        Queue<Integer> kk=new LinkedList<>();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            for(int k:nm.get(i))
            {
                a[k]++;
            }
        }
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==0)
            {
                kk.offer(i);
            }
        }
        List<Integer> k=new ArrayList<>();
        while(!kk.isEmpty())
        {
            int x=kk.poll();
            k.add(x);
            for(int j:nm.get(x))
            {
                a[j]--;
                if(a[j]==0)
                {
                    kk.offer(j);
                }
            }
        }
        return k.size()==n;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n=sc.nextInt();
      int m=sc.nextInt();
      int[][] m1=new int[n][m];
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            m1[i][j]=sc.nextInt();
        }
      }
        
     System.out.println(canFinish(n1,m1));
    }
}