
public interface List <T> {

    void add(T data);

    void addFirst(T data);

    boolean isEmpty();

    boolean contains(T data);

    T get(int index);

    T getFirst();

    T getLast();

    T peek();

//   void RecursiveAdd(T data);
//
//    T RecursiveRemove(Node<T> node, int index);

}


