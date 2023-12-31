
class Solution{
    public static final int MOD = (int) 1e9;

	public int minCoins(int coins[], int M, int V) 
	{ 
	    int[][] dp = new int[M][V + 1];
	    for(int[] row : dp) Arrays.fill(row, -1);
	    int ans = f(coins, M - 1, V, dp);
	    if(ans == MOD){
            return -1;
        }else  
            return ans;
	} 
	int f(int[] coins, int index, int target, int[][] dp){
	    if(index == 0){
	        if(target % coins[index] == 0) return target / coins[index];
	        else return MOD;
	    }
	    if(dp[index][target] != -1) return dp[index][target];
	    
	    int notPick = 0 + f(coins, index - 1, target, dp);
	    int pick = Integer.MAX_VALUE;
	    if(coins[index] <= target)
	        pick = 1 + f(coins, index, target - coins[index], dp);
	        
	    return dp[index][target] = Math.min(pick, notPick);
	}
}
