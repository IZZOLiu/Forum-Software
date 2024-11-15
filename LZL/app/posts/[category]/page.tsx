'use client';
import { Post } from "@/types/post";
import {
  Card,
  CardBody,
  Checkbox,
  CheckboxGroup,
  Divider,
  Image,
} from "@nextui-org/react";
import React, { useEffect, useState } from "react";
import Link from "next/link";
import { useParams } from 'next/navigation';

export function ContainerTemplate({ post }: { post: Post }) {
  return (
    <div className="w-full p-4 rounded-md mx-auto bg-gray-600">
      <div className="flex items-center space-x-4">
        <div className="flex-1 space-y-1">
          <h2 className="text-2xl font-bold text-white">{post.author.name}</h2>
          <Divider />
          <p className="text-sm text-gray-400">{post.createdAt}</p>
        </div>
      </div>
    </div>
  );
}

export function Temp({ post }: { post: Post }) {
  return (
    <Card
      isBlurred
      className="border-none bg-white/50 w-full"
      shadow="sm"
    >
      <CardBody>
        <div className="grid grid-cols-6 md:grid-cols-12 gap-6 md:gap-4 justify-center">
          <div className="relative col-span-6 md:col-span-4">
            <Link href={`/posts/${post.category}/${post.id}`}>
              <Image
                alt="Post image"
                className="object-cover cursor-pointer"
                height={200}
                shadow="md"
                src={post.imageUrl}
                width="100%"
              />
            </Link>
          </div>
          <div className="relative col-span-6 md:col-span-4">
            {/* 标题跳转 */}
            <Link href={`/posts/${post.category}/${post.id}`}>
              <p className="text-2xl mt-4 mb-4 text-blue-500 hover:underline cursor-pointer">
                {post.title}
              </p>
            </Link>
            <Divider />
            <p className="text-xl mt-3">{post.description}</p>
          </div>
        </div>
      </CardBody>
    </Card>
  );
}

export function SideBarTemplate() {
  return (
    <div className="w-full p-4 rounded-md mx-auto bg-gray-600 space-y-2 text-white">
      <CheckboxGroup label="选择竞赛相关的领域">
        <Divider />
        <Checkbox value="bio">生物</Checkbox>
        <Checkbox value="math">数学</Checkbox>
        <Checkbox value="economy">金融</Checkbox>
        <Checkbox value="literature">文学</Checkbox>
        <Checkbox value="computer">计算机</Checkbox>
      </CheckboxGroup>
    </div>
  );
}

export default function ListTemplate() {
  const params = useParams();
  const [posts, setPosts] = useState<Post[]>([]);

  useEffect(() => {
    // 获取帖子数据
    fetch("http://127.0.0.1:5000/api/posts")
      .then((response) => response.json())
      .then((data) => setPosts(data))
      .catch((error) => console.error("获取帖子数据时出错：", error));
  }, []);

  const categoryPosts = posts.filter(post =>
    params.category === 'all' ? true : post.category === params.category
  );

  return (
    <div className="w-4/5 mx-auto mt-10 flex flex-row space-x-5">
      <div className="w-3/12 mt-10 flex flex-col items-center space-y-4">
        <SideBarTemplate />
      </div>
      <div className="w-4/5 mt-10 flex flex-col items-center space-y-4">
        {categoryPosts.map(post => (
          <div key={post.id}>
            <ContainerTemplate post={post} />
            <Temp post={post} />
          </div>
        ))}
      </div>
    </div>
  );
}