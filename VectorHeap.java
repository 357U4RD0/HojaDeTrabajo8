import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    protected Vector<E> data;

    public VectorHeap() {
        data = new Vector<>();
    }

    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    @Override
    public E remove() {
        if (data.isEmpty()) {
            return null;
        }
        E minValue = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) {
            pushDownRoot(0);
        }
        return minValue;
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //Ajusta la estructura del árbol al agregar un nodo
    protected void percolateUp(int leaf) {
        int parent = (leaf - 1) / 2;
        E value = data.get(leaf);
    
        while (leaf > 0 && value.compareTo(data.get(parent)) < 0) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = (leaf - 1) / 2;
        }

        data.set(leaf, value);
    }

    //Ajusta la estructura del árbol al eliminar un nodo
    protected void pushDownRoot(int root) {
        E value = data.get(root);
    
        while (root < data.size() / 2) {
            int child = 2 * root + 1;
            
            if (child < data.size() - 1 && data.get(child).compareTo(data.get(child + 1)) > 0) {
                child++;
            }

            if (value.compareTo(data.get(child)) <= 0) {
                break;
            }

            data.set(root, data.get(child));
            root = child;
        }

        data.set(root, value);
    }
}
