public class LinkedList<T> {


    Node<T> head =null ;

    public void add(T data){

        Node<T> curr =new Node<>(data) ;
         if(head == null){
             head= curr ;

         }
         else{
             Node<T> temp = head ;

             while(temp.next != null){
                  temp=temp.next ;
             }
             temp.next = curr ;
         }
    }

    public void reverse(){

         Node<T> prev = null ;
         Node<T> temp =head ;

         if(head == null) return ;
         while(temp!= null){

             Node<T> t = temp.next ;
             temp.next =prev ;
             prev=temp ;
             temp = t;

         }

         head = prev ;
    }

    public void display(){
        Node<T> temp = head ;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp=temp.next ;
        }


    }

}
