// AI 生成 By Peng.Guo
import { FormEvent, useEffect } from 'react';
import { useTodoViewModel } from '../../../viewmodel/useTodoViewModel';

export function TodoPage() {
  const { todos, title, loading, submitting, error, canSubmit, setTitle, loadTodos, createTodo } = useTodoViewModel();
  const sqliteWebUrl = 'http://127.0.0.1:8081';

  useEffect(() => {
    loadTodos();
  }, []);

  async function handleSubmit(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();
    if (!canSubmit) {
      return;
    }
    await createTodo();
  }

  return (
    <main className="page">
      <section className="card">
        <div className="headerRow">
          <h1>Todo Web</h1>
          <a
            className="dbLink"
            href={sqliteWebUrl}
            target="_blank"
            rel="noreferrer"
            title="需先在项目根目录执行 ./scripts/sqlite-web.sh（默认监听 8081），否则会连接被拒绝"
          >
            访问数据库
          </a>
        </div>
        <p className="desc">前后端分离示例（React + Spring Boot + SQLite）</p>

        <form className="row" onSubmit={handleSubmit}>
          <input
            value={title}
            onChange={(event) => setTitle(event.target.value)}
            placeholder="输入待办标题"
            maxLength={100}
          />
          <button type="submit" disabled={!canSubmit}>
            {submitting ? '创建中...' : '创建'}
          </button>
        </form>

        {error ? <p className="error">{error}</p> : null}

        {loading ? (
          <p>加载中...</p>
        ) : (
          <ul className="list">
            {todos.map((todo) => (
              <li key={todo.id}>
                <span>{todo.title}</span>
                <small>{new Date(todo.createdAt).toLocaleString()}</small>
              </li>
            ))}
          </ul>
        )}
      </section>
    </main>
  );
}
