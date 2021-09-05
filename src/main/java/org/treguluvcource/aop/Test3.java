package org.treguluvcource.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Test3.main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);
        String bookName = library.returnBook();
        System.out.println("В билбиотеку вернули книгу " + bookName);


        context.close();
        System.out.println("Test3.main ends");
    }
}
