import type { Config } from "tailwindcss";
const { nextui } = require("@nextui-org/react");
import Form from "@tailwindcss/forms";
import Typography from "@tailwindcss/typography";
export default {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",
    "./app/**/*.{js,ts,jsx,tsx,mdx}",
    "./node_modules/@nextui-org/theme/dist/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        primary: {
          50: "#FFF5F5", 
          75: "#FFE8E8",  
          100: "#F9D2D0",
          200: "#F3A3A8",
          300: "#D55A80",
          400: "#B74763",
          500: "#881940",
          600: "#74123E",
          700: "#610C3B",
          800: "#4E0735",
          900: "#410431", 
          DEFAULT: "#881940",
          foreground: "#ffffff",
        },
      },
    },
  },
  darkMode: "class",
  plugins: [Form, Typography,
    nextui({
      themes: {
        "szu": {
          extend: "light",
          colors: {
            background: "#DADADA",
            foreground: "#ffffff",
            primary: {
              50: "#F9D2D0",
              100: "#F9D2D0",
              200: "#F3A3A8",
              300: "#DB6F80",
              400: "#B74763",
              500: "#881940",
              600: "#74123E",
              700: "#610C3B",
              800: "#4E0735",
              900: "#410431",
              DEFAULT: "#881940",
              foreground: "#ffffff",
            },
            focus: "#F182F6",
          },
          layout: {
            disabledOpacity: "0.3",
            radius: {
              small: "4px",
              medium: "6px",
              large: "8px",
            },
            borderWidth: {
              small: "1px",
              medium: "2px",
              large: "3px",
            },
          },
        },
      },
    }),
  ],
} satisfies Config;