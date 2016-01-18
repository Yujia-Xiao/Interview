/* Wedding Planner
1. data in the database
2. data in the high and low -> linear interpolated
3. data all high/ all low -> colsest two, anasys
4.disregard the invalid 
*/
// not tested yet
public int Solution(int n, int[] a, int[] u){
	if(n<=0)return 0;
	int index = Arrays.binarySearch(a,n)
	if(index>=0)return u[index];
	else{
		if(n>a[a.length-1]){
			int i = a.length-1;
			while(u[i]<=0 && i-1>=0)i--;
			int s = u[i];
			if(i==0)return u[i];
			int e = u[i-1];
			return s+(n-s)/(a[i]-a[i-1])*(s-e);
		}
		else if(n<a[0]){
			int j = 0;
			while(u[j]<=0 && j+1<=a.length-1)j++;
			int s = u[j];
			if(j==a.length-1)return u[j];
			int e = u[j+1];
			return s-(s-n)/(a[j+1]-a[j])*(e-s);
		}
		else{
			int insertPosition = -(index+1);
			int s = insertPosition-1;
			int e = insertPosition;
			if(u[s]<=0 && s-1>=0)s--;
			else return u[e];
			if(u[e]<=0 && e+1<=a.length-1)e++;
			else return u[s];
			return (u[s]+u[e])/2;
		}
	}
}