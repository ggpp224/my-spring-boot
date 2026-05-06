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

    private final TodoMapper todoMapper;

    public SqliteTodoRepositoryAdapter(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @Override
    public TodoItem save(String title) {
        TodoEntity entity = new TodoEntity(title, false, Instant.now());
        todoMapper.insert(entity);
        return toDomain(entity);
    }

    @Override
    public List<TodoItem> findAll() {
        return todoMapper.findAll().stream().map(this::toDomain).toList();
    }

    private TodoItem toDomain(TodoEntity entity) {
        return new TodoItem(
                entity.getId(),
                entity.getTitle(),
                entity.isDone(),
                instantFromStoredNumeric(entity.getCreatedAtEpochSeconds()));
    }

    /**
     * 兼容旧库：Hibernate 时代 {@code created_at} 可能存毫秒；当前 schema 约定为纪元秒。
     */
    private static Instant instantFromStoredNumeric(long stored) {
        if (stored >= 10_000_000_000L) {
            return Instant.ofEpochMilli(stored);
        }
        return Instant.ofEpochSecond(stored);
    }
}
