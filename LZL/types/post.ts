export interface Post {
    id: string;
    title: string;
    content: string;
    description: string;
    imageUrl: string;
    category: 'competition' | 'resource' | 'team';
    author: {
      name: string;
      role: string;
    };
    createdAt: string;
    updatedAt: string;
    tags: string[]; 
  }