// AI 生成 By Peng.Guo
package com.pengguo.myspringboot.infrastructure.datasource;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.stereotype.Component;

@Component
public class SqliteDataSourceInitializer {

    @PostConstruct
    public void createDataDirectory() throws IOException {
        Files.createDirectories(Path.of("data"));
    }
}
