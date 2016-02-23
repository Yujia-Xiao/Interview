/*
flower
*/
public static boolean canPlant(boolean[] arr, int count){
    if(arr == null){
        throw new NullPointerException();
    }
    int locations = 0;
    boolean lastPos = false, thisPos = false, nextPos = false;

    for(int i=0;i<arr.length;i++){
        lastPos=(i==0)?false:arr[i-1];
        thisPos=arr[i];
        nextPos=(i==arr.length-1)?fase:arr[i+1];
        if(!(lastPos || thisPos || nextPos)){
            arr[i]=true;
            locations ++
            if(locations >= count){
                return true;
            }
        }
    }
    return false;
}