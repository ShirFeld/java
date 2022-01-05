import java.util.Collections;

public class LinkedList <T> implements List <T> {

    private Node <T> head;      //כתובת = חייב לדעת מי בראש הרשימה
    private int size;
    private Node  <T> current;

    public LinkedList() {
        this.head = null;  // אף אחד עדין לא הגיע. אין מישהו ברשימה עדין
        this.size = 0;     //  גודל הרשימה שלי
        this.current = this.head;
    }


    @Override
    public void add(T data)    {
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

    @Override
    public void addFirst(T data) {
        Node temp = new Node(data, 0);
        if (this.head == null)
            this.head = temp;
        else {
            temp.next = this.head;
            this.head = temp;
            while (temp.next != null) {
                temp.next.index++;
                temp = temp.next;
            }
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return this.head==null;
    }

    @Override
    public boolean contains(T data) { // האם הרשימה כוללת את הצומת עם הערך
        Node temp_head = this.head;
        while (temp_head != null){
            if (temp_head.data.equals(data))
                return true;
            else temp_head = temp_head.next;
        }
        return false;
    }

    @Override
    public T get(int index) {
        if (isEmpty() || index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();                   //  נזרוק שגיאה שאומרת שהאינדקס שהכניסו לנו לא בטווח
        Node temp_head = this.head;
        while (temp_head != null && temp_head.index != index)
            temp_head = temp_head.next;
        return temp_head != null ? (T) temp_head.data : null;
    }

    @Override
    public T getFirst() {
        return (T) this.head.data;
    }

    @Override
    public T getLast() {
        Node temp_head = this.head;
        while (temp_head.next != null)
            temp_head = temp_head.next;
        return (T) temp_head.data;
    }

    @Override
    public T peek() {
        if (this.head == null)
            return null;
        return (T) this.head.data;
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





    public static void main(String[] args) {
        Node head = new Node(2,0);
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        LinkedList l3 = new LinkedList();

    
    }


}


