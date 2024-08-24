public class Linkedlist {
    private class Node{
        private int data=0;
        private Node next=null;

        Node(int data)
        {
            this.data=data;
        }
    }

    private Node Head=null;
    private Node Tail=null;
    private int noOfNodes=0;

    public int size(){
        return this.noOfNodes;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public void handleZeroSize(Node node){
        this.Head= node;
        this.Tail= node;
    }

    public void addFirst(Node node){
        if(size()==0){
            handleZeroSize(node);
        }
        else{
            node.next=this.Head;
            this.Head= node;
        }
        this.noOfNodes++;
    }

    public void addLast(Node node){
        if(size()==0)
        {
            handleZeroSize(node);
        }
        else {
            this.Tail.next=node;
            this.Tail=node;
        }
        this.noOfNodes++;
    }

    public Node getNode(int idx)
    {
        Node current= this.Head;
        while(idx > 0)
        {
            current= current.next;
            idx--;
        }
        return current;
    }

    public void addNodeAt(Node node, int idx){
        if(idx==0)
        {
            addFirst(node);
        }
        else if(idx==size()-1)
        {
            addLast(node);
        }
        else
        {
            Node prev= getNode(idx-1);
            node.next=prev.next;
            prev.next=node;
            this.noOfNodes++;            
        }
        
    }

    public void removeFirst()
    {
        if(size()==1)
        {
            this.Head=null;
            this.Tail=null;
        }
        else{
            this.Head=this.Head.next;
            this.Head.next=null;
        }
        this.noOfNodes--;
    }

    public void removeLast()
    {
        if(size()==1)
        {
            this.Head=null;
            this.Tail=null;
        }
        else{
            Node prev= getNode(size()-2);
            prev.next=null;
            this.Tail=prev;
        }
        this.noOfNodes--;
    }

    public void removeAtIndex(int idx)
    {
        if(idx==0){
            removeFirst();
        }
        else if(idx==size()-1){
            removeLast();
        }
        else{
            Node prev= getNode(idx-1);
            Node current= prev.next;
            prev.next=current.next;
            current.next=null;
            this.noOfNodes--;/////writing thisinside else because in above removeFirst and removeLast already decrements
                            ///// the noOfNodes in this respective function
        }
    }

    public int getFirstNode()
    {
        return this.Head.data;
    }
    
    public int getLastNode()
    {
        return this.Tail.data;
    }

    public int getNodeAt(int idx)
    {
        if(idx==0)
        {
            return getFirstNode();
        }
        else if(idx==size()-1)
        {
            return getLastNode();
        }
        else
        {
            Node temp= getNode(idx);
            return temp.data;
        }
    }

    public boolean contains(int data)
    {
        Node temp= this.Head;
        for(int i=0; i< size(); i++)
        {
            if(temp.data== data)
            {
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    public Node middleNode()
    {
        Node idx1=this.Head;
        Node idx2= this.Head;
        while(idx2.next!=null)
        {
            idx1= idx1.next;
            idx2= idx2.next.next;
        }
        return idx1;
    }

    public boolean isPalindrome()
    {
        int count=0;
        Node temp=this.Head;
        while(temp.next!=null)
        {
            count+=1;
            temp=temp.next;
        }
        Node start=this.Head;
        for(int i=0; i<= count/2; i++)
        {
            Node end= getNode(count-i);
            if(i==count-i)
            {
                return true;
            }
            if(start.data!=end.data)
            {
                return false;
            }
            start= start.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Linkedlist Ls= new Linkedlist();
        
        Node ans= Ls.middleNode();
    }

}
