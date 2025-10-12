import React from "react";
import { motion } from "framer-motion";

// Import service images
import venueImg from "../../assets/venue.jpg";
import photographyImg from "../../assets/photography.jpg";
import beautyImg from "../../assets/beauty.jpg";
import dressImg from "../../assets/dress.jpg";
import catheringImg from "../../assets/cathering.jpg";
import decoImg from "../../assets/deco.jpg";
import hennaImg from "../../assets/henna.jpg";
import flowersImg from "../../assets/flowers.jpg";

const services = [
  { title: "Venues", img: venueImg },
  { title: "Photography", img: photographyImg },
  { title: "Makeup & Beauty", img: beautyImg },
  { title: "Bridal Dresses", img: dressImg },
  { title: "Catering", img: catheringImg },
  { title: "Decoration", img: decoImg },
  { title: "Henna Art", img: hennaImg },
  { title: "Flowers", img: flowersImg },
];

const ServicesSection = () => {
  return (
    <section className="relative py-24 px-6 mt-20 md:px-16 bg-gradient-to-b from-purple-50 via-white to-pink-50 overflow-hidden">
      {/* Title */}
      <div className="text-center mb-16">
        <h2 className="text-5xl md:text-6xl font-bold text-[var(--color-text)] mb-4">
          Explore Our Services
        </h2>
      </div>

      {/* Services Grid */}
      <div className="max-w-7xl mx-auto grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-10">
        {services.map((service, index) => (
          <motion.div
            key={index}
            className="relative group overflow-hidden rounded-3xl shadow-lg hover:shadow-2xl transition-all duration-300"
            initial={{ opacity: 0, y: 40 }}
            whileInView={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.8, delay: index * 0.1 }}
            viewport={{ once: true }}
          >
            {/* Image */}
            <img
              src={service.img}
              alt={service.title}
              className="w-full h-64 object-cover transform group-hover:scale-110 transition-transform duration-500"
            />

            {/* Overlay */}
            <div className="absolute inset-0 bg-black/10 group-hover:bg-black/30 transition-all duration-300" />

            {/* Title */}
            <motion.h3
              className="absolute bottom-6 left-6 !text-white text-2xl font-semibold"
              whileHover={{ scale: 1.05 }}
            >
              {service.title}
            </motion.h3>
          </motion.div>
        ))}
      </div>

      {/* Footer Sentence Instead of Button */}
      <div className="text-center mt-16">
        <p className="text-2xl md:text-3xl text-[var(--color-accent)] font-signature">
          ... and many more ✨
        </p>
      </div>

    </section>
  );
};

export default ServicesSection;
