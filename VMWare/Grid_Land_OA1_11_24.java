/*
Bob just reached Gridland, a 2D world divided in many cells. Each cell is denoted by a pair (r,c) where r>=0 and c>=0.
From a cell (r,c) one can move to (r+1,c), (r,c+1),(r-1,c) and (r,c-1). 
Bob is standing at cell (0,0) and he wants to go to cell(x,y) in the smallest number of moves. But there are so many 
possible shortest path and in some of the path there are dangerous dragons. But Bob knows that if he uses the lexicographically 
kth shortest path, he will be able to avoid the dragons!
All possible shortest ways consist of some horizontal and some vertical moves, lets denote the moves by H and V.  
A possible way to go from (0,0) to (2,2) is HVHV, that means he first made a horizontal move, then a vertical move, 
then a horizontal move again and finally a vertical move. 
HVVH can be another possible way but HVHV is lexicographically smaller that HVVH.
Given the value of k find the lexicographically kth path to go from (0,0) to (x,y) using smallest number of moves. 
Note that k is numbered from 0 to P-1 where P is number of possible paths. So for the example above HHVV is the 
lexicograpically 0th path.

Input Parameters:
You need to complete a function gridLand. If will take an array of string inp as parameter. 
Each element of the inp will represent a single case in the form "x y k"

Return Value:
Return an array of string, ith element of the array should contain answer of ith test case.

Constraints
1 <= |inp| <=100000
1 <= x <= 10
1 <= y <= 10
0 <= k < number of paths
5 l7 n$ f  ]9 i, B
Sample Input
inp={"2 2 2", "2 2 3",}
Sample Output
{"HVVH","VHHV"}
Explanation; 
All the paths of going to (2,2) from (0,0) in lexicographically increasing order:

0. HHVV
1. HVHV
2. HVVH
3. VHHV
4. VHVH
5. VVHH
*/
	public String[] gridLand(String[] inp){
		//H>V, shortest path: x->H y->V
			String[] ans = new String[inp.length];
			for(int i=0;i<inp.length;i++){
				if(inp[i].length()<5)break;
				int x=Integer.parseInt(inp[i].charAt(0)+"");
				int y=Integer.parseInt(inp[i].charAt(2)+"");
				int k=Integer.parseInt(inp[i].charAt(4)+"");
				ans[i]=kthPath(x,y,k+1,"");
			}
			return ans;
		}

		public String kthPath(int x,int y,int k, String ans){
			//x-H y-V
			int degree = (x>=1)?y+1:1;
			if(degree<k){
				return kthPath(x,y-1,k-degree,ans+"V");
			}
			else{
				for(int i=0;i<x-1;i++)ans=ans+"H";
				for(int j=0;j<1+y;j++){
					k--;
					if(k==0)ans=ans+"H";
					else ans=ans+"V";
				}
			}
			return ans;
		} 
