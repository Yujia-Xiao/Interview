public class Tag implements Comparable<Tag>{
    
    int num = 0;
    String topic = "";
    Tag(String s){topic=s;}
    
    @Override
    public int compareTo(Tag a) {
        // TODO Auto-generated method stub
        return (this.num-a.num);
    }

}

public class Design {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Tag[] tags = new Tag[4];
        Tag a = new Tag(5,"animal");
        Tag b = new Tag(3,"sport");
        Tag c = new Tag(2,"bags");
        Tag d = new Tag(9,"clothes");   
        tags[0]=a;tags[1]=b;tags[2]=c;tags[3]=d;
        Design de = new Design();
        de.Design2(3, tags);

    }
    public void Design2(int size, Tag[] tags){
        PriorityQueue<Tag> maxheap = new PriorityQueue<Tag>(size,Collections.reverseOrder());
        PriorityQueue<Tag> minheap = new PriorityQueue<Tag>(size);
        for(int i=0;i<tags.length;i++){
            if(maxheap.size()<size){
                maxheap.offer(tags[i]);
                minheap.offer(tags[i]);
            }
            else{
                if(tags[i].num>minheap.peek().num){
                    Tag re = minheap.poll();
                    minheap.offer(tags[i]);
                    maxheap.remove(re);
                    maxheap.offer(tags[i]);
                }
            }   
        }
        while(!maxheap.isEmpty())System.out.print(maxheap.poll().topic+" ");
        System.out.println();
        while(!minheap.isEmpty())System.out.print(minheap.poll().topic+" ");
    }

}
