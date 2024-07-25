package com.example.todoSpring.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoController {
    private static List<Todo> TodoList;

    public ToDoController(){
        TodoList=new ArrayList<>();
        TodoList.add(new Todo(1,false,"Todo",1));
        TodoList.add(new Todo(2,false,"Todo",2));
        TodoList.add(new Todo(3,false,"Todo",3));
    }

    @GetMapping("/todos")
    public List<Todo> getTodos(){
        return TodoList;
    }
    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo newTodo){
       TodoList.add(newTodo);
       return newTodo;
    }


}
