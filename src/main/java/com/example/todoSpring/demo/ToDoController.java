package com.example.todoSpring.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class ToDoController {
    private static List<Todo> TodoList;

    public ToDoController(){
        TodoList=new ArrayList<>();
        TodoList.add(new Todo(1,false,"Todo",1));
        TodoList.add(new Todo(2,false,"Todo",2));
        TodoList.add(new Todo(3,false,"Todo",3));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(TodoList);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)//we can use this annotation to set status
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){

       TodoList.add(newTodo);
       return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long todoId){
        for(Todo todo:TodoList){
            if(todo.getId()==todoId){
                return ResponseEntity.ok(todo);
             }
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable Long todoId) {
        for (Todo todo : TodoList) {
            if (todo.getId()==(todoId)) {
                TodoList.remove(todo);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
    @PatchMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long todoId, @RequestBody Todo updatedFields) {
        for (Todo todo : TodoList) {
            if (todo.getId()==(todoId)) {
                if (updatedFields.getTitle() != null) {
                    todo.setTitle(updatedFields.getTitle());
                }
                if (updatedFields.getCompleted() != null) {
                    todo.setCompleted(updatedFields.isCompleted());
                }
                return ResponseEntity.ok(todo);
            }
        }
        return ResponseEntity.notFound().build();
    }

}
