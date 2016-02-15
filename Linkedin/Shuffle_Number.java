/*
shuffle number
Shuffle a given array such that each position is equally likely.
a. When do shuffling, how to make sure each num is picked equally? Prove it.
b. How many permutation can you get?
*/
public void Shuffle(){}
    for(int i=0;i<arr.length;i++){
            x = (int) ((Math.random()*(arr.length-i)) + i);
            temp = arr[x];
            arr[x]=arr[i];
            arr[i]=temp;            
    }
}
//n-1 * n-2 * --> (n-1)!
