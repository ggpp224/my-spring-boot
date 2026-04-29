<!-- AI 生成 By Peng.Guo -->
# my-spring-boot

Spring Boot + SQLite 初始化示例，基于 Java 21 与 Maven。

## 技术栈
- Java 21
- Spring Boot 3
- Spring Data JPA
- SQLite

## 分层结构
- `controller`：View 层，仅负责 HTTP 协议处理
- `viewmodel`：ViewModel 层，负责 DTO 与映射
- `domain`：Domain 层，包含业务模型、服务、仓储抽象
- `infrastructure`：Infrastructure 层，包含 SQLite 持久化实现与数据源初始化

## 启动方式
```bash
./mvnw spring-boot:run
```

## 常用命令
```bash
./mvnw -v
./mvnw test
./mvnw clean package
```

默认端口：`8080`

SQLite 文件路径：`./data/app.db`

## 验证接口
1. 健康检查
```bash
curl http://localhost:8080/api/health
```

2. 新建 Todo
```bash
curl -X POST http://localhost:8080/api/todos \
  -H "Content-Type: application/json" \
  -d '{"title":"learn spring boot"}'
```

3. 查询 Todo 列表
```bash
curl http://localhost:8080/api/todos
```