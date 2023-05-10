package tasks.task8;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test()
public class ItemTest {

    @DataProvider(name="test1")
    public Object[][] createData1() {
        return new Object[][]{{"test", "test"}};
    }
    @DataProvider(name="test2")
    public Object[][] createData2() {
        return new Object[][]{{"test", "test1"}};
    }
    @DataProvider(name="test3")
    public Object[][] createData3() {
        return new Object[][]{{"test", "test"}};
    }
    @DataProvider(name="test4")
    public Object[][] createData4() {
        return new Object[][]{{"test", "test1"}};
    }

    @Test(dataProvider = "test1")
    public void valid_equals(String name1, String name2) {
        Item item1 = new Item("test");
        Item item2 = new Item("test");
        assertEquals(item1.getName(), item2.getName());

        Item item3 = new Item(name1);
        Item item4 = new Item(name2);
        assertEquals(item3.getName(), item4.getName());
    }

    @Test(dataProvider = "test2")
    public void error_equals(String name1, String name2) {
        Item item1 = new Item("test");
        Item item2 = new Item("test1");
        assertNotEquals(item1.getName(), item2.getName());
        Item item3 = new Item(name1);
        Item item4 = new Item(name2);
        assertNotEquals(item3.getName(), item4.getName());
    }
    @Test(dataProvider = "test3")
    public void valid_compareTo(String name1, String name2) {
        Item item1 = new Item("test");
        Item item2 = new Item("test");
        assertEquals(item1.getName().compareTo(item2.getName()), 0);
        Item item3 = new Item(name1);
        Item item4 = new Item(name2);
        assertEquals(item3.getName().compareTo(item4.getName()), 0);
    }
    @Test(dataProvider = "test4")
    public void error_compareTo(String name1, String name2) {
        Item item1 = new Item("test");
        Item item2 = new Item("test1");
        assertEquals(item1.getName().compareTo(item2.getName()), -1);
        Item item3 = new Item(name1);
        Item item4 = new Item(name2);
        assertEquals(item3.getName().compareTo(item4.getName()), -1);
    }
    @Parameters({ "test-name" })
    @Test
    public void test_load_parameter(String name) {
        Item item1 = new Item(name);
        Item item2 = new Item(name);
        assertEquals(item1.getName(), item2.getName());
    }
}