"use client";

import { CheckIcon, LoginSzuLogo } from "@/components/icons";
import { Button, CheckboxGroup, Input, Select, SelectItem, Textarea } from "@nextui-org/react";
import React, { useState } from "react";
import { useCheckbox, Chip, VisuallyHidden, tv } from "@nextui-org/react";
import toast, { Toaster } from "react-hot-toast";

// 定义帖子类别
export const categories = [
  { key: "competition", label: "竞赛发布" },
  { key: "resource", label: "资源分享" },
  { key: "team", label: "队员招募" }
];

const checkbox = tv({
  slots: {
    base: "border-default hover:bg-default-200",
    content: "text-default-500"
  },
  variants: {
    isSelected: {
      true: {
        base: "border-primary bg-primary hover:bg-primary-500 hover:border-primary-500",
        content: "text-primary-foreground pl-1"
      }
    },
    isFocusVisible: {
      true: { 
        base: "outline-none ring-2 ring-focus ring-offset-2 ring-offset-background",
      }
    }
  }
});

export const CustomCheckbox = (props) => {
  const {
    children,
    isSelected,
    isFocusVisible,
    getBaseProps,
    getLabelProps,
    getInputProps,
  } = useCheckbox({
    ...props
  })

  const styles = checkbox({ isSelected, isFocusVisible });

  return (
    <label {...getBaseProps()}>
      <VisuallyHidden>
        <input {...getInputProps()} />
      </VisuallyHidden>
      <Chip
        classNames={{
          base: styles.base(),
          content: styles.content(),
        }}
        color="primary"
        startContent={isSelected ? <CheckIcon className="ml-1" /> : null}
        variant="faded"
        {...(getLabelProps() as any)}
      >
        {children ? children : isSelected ? "Enabled" : "Disabled"}
      </Chip>
    </label>
  );
}

export default function SubmitPage() {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [content, setContent] = useState("");
  const [category, setCategory] = useState("");
  const [groupSelected, setGroupSelected] = useState<string[]>([]);

  const handleSubmit = async () => {
    const authorName = localStorage.getItem("username") || "guest";
    const role = "student"; // 默认角色为 student

    // 生成 Unix 时间戳作为唯一标识
    const id = Date.now().toString();

    // 收集帖子数据
    const postData = {
      id, // 设置唯一的帖子ID
      title,
      description,
      content,
      category,
      author: {
        name: authorName,
        role
      },
      tags: groupSelected,
      createdAt: new Date().toISOString(),
      updatedAt: new Date().toISOString(),
    };

    // 发送帖子数据到后端
    try {
      const response = await fetch("http://127.0.0.1:5000/api/posts", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(postData),
      });

      if (response.ok) {
        toast.success("帖子提交成功！");
      } else {
        const errorData = await response.json();
        toast.error(errorData.message)
      }
    } catch (error) {
      toast.error("提交帖子时出错！");
    }
  };

  return (
    <div className="w-4/5 mx-auto flex flex-col items-center gap-4"> 
      <div className="w-4/5 h-1/2 flex flex-col mt-4 mr-4 bg-black rounded-xl">
        <LoginSzuLogo />
        <Toaster position="top-center" reverseOrder={false} />
        <Select
          items={categories}
          label="帖子分区"
          placeholder="选择你的帖子类型"
          className="max-w-xs bg-black ml-48 mt-5"
          onSelectionChange={(keys) => setCategory(Array.from(keys).join(""))}
        >
          {(category) => (
            <SelectItem className="bg-gray-500" key={category.key}>
              {category.label}
            </SelectItem>
          )}
        </Select>
        <Input
          className="none-border-input w-3/5 ml-9 mt-5 mx-auto"
          variant="underlined"
          type="text"
          label="标题"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        <Input
          className="none-border-input w-3/5 ml-9 mt-5 mx-auto"
          variant="underlined"
          type="text"
          label="简介"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
        <Textarea
          isRequired
          minRows={20}
          label="正文"
          labelPlacement="outside"
          placeholder="请使用 Markdown 语法进行编辑"
          className="max-w-2xl mx-auto mt-10 textarea-custom"
          value={content}
          onChange={(e) => setContent(e.target.value)}
        />
        <CheckboxGroup
          className="gap-1 mt-8 ml-32"
          label="选择帖子标签："
          orientation="horizontal"
          value={groupSelected}
          onChange={setGroupSelected}
        >
          <CustomCheckbox value="math">数学</CustomCheckbox>
          <CustomCheckbox value="computer">计算机</CustomCheckbox>
          <CustomCheckbox value="eco">金融</CustomCheckbox>
        </CheckboxGroup>
        <Button color="danger" className="w-1/8 mx-auto mt-10 mb-10" onClick={handleSubmit}>
          提交
        </Button>
      </div>
    </div>
  );
};