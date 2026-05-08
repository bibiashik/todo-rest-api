package com.Todo.RestApiBasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Todo.RestApiBasic.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {


}