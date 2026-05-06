// AI 生成 By Peng.Guo
import type { CreateTodoCommand, Todo } from '../../shared/types/todo';

const BASE_PATH = '/api/todos';

async function parseJson<T>(response: Response): Promise<T> {
  if (!response.ok) {
    throw new Error(`请求失败: ${response.status}`);
  }
  return (await response.json()) as T;
}

export const todoApiDataSource = {
  async listTodos(): Promise<Todo[]> {
    const response = await fetch(BASE_PATH);
    return parseJson<Todo[]>(response);
  },
  async createTodo(command: CreateTodoCommand): Promise<Todo> {
    const response = await fetch(BASE_PATH, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(command)
    });
    return parseJson<Todo>(response);
  }
};
