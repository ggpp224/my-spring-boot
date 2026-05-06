<!-- AI 生成 By Peng.Guo -->
# my-spring-boot

Spring Boot + SQLite 初始化示例，基于 Java 21 与 Maven。
当前已包含方案 B：前后端分离（React + TypeScript + Vite）。

## 技术栈
- Java 21
- Spring Boot 3
- Spring Data JPA
- SQLite
- React 18 + TypeScript
- Vite

## 分层结构
- `controller`：View 层，仅负责 HTTP 协议处理
- `viewmodel`：ViewModel 层，负责 DTO 与映射
- `domain`：Domain 层，包含业务模型、服务、仓储抽象
- `infrastructure`：Infrastructure 层，包含 SQLite 持久化实现与数据源初始化

## 启动方式
1. 启动后端
```bash
./mvnw spring-boot:run
```

2. 启动前端（新终端）
```bash
cd frontend
npm install
npm run dev
```

前端地址：`http://localhost:5173`
后端地址：`http://localhost:8080`

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

## 前端分层结构
- `frontend/src/view`：View 层（页面与展示组件）
- `frontend/src/viewmodel`：ViewModel 层（页面状态编排）
- `frontend/src/domain`：Domain 层（业务规则与服务抽象）
- `frontend/src/infra`：Infrastructure 层（HTTP DataSource）

## SQLite 可视化查看（集成工具）
项目内已集成 `sqlite-web` 启动脚本，可随时在浏览器查看数据库内容。

```bash
./scripts/sqlite-web.sh
```

默认访问地址：`http://127.0.0.1:8081`

可选自定义端口：
```bash
SQLITE_WEB_PORT=8090 ./scripts/sqlite-web.sh
```