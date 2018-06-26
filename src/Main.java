public class Main {

    public static void main(String [] args) {
        SearchList searchList = new SearchList();

        searchList.add("Hello");
        searchList.add("World");
        searchList.add("third");
        searchList.add("lorem");


        searchList.printList(); // Hello, World, third, lorem

        System.out.println(searchList.noWords()); // 4

        searchList.remove("third");

        searchList.printList(); // Hello, World, lorem

        System.out.println(searchList.noWords()); // 3
    }
}
