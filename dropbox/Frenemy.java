/*
Dropbox Frenemy
if enemy or friend

Given a matrix of friend/enemy relationship between a group of people, 
your goal is to figure out if two individuals have a particular relationship chain (friend of a friend, enemy of a friend) 
For example, consider when you have the following matrix of relationships, where F means friend of and E means nemy of, 
and an entry at (x,y) is the relationships between individual x and individual y: -FE F-F EF- In this example, 

  0 1 2
0 - F E
1 F - F
2 E F -

individual 0 and individual 2 have a relationship chain E (eg.0-2), 
but they also have the relationship chains FF (0-1-2) and EFFE (0-2-1-0-2) that is cycles of relationships are possible. 
These relationships have the following properties: 


1. Being friends and enemies are symmetric, so if person A is friend with person B that implies that 
person B is also friends with Person A, similarly with enemies 
2. A person cannot have a relationship to themself and so no relationshp chain will include 0-0 
3. The only valid relationships are F, E, or - (friend, enemy, or neither) Given a matrix of size n x n,
 the indices for 2 individuals, and a relationshp chain as a string, return 1 this relationshp exists between 2 people and 0 if otherwise. 

1 | 2 | 3 |
1 *   E   F
2 E   *   E
3 F   E   *

This is the boilerplate function, I had to write the code for:
 n = number of people
 frenemy is the relationship
 type x = index of person A, y = index of person B 
 relationship = def is_Frenemy(n, frenemy, x, y, relationship): 
*/

public static void main(String[] args) {
    // TODO Auto-generated method stub
    char[][] frenemy = {{'-','F','E'},{'F','-','F'},{'E','F','-'}};
    char[][] frenemy2 = {
            {'-','F','F','E','F'},
            {'F','-','F','E','F'},
            {'E','F','-','E','F'},
            {'E','E','E','-','E'},
            {'F','F','F','E','-'}
    };
    
    Fremy f = new Fremy();
    System.out.println(f.is_Frenemy(5, frenemy2, 0, 2, "EEFFE"));
}

public int is_Frenemy(int n, char[][] frenemy, int x, int y, String relationship){
    //return 1 id there is such relationship, return 0 id there is no such relationship
    boolean[] dp = new boolean[n];
    Arrays.fill(dp,false);
    dp[x]=true;
    for(int i=0;i<relationship.length();i++){
        char Relation = relationship.charAt(i);
        boolean[] nextDp = new boolean[n];
        Arrays.fill(nextDp,false);
        for(int t=0;t<n;t++){
            if(dp[t]){
                for(int j=0;j<n;j++){
                    if(t!=j && frenemy[t][j]==Relation){
                        nextDp[j]=true;
                    }
                }
            }
        }
        dp=nextDp;
    }
    return (dp[y])?1:0;
}

public int is_Frenemy(int n, char[][] frenemy, int x, int y, String relationship){
    boolean[][] dp = new boolean[relationship.length()][n];
    for(int i=1;i<relationship.length();i++){
        for(int j=0;j<n;j++){
            for(int t=0;t<n;t++){
                if(frenemy[j][k]==relationship.charAt(i) && dp[i-1][k]){
                    dp[i][j]=true;
                    break;
                }
            }
        }
    }
    return (dp[relationship.length()][y])?1:0;
}
