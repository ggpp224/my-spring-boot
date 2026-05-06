// AI 生成 By Peng.Guo
package com.pengguo.myspringboot.infrastructure.entity;

import java.time.Instant;

/**
 * 持久化模型（MyBatis），与领域模型 {@link com.pengguo.myspringboot.domain.model.TodoItem} 分离。
 */
public class TodoEntity {

    private Long id;
    private String title;
    private boolean done;
    /** SQLite 中以 UNIX 纪元秒存储 */
    private long createdAtEpochSeconds;

    public TodoEntity() {
    }

    public TodoEntity(String title, boolean done, Instant createdAt) {
        this.title = title;
        this.done = done;
        this.createdAtEpochSeconds = createdAt.getEpochSecond();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public long getCreatedAtEpochSeconds() {
        return createdAtEpochSeconds;
    }

    public void setCreatedAtEpochSeconds(long createdAtEpochSeconds) {
        this.createdAtEpochSeconds = createdAtEpochSeconds;
    }
}
