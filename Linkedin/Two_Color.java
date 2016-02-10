public class Node{
    int color = -1;
    Node[] neighbours = null;
    Node(Node[] n){
        neighbours=n;
    }

}
public boolean Two_Color(Node[] nodes){
    boolean ifTwo = true;
    for(Node n:nodes){
        if(n.color==-1){
            ifTwo=Two_Color_Form(n);
        }
        if(!ifTwo)return false;
    }
    return true;
}

public boolean Two_Color_Form(Node s){
    s.color=0;
    Queue<Node> queue = new LinkedList<Node>();
    queue.offer(s);
    while(!queue.isEmpty()){
        Node n = queue.poll();
        Node[] ad = n.neighbours;
        for(Node eachN : ad){
            if(eachN.color==s.color)return false;
            else if(eachN.color==-1){
                eachN.color=(v.color+1) % 2;
                queue.offer(eachN);
            }
        }
    }
    return true;
}