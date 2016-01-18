/*
 Given an array comprises of 0 or 1, flip a subarray (0 becomes 1, 1 becomes 0), get an array with most 1s.
This is to find the maximum subarray
*/
public int maxFlip(int[] nums){
	if(nums==null || nums.length==0)return 0;
	int[] sum = new int[nums.length];
	int min=0; sum[0]=nums[0];ans=nums[0];
	for(int i=1;i<nums.length;i++){
		sum[i]=sum[i-1]+nums[i];
		if(min>sum[i-1]){min=sum[i-1];}
	}
	return ans;
}

 
