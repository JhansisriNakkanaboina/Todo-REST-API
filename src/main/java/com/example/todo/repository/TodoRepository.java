package com.example.todo.repository;

import com.example.todo.model.*;
import java.util.*;

public interface TodoRepository {
    ArrayList<Todo> getAllTodos();

    Todo getTodoById(int id);

    Todo postTodo(Todo todo);

    Todo putTodo(int id, Todo todo);

    void deleteTodo(int id);
}