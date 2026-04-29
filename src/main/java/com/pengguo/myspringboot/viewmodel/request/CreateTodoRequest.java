// AI 生成 By Peng.Guo
package com.pengguo.myspringboot.viewmodel.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTodoRequest(
        @NotBlank(message = "title 不能为空")
        @Size(max = 100, message = "title 长度不能超过 100")
        String title
) {
}
