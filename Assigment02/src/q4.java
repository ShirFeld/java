public class q4 <T> implements List <T>{

    private Node <T> head;      //כתובת = חייב לדעת מי בראש הרשימה
    private int size;
    private Node  <T> current;

    public q4 () {
        this.head = null;  // אף אחד עדין לא הגיע. אין מישהו ברשימה עדין
        this.size = 0;     //  גודל הרשימה שלי
        this.current = this.head;
    }


    public static <Integer> q4 mergeLists (q4 <Integer> l1, q4  <Integer> l2){

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // LinkedList <Integer>mergedHead =new LinkedList();  // הגדרת רשימה ריקה
        q4 mergedHead = new q4();
//
        l1.current=l1.head;
        l2.current=l2.head;

        if ((int)l1.current.data < (int)l2.current.data){  // at theZ first current = head
            mergedHead.head =  l1.current;
            l1.current = l1.head.next;
        }
        else {
            mergedHead.head = l2.current;
            l2.current = l2.head.next;
        }
        mergedHead.size++;

        mergedHead.current = mergedHead.head;  // add

        while(l2.current !=null && l1.current !=null){           // remove next
            if((int)l1.current.data <= (int)l2.current.data) {
                mergedHead.current.next = l1.current;
                l1.current=l1.current.next;
                mergedHead.size++;
            }
            else {
                mergedHead.current.next = l2.current;
                l2.current=l2.current.next;
                mergedHead.size++;
            }

            mergedHead.current = mergedHead.current.next;
        }

        if (l1.current == null){
            mergedHead.current.next = l2.current;
            mergedHead.size++;
        }

        else if (l2.current == null ){
            mergedHead.current.next = l1.current;
            mergedHead.size++;
        }

        return mergedHead ;
    }

    public static <Integer> q4 avg ( q4 <Integer> l3){

        q4 nodesBiggerThanAvg = new q4();
        double avg =0.0;
        l3.current = l3.head;
        Node tempCurrent =  l3.current;


        if (l3.isEmpty()) return null;


        while (tempCurrent != null){
            avg += (int)tempCurrent.data;
           //System.out.println((int)tempCurrent.data);
            if (tempCurrent.next != null){
                tempCurrent = tempCurrent.next;
            }
            else break;
        }

        avg = avg/(l3.size);
        System.out.println("avg = " + avg);

        while (l3.current != null ) {
            if ((int)l3.current.data > avg){
                nodesBiggerThanAvg.add(l3.current.data);
            }
            if (l3.current.next != null){
                l3.current = l3.current.next;
            }
            else break;
        }
        return nodesBiggerThanAvg;
    }


    @Override
    public void add(T data) {
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

    }
    @Override
    public boolean isEmpty() {
        return this.head==null;
    }
    @Override
    public boolean contains(T data) {
        return false;
    }
    @Override
    public T get(int index) {
        return null;
    }
    @Override
    public T getFirst() {
        return null;
    }
    @Override
    public T getLast() {
        return null;
    }
    @Override
    public T peek() {
        return null;
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
        return "";
    }



    public static void main(String[] args) {
        q4 l1 = new q4();
        q4 l2 = new q4();

        l1.add(2);
        l1.add(9);
        l1.add(7);

        l2.add(3);
        l2.add(4);
        l2.add(6);

       // בדיקת מיזוג של שתי רשימות:
             //System.out.println(" before merge l1 " + l1 + "\n");
            // System.out.println(" before merge l2 " + l2 +"\n");
            // System.out.println(" merge : " + mergeLists(l1,l2));     // merge
            System.out.println(avg(mergeLists(l1,l2)));              // avg

    }
}
