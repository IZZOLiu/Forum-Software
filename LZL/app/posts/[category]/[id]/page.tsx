"use client";
import {
  Card,
  CardBody,
  Divider,
  Tab,
  Tabs,
} from "@nextui-org/react";
import Image from "next/image";
import { Post } from "@/types/post";
import React, { useEffect, useState } from "react";
import { useParams, notFound } from "next/navigation";
import toast, { Toaster } from "react-hot-toast";
import ReactMarkdown from "react-markdown";
import rehypeHighlight from "rehype-highlight";
function PostHeader({ post }: { post: Post }) {
  return (
    <div className="w-4/5 p-4 rounded-md mx-auto">
      <div className="flex items-center space-x-4">
        <Image
          alt="Card background"
          className="object-cover rounded-md ml-10"
          src={post.imageUrl}
          width={150}
          height={150}
        />
        <div className="flex-1 space-y-1">
          <h2 className="text-2xl font-bold text-primary-700">{post.title}</h2>
          <p className="text-md text-gray-400">{post.description}</p>
        </div>
      </div>
      <Divider className="mt-4" />
    </div>
  );
}

export function PostBody({ post }: { post: Post }) {
  return (
    <div className="w-3/4 flex flex-row items-start space-x-4">
      <div className="w-4/5 p-4 rounded-md mx-auto space-y-4">
        <div className="flex w-full flex-col">
          <Tabs aria-label="Options">
            <Tab key="content" title="介绍">
              <Card>
                <CardBody className="text-primary-800">
      <ReactMarkdown className="prose prose-zinc max-w-none" rehypePlugins={[rehypeHighlight]}>{post.content}</ReactMarkdown>

                  </CardBody>
              </Card>
            </Tab>
            <Tab key="others" title="资源占位符">
              <Card>
                <CardBody>
                    测试占位符
                </CardBody>
              </Card>
            </Tab>
          </Tabs>
        </div>
        <div className="flex items-center space-x-4 rounded-md bg-gray-600"></div>
      </div>
      <div className="w-1/5 p-4 rounded-md mt-10 mx-auto bg-gray-200">
        <div className="flex items-center space-x-4">
          <div className="flex-1 space-y-1">
            <h2 className="text-2xl font-bold text-primary">
              {post.author.name}
            </h2>
            <Divider />
            <p className="text-sm text-primary">{post.createdAt}</p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default function PostTemplate() {
  const params = useParams();
  const [post, setPost] = useState<Post | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchPost = async () => {
      try {
        const response = await fetch(
          `http://127.0.0.1:5000/api/posts/${params.id}`
        );
        if (response.ok) {
          const data = await response.json();
          setPost(data);
        } else {
          notFound();
        }
      } catch (error) {
        console.error("获取帖子详情时出错：", error);
        toast.error("出错！");
      } finally {
        setLoading(false);
      }
    };
    const timer = setTimeout(fetchPost, 2000); 
    return () => clearTimeout(timer); 
  }, [params.id]);

  useEffect(() => {
    if (loading) {
      const toastId = toast.loading("正在加载数据...");
      return () => toast.dismiss(toastId); 
    }
  }, [loading]);

  if (loading) {
    return (
      <></>
    );
  }

  if (!post) {
    return notFound();
  }

  return (
    <div className="w-full mt-10 flex flex-col items-center">
      <PostHeader post={post} />
      <PostBody post={post} />
    </div>
  );
}