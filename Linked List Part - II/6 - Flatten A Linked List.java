/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node child;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.child = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.child = null;
     }
     Node(int data, Node next, Node child)
     {
         this.data = data;
         this.next = next;
         this.child = child;
     }
 }

 *****************************************************************/

public class Solution {

    public static Node mergeTwoLists(Node a, Node b){
        
        Node temp = new Node(0);

        Node res = temp; 
        
        while(a!=null && b!=null){

            if(a.data < b.data){
                temp.child = a; 
                temp = temp.child; 
                a = a.child; 
            }
            else{
                temp.child = b;
                temp = temp.child; 
                b = b.child; 
            }

        }
        
        if(a!=null){
            temp.child = a; 
        }
        else{
            temp.child = b;
        }

        return res.child; 
    
    }

    public static Node flattenLinkedList(Node root) {
        
        if(root == null || root.next == null){
            return root; 
        }
      
        root.next = flattenLinkedList(root.next); 
    
        root = mergeTwoLists(root, root.next); 
    
        return root; 

    }

}
