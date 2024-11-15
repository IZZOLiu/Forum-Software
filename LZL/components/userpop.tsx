"use client";
import { User, PopoverTrigger, Popover, PopoverContent } from "@nextui-org/react";
import { Toaster, toast } from "react-hot-toast";
import { Listbox, ListboxItem } from "@nextui-org/react";
import React from "react";
import { useRouter } from "next/navigation";
import { useAuthStore } from "../app/store/auth";

export const ListboxWrapper = ({ children }: { children: React.ReactNode }) => (
  <div className="w-full max-w-[260px] px-1 py-2 rounded-small bg-black border-none">
    {children}
  </div>
);

export function Sample() {
  const items = [
    {
      key: "profile",
      label: "个人信息",
    },
    {
      key: "settings",
      label: "设置",
    },
    {
      key: "logout",
      label: "登出",
    },
  ];
  const router = useRouter()
  const setIsLoggedIn = useAuthStore((state) => state.setIsLoggedIn);
  const handleAction = (key: string) => {
    switch (key) {
      case "profile":
        alert("查看个人信息");
        break;
      case "settings":
        alert("打开设置");
        break;
      case "logout":
        localStorage.removeItem("token");
        localStorage.removeItem("username");
        setIsLoggedIn(false);
        toast.success("登出成功！即将跳转到登录页面...");
        setTimeout(() => {
          router.push("/user/login"); // 跳转到登录页面
        }, 2000); // 等待 2 秒后跳转
        break;
      default:
        break;
    }
  };

  return (
      <Listbox
        className="bg-primary-500"
        items={items}
        aria-label="用户操作"
        onAction={(key) => handleAction(key)}
      >
        {(item) => (
          <ListboxItem
            key={item.key}
            color={item.key === "logout" ? "danger" : "default"}
            className={item.key === "logout" ? "text-danger" : ""}
          >
            {item.label}
          </ListboxItem>
        )}
      </Listbox>
  );
}

export default function UserPop() {
  return (
    <div className="flex flex-col mx-auto w-full">
    <Popover showArrow placement="bottom">
      <PopoverTrigger>
        <User   
          as="button"
          name="IOxyz"
          description="Student"
          className="transition-transform"
          avatarProps={{
            src: "https://img.picui.cn/free/2024/11/15/6737143e202ad.jpeg"
          }}
        />
      </PopoverTrigger>
      <PopoverContent className="p-1 bg-primary-500">
        <Sample />
      </PopoverContent>
    </Popover>
    </div>
  );
}
