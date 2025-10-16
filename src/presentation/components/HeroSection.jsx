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
    {
      src: flowersImg,
      alt: "Flowers",
      top: "10%",
      right: "5%",
      size: "w-44 h-44",
      duration: 6,
      yRange: 15,
    },
    {
      src: venueImg,
      alt: "Venue",
      top: "13%",
      right: "35%",
      size: "w-56 h-62",
      duration: 7,
      yRange: 20,
    },
    {
      src: photographyImg,
      alt: "Photography",
      top: "25%",
      right: "20%",
      size: "w-50 h-50",
      duration: 7.8,
      yRange: 18,
    },
    {
      src: decoImg,
      alt: "Decorations",
      top: "40%",
      right: "6%",
      size: "w-42 h-42",
      duration: 8,
      yRange: 15,
    },
    {
      src: hennaImg,
      alt: "Henna",
      top: "47%",
      right: "35%",
      size: "w-40 h-40",
      duration: 8.2,
      yRange: 12,
    },
    {
      src: catheringImg,
      alt: "Catering",
      bottom: "20%",
      right: "22%",
      size: "w-40 h-50",
      duration: 9,
      yRange: 20,
    },
    {
      src: dressImg,
      alt: "Dresses",
      bottom: "4%",
      right: "36%",
      size: "w-50 h-50",
      duration: 6.5,
      yRange: 15,
    },
    {
      src: beautyImg,
      alt: "Beauty",
      bottom: "5%",
      right: "4%",
      size: "w-64 h-64",
      duration: 9,
      yRange: 20,
    },
  ];

  return (
    <section className="relative min-h-screen flex items-center bg-gradient-to-br from-white via-[var(--color-primary)]/5 to-[var(--color-accent)]/5 overflow-hidden">
      {/* Floating stickers */}
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
              scale: [1, 1.02, 1],
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

      {/* Headline and actions */}
      <div className="relative z-10 text-center px-6 max-w-3xl">
        <h1 className="text-5xl md:text-6xl font-bold text-[var(--color-text)] mb-6 leading-tight tracking-tight">
          Wedify
        </h1>
        <h2 className="text-5xl md:text-6xl font-bold text-[var(--color-text)] !mb-6 leading-tight tracking-tight">
          Where Love Meets Opportunity
        </h2>

        <p className="text-xl text-[var(--color-secondary-text)] mb-10 leading-relaxed">
          For couples dreaming of the perfect day and vendors bringing those dreams to life — Wedify connects you in one beautiful place.
        </p>

        {/* Dual CTA buttons */}
        <div className="flex flex-col sm:flex-row justify-center gap-4">
          <motion.button
            whileHover={{ scale: 1.05 }}
            whileTap={{ scale: 0.95 }}
            className="px-8 py-4 rounded-full bg-[var(--color-accent)] text-[var(--color-button-text)] font-semibold shadow-md hover:bg-[var(--color-button-hover)] transition-all duration-300"
          >
            I’m Planning My Wedding
          </motion.button>

          <motion.button
            whileHover={{ scale: 1.05 }}
            whileTap={{ scale: 0.95 }}
            className="px-8 py-4 rounded-full border-2 border-[var(--color-accent)] text-[var(--color-accent)] font-semibold bg-transparent hover:bg-[var(--color-accent)] hover:text-[var(--color-button-text)] transition-all duration-300"
          >
            I’m a Vendor
          </motion.button>
        </div>
      </div>
    </section>
  );
};

export default HeroSection;
