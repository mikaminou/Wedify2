/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}", // adjust if your source files are elsewhere
  ],
  theme: {
    extend: {
      colors: {
        primary: "#fbcfe8",      // soft pink
        secondary: "#fde68a",    // pastel yellow
        accent: "#ec4899",       // vibrant pink
        background: "#fff7f9",   // page background
        text: "#4b5563",         // gray text
        buttonBg: "#ec4899",     // button background
        buttonText: "#ffffff",   // button text
      },
      fontFamily: {
        sans: ['system-ui', 'Avenir', 'Helvetica', 'Arial', 'sans-serif'],
        serif: ['Playfair Display', 'serif'],
      },
      borderRadius: {
        xl: '1.5rem', // pill-shaped
      },
      boxShadow: {
        xl: '0 10px 25px rgba(0,0,0,0.1)',
      },
    },
  },
  plugins: [],
  darkMode: 'media', // respects prefers-color-scheme
};a// tailwind.config.js
module.exports = {
  content: ["./src/**/*.{js,jsx,ts,tsx}"],
  theme: {
    extend: {
      colors: {
        'accent': '#F4A300',
        'primary': '#F8D6D0',
        'secondary': '#F1E1D0',
        'dark': '#333333',
        'light': '#F9F9F9',
      },
      fontFamily: {
        'serif': ['"Playfair Display"', 'serif'],
        'handwriting': ['"Dancing Script"', 'cursive'],
      },
      keyframes: {
        "bounce-slow": {
          "0%, 100%": { transform: "translateY(0)" },
          "50%": { transform: "translateY(-10px)" },
        },
        "spin-slow": {
          "0%": { transform: "rotate(0deg)" },
          "100%": { transform: "rotate(360deg)" },
        },
      },
      animation: {
        "bounce-slow": "bounce-slow 4s infinite ease-in-out",
        "spin-slow": "spin-slow 20s linear infinite",
      },
    },
  },
  plugins: [],
};


