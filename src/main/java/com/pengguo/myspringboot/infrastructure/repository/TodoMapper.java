// AI 生成 By Peng.Guo
package com.pengguo.myspringboot.infrastructure.repository;

import com.pengguo.myspringboot.infrastructure.entity.TodoEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {

    void insert(TodoEntity entity);

    List<TodoEntity> findAll();
}
