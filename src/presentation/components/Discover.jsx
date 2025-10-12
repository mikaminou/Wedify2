import React from "react";
import { motion } from "framer-motion";
import coupleImg from "../../assets/deco.jpg"; // Replace with your actual image

const DiscoverSection = () => {
  return (
    <section className="relative py-24 px-6 mt-20 md:px-16 bg-gradient-to-b from-white via-pink-50 to-purple-50 overflow-hidden">
      <div className="max-w-7xl mx-auto flex flex-col md:flex-row items-center gap-16">
        {/* Left Text Side */}
        <motion.div
          className="md:w-1/2 text-center md:text-left"
          initial={{ opacity: 0, x: -40 }}
          whileInView={{ opacity: 1, x: 0 }}
          transition={{ duration: 1 }}
          viewport={{ once: true }}
        >
          <h2 className="text-5xl md:text-6xl font-bold text-[var(--color-text)] leading-tight mb-6">
            Discover the Magic of{" "}
            <span className="text-[var(--color-accent)]">Wedify</span>
          </h2>

          <p className="font-signature text-3xl text-[var(--color-accent)] mb-6">
            Where love meets perfect planning
          </p>

          <p className="text-lg text-gray-700 leading-relaxed mb-10">
            Wedify brings couples and wedding professionals together in one
            beautiful place. Whether you're planning your big day or showcasing
            your craft, Wedify turns your dream wedding into a seamless,
            stress-free experience filled with elegance and joy.
          </p>

          <motion.button
            whileHover={{ scale: 1.05 }}
            whileTap={{ scale: 0.95 }}
            className="px-10 py-4 rounded-full bg-[var(--color-accent)] text-[var(--color-button-text)] font-semibold shadow-lg hover:shadow-xl hover:bg-[var(--color-button-hover)] transition-all duration-300"
          >
            Explore Services
          </motion.button>
        </motion.div>

        {/* Right Image Side */}
        <motion.div
          className="md:w-1/2 relative"
          initial={{ opacity: 0, x: 40 }}
          whileInView={{ opacity: 1, x: 0 }}
          transition={{ duration: 1 }}
          viewport={{ once: true }}
        >
          <div className="relative">
            <img
              src={coupleImg}
              alt="Wedding couple"
              className="w-full h-[500px] object-cover rounded-3xl shadow-2xl"
            />

            {/* Floating glow animation */}
            <motion.div
              className="absolute inset-0 rounded-3xl bg-gradient-to-t from-pink-100/20 to-transparent"
              animate={{ opacity: [0.3, 0.6, 0.3] }}
              transition={{
                duration: 5,
                repeat: Infinity,
                ease: "easeInOut",
              }}
            ></motion.div>

            {/* Floating soft petals */}
            <motion.span
              className="absolute top-10 left-10 w-6 h-6 bg-pink-300 rounded-full opacity-60 blur-md"
              animate={{ y: [0, -20, 0], opacity: [0.4, 0.7, 0.4] }}
              transition={{ duration: 6, repeat: Infinity, ease: "easeInOut" }}
            />
            <motion.span
              className="absolute bottom-12 right-12 w-8 h-8 bg-purple-200 rounded-full opacity-50 blur-md"
              animate={{ y: [0, -15, 0], opacity: [0.4, 0.7, 0.4] }}
              transition={{ duration: 7, repeat: Infinity, ease: "easeInOut" }}
            />
          </div>
        </motion.div>
      </div>
    </section>
  );
};

export default DiscoverSection;
