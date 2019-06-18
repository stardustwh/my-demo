package annotation;

import org.junit.Test;

import java.lang.reflect.Method;

public class TestAnnotation {

    @Todo(priority = Todo.Priority.MEDIUM,author = "Yashwant",status = Todo.Status.STARTED)
    @Test
    public void incompleteMethod1(){

        Class testAnnotation = TestAnnotation.class;
        for(Method method : testAnnotation.getMethods()){
            Todo todoAnnotation = (Todo)method.getAnnotation(Todo.class);
            if(todoAnnotation != null){
                System.out.println("Method Name:"+method.getName());
                System.out.println("Author:"+todoAnnotation.author());
                System.out.println("Priority:"+todoAnnotation.priority());
                System.out.println("Status:"+todoAnnotation.status());
            }
        }
    }
}
