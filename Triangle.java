// //adding min sum in global variable
// class Solution {
//     int sum;
//     public int minimumTotal(List<List<Integer>> triangle) {
//         this.sum = Integer.MAX_VALUE;
//         helper(triangle, 0, 0, 0);
//         return sum;
//     }
//     private void helper(List<List<Integer>> triangle, int r, int c, int currSum){
//         //base
//         if(r == triangle.size()){//not checking for c because each row will always have one extra column
//             sum = Math.min(sum, currSum);
//             return;
//         }
//      //logic
//         helper(triangle, r + 1, c, currSum + triangle.get(r).get(c));
//         helper(triangle, r + 1, c + 1, currSum + triangle.get(r).get(c));
//     }
// }

// //int based recurssion
// class Solution {
//      public int minimumTotal(List<List<Integer>> triangle) {
     
//         return helper(triangle, 0, 0);
 
//     }
//     private int helper(List<List<Integer>> triangle, int r, int c){
//         //base
//         if(r == triangle.size()){//not checking for c because each row will always have one extra column
//             return 0;
//         }

//      //logic
//         int left = helper(triangle, r + 1, c);
//         int right = helper(triangle, r + 1, c + 1);

//         return Math.min(left, right) + triangle.get(r).get(c);
//     }
// }


//recurssion with memoisation  tc- O(n^2) sc-O(n^2)


// class Solution {
//     int[][] memo;
//      public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         this.memo = new int[n][n];
//         for(int i = 0; i<n; i++){
//             Arrays.fill(memo[i], Integer.MAX_VALUE);
//         }
//         return helper(triangle, 0, 0);
 
//     }
//     private int helper(List<List<Integer>> triangle, int r, int c){
//         //base
//         if(r == triangle.size()){//not checking for c because each row will always have one extra column
//             return 0;
//         }

//      //logic
//         if(memo[r][c]!=Integer.MAX_VALUE) return memo[r][c];
//         int left = helper(triangle, r + 1, c);
//         int right = helper(triangle, r + 1, c + 1);

//         memo[r][c] = Math.min(left, right) + triangle.get(r).get(c);

//         return memo[r][c];
//     }
// }

// //tabulation top down tc- O(n^2) sc-O(1)
// class Solution {
//      public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();

//         for(int i = 1; i < n; i++){
//             for(int j = 0; j <= i; j++){
//                 if(j == 0){
//                     triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
//                 }else if(j == i){
//                     triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
//                 }else{
//                     triangle.get(i).set(j, triangle.get(i).get(j) + 
//                                         Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)));
//                 }
//             }
//         }

//         int result = Integer.MAX_VALUE;
//         for(int j =0; j < n; j++){
//             result = Math.min(result, triangle.get(n-1).get(j));
//         }

//         return result;
//     }

// }

// //tabulation bottom up tc- O(n^2) sc-O(1)
// class Solution {
//      public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();

//         for(int i = n-2; i >= 0; i--){
//             for(int j = 0; j <= i; j++){
//               triangle.get(i).set(j, triangle.get(i).get(j) + 
//               Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
//             }
//         }
//         return triangle.get(0).get(0);
//     }

// }

//tabulation bottom up using dp extra space tc- O(n^2) sc-O(n^2)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       int n = triangle.size();
       int[][] dp = new int[n][n];

       for(int j =0; j<n; j++){
           dp[n-1][j] = triangle.get(n-1).get(j);
       }

       for(int i = n-2; i >= 0; i--){
           for(int j = 0; j <= i; j++){
             dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
           }
       }
       return dp[0][0];
   }

}