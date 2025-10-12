import React from "react";
import { motion } from "framer-motion";

// Import sticker images
import flowersImg from "../../assets/flowers.jpg";
import venueImg from "../../assets/venue.jpg";
import decoImg from "../../assets/deco.jpg";
import catheringImg from "../../assets/cathering.jpg";
import beautyImg from "../../assets/beauty.jpg";
import hennaImg from "../../assets/henna.jpg";
import dressImg from "../../assets/dress.jpg";
import photographyImg from "../../assets/photography.jpg";

const HeroSection = () => {
  const stickers = [
    // Top row - Featuring larger venue image
    {
      src: flowersImg,
      alt: "Flowers",
      top: "17%",
      left: "15%",
      size: "w-32 h-32",
      duration: 6,
      yRange: 15,
    },
    {
      src: venueImg,
      alt: "Venue",
      top: "15%",
      right: "15%",
      size: "w-44 h-44",
      duration: 7,
      yRange: 20,
    },
    {
      src: photographyImg,
      alt: "Photography",
      top: "14%",
      left: "45%",
      size: "w-36 h-36",
      duration: 7.8,
      yRange: 18,
    },

    // Middle row - Smaller decorative elements
    {
      src: decoImg,
      alt: "Decorations",
      top: "45%",
      left: "6%",
      size: "w-32 h-32",
      duration: 8,
      yRange: 15,
    },
    {
      src: hennaImg,
      alt: "Henna",
      top: "47%",
      right: "5%",
      size: "w-32 h-32",
      duration: 8.2,
      yRange: 12,
    },

    // Bottom row - Featuring larger dress and catering images
    {
      src: catheringImg,
      alt: "Cathering",
      bottom: "8%",
      right: "20%",
      size: "w-36 h-36",
      duration: 9,
      yRange: 20,
    },
    {
      src: dressImg,
      alt: "Beauty",
      bottom: "10%",
      left: "20%",
      size: "w-32 h-32",
      duration: 6.5,
      yRange: 15,
    },
    {
      src: beautyImg,
      alt: "Dress",
      bottom: "5%",
      right: "45%",
      size: "w-44 h-44",
      duration: 9,
      yRange: 20,
    },
  ];

  return (
    <section className="relative min-h-screen flex flex-col justify-center items-center bg-gradient-to-b from-pink-100 via-white to-purple-50 overflow-hidden">
      {/* Decorative background with stickers */}
      <div className="absolute inset-0 pointer-events-none">
        {stickers.map((sticker, idx) => (
          <motion.img
            key={idx}
            src={sticker.src}
            alt={sticker.alt}
            className={`absolute ${sticker.size} rounded-xl shadow-lg object-cover opacity-90 hover:opacity-100 transition-opacity`}
            style={{
              top: sticker.top,
              bottom: sticker.bottom,
              left: sticker.left,
              right: sticker.right,
            }}
            animate={{
              y: [0, -sticker.yRange, 0],
              scale: [1, 1.02, 1], // more subtle scale breathing
            }}
            transition={{
              duration: sticker.duration,
              repeat: Infinity,
              repeatType: "mirror",
              ease: "easeInOut",
            }}
          />
        ))}
      </div>

      {/* Main headline */}
      <div className="relative z-10 text-center px-6 max-w-2xl">
        <h1 className="text-5xl md:text-6xl font-bold text-[var(--color-text)] mb-6 leading-tight tracking-tight">
          Your Dream Wedding Awaits
        </h1>
        <p className="font-signature text-3xl text-[var(--color-accent)] mb-10">
          Crafted with love, just for you
        </p>
        <motion.button
          whileHover={{ scale: 1.05 }}
          whileTap={{ scale: 0.95 }}
          className="px-10 py-4 rounded-full bg-[var(--color-accent)] text-[var(--color-button-text)] font-semibold shadow-lg hover:shadow-xl hover:bg-[var(--color-button-hover)] transition-all duration-300"
        >
          Start Planning
        </motion.button>
      </div>
    </section>
  );
};

export default HeroSection;
