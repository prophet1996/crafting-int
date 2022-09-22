public class test {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList();
        list.insert("1");
        list.insert("2");
        list.insert("3");
        list.insert("4");
        list.insert("5");
        list.delete("3");
        System.out.print("");
    }
}

class LinkedList<T> {
    Node<T> head;
    Node<T> tail;
    void insert(T item) {
        if(head == null){
            head = new Node<T>(item);
            tail = head;
        }
        else{
            Node temp = new Node(item);
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }

    }

    T find(T item){
       Node<T> temp = head;
       while(temp.next != null){
           if(temp.val == item){
               return temp.val;
           }
           temp = temp.next;
       }
       return null;
    }

    void delete(T item){
        Node<T> temp = head;
        while(temp != null){
            if(temp.val == item){
                if(temp.prev == null){
                    head = head.next;
                    head.prev = null;
                }
                if(temp.next == null){
                    tail = tail.prev;
                    tail.next = null;
                }else{
                    Node prev = temp.prev;
                    Node next = temp.next;
                prev.next = next;
                next.prev = prev;
                }
            }
            temp = temp.next;
        }
    }

    class Node<T>{
        Node next;
        Node prev;
        T val;

        Node(T item) {
            this.next = null;
            this.prev = null;
            this.val = item;
        }
    }
}