// AI 生成 By Peng.Guo
import type { CreateTodoCommand, Todo } from '../shared/types/todo';

export interface TodoDataSource {
  listTodos(): Promise<Todo[]>;
  createTodo(command: CreateTodoCommand): Promise<Todo>;
}

export class TodoService {
  constructor(private readonly dataSource: TodoDataSource) {}

  async list(): Promise<Todo[]> {
    return this.dataSource.listTodos();
  }

  async create(title: string): Promise<Todo> {
    const normalizedTitle = title.trim();
    if (!normalizedTitle) {
      throw new Error('标题不能为空');
    }
    return this.dataSource.createTodo({ title: normalizedTitle });
  }
}
