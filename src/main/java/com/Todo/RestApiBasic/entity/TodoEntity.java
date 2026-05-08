package com.Todo.RestApiBasic.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class TodoEntity {
        @Id
        @GeneratedValue
        Long id;
        @NonNull
        String name;
        String description;
        Boolean isCompleted;


}
