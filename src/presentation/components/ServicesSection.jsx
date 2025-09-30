// src/presentation/components/ServicesSection.jsx
import React from "react";

const services = [
  { title: "Venues", text: "Discover stunning venues in your region tailored to your style and budget." },
  { title: "Photography", text: "Capture every precious moment with our professional photographers who specialize in weddings." },
  { title: "Beauty", text: "Professional makeup and hairstyling to help you shine with confidence and elegance." },
  { title: "Clothing", text: "From stunning white and traditional dresses to elegant suits, tailored to your special day." },
  { title: "Catering", text: "Delight your guests with curated menus from top chefs, customized for your celebration." },
  { title: "DJ & Music", text: "Professional DJs and live music to keep your celebration unforgettable." }
];

const ServicesSection = () => {
  return (
    <section className="container mx-auto px-6 py-20 bg-[var(--color-background)] flex flex-col items-center">
      <h2 className="text-4xl font-bold text-center text-[var(--color-primary)] mb-12">
        Our Services
      </h2>
      <div className="grid md:grid-cols-3 gap-10">
        {services.map((service, idx) => (
          <div key={idx} className="bg-white rounded-2xl shadow-xl p-8 text-center hover:scale-105 transition-transform duration-300">
            <h3 className="text-2xl font-semibold mb-4">{service.title}</h3>
            <p>{service.text}</p>
          </div>
        ))}
      </div>
    </section>
  );
};

export default ServicesSection;
