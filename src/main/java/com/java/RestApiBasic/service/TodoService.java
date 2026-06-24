package com.java.RestApiBasic.service;

import com.java.RestApiBasic.entity.TodoEntity;
import com.java.RestApiBasic.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
     @Autowired
     private TodoRepository todoRepository;

     public TodoEntity createTodo(TodoEntity todo) {
            return todoRepository.save(todo);

     }

     public TodoEntity getTodoById(Long id) {
            return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found " + id));
     }


     public List<TodoEntity> getAllTodos() {
            return todoRepository.findAll();
     }


     public TodoEntity updateTodo(TodoEntity todo) {
            return todoRepository.save(todo);
     }

     public void deleteTodoById(Long id) {
             todoRepository.deleteById(id);
     }

}



