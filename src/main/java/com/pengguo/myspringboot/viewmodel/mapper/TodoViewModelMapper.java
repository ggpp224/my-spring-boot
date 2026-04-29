// AI 生成 By Peng.Guo
package com.pengguo.myspringboot.viewmodel.mapper;

import com.pengguo.myspringboot.domain.model.TodoItem;
import com.pengguo.myspringboot.viewmodel.response.TodoResponse;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TodoViewModelMapper {

    public TodoResponse toResponse(TodoItem item) {
        return new TodoResponse(item.id(), item.title(), item.done(), item.createdAt());
    }

    public List<TodoResponse> toResponseList(List<TodoItem> items) {
        return items.stream().map(this::toResponse).toList();
    }
}
