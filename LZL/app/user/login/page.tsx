"use client";

import { LoginSzuLogo } from "@/components/icons";
import { Button, Checkbox, Divider, Input, Link } from "@nextui-org/react";
import React, { useState } from "react";
import { useRouter } from "next/navigation";
import toast from "react-hot-toast";
import { User, initialUser } from "@/types/user"; 

export default function LoginPage() {
  const [isVisible, setIsVisible] = useState(false);
  const [studentId, setStudentId] = useState("");
  const [password, setPassword] = useState("");
  const [user, setUser] = useState<User>(initialUser); 
  const router = useRouter(); 

  const toggleVisibility = () => setIsVisible(!isVisible);

  const handleLogin = async () => {
    if (!studentId || !password) {
      toast.error("请填写学号和密码！");
      return;
    }

    const userData = {
      stu_id: studentId,
      password: password,
    };

    try {
      // 发送POST请求到后端
      const response = await fetch("http://127.0.0.1:5000/api/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(userData),
      });

      if (response.ok) {
        const data = await response.json();
        
        // 更新用户状态
        setUser({
          id: data.user_id || studentId,
          username: data.username || "User",
          token: data.token,
          isLoggedIn: true,
        });

        localStorage.setItem("token", data.token);
        localStorage.setItem("username", data.username || "User");
  
        toast.success("登录成功！3秒后自动跳转至主页...");
        setTimeout(() => {
          window.location.href = "/";
        }, 2000);
      } else {
        const errorData = await response.json();
        toast.error(errorData.message || "登录失败，请检查学号和密码！");
      }
    } catch (error) {
      toast.error("网络错误，请检查您的网络连接！");
    }
  };

  return (
    <div className="w-4/5 mx-auto flex flex-col items-center">
      <div className="w-2/5 h-1/2 flex flex-col mt-4 mr-4 bg-black rounded-xl">
        <LoginSzuLogo />
        <h1 className="ml-10 text-4xl">登录</h1>
        <Input
          className="none-border-input w-4/5 ml-9 mt-5"
          type="id"
          label="学号"
          value={studentId}
          onChange={(e) => setStudentId(e.target.value)}
        />
        <Input
          className="none-border-input w-4/5 ml-9 mt-5"
          type={isVisible ? "text" : "password"}
          label="密码"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <Checkbox defaultSelected className="ml-7 mt-2">
          七天内免登陆
        </Checkbox>
        <Button
          color="primary"
          className="w-3/4 ml-12 mt-6"
          onClick={handleLogin}
        >
          确认登录
        </Button>
        <div className="flex flex-row items-center">
          <Divider className="mt-4 w-1/5 mx-auto" />
          <h2 className="text-gray-500 mt-4 mr-4">还没有账号？</h2>
          <Divider className="mt-4 w-1/5 mx-auto" />
        </div>
        <Button
          href="/user/register"
          as={Link}
          showAnchorIcon
          color="danger"
          className="w-3/4 ml-12 mt-4"
        >
          注册
        </Button>
        <div className="flex flex-row items-center mb-2">
          <Divider className="mt-4 w-1/5 mx-auto" />
          <h2 className="text-gray-500 mt-4 mr-4">欢迎！</h2>
          <Divider className="mt-4 w-1/5 mx-auto" />
        </div>
      </div>
    </div>
  );
}