'use client';
import { useEffect, useState } from "react";
import { Button } from "@nextui-org/react";

export default function Home() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [username, setUsername] = useState("guest");

  useEffect(() => {
    // 检查 localStorage 中是否有 token 和 username
    const token = localStorage.getItem("token");
    const storedUsername = localStorage.getItem("username");

    if (token && storedUsername) {
      setIsLoggedIn(true);
      setUsername(storedUsername); // 设置用户名
    } else {
      setIsLoggedIn(false);
      setUsername("guest");
    }
  }, []);

  return (
    <div className="grid grid-rows-[20px_1fr_20px] items-center justify-items-center min-h-screen p-8 pb-20 gap-16 sm:p-20 font-[family-name:var(--font-geist-sans)]">
      <Button color="secondary" variant="flat">
        {isLoggedIn ? `${username}，你已登录` : "你还未登录"}
      </Button>
    </div>
  );
}