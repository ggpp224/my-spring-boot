// AI 生成 By Peng.Guo
export interface Todo {
  id: number;
  title: string;
  done: boolean;
  createdAt: string;
}

export interface CreateTodoCommand {
  title: string;
}
