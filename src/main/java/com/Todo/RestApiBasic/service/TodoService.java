package com.Todo.RestApiBasic.service;

import com.Todo.RestApiBasic.entity.TodoEntity;
import com.Todo.RestApiBasic.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

     public void detetetodo(TodoEntity todo) {
             todoRepository.delete(todo);
     }

     public Page<TodoEntity> getTodosWithPage(int page, int size) {
         Pageable pageable = PageRequest.of(page, size);
         return todoRepository.findAll(pageable);
     }
}



