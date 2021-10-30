/**
 * Exercise 3
 */
public class HashTable {

    private static class ListNode {
        String key;
        String value;
        ListNode next;
    }

    private int nodeCount;
    private static ListNode[] data;

    public HashTable() {
        data = new ListNode[50];
    }

    public String get(String key) {
        int indexOfKey;
        int length = data.length;
        indexOfKey = (Math.abs(key.hashCode())) % length;

        ListNode list = data[indexOfKey];
        while (list != null) {
            if (list.key.equals(key)) {
                return list.value;
            }
            list = list.next;
        }
        return null;
    }

    private void put(String key, String value) {
        if (key == null) {
            return;
        }

        int length = data.length;
        int indexOfKey;
        indexOfKey = (Math.abs(key.hashCode())) % length;

        ListNode list = data[indexOfKey];
        while (list != null) {
            if (list.key.equals(key)) {
                break;
            }
            list = list.next;
        }

        if (list != null) {
            list.value = value;
        } else {
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            newNode.next = data[indexOfKey];
            data[indexOfKey] = newNode;
            nodeCount++;
        }
    }

    public void remove(String key) {
        int indexOfKey;
        int length = data.length;
        indexOfKey = (Math.abs(key.hashCode())) % length;

        if (data[indexOfKey] == null) {
            return;
        }

        if (data[indexOfKey].key.equals(key)) {
            data[indexOfKey] = data[indexOfKey].next;
            nodeCount--;
            return;
        }

        ListNode previousNode = data[indexOfKey];
        ListNode currentNode = previousNode.next;

        while (currentNode != null && !currentNode.key.equals(key)) {
            currentNode = currentNode.next;
            previousNode = currentNode;
        }

        if (currentNode != null) {
            previousNode.next = currentNode.next;
            nodeCount--;
        }
    }

    public boolean containsKey(String key) {
        int indexOfKey;
        int length = data.length;
        indexOfKey = (Math.abs(key.hashCode())) % length;

        ListNode list = data[indexOfKey];
        while (list != null) {
            if (list.key.equals(key)) {
                return true;
            }
            list = list.next;
        }
        return false;
    }

    public int size() {
        return nodeCount;
    }

}
