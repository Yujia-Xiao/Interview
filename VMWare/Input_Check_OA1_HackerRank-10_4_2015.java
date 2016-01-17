/*
Test case: 1
3               
3 1 2         SUCCESS => RECEIVED: 3
1 5 2 3      FAILURE => RECEIVED: 4, EXPECTED: 5
4 2 3         FAILURE => RECEIVED: 3, EXPECTED: 4
Test case: 2
2               
1 p 2         FAILURE => WRONG INPUT (LINE 2)
3 2                  FAILURE => RECEIVED: 2, EXPECTED: 3
1 3 2 5      FAILURE => WRONG INPUT (LINE 4)
1 2 4 5 3   FAILURE => WRONG INPUT (LINE 5)+ ?# n  ~1 D+ r6 d& c: a/ Q! b
hint (not shown in HackerRank) : 
1. expected num is max number in each row
2. test case 2, line 2 is because of 'p' is not an integer, line 4 and 5 beyond test case number (2 in Iine 1)
*/

public void Solution(){			
	try {
		int line = 0;
		Scanner scan = new Scanner(new File("A.txt")); //Scanner scan = new Scanner(System.in);
		if(scan.hasNextLine())line=Integer.parseInt(scan.nextLine());		
		for(int i=0;i<line;i++){
			int max = 0; int count = 0; int current = 0; int er = 0;
			if(scan.hasNextLine()){
				String thisLine = scan.nextLine();
				String[] element = thisLine.split(" ");
				for(int j=0;j<element.length;j++){
					try{
						current = Integer.parseInt(element[j]+"");
						count++;
						max=(max<current)?current:max;
					}catch(NumberFormatException e){
						System.out.println("FAILURE => WRONG INPUT (LINE "+(i+2)+")");
						er=1; break;
					}
				}
				if(er!=1){
					if(count==max)System.out.println("SUCCESS => RECEIVED: "+max);
					else System.out.println("FAILURE => RECEIVED: "+count+", EXPECTED: "+max);
				}
			}
			else{
				System.out.println("FAILURE => WRONG INPUT (LINE "+(i+1)+")");
			}
		}
		line++;
		while(scan.hasNextLine() && scan.nextLine()!=""){
			line++;
			System.out.println("FAILURE => WRONG INPUT (LINE "+line+")");
		}		
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	}	
	return;
}
