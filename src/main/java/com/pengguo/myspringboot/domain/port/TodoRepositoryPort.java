// AI 生成 By Peng.Guo
package com.pengguo.myspringboot.domain.port;

import com.pengguo.myspringboot.domain.model.TodoItem;
import java.util.List;

public interface TodoRepositoryPort {

    TodoItem save(String title);

    List<TodoItem> findAll();
}
