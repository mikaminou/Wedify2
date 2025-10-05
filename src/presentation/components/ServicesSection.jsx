// src/presentation/components/ServicesSection.jsx
import React from "react";

// Import your JPG images directly from assets
import venuesImg from "../../assets/venue.jpg";
import photographyImg from "../../assets/photography.jpg";
import beautyImg from "../../assets/beauty.jpg";
import cateringImg from "../../assets/cathering.jpg";
import musicImg from "../../assets/dj.jpg";
import dressImg from "../../assets/dress.jpg";
import flowerImg from "../../assets/flowers.jpg";
import decoImg from "../../assets/deco.jpg";


const services = [
  {
    title: "Venues",
    text: "Find the perfect wedding venue that matches your dream style.",
    image: venuesImg,
  },
  {
    title: "Photography",
    text: "Capture every moment with professional wedding photographers.",
    image: photographyImg,
  },
  {
    title: "Beauty",
    text: "Look and feel amazing with expert hair and makeup services.",
    image: beautyImg,
  },
  {
    title: "Catering",
    text: "Delight your guests with delicious wedding catering options.",
    image: cateringImg,
  },
  {
    title: "Music",
    text: "Create unforgettable vibes with the perfect wedding playlist.",
    image: musicImg,
  },
  {
    title: "Dresses",
    text: "Find your dream wedding dresses with our curated selection.",
    image: dressImg,
  },
  {
    title: "Decoration",
    text: "Bring your vision to life with stunning wedding decorations.",
    image: decoImg,
  },
  {
    title: "Flowers",
    text: "Elegant floral designs that bring beauty and romance to your wedding.",
    image: flowerImg,
  },
];

const ServicesSection = () => {
  return (
    <section className="py-20 bg-[var(--color-primary)]/50 relative mt-30 mb-20">
      <div className="container mx-auto px-20">
        <h2 className="text-4xl font-bold text-center text-[var(--color-text)] mb-30">
          Our Services
        </h2>

        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6 mt-12">
          {services.map((service, idx) => (
            <div
              key={idx}
              className="relative bg-white rounded-2xl overflow-hidden h-[400px] flex flex-col"
            >
              {/* Image wrapper */}
              <div className="w-60 h-60 mx-auto mt-10 overflow-hidden">
                <img
                  src={service.image}
                  alt={service.title}
                  className="w-full h-full object-cover rounded-t-2xl"
                />
              </div>

              {/* Content */}
              <div className="p-6 text-center flex-1">
                <h3 className="text-2xl font-semibold mb-4 text-[var(--color-text)]">
                  {service.title}
                </h3>
                <p className="text-[var(--color-subtext)]">{service.text}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
};


export default ServicesSection;
