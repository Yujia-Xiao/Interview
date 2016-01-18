package VMWare;

import java.util.Arrays;

public class Sensor_Network_Intern {
	public static void main(String[] args){
		Sensor_Network_Intern s = new Sensor_Network_Intern();
		String[] str = {"XOOO","OXOX","OOOO"};
		String[] ans = s.generate(str);
		for(String strr :ans){
			System.out.println(strr);
		}
	}
	
	static String[] generate(String[] input){
		String[] ans = Arrays.copyOf(input, input.length);
		int[][] map = new int[input.length][input[0].length()];
		for(int i=0;i<ans.length;i++)Arrays.fill(map[i], -1);
		for(int i=0;i<ans.length;i++){
			for(int j=0;j<ans[0].length();j++){
				if(ans[i].charAt(j)=='X')BFS(ans,i,j,map,0);
			}
		}
		
		for(int i=0;i<ans.length;i++){
			for(int j=0;j<ans[0].length();j++){
				Mark(ans,i,j,map);
			}
		}		
		return ans;
	}
	public static void BFS(String[] ans, int i, int j, int[][] map, int val){
		map[i][j]=val;
		int nextInt=val+1;
		if(i-1>=0 && ans[i-1].charAt(j)=='O')
			if(map[i-1][j]==-1 || (map[i-1][j]!=-1 && map[i-1][j]>nextInt))BFS(ans,i-1,j,map,nextInt);
		if(i+1<ans.length && ans[i+1].charAt(j)=='O')
			if(map[i+1][j]==-1 || (map[i+1][j]!=-1 && map[i+1][j]>nextInt))BFS(ans,i+1,j,map,nextInt);
		if(j-1>=0 && ans[i].charAt(j-1)=='O')
			if(map[i][j-1]==-1 || (map[i][j-1]!=-1 && map[i][j-1]>nextInt))BFS(ans,i,j-1,map,nextInt);
		if(j+1<ans[0].length() && ans[i].charAt(j+1)=='O')
			if(map[i][j+1]==-1 || (map[i][j+1]!=-1 && map[i][j+1]>nextInt))BFS(ans,i,j+1,map,nextInt);
		return;
	}
	
	public static void Mark(String[] ans, int i, int j, int[][] map){
		if(ans[i].charAt(j)=='X' || ans[i].charAt(j)=='F')return;
		if(map[i][j]==-1){Replace(ans[i],j,'?');return;}
		if(i-1>=0 && map[i-1][j]!=-1 && (map[i-1][j]<map[i][j])){ans[i]=Replace(ans[i],j,'^');return;}
		if(j+1<ans[0].length() && map[i][j+1]!=-1 && (map[i][j+1]<map[i][j])){ans[i]=Replace(ans[i],j,'>');return;}
		if(i+1<ans.length && map[i+1][j]!=-1 && (map[i+1][j]<map[i][j])){ans[i]=Replace(ans[i],j,'v');return;}
		if(j-1>=0 && map[i][j-1]!=-1 && (map[i][j-1]<map[i][j])){ans[i]=Replace(ans[i],j,'<');return;}
		return;
	}
	public static String Replace(String ans, int j, char ch){
		char[] temp = ans.toCharArray();
		temp[j]=ch;
		return String.valueOf(temp);
		//it is changed here
	}

}
