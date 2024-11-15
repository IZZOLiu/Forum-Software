// types.ts
export interface User {
    id: string;       // 用户ID
    username: string; // 用户名
    token: string;    // 登录token
    isLoggedIn: boolean; // 登录状态
  }
  
  // 初始化的未登录用户对象
  export const initialUser: User = {
    id: "unknown",
    username: "guest",
    token: "",
    isLoggedIn: false
  };