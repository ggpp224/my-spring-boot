// AI 生成 By Peng.Guo
package com.pengguo.myspringboot.infrastructure.repository;

import com.pengguo.myspringboot.domain.model.TodoItem;
import com.pengguo.myspringboot.domain.port.TodoRepositoryPort;
import com.pengguo.myspringboot.infrastructure.entity.TodoEntity;
import java.time.Instant;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class SqliteTodoRepositoryAdapter implements TodoRepositoryPort {

    private final TodoJpaRepository todoJpaRepository;

    public SqliteTodoRepositoryAdapter(TodoJpaRepository todoJpaRepository) {
        this.todoJpaRepository = todoJpaRepository;
    }

    @Override
    public TodoItem save(String title) {
        TodoEntity saved = todoJpaRepository.save(new TodoEntity(title, false, Instant.now()));
        return toDomain(saved);
    }

    @Override
    public List<TodoItem> findAll() {
        return todoJpaRepository.findAll().stream().map(this::toDomain).toList();
    }

    private TodoItem toDomain(TodoEntity entity) {
        return new TodoItem(entity.getId(), entity.getTitle(), entity.isDone(), entity.getCreatedAt());
    }
}
