/*log_hit()和get_hit_number_in_last_5_mins()
you are building a website and how would you count 
the number of visitors for the past 5 min. 
Follow ups included exploring potential 
concurrency issues and how would you fix it.
*/

public class HitNum{
    
    private long time;
    private int size = 5*60;
    private List<Integer> queue = new List<Integer>();
    private long starTtime;
    private int lasthit = 0;

    public HitNum(){
        static long starTtime =System.currentTimeMillis()/1000;
        //add size element to queue;

    }


    public void hit(Event e){
        static long time =System.currentTimeMillis()/1000; //econd
        index=time-startTime+1;
        if(index==size){
            //add
        }
        else{
            starTtime=time-size+1;
            int step = index-size;
            for(i=0;i<step-1;i++){
                inte = queue.get(size-1);
                queue.add(inte);
                last=queue.remove(0);
            } 
            lastone ---
        }
    }

    public int getHit5(){
        return queue.get(size)-queue.get(0);
    }
}