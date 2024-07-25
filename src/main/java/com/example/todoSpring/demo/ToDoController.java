package com.example.todoSpring.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoController {
    private static List<Todo> todos;

    public ToDoController(){
        todos=new ArrayList<>();
        todos.add(new Todo(1,false,"Todo",1));
        todos.add(new Todo(2,false,"Todo",2));
        todos.add(new Todo(3,false,"Todo",3));
    }
}
