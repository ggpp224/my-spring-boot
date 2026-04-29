// AI 生成 By Peng.Guo
package com.pengguo.myspringboot.infrastructure.repository;

import com.pengguo.myspringboot.infrastructure.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoJpaRepository extends JpaRepository<TodoEntity, Long> {
}
