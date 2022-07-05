package com.sapp.springapp.model;

import com.sapp.springapp.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private List<Todo> todos;

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }

    public User() {
    }
}
