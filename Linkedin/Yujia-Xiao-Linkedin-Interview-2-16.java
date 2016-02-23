/*It is really a pitty that we only discussed the algorithm for nearest k points. 
I believe the algorithm works and I implemented the code bellow.
If you two want to have a look, I really appreciate it.
I really want to have an opportunity to intern at Linkedin, because it is my dream company.
Thank you so much!
*/

/*
Given Point[] points and a target point, return k nearest points to target points.
To: Bohan and Olivia, Thank you very much for your two's time interviewing me :)
*/
Class Point{
    int x;
    int y;
    Point(int a, int b){x = a; y = b;}
}

public List<Point> NearestKPoints2(Point[] points, int k, Point target){
    List<Point> ans = new LinkedList<Point>();
    int n = points.length;
    // if n<k then n points will added into ans
    PriorityQueue<Point> max = new PriorityQueue<Point>(k,new Comparator<Point>(){
        @Override
        public int compare(Point a, Point b) {
            int disa = (target.x-a.x)*(target.x-a.x)+(target.y-a.y)*(target.y-a.y);
            int disb = (target.x-b.x)*(target.x-b.x)+(target.y-b.y)*(target.y-b.y);
            return (disb-disa);//max heap
        }       
    }); // k is the initial capacity, I will judge size to keep the max size of heap to be k. 
    
    for(int i=0;i<n;i++){
        if(max.size()<k)max.offer(points[i]);
        else{
            //the size of heap is k
            Point a = points[i]; Point b = max.peek();
            int disa = (target.x-a.x)*(target.x-a.x)+(target.y-a.y)*(target.y-a.y);
            int disb = (target.x-b.x)*(target.x-b.x)+(target.y-b.y)*(target.y-b.y);
            if(disa<disb){max.poll();max.offer(a);}
        }
    }
    while(max.size()!=0){ans.add(max.poll());}
    return ans;
}
