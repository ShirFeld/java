public class q3 <T> {

    private Node <T> head;      //כתובת = חייב לדעת מי בראש הרשימה
    private int size;
    private Node <T> current;

    public q3() {
        this.head = null;  // אף אחד עדין לא הגיע. אין מישהו ברשימה עדין
        this.size = 0;     //  גודל הרשימה שלי
        this.current = this.head;
    }

    public void add(T data)   {
        if (this.head==null)                 // האם רשימה ריקה
            this.head=new Node(data,size); // אם כן אז מכנסים את האיבר שקיבלנו למקום הראשון
        else{
            Node<T> new_Node = new Node<T>(data,size);  //  בונה עוד צומת
            Node temp_head = this.head;          // הכנסנו את הכתובת
            while (temp_head.next!=null)     //  בודק אם יש כתובת בצומת אם יש כתובת אז נכנסים ולוקחים את הכתובת הבאה
                // ושמים אותה במשתנה ואיתה חוזרים שוב ללולאה ובודקיפ אם יש בה כתובת או לא.
                temp_head=temp_head.next;
            temp_head.next=new_Node;
        }
        size++;
    }

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





    public Node delete(Node current , Integer x){  // x = number to delete
        if (this.size == 0)
            return null;

        if (this.size==1){
            if (this.head.data == x) {
                this.head = null;
                this.size--;
                return null;
            }
            return head;
        }

        if (current.next != null && current.next.data == x){
            if (current.next.next != null){
                current.next=current.next.next;

            }
            else {
                current.next=null;
                return null;
            }
            this.size--;

        }
        else {
            if (current.next.data == x){
                this.size--;
                return null;}
        }
        if (current.next == null){
            this.size--;
            return null;
        }
        

            return  delete(current.next,2);
    }


    public static void main(String[] args) {
        q3 l1 = new q3();

        l1.add(8);
        l1.add(2);
        l1.add(56);
        l1.add(2);
        l1.add(3);
        l1.add(36);
        l1.add(2);

         //  בדיקת delete:
        System.out.println(l1);
        l1.delete( l1.head,2);
        System.out.println(l1);

    }



}
