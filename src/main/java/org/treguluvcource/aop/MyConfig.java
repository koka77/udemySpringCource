package org.treguluvcource.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.treguluvcource.aop")
@EnableAspectJAutoProxy
public class MyConfig {
}
