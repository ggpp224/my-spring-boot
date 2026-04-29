// AI 生成 By Peng.Guo
package com.pengguo.myspringboot.viewmodel.response;

import java.time.Instant;

public record TodoResponse(Long id, String title, boolean done, Instant createdAt) {
}
