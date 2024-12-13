

// //bruteforce tc- n^2, sc- O(1)
// class Solution {
//     public int numberOfArithmeticSlices(int[] nums) {
//         int n = nums.length;
//         int count = 0;

//         for(int i = 0; i<n-2; i++){
//             for(int j = i+2; j < n; j++){
//                 if(nums[j] - nums[j-1] == nums[j-1] - nums[j-2]){
//                     count++;
//                 }else{
//                     break;
//                 }
//             }
//         }
//         return count;
//     }
// }



// //recursive optimised tc- O(n)
// class Solution {
//     int count;
//     public int numberOfArithmeticSlices(int[] nums) {
//         int n = nums.length;
//         if(n<3) return 0;
//         this.count = 0;
//         helper(nums, 2, 0);
//         return count;
//     }
//     private void helper(int[] nums, int i, int prev){
//         //base
//         if(i == nums.length) return;

//         //logic
//         int curr = 0;
//         if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
//             curr = prev + 1;
//             count += curr;
//          }
//          helper(nums, i+1, curr);
//     }
// }
//6 9 12 15 18 22 24 26
//0 0 1  2   3  0  0 1
//12-9 == 9-6 count++
//15-12 == 12-9 count++
//dp optimised tc-O(n)
// class Solution {
//     public int numberOfArithmeticSlices(int[] nums) {
//         int n = nums.length;
//         int count = 0;
//         int[] dp = new int[n];

//         for(int i = 2; i<n; i++){
//           if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
//             dp[i] = dp[i-1] + 1;
//             count += dp[i];
//           }
            
//         }
//         return count;
//     }
// }
//with one variable tc-O(n)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        int curr = 0;

        for(int i = 2; i<n; i++){
          if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
            curr = curr + 1;
            count += curr;
          }else{
            curr = 0;
          }
            
        }
        return count;
    }
}