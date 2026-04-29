// AI 生成 By Peng.Guo
package com.pengguo.myspringboot.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "todos")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private boolean done;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    protected TodoEntity() {
    }

    public TodoEntity(String title, boolean done, Instant createdAt) {
        this.title = title;
        this.done = done;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
