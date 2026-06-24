package com.java.RestApiBasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.RestApiBasic.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {


}