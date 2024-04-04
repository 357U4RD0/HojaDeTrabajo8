public interface PriorityQueue<E extends Comparable<E>> {
    
    //Métodos para: Añadir a la cola, remover y devolver el valor con mayor prioridad y verificar si la cola está vacía
    void add(E value);
    E remove();
    boolean isEmpty();
}
