package org.treguluvcource.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.treguluvcource.aop.Book;

@Component
@Aspect
@Order(1)
public class LoggingAspect {


//    @Pointcut("execution(* org.treguluvcource.aop.UniLibrary.*(..))")
//    private void allMethodFromUnilibrary() {}
//
//
//    @Pointcut("execution(public void org.treguluvcource.aop.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary() {}
//
//    @Pointcut("allMethodFromUnilibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniLibrary() {}
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineAdvice() {
//        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice : writing Log #10");
//    }

//    @Pointcut("execution(* org.treguluvcource.aop.UniLibrary.get*())")
//    public void allGetMethodFromUniLibrary() {
//    }
//
//    @Pointcut("execution(* org.treguluvcource.aop.UniLibrary.return*())")
//    public void allReturnMethodFromUniLibrary() {
//    }
//
//    @Pointcut("allGetMethodFromUniLibrary() || allReturnMethodFromUniLibrary()")
//    public void allGetAndReturnMethodFromUniLibrary() {
//    }
//
//    @Before("allGetMethodFromUniLibrary()")
//    private void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//
//    @Before("allReturnMethodFromUniLibrary()")
//    private void beforeReturnLoggingAdvice() {
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//    }
//
//    @Before("allGetAndReturnMethodFromUniLibrary()")
//    private void beforeGetAndReturnLoggingAdvice() {
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
//    }


    @Before("org.treguluvcource.aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingBookAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();

            for (Object obj : arguments) {
                if (obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: название - " + myBook.getName() +
                            ", автор - " + myBook.getAuthor() +
                            ", год издания - " + myBook.getYearOfPublication());
                } else if (obj instanceof String) {
                    System.out.println("Книгу в библиотеку даобавляет - " + obj);
                }
            }
        }

        System.out.println("LoggingAspect.beforeGetBookAdvice - логирование попытки получить книгу или журнал");
        System.out.println("--------------------------------------------------------------------------------------");
    }


}
