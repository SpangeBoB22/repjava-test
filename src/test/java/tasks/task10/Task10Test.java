package tasks.task10;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Task10Test {

    Task10 task10 = new Task10();
    @Test
    public void testGetLabel() {
        assertTrue(task10.getLabel().isDisplayed());
    }

    @Test
    public void testGetInputUserName() {
        assertTrue(task10.getInputUserName().isDisplayed());
    }
    @Test
    public void testGetInputPassword() {
        assertTrue(task10.getInputPassword().isDisplayed());
    }

    @Test
    public void testGetSignupButton() {
        assertTrue(task10.getSignupButton().isDisplayed());
    }

    @Test
    public void testGetCloseButton() {
        assertTrue(task10.getCloseButton().isDisplayed());
    }
}