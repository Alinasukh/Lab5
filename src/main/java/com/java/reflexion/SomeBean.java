package com.java.reflexion;

/**
 * This class represents a bean with injected dependencies and provides a method to perform some actions using those dependencies.
 */

public class SomeBean {
    @AutoInjectable
    private SomeInterface field1;
    @AutoInjectable
    private SomeOtherInterface field2;

    /**
     * Executes some actions using the injected dependencies.
     */
    public void doSomething(){
        field1.doSomething();
        field2.doSomethingOther();
    }

}
