package tasks.task8;

public class Task8 {
    public void run() {
        Item item1 = new Item("test1");
        Item item2 = new Item();
        item2.setName("test2");
        System.out.println(item1.getName().equals(item2.getName()));
        System.out.println(item1.getName().compareTo(item2.getName()));
        item1.setName("test2");
        System.out.println(item1.getName().equals(item2.getName()));
        System.out.println(item1.getName().compareTo(item2.getName()));
    }
}
