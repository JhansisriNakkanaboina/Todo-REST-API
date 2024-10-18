package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.todo.service.*;
import com.example.todo.model.*;

@RestController
public class TodoController {
    @Autowired
    private TodoJpaService todoJpaService;

    @GetMapping("/todos")
    public ArrayList<Todo> getAllTodos() {
        return todoJpaService.getAllTodos();
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id) {
        return todoJpaService.getTodoById(id);
    }

    @PostMapping("/todos")
    public Todo postTodo(@RequestBody Todo todo) {
        return todoJpaService.postTodo(todo);
    }

    @PutMapping("/todos/{id}")
    public Todo putTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
        return todoJpaService.putTodo(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable("id") int id) {
        todoJpaService.deleteTodo(id);
    }

}