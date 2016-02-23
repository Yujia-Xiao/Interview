//phone number combinations
//find all duplicate files given a root directory, return a list of lists.
//given number, and a dictionary -> all the combinations
/*
2-abc 3-def 4-ghi 5-jkl 6-mno 7-pqrs 8-tuv 9-wxyz
*/
public List<String> phone_number(int[] num){
    //614-615-9072  ----10
    List<>
    if(num.length!=10)
    //combinations
    //
    

}

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> ans = new ArrayList<String>();
        if(s==null || s.length()==0) return ans;
        //DP
        List<String>[] dp = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<String>(); String subString;
        for(int i=1;i<s.length()+1;i++){
            for(int j=0;j<i;j++){
                subString = s.substring(j,i);
                if((dp[j]!=null) && wordDict.contains(subString)){
                    if(dp[i]==null){
                        List<String> dpMatch = new ArrayList<String>();
                        dpMatch.add(subString);
                        dp[i]=dpMatch;
                    }
                    else{
                        dp[i].add(subString);
                    }
                }
            }
        }
        
        if(dp[s.length()]==null) return ans;
        List<String> temp = new ArrayList<String>();int start=0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]!=null && dp[i].size()!=0){
                start=i;break;
            }
        }
        dfs(dp,temp,s.length(),ans);
        //dfs2(dp,temp,start,s.length(),ans);
        return ans;
    }
    
    public void dfs(List<String>[] dp, List<String> temp, int end, List<String> ans){
        if(end<=0){ //end condition
                String ansString = "";
            for(String s:temp){
                ansString = s+" "+ansString;
            }          
                ansString=ansString.substring(0,ansString.length()-1);
                ans.add(ansString);               
        }
        for(String endString:dp[end]){
            temp.add(endString);
            dfs(dp,temp,end-endString.length(),ans);
            temp.remove(endString);
        }
        return;
    }