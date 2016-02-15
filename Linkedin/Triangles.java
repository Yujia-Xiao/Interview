/*
triangles O(n^3) solution
1. 输出array能组成triangle的数目。
2. 输出所有的能组成的triangle。time complexity，优化等。
*/

public List<List<Integer>> Triangle(int[] nums){
    List<Integer> ans = new LinkedList<List<Integer>>();
    if(nums==null || nums.length<=2)return ans;
    int n = nums.length;
    for(int i=0;i<n-2;i++){
        for(int j=i+1;j<n-1;j++){ // avoid duplicates
            for(int k=j+1;k<n;k++){
                if(nums[i]+nums[j]<=nums[k])continue;
                if(nums[i]+nums[k]<=nums[j])continue;
                if(nums[k]+nums[j]<=nums[i])continue;
                List<Integer> temp = new LinkedList<Integer>();
                temp.add(nums[i]);,temp.add(nums[j]);temp.add(nums[k]);
                ans.add(temp);
            }
        }
    }
    return ans;
}

