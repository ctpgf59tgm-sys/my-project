# 人力资源管理系统 (HumanManage)

> 一个基于 Spring Boot 的简易人力资源管理系统，用于管理员工信息、部门及考勤记录。

## ✨ 主要功能
- 员工信息的增删改查（CRUD）
- 基于 JWT 的登录认证（正在集成中）
- 部门信息管理

## 🛠 技术栈
- **后端框架**: Spring Boot 2.x
- **数据库**: MySQL 8.0
- **权限认证**: JWT (Java-JWT)
- **缓存**: Redis (计划接入)
- **构建工具**: Maven

## 🚀 如何运行（让面试官能跑起来）
1. 克隆项目：`git clone https://github.com/你的用户名/my-project.git`
2. 导入 IDEA，等待 Maven 依赖下载完成。
3. 修改 `application.yml` 中的数据库密码。
4. 运行 `HumanManageApplication.java` 的 main 方法。
5. 访问 `http://localhost:8080`。

## 📌 目前进度
- [x] 员工管理模块
- [x] 数据库设计
- [ ] JWT 登录集成（开发中）
- [ ] 部门管理模块
