package test_ng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {

    @BeforeTest
    public void beforetest() {
        System.out.println(">>> Checking products before running tests");
    }

    @Test(priority = 1)
    public void addProduct() {
        System.out.println("Adding product to cart");
    }

    @Test(priority = 2)
    public void updateProduct() {
        System.out.println("Updating product quantity");
    }

    @Test(priority = 3)
    public void checkoutProduct() {
        System.out.println("Proceeding to checkout");
    }

    @AfterTest
    public void aftertest() {
        System.out.println(">>> Removing products after test execution");
    }
}
