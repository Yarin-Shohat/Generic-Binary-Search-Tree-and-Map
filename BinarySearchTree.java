import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A binary search tree Class
 * In a binary search tree, the tree consists of vertices and each vertex has up to two children.
 * The right child is always bigger than its parent, while the left is always smaller.
 * @param <T> - Generic Type of the values
 */
public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T>{
    /**
     * Regular constructor
     */
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }
    /**
     * Function that return the size of the tree
     * @return size
     */
    public int size() {
        return size;
    }
    /**
     * Function that return the root of the tree
     * @return node<T> - The root
     */
    public Node<T> getRoot() {
        return this.root;
    }
    /**
     * Function that check if the tree contains value
     * @param value - value to search
     * @return false/true if exist in the tree
     */
    public boolean contains(T value) {
        if(value == null) return false;
        Node<T> node = this.root;
        while (node != null) {
            if (node.getValue().compareTo(value) == 0) {
                // Equal
                return true;
            }
            else if (node.getValue().compareTo(value) < 0) {
                // node.getValue() < (value)
                if (node.getRight() == null) {
                    // Check not null
                    return false;
                }
                node = node.getRight();
            }
            else if (node.getValue().compareTo(value) > 0) {
                // node.getValue() > (value)
                if (node.getLeft() == null) {
                    // Check not null
                    return false;
                }
                node = node.getLeft();
            }
        }
        // Don't Contain!
        return false;
    }
    /**
     * Return the value from the tree if he exists
     * @param value - Value to search
     * @return value
     */
    public T get(T value) {
        if(value == null) return null;
        Node<T> node = this.root;
        while (node != null) {
            if (node.getValue().compareTo(value) == 0) {
                // Equal - Found!
                return node.getValue();
            }
            else if (node.getValue().compareTo(value) < 0) {
                // node.getValue() < (value)
                if (node.getRight() == null) {
                    // Check not null
                    return null;
                }
                node = node.getRight();
            }
            else if (node.getValue().compareTo(value) > 0) {
                // node.getValue() > (value)
                if (node.getLeft() == null) {
                    // Check not null
                    return null;
                }
                node = node.getLeft();
            }
        }
        // Don't Contain!
        return null;
    }
    /**
     * Function that return Iterator on the tree
     * @return Iterator<T>
     */
    public Iterator<T> iterator() {
        return new InOrderIterator<T>(this.root);
    }
    /**
     * Function that add value to the tree
     * @param value - value to add
     * @return false/true if success to add value
     */
    public boolean add(T value) {
        // Check don't null
        if(value == null) return false;
        // Tree empty
        if (this.root == null) {
            this.root = new Node<T>(value);
            this.size++;
            return true;
        }
        // If contain value - dont add
        if (this.contains(value)) {
            return false;
        }
        // Check for position for new node
        Node<T> currNode = this.root;
        while (currNode != null){
            if(currNode.getValue().compareTo(value) < 0){
                // This.root.value < value
                if(currNode.getRight() != null){
                    currNode = currNode.getRight();
                }
                else{
                    currNode.right = new Node<T>(value);
                    this.size++;
                    return true;
                }
            }
            else{
                // This.root.value > value
                if(currNode.getLeft() != null){
                    currNode = currNode.getLeft();
                }
                else{
                    currNode.left = new Node<T>(value);
                    this.size++;
                    return true;
                }

            }
        }
        return false;
    }
    // The root of the tree
    private Node<T> root;
    // The size of the tree
    private int size;
    /**
     * Class for nodes objects for the tree
     * @param <T>
     */
    public static class Node<T> {
        /**
         * Regular Constructor
         * @param value - value of the node
         */
        Node(T value) {
            this.value = value;
        }
        /**
         * Function return the right son of the node
         * @return Node<T>
         */
        public Node<T> getRight() {
            return right;
        }
        /**
         * Function return the left son of the node
         * @return Node<T>
         */
        public Node<T> getLeft() {
            return left;
        }
        /**
         * Function return the value of the node
         * @return T
         */
        public T getValue() {
            return value;
        }
        // Right son
        private Node<T> right;
        // Left son
        private Node<T> left;
        // Value of the node
        private T value;
    }
    /**
     * Class for This is an iterator of the structure which
     * returns the values in order from smallest to largest.
     * @param <T>
     */
    public static class InOrderIterator<T> implements Iterator<T> {
        // int for size of the tree and current index of the iterator
        private int size, currIndex;
        // Stack that will help us iter the tree
        private List<Node<T>> arr;
        /**
         * Constructor for Iterator
         * @param root
         */
        public InOrderIterator(Node<T> root) {
            // Initial
            arr = new ArrayList<Node<T>>();
            this.size = 0;
            this.currIndex = 0;
            // Calling recoursive to fill the tree
            fillArray(root);
        }
        /**
         * Private function to fill the array with tree elements
         * @param root
         */
        private void fillArray(Node<T> root) {
            // Check don't null
            if (root == null) {return;}
            // Fill all from left if has
            fillArray(root.getLeft());
            // Add the current node
            arr.add(root);
            size += 1;
            // Fill all from right if has
            fillArray(root.getRight());
        }
        /**
         * Returns true if the iteration has more elements.
         * (In other words, returns true if next would
         * return an element rather than throwing an exception.)
         *
         * @return true/false if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return currIndex < arr.size();
        }
        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() throws NoSuchElementException {
            if (hasNext()) {
                return arr.get(currIndex++).getValue();
            }
            throw new NoSuchElementException();
        }
    }
}
