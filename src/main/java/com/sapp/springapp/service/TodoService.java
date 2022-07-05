package com.sapp.springapp.service;

import com.sapp.springapp.entity.TodoEntity;
import com.sapp.springapp.entity.UserEntity;
import com.sapp.springapp.model.Todo;
import com.sapp.springapp.repository.TodoRepo;
import com.sapp.springapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));

    }

    public Todo completeTodo(Long todoId) {
        TodoEntity todo = todoRepo.findById(todoId).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
