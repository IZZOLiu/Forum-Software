## 帖子后端启动说明
``` bash
打开 FunctionPoint-Post/src/main/java/com/classes/FunctionPointPost.java 即可启动后端程序
```

## 功能完成情况
- [x] 基本发帖
- [x] 查看所有帖子 
- [x] 查看帖子详情
- [ ] 登陆后才能发帖（现在的发帖逻辑是用前端默认的guest用户进行发帖）
- [ ] 管理员审核
- [ ] 根据筛选条件批量渲染

## 配置文件
``` bash
配置文件位于：src/main/resources/application.properties
```
可以在这里设置数据库连接和其他配置
数据库配置包括URL、用户名和密码

## 依赖管理
项目依赖通过 Maven 管理，定义在 `pom.xml` 文件中。
主要依赖：
- **Spring Boot** 3.3.5
- **MySQL** 8.0.26
- **Maven**

## 接口
- POST —— /api/posts —— 创建新帖子
- GET —— /api/posts —— 获取所有帖子列表
- GET —— /api/posts/{id} —— 获取指定ID的帖子详情 

## 项目结构
项目主要分为以下几个模块：

- **Controller 层**：处理 HTTP 请求，调用服务层，并返回响应。
- **Service 层**：包含业务逻辑，调用数据访问层。
- **DAO/Repository 层**：与数据库交互，执行 CRUD 操作。
- **DTO（Data Transfer Object）**：用于匹配前端数据的对象。
- **Mapper**：用于前端与数据库之间对象类型的转换。
- **Post**：数据库对应的帖子实体。
- **User**：数据库对应的用户实体。

## 主要代码文件和功能

### 1. `PostController.java`
处理与帖子相关的 HTTP 请求。提供接口创建新帖子、获取所有帖子、获取单个帖子详情。

### 2. `PostService.java`
包含业务逻辑，如创建帖子、获取帖子列表和根据 ID 获取帖子详情。

### 3. `Post.java`
实体类，映射到数据库中的 `post` 表。包含帖子的基本信息，如标题、内容、创建时间和更新时间等。

### 4. `User.java`
实体类，映射到数据库中的 `user` 表。包含用户的基本信息，如ID、昵称、创建时间和更新时间等。

### 5. `PostRepository.java`
定义了与帖子相关的数据库交互的接口，继承自 Spring Data JPA 的 `JpaRepository`。

### 6. `UserRepository.java`
定义了与用户相关的数据库操作接口，同时定义了根据用户名查找用户的查询方法。

### 7. `RequestMapper.java` 和 `ResponseMapper.java`
包含对象映射逻辑，用于将 `PostRequestDTO` 转换为 `Post` 实体，以及将 `Post` 实体转换为 `PostResponseDTO`。

### 8. `WebConfig.java`
配置跨域资源共享（CORS），允许前端应用从不同的端口或域名访问后端服务。

### 9. `application.properties`
包含应用程序的配置信息，如数据库连接、端口号等。

