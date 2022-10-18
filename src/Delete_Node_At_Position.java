public class Delete_Node_At_Position {
    static Node head = null;
    static class Node{
        int data;
        Node prev;
        Node next;
        Node(int d){
            data = d;
        }
    }
    public static void main(String[] args){
        push(5);
        push(2);
        push(4);
        push(8);
        push(10);
        System.out.println("Doubly linked list before deletion");
        printList();
        int n = 2;
        deleteNodeAtGivenPos(n);
        System.out.println("Doubly linked list After Deletion");
        printList();
    }

    private static void deleteNodeAtGivenPos(int n) {
        if(head == null || n <= 0){
            return;
        }
        Node current = head;
        for(int i = 0; i < n; i++){
            current = current.next;
        }
        if(current != null){
            return;
        }
        deleteNode(current);
    }

    private static Node deleteNode(Node current) {
        if(head == null || current == null){
            return null;
        }
        if(head == current){
            head = current.next;
        }
        if(current.prev != null){
            current.prev.next = current.next;
        }
        if(current.next != null){
            current.next.prev = current.prev;
        }
        current = null;
        return head;
    }

    private static void printList() {
        Node temp = head;
        if(temp == null){
            System.out.println("Doubly Linked List is null");
        }
        while(temp != null){
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
    }

    private static void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.data = new_data;
        new_node.next = head;
        new_node.prev = null;
        if(head != null){
            head.prev = new_node;
        }
        head = new_node;
    }
}
