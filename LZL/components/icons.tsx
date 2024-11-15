import * as React from "react";
import { SVGProps } from "react";

export type IconSvgProps = SVGProps<SVGSVGElement> & {
  size?: number;
};

export const SearchIcon = (props: IconSvgProps) => (
  <svg
    aria-hidden="true"
    fill="none"
    focusable="false"
    height="1em"
    role="presentation"
    viewBox="0 0 24 24"
    width="1em"
    {...props}
  >
    <path
      d="M11.5 21C16.7467 21 21 16.7467 21 11.5C21 6.25329 16.7467 2 11.5 2C6.25329 2 2 6.25329 2 11.5C2 16.7467 6.25329 21 11.5 21Z"
      stroke="currentColor"
      strokeLinecap="round"
      strokeLinejoin="round"
      strokeWidth="2"
    />
    <path
      d="M22 22L20 20"
      stroke="currentColor"
      strokeLinecap="round"
      strokeLinejoin="round"
      strokeWidth="2"
    />
  </svg>
);
export const SzuLogo = () => (
  <svg
    width="92"
    height="80"
    viewBox="0 0 36 36"
    xmlns="http://www.w3.org/2000/svg"
  >
    <image
      href="https://www1.szu.edu.cn/images/szu.png"
      width="36"
      height="36"
    />
  </svg>
);
export const LoginSzuLogo = () => (
  <svg
    width="92"
    height="80"
    viewBox="0 0 36 36"
    xmlns="http://www.w3.org/2000/svg"
    className="ml-8 mt-2"
  >
    <image
      href="https://www1.szu.edu.cn/images/szu.png"
      width="36"
      height="36"
    />
  </svg>
);

export const CheckIcon = (props: React.JSX.IntrinsicAttributes & React.SVGProps<SVGSVGElement>) =>
  (
    <svg
      aria-hidden="true"
      fill="none"
      focusable="false"
      height="1em"
      stroke="currentColor"
      strokeLinecap="round"
      strokeLinejoin="round"
      strokeWidth={2}
      viewBox="0 0 24 24"
      width="1em"
      {...props}
    >
      <polyline points="20 6 9 17 4 12" />
    </svg>
  );