"use client";

import { LoginSzuLogo } from "@/components/icons";
import { Button, Divider, Input, Link } from "@nextui-org/react";
import React, { useState } from "react";
import toast, { Toaster } from "react-hot-toast";

export default function RegPage() {
  const [isVisible, setIsVisible] = useState(false);
  const [studentId, setStudentId] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const toggleVisibility = () => setIsVisible(!isVisible);

  const validateInputs = () => {
    // 学号验证：10位数字
    const studentIdRegex = /^\d{10}$/;
    if (!studentId.match(studentIdRegex)) {
      toast.error("学号必须是10位数字!");
      return false;
    }

    // 密码验证：至少8个字符，且必须包含字母和数字
    const passwordRegex = /^(?=.*[a-zA-Z])(?=.*\d)[A-Za-z\d]{8,}$/;
    if (!password.match(passwordRegex)) {
      toast.error("密码必须至少8个字符，包含字母和数字!");
      return false;
    }

    // 确认密码验证
    if (password !== confirmPassword) {
      toast.error("密码和确认密码不一致!");
      return false;
    }

    return true;
  };

  const handleRegister = async () => {
    if (validateInputs()) {
      // 将输入的学号和密码打包成JSON对象
      const userData = {
        stu_id: studentId,
        password: password
      };

      try {
        // 发送POST请求到后端
        const response = await fetch("http://127.0.0.1:5000/api/auth/register", {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(userData)
        });

        // 判断请求是否成功
        if (response.ok) {
          // 成功响应，显示注册成功
          toast.success("注册成功！");
        } else {
          // 如果注册失败，显示错误消息
          const errorData = await response.json();
          toast.error(errorData.message || "注册失败，请稍后再试！");
        }
      } catch (error) {
        // 捕获请求错误
        toast.error("网络错误，请检查您的网络连接！");
      }
    }
  };

  return (
    <div className="w-4/5 mx-auto flex flex-col items-center">
      <div className="w-2/5 h-1/2 flex flex-col mt-4 mr-4 bg-black rounded-xl">
        <LoginSzuLogo />
        <h1 className="ml-10 text-4xl">注册</h1>
        <Input
          className="none-border-input w-4/5 ml-9 mt-5"
          type="id"
          label="你的学号"
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
        <Input
          className="none-border-input w-4/5 ml-9 mt-5"
          type={isVisible ? "text" : "password"}
          label="确认密码"
          value={confirmPassword}
          onChange={(e) => setConfirmPassword(e.target.value)}
        />
        {errorMessage && (
          <div className="text-red-500 text-sm mt-2">{errorMessage}</div>
        )}
        <Button
          color="success"
          className="w-3/4 ml-12 mt-6"
          onClick={handleRegister}
        >
          确认注册
        </Button>
        <div className="flex flex-row items-center">
          <Divider className="mt-4 w-1/5 mx-auto" />
          <h2 className="text-gray-500 mt-4 mr-4">已经有账号了？</h2>
          <Divider className="mt-4 w-1/5 mx-auto" />
        </div>
        <Button
          href="/user/login"
          as={Link}
          color="danger"
          showAnchorIcon
          className="w-3/4 ml-12 mt-4"
        >
          登陆
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
