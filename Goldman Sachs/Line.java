/*Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

 

Example 1:


Input: points = [[1,1],[2,2],[3,3]]
Output: 3
Example 2:


Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
 

Constraints:

1 <= points.length <= 300
points[i].length == 2
-104 <= xi, yi <= 104
All the points are unique.
*/

import java.util.*;
public class Line{
    public static int maxPoints(int[][] points) {
        int n=points.length;
        if(n<=2){
           return n;
        }
        int m=2;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int t=2;
                for(int k=0;k<n;k++){
                    if(k!=i&&k!=j){
                        if((points[j][1]-points[i][1])*(points[k][0]-points[i][0])==(points[k][1]-points[i][1])*(points[j][0]-points[i][0])){
                            t++;
                        }
                    }
                    m=Math.max(m,t);
                }
            }
        }
        return m;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] m1=new int[n][m];
        for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              m1[i][j]=sc.nextInt();
          }
        }
        System.out.println(maxPoints(m1));
    }
}