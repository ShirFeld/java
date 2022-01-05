
public class Node <T>{

    public T data; // ערך כמו שיש ערך במערך
    public Node <T> next; // פתק קטן שמראה לי את המיקום של האיבר הבא
    public int index;


    public Node (T data , int index){
        this.data = data;
        this.next = null;
        this.index = index;
    }


}
