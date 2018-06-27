public class Main {

    public static void main(String [] args) {
        SearchList searchList = new SearchList();

        searchList.add(1);
        searchList.add(1);
        searchList.add(234);
        searchList.add(234);
        searchList.add(426);
        searchList.add(22);
        searchList.add(278);
        searchList.add(234);
        searchList.add(426);

        searchList.printList();
        System.out.println(searchList.noOccurences());
        System.out.println(searchList.noWords());
    }
}
