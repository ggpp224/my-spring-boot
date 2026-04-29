// AI 生成 By Peng.Guo
package com.pengguo.myspringboot.domain.service;

import com.pengguo.myspringboot.domain.model.TodoItem;
import com.pengguo.myspringboot.domain.port.TodoRepositoryPort;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepositoryPort todoRepositoryPort;

    public TodoService(TodoRepositoryPort todoRepositoryPort) {
        this.todoRepositoryPort = todoRepositoryPort;
    }

    public TodoItem createTodo(String title) {
        return todoRepositoryPort.save(title.trim());
    }

    public List<TodoItem> listTodos() {
        return todoRepositoryPort.findAll();
    }
}
