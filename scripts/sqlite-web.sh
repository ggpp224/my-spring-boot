#!/usr/bin/env bash
# AI 生成 By Peng.Guo

set -euo pipefail

PROJECT_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
DB_PATH="${PROJECT_ROOT}/data/app.db"
HOST="${SQLITE_WEB_HOST:-127.0.0.1}"
PORT="${SQLITE_WEB_PORT:-8081}"

if [[ ! -f "${DB_PATH}" ]]; then
  echo "数据库文件不存在: ${DB_PATH}"
  echo "请先启动后端或手动创建 data/app.db"
  exit 1
fi

if [[ ! -x "${PROJECT_ROOT}/.venv/bin/sqlite_web" ]]; then
  echo "sqlite_web 未安装，正在初始化项目虚拟环境..."
  python3 -m venv "${PROJECT_ROOT}/.venv"
  "${PROJECT_ROOT}/.venv/bin/pip" install sqlite-web
fi

echo "SQLite Web 已启动: http://${HOST}:${PORT}"
echo "数据库文件: ${DB_PATH}"

exec "${PROJECT_ROOT}/.venv/bin/sqlite_web" \
  -H "${HOST}" \
  -p "${PORT}" \
  "${DB_PATH}"
