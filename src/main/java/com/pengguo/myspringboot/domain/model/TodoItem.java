// AI 生成 By Peng.Guo
package com.pengguo.myspringboot.domain.model;

import java.time.Instant;

public record TodoItem(Long id, String title, boolean done, Instant createdAt) {
}
