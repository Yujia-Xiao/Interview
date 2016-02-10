/*
Maximum palindromic subset
*/
public int MaxPSubset(int[] nums){
    if(nums==null || nums.length()==0)return false;
    int n=nums.length;
    int[][] dp = new int[n][n];
    for(int i=0;i<n;i++)dp[i][i]=1; //initialize
    for(int len=2;len<=n;len++){
        for(int i=len-1;i<n;i++){
            int j=i-len+1;
            if(nums[i]==nums[j] && len==2) dp[j][i]=2;
            else if(nums[i]==nums[j])dp[j][i]=dp[j+1][i-2]+2;
            else dp[j][i]=Math.max(dp[j+1][i],dp[j][i-1]);
        }
    }
    return dp[0][n-1];
}