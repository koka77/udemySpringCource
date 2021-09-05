package org.treguluvcource.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointcuts {
    @Pointcut("execution(* add*(..))")
    public void allAddMethods(){}
}
