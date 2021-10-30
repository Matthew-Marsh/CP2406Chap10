import java.util.TreeMap;

public class Exercise1 {

    private static TreeMap<String, String> data;

    public static void main(String[] args) {
        data = new TreeMap<>();
        putNumber("Tom", "0487931125");
        putNumber("Bob", "0487575755");
        putNumber("Phil", "0487977775");
        putNumber("Jenn", "04875757525");
        System.out.println("Jenn's number is " + getNumber("Jenn"));
        System.out.println("Bob's number is " + getNumber("Bob"));
    }

    public static void putNumber(String name, String number) {
        if (name == null || number == null)
            throw new IllegalArgumentException("name and number cannot be null");

        if (!data.containsKey(name)) {
            data.put(name, number);
        }
    }

    public static String getNumber(String name) {
        return data.get(name);
    }

}
