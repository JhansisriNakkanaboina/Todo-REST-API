package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.todo.model.*;
import com.example.todo.repository.*;

@Service
public class TodoJpaService implements TodoRepository {
    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @Override
    public ArrayList<Todo> getAllTodos() {
        return new ArrayList<>(todoJpaRepository.findAll());
    }

    @Override
    public Todo getTodoById(int id) {
        try {
            return todoJpaRepository.findById(id).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Todo postTodo(Todo todo) {
        todoJpaRepository.save(todo);
        return todo;
    }

    @Override
    public Todo putTodo(int id, Todo todo) {
        try {
            Todo newTodo = todoJpaRepository.findById(id).get();
            if (todo.getTodo() != null) {
                newTodo.setTodo(todo.getTodo());
            }
            if (todo.getStatus() != null) {
                newTodo.setStatus(todo.getStatus());
            }
            if (todo.getPriority() != null) {
                newTodo.setPriority(todo.getPriority());
            }
            todoJpaRepository.save(newTodo);
            return newTodo;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTodo(int id)

    {
        try {
            todoJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
