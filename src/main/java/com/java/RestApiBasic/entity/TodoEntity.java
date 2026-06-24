package com.java.RestApiBasic.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TodoEntity {
        @Id
        @GeneratedValue
        Long id;
        @NonNull
        @NotBlank
        String title;
        Boolean isCompleted;


}
