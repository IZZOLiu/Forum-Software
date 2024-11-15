"use client";
import { SzuLogo, SearchIcon } from "@/components/icons";
import routes from "@/config/routes";
import {
  Input,
  Navbar,
  NavbarBrand,
  NavbarItem,
  Button,
  link,
} from "@nextui-org/react";
import clsx from "clsx";
import Link from "next/link";
import UserPop from "@/components/userpop"; // 引入 UserPop 组件
import { useAuthStore } from "../app/store/auth";

const searchInput = (
  <Input
    aria-label="Search"
    variant="flat"
    classNames={{
      inputWrapper: "bg-default-100",
      input: "text-sm ",
    }}
    labelPlacement="outside"
    placeholder="Search..."
    startContent={
      <SearchIcon className="text-base text-default-400 pointer-events-none flex-shrink-0" />
    }
    type="search"
  />
);

const ForumNavbar = () => {
  const isLoggedIn = useAuthStore((state) => state.isLoggedIn); 

  return (
    <Navbar
      className="bg-primary-500"
      maxWidth="xl"
      position="sticky"
      shouldHideOnScroll
    >
      <NavbarBrand className="gap-3 max-w-fit">
        <SzuLogo />
        <p className="font-bold text-inherit">论坛名字占位符</p>
        {/* 各页面的导航 */}
        <div className="hidden lg:flex gap-4 justify-start ml-2">
          {routes.slice(0, 3).map((item) => (
            <Link
              key={item.href}
              href={item.href}
              className={clsx(
                link({ color: "foreground" }),
                "data-[active=true]:text-primary data-[active=true]:font-medium"
              )}
            >
              {item.label}
            </Link>
          ))}
        </div>
      </NavbarBrand>

      {/* 搜索框 */}
      <NavbarItem className="none-border-input lg:flex">
        {searchInput}
        {isLoggedIn ? (
          <UserPop /> 
        ) : (
          <Link href="/user/login">
            <Button color="primary">
              登录
            </Button>
          </Link>
        )}
      </NavbarItem>
    </Navbar>
  );
};

export default ForumNavbar;