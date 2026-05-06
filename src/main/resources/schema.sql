-- AI 生成 By Peng.Guo
CREATE TABLE IF NOT EXISTS todos (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    title       VARCHAR(100) NOT NULL,
    done        INTEGER        NOT NULL DEFAULT 0,
    created_at  INTEGER        NOT NULL
);
