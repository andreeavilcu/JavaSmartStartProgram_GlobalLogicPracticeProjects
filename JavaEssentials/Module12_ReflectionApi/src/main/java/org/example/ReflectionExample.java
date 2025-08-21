package org.example;

public class ReflectionExample {
    public static void main(String[] args){
        Person p = new Person();
        p.setName("Sara");
        p.setAge(25);

        System.out.println("Person fields");
        ReflectionUtil.printFieldNamesAndValues(p);

        System.out.println("\nInvoking private method:");
        ReflectionUtil.invokePrivateMethod(p, "sayHello");
    }
}
