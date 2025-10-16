import React from "react";
import { motion } from "framer-motion";
import coupleImg from "../../assets/deco.jpg";

const DiscoverSection = () => {
  return (
    <section className="relative py-24 px-6 mt-20 md:px-16 bg-gradient-to-b from-white via-[var(--color-background)] to-[var(--color-primary)]/10 overflow-hidden">
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
            Discover the World of{" "}
            <span className="text-[var(--color-accent)]">Wedify</span>
          </h2>

          <p className="font-signature text-3xl text-[var(--color-accent)] mb-6">
            Where dreams meet opportunity
          </p>

          <p className="text-lg text-[var(--color-secondary-text)] leading-relaxed mb-10">
            Wedify connects engaged couples with trusted wedding professionals
            across Algeria. From makeup artists to photographers, florists to
            planners — we make planning effortless and showcase local talent
            beautifully. Whether you’re creating memories or growing your
            business, Wedify is where it all begins.
          </p>

          <motion.button
            whileHover={{ scale: 1.05 }}
            whileTap={{ scale: 0.95 }}
            className="px-10 py-4 rounded-full bg-[var(--color-accent)] text-[var(--color-button-text)] font-semibold shadow-lg hover:shadow-xl hover:bg-[var(--color-button-hover)] transition-all duration-300"
          >
            Explore the Experience
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
              alt="Wedify experience"
              className="w-full h-[500px] object-cover rounded-3xl shadow-2xl"
            />

            {/* Floating glow */}
            <motion.div
              className="absolute inset-0 rounded-3xl bg-gradient-to-t from-[var(--color-accent)]/10 to-transparent"
              animate={{ opacity: [0.3, 0.6, 0.3] }}
              transition={{
                duration: 5,
                repeat: Infinity,
                ease: "easeInOut",
              }}
            ></motion.div>

            {/* Floating Cards with gentle vertical movement */}
            <motion.div
              className="absolute -bottom-10 left-6 bg-white/90 backdrop-blur-md px-6 py-4 rounded-2xl shadow-xl w-64"
              initial={{ opacity: 0 }}
              whileInView={{ opacity: 1 }}
              animate={{ y: [0, -10, 0] }}
              transition={{ duration: 3, repeat: Infinity, ease: "easeInOut" }}
            >
              <h4 className="font-semibold text-[var(--color-text)] mb-2">
                For Couples 💍
              </h4>
              <p className="text-sm text-gray-600">
                Plan your dream wedding effortlessly with trusted vendors.
              </p>
            </motion.div>

            <motion.div
              className="absolute -top-10 right-6 bg-white/90 backdrop-blur-md px-6 py-4 rounded-2xl shadow-xl w-64"
              initial={{ opacity: 0 }}
              whileInView={{ opacity: 1 }}
              animate={{ y: [0, 10, 0] }}
              transition={{ duration: 3.5, repeat: Infinity, ease: "easeInOut" }}
            >
              <h4 className="font-semibold text-[var(--color-text)] mb-2">
                For Vendors 💼
              </h4>
              <p className="text-sm text-gray-600">
                Showcase your expertise and grow your wedding business.
              </p>
            </motion.div>
          </div>
        </motion.div>
      </div>
    </section>
  );
};

export default DiscoverSection;
