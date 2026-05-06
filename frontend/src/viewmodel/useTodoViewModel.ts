// AI 生成 By Peng.Guo
import { useMemo, useState } from 'react';
import type { Todo } from '../shared/types/todo';
import { TodoService } from '../domain/todoService';
import { todoApiDataSource } from '../infra/http/todoApiDataSource';

const todoService = new TodoService(todoApiDataSource);

export function useTodoViewModel() {
  const [todos, setTodos] = useState<Todo[]>([]);
  const [title, setTitle] = useState('');
  const [loading, setLoading] = useState(false);
  const [submitting, setSubmitting] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const canSubmit = useMemo(() => title.trim().length > 0 && !submitting, [title, submitting]);

  async function loadTodos() {
    setLoading(true);
    setError(null);
    try {
      setTodos(await todoService.list());
    } catch (err) {
      setError(err instanceof Error ? err.message : '加载失败');
    } finally {
      setLoading(false);
    }
  }

  async function createTodo() {
    setSubmitting(true);
    setError(null);
    try {
      const created = await todoService.create(title);
      setTodos((prev) => [...prev, created]);
      setTitle('');
    } catch (err) {
      setError(err instanceof Error ? err.message : '创建失败');
    } finally {
      setSubmitting(false);
    }
  }

  return {
    todos,
    title,
    loading,
    submitting,
    error,
    canSubmit,
    setTitle,
    loadTodos,
    createTodo
  };
}
