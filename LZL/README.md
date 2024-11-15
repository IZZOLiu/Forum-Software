## 前端启动说明(已经安装了Node.js)
```bash
在当前目录下打开终端，输入以下命令：
npm install
npm run dev
```

## API 接口说明

### 用户认证相关接口

#### 1. 用户注册
- **接口**: `/api/auth/register`
- **方法**: `POST`
- **请求体**:
  ```json
  {
    "stu_id": "string", // 学号(10位数字)
    "password": "string" // 密码(至少8位，包含字母和数字)
  }
  ```
- **响应体**:
  ```json
  {
    "message": "string", // 成功或错误信息
    "status": number // 状态码
  }
  ```

#### 2. 用户登录
- **接口**: `/api/auth/login`
- **方法**: `POST`
- **请求体**:
  ```json
  {
    "stu_id": "string", // 学号
    "password": "string" // 密码
  }
  ```
- **响应体**:
  ```json
  {
    "token": "string", // JWT token
    "username": "string", // 用户名
    "user_id": "string", // 用户ID
    "message": "string" // 成功或错误信息
  }
  ```

---

### 帖子相关接口

#### 1. 发布帖子
- **接口**: `/api/posts`
- **方法**: `POST`
- **请求体**:
  ```json
  {
    "id": "string", // 帖子ID(时间戳)
    "title": "string", // 标题
    "description": "string", // 简介
    "content": "string", // 正文(Markdown格式)
    "category": "string", // 分类(competition/resource/team)
    "author": {
      "name": "string", // 作者名
      "role": "string" // 作者角色
    },
    "tags": ["string"], // 标签数组
    "createdAt": "string", // 创建时间
    "updatedAt": "string" // 更新时间
  }
  ```
- **响应体**:
  ```json
  {
    "message": "string", // 成功或错误信息
    "status": number // 状态码
  }
  ```

#### 2. 获取帖子列表
- **接口**: `/api/posts`
- **方法**: `GET`
- **响应体**:
  ```json
  [
    {
      "id": "string",
      "title": "string",
      "description": "string",
      "content": "string",
      "imageUrl": "string",
      "category": "string",
      "author": {
        "name": "string",
        "role": "string"
      },
      "createdAt": "string",
      "updatedAt": "string",
      "tags": ["string"]
    }
  ]
  ```

#### 3. 获取单个帖子
- **接口**: `/api/posts/{id}`
- **方法**: `GET`
- **参数**: 
  - `id`: 帖子ID (路径参数)
- **响应体**:
  ```json
  {
    "id": "string",
    "title": "string",
    "description": "string",
    "content": "string",
    "imageUrl": "string",
    "category": "string",
    "author": {
      "name": "string",
      "role": "string"
    },
    "createdAt": "string",
    "updatedAt": "string",
    "tags": ["string"]
  }
  ```
