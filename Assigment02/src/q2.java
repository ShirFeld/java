public class q2 <T> {

    private Node <T> head;      //כתובת = חייב לדעת מי בראש הרשימה
    private int size;
    private Node <T> current;


    public String toString() {
        if (this.head == null)
            return "null";
        else {
            Node temp_head = this.head;
            while (temp_head != null) {
                System.out.print("[data = " + temp_head.data+ " index = " + temp_head.index + "] , ");
                temp_head = temp_head.next;
            }

        }
        return " [size =" + size + "]";
    }

    public void add(T data) {
        if (this.head == null ){                // אם הרשימה ריקה
            this.head = new Node(data,size++);  // תכניס פה את הצומת החדש
            this.current = this.head;
            return;
        }
        else if (this.current.next == null){    // אם האיבר השני ברשימה ריק
            this.current.next = new Node(data,size++);  // נכניס פה את הצומת החדש
            return;
        }
        current = current.next;
        add(data);
        current = head;
    }

    public  T remove(Node<T> node, int index) {
        T data;
        if (head == null || index < 0 || index >= size) // בדיקה אם הרשימה ריקה או אינדקס לא בגבולות
            return (T) head;

        if (size == 1) {                                 // אם יש לי רק איבר אחד
            if (head.index == index){
                data = (T) this.head.data;
                this.head = null;
                size--;
                return data;
            }
            else {
                return head.data;
            }
        }
        if ( head.next != null &&  head.next.index == index){  // ובדיקה אם זה האינדקס שלי ואם האיבר הבא לא ריק
            if (head.next.next != null){                       // אם הוא לא האיבר האחרון צריך לחבר בין הקודם לאיבר הבא שלא יהיה "חור"
                data = (T) head.next.data;                     //שמירה על הערך לפני שנמחק את האיבר
                head.next = head.next.next;
                size--;
                return data;
            }
            else {
                data = (T) head.next.data;
                head.next = null;
                size--;
                return data;
            }
        }
        return remove(head.next,index);
    }


    public static void main(String[] args) {
        Node head = new Node(2,0);
        q2 l1 = new q2();


       // בדיקה של ADD ברקורסיה:
        l1.add(2);
        l1.add(3);
        l1.add(36);


       // בדיקת remove
        System.out.println(l1);
        l1.remove(l1.head,1);
        System.out.println(l1);

    }

}
