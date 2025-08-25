package test_ng;

import org.testng.annotations.Test;

public class GroupsDemo {

    @Test(groups = {"Sanity", "Regression"})
    public void testcase1() { System.out.println("Testcase1 executed"); }

    @Test(groups = {"Regression"})
    public void testcase2() { System.out.println("Testcase2 executed"); }

    @Test(groups = {"Sanity"})
    public void testcase3() { System.out.println("Testcase3 executed"); }

    @Test(groups = {"Regression"})
    public void testcase4() { System.out.println("Testcase4 executed"); }
}