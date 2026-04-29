// AI 生成 By Peng.Guo
package com.pengguo.myspringboot.controller;

import com.pengguo.myspringboot.domain.service.TodoService;
import com.pengguo.myspringboot.viewmodel.mapper.TodoViewModelMapper;
import com.pengguo.myspringboot.viewmodel.request.CreateTodoRequest;
import com.pengguo.myspringboot.viewmodel.response.TodoResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;
    private final TodoViewModelMapper todoViewModelMapper;

    public TodoController(TodoService todoService, TodoViewModelMapper todoViewModelMapper) {
        this.todoService = todoService;
        this.todoViewModelMapper = todoViewModelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoResponse create(@Valid @RequestBody CreateTodoRequest request) {
        return todoViewModelMapper.toResponse(todoService.createTodo(request.title()));
    }

    @GetMapping
    public List<TodoResponse> list() {
        return todoViewModelMapper.toResponseList(todoService.listTodos());
    }
}
