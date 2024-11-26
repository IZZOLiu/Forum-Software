### 启动说明
```base
还没完成相应主程序，暂时无法启动
```

### 功能点
- [x] 日志系统
- [x] 处理业务逻辑的线程池
- [x] TCP连接服务器
- [ ] TCP服务器添加定时器，并设置为非阻塞IO
- [ ] 数据库连接
- [ ] 搜索查询


### 服务器特点
- 使用log4cpp库实现日志系统，通过单例模式实现日志对象的唯一性
- 使用redis数据库实现数据的持久化存储
- 使用POSIX多线程库实现线程池，实现了线程、条件变量、互斥锁等多线程编程的基本功能
- 实现了一个计算线程，处理业务逻辑，通知IO线程进行数据的发送
- 使用Reactor模型实现了一个基于事件驱动的TCP服务器


### 项目依赖
##### 环境要求
- Ubuntu 20.04
- C++ 11
- Redis 6.0.6
- MySQL 8.0.22

##### 第三方库
- log4cpp
- JsonCpp
- hiredis
- TinyXML-2
- CppJieba
- simhash

### 项目结构
````
.
├── CMakeLists.txt
├── README.md
├── SearchEngine.jpg    项目类图
├── src                 源代码
│   ├── net
│   ├── threadpool
│   ├── JsonCpp
│   ├── mylogger
│   ├── tinyxml2
├── include             头文件
│   ├── cppjieba
│   ├── json
│   ├── net
│   ├── threadpool
│   ├── Redis
│   ├── mylogger
│   ├── tinyxml2
└── bin                 可执行文件
```
