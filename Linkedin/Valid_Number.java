/*
Valid Number
*/
public boolean isValid(String s){
    if(s==null || s.length()==0)return false;

    //avoid s="." to be judged true
    if(s.length()==1)return isNumber(s);

    //I will devide into several cases
    //case1: space -> false
    if(s.contains(" "))return false; 

    //case2: negative
    if(s.charAt(0)=='-'){
        s=s.substring(1,s.length());
        //becasue s.length()>=2 at least here. 1 is already returned.
    } //parse below, becasue "" is will return true in isNumber

    //case3: decimals, ".34", "22." is all valid as discussioned in interview
    if(s.contains("."){
        int index = s.indexOf("."); //first dot
        String s1 = s.substring(0,index);
        String s2 = s.substring(index+1,s.length());
        return isNumber(s1) && isNumber(s2);
    }

    //case4: Other cases
    return isNumber(s);
}

public boolean isNumber(String s){
    if(s.length()==0)return true;
    for(int i=0;i<s.length();i++){
        if(s.charAt(i)<'0' || s.charAt(i)>'9') return false;
    }
    return true;
}