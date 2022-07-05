package com.sapp.springapp.model;

import com.sapp.springapp.entity.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {
    private Long id;
    private String title;
    private Boolean completed;

    public static Todo toModel(TodoEntity entity) {
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setCompleted(entity.getCompleted());
        model.setTitle(entity.getTitle());
        return model;
    }

    public Todo() {
    }
}
