/*
A  core meltddown occurred at a nuclear plant. there are n nuclear duel rods need to be removed.
the rods are assigned number 1-n. Also recoed which rods were fused to each other.
Can remove one set of rods which are fused to each other. 
the cost is K to recover K^2 rods. Isolation chambers are available for all posotive integer costs.
minimal cost for recovering all the rods as an integer.
2<=N<=100,000
1<=P,Q<=N
p!=Q
Sample input
4
2
1 2
1 4
sample output
3

*/
	public int Solution(){
		int cost = 0;
		try{
			Scanner scan = new Scanner(new File("A.txt")); //Scanner scan = new Scanner(System.in);
			int n = Integer.parseInt(scan.nextLine());
			int m = Integer.parseInt(scan.nextLine());
			int[] union = new int[n];
			for(int i=0;i<union.length;i++)union[i]=i;
			for(int i=0;i<m;i++){
				String line = scan.nextLine();
				String[] rods = line.split(" ");
				int a = Integer.parseInt(rods[0])-1;
				int b = Integer.parseInt(rods[1])-1;
				if(find(a,union)!=find(b,union)){
					union[find(a,union)]=b;
				}
			}
			for(int i=0;i<union.length;i++){
				if(union[i]!=i)union[i]=find(i,union);
			}
			Arrays.sort(union);
			int count=1;
			for(int i=1;i<union.length;i++){
				if(union[i]==union[i-1])count++;
				else{
					cost+=Math.ceil(Math.sqrt(count));
					count=1;
				}
			}
			cost+=Math.ceil(Math.sqrt(count));
			
		}catch(FileNotFoundException e1){}
		return cost;
	}
	
	public int find(int x, int[] map){
		if(map[x]!=x)return find(map[x],map);
		return x;
	}

