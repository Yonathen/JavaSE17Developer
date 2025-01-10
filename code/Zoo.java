public class Zoo {
    public static void reassignName(String name) {
        name = "Georette";
    }

    public static void appendName(StringBuilder sb) {
        sb.append(" Jason");
    }
    public static void main(String[] args) {
        String name = "Webby";
        reassignName(name);
        System.out.println(name); // This will still be "Webby"

        // How about the following?
        StringBuilder sb = new StringBuilder("Web");
        appendName(sb);
        System.out.println(sb.toString());
    }
}
