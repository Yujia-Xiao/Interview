/** 
* Given a nested list of integers, returns the sum of all integers in the list weighted by their depth 
* For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1) 
* Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3) 
*/ 
public int depthSum (List<NestedInteger> input) { // ur implementation here
    return depthSumHelper(input, 1);
} 
/** 
* This is the interface that represents nested lists. 
* You should not implement it, or speculate about its implementation. 
*/ 
private int depthSumHelper(List<NestedInteger> input, int level){
    int sum = 0;

    // look at each nested integer
    for( NestedInteger nestedInt : input){
        if(nestedInt.isInteger()){
            sum += nestedInt.getInteger() * level;
        } else {
            sum += depthSumHelper(nestedInt.getList(), level++);
        }
    }
    return sum;
}


public interface NestedInteger{ 
/** @return true if this NestedInteger holds a single integer, rather than a nested list */ 
boolean isInteger(); 

/** @return the single integer that this NestedInteger holds, if it holds a single integer 
* Return null if this NestedInteger holds a nested list */ 
Integer getInteger(); 

/** @return the nested list that this NestedInteger holds, if it holds a nested list 
* Return null if this NestedInteger holds a single integer */ 
List<NestedInteger> getList(); 



/*

第二道是新题，给multidimensional array，给一个function， 输入这个array以及各个dimension上的index，可以output这个位置上的数字。
写一个function，input是multidimensional array，以及array的dimensions，只能调用上面给的那个function，输出这个array里面所有的数字的和。. Waral 鍗氬鏈夋洿澶氭枃绔�,
题不难，是我当时脑子懵了，一直在想怎么找这个array的各个dimension上的boundary，其实input就给了。和面试官一直在交流，但我没说好，十几分钟一直在纠结这个问题。 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
后来面试官举了个例子，立刻反应过来了。但也没有什么时间，就草草的说了下pseudo code，用dfs做所有dimension上的不同index的combination，然后调用那个function求和。


*/