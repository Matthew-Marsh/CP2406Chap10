import java.util.*;
import java.util.function.Predicate;

/**
 * Exercise 4 - Predicates
 */
public class Predicates {

    public static <T> void remove(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (pred.test(item)) {
                iterator.remove();
            }
        }
    }

    public static <T> void retain(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (!pred.test(item)) {
                iterator.remove();
            }
        }
    }

    public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred) {
        List<T> listOfObjects = new ArrayList<>();
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (pred.test(item)) {
                listOfObjects.add(item);
            }
        }
        return listOfObjects;
    }

    public static <T> int find(ArrayList<T> list, Predicate<T> pred) {
        int indexOfObject = 0;
        Iterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (pred.test(item)) {
                return indexOfObject;
            }
            indexOfObject++;
        }
        return -1;
    }

}
