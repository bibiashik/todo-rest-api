package com.java.RestApiBasic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.java.RestApiBasic.entity.TodoEntity;
import com.java.RestApiBasic.service.TodoService;

import java.util.List;

@RestController
@Slf4j
public class TodoController {
    @Autowired
        private TodoService todoService;
    @PostMapping("/create")
    ResponseEntity<TodoEntity> createTodo(@RequestBody TodoEntity todo) {
        return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<TodoEntity> getTodoById(@PathVariable Long id) {
        try {
            TodoEntity todo = todoService.getTodoById(id);
                return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.info("Todo with id {} not found", id);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/All")
    ResponseEntity<List<TodoEntity>> getAllTodos() {
        return new ResponseEntity<List<TodoEntity>>(todoService.getAllTodos(), HttpStatus.OK);
}


    @PutMapping("/update")
    ResponseEntity<TodoEntity> updateTodo(@RequestBody TodoEntity todo) {
        return new ResponseEntity<>(todoService.updateTodo(todo), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}