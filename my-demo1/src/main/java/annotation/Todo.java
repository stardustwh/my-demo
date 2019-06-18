package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Todo {

    public enum Priority{LOW,MEDIUM,HIGH}

    public enum Status{STARTED,NOT_STARTUED}

    String author() default "Yash";

    Priority priority() default Priority.LOW;

    Status status() default Status.NOT_STARTUED;


}
