/**
 * A map (or dictionary) is a data structure that contains pairs of values usually called key & value.
 *  The main idea behind the map is that when you ask for the key, you get back the value.
 * @param <T> - Generic Type of the Keys
 * @param <E> - Generic Type of the Values
 */
public class Map<T extends Comparable<T>, E> {
    /**
     * Regular constructor
     */
    public Map() {
        this.bst = new BinarySearchTree<>();
    }
    /**
     * Function that add value to the map
     * @param key - key to add
     * @param value - value to add
     * @return false/true if success to add value
     */
    public boolean add(T key, E value) {
        if(key == null || value == null) return false;
        if (this.contains(key)) return false;
        return this.bst.add(new Pair<>(key, value));
    }
    /**
     * Return the value from the map if he exists
     * @param key - key to search
     * @return value
     */
    public E get(T key) {
        if(key == null) return null;
        Pair<T, E> p = this.bst.get(new Pair<>(key, null));
        if(p == null) return null;
        return p.getValue();
    }
    /**
     * Function that return the size of the map
     * @return size
     */
    public int size() {
        return this.bst.size();
    }
    /**
     * Function that check if the map contains key
     * @param key - key to search
     * @return false/true if exist in the map
     */
    public boolean contains(T key) {
        if(key == null) return false;
        return this.bst.contains(new Pair<>(key, null));
    }
    // Binary Search Tree that contain pairs
    private BinarySearchTree<Pair<T, E>> bst;
    /**
     * Class for Pair objects for the map
     * @param <T> - The key Type
     * @param <E> - The value Type
     */
    private static class Pair<T extends Comparable<T>, E> implements Comparable<Pair<T, E>>{
        /**
         * Regular Constructor
         * @param key - key of the Pair
         * @param value - value of the Pair
         */
        public Pair(T key, E value) {
            this.key = key;
            this.value = value;
        }
        /**
         * Function return the Key of the Pair
         * @return T
         */
        public T getKey() {
            return key;
        }
        /**
         * Function return the Value of the Pair
         * @return E
         */
        public E getValue() {
            return value;
        }
        /**
         * This function Check if given Object is equal/greater/smaller than the current object
         * By Compare a.compareTo(b):
         * if a>b return 1 - a after b
         * if a=b return 0
         * if a<b return -1 - a before b
         *
         * @param o - Other Object we want to check if this is equal to that object
         *
         * @return int - if equal(0)/greater(1)/smaller(-1)
         */
        @Override
        public int compareTo(Pair<T, E> o) {
            // Check that the compare isn't null
            if(o == null) return 1;
            if(this.key == null) return -1;
            if(o.key == null) return 1;
            return this.key.compareTo(o.key);
        }
        // The Key of the Pair
        private T key;
        // The value of the Paor
        private E value;
    }
}
