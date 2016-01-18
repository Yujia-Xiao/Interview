/*
All subsets of a string.from small to big
Example:
1:  "abc"-> "a","ab","abc",“ac”,"b","bc","c".
2: "aa"-> "a","aa",
3:'bca"->"a","b","ba","bc","bca","c","ca"
*/
public String[] Solution(String str){
		String[] ans = new String[(1<<str.length())-1];
		if(str==null || str.length()==0)return ans;
		//bit manipulation
		for(int i=1;i<1<<str.length();i++){
			String temStr = "";
			int a = i;
			for(int j=0;j<str.length();j++){
				if((a & 1)==1)
					temStr+=str.charAt(j);
				a >>= 1;
			}
			ans[i-1]=temStr;
		}
		Arrays.sort(ans);
		return ans;
	}