// src/presentation/components/ServicesSection.jsx
import React from "react";
import { Camera, Music, Utensils, Building2, Scissors, Shirt } from "lucide-react";

const services = [
  { title: "Venues", icon: <Building2 size={64} className="text-[var(--color-accent)]" /> },
  { title: "Photography", icon: <Camera size={64} className="text-[var(--color-accent)]" /> },
  { title: "Beauty", icon: <Scissors size={64} className="text-[var(--color-accent)]" /> },
  { title: "Clothing", icon: <Shirt size={64} className="text-[var(--color-accent)]" /> },
  { title: "Catering", icon: <Utensils size={64} className="text-[var(--color-accent)]" /> },
  { title: "DJ & Music", icon: <Music size={64} className="text-[var(--color-accent)]" /> },
];

const ServicesSection = () => {
  return (
    <section className="container bg-[var(--color-accent)] mx-auto px-6 py-20 flex flex-col items-center w-full">
      <h2 className="text-4xl font-bold text-center text-[var(--color-primary)] mb-12">
        Our Services
      </h2>
      <div className="grid md:grid-cols-3 gap-10 mt-10 w-full">
        {services.map((service, idx) => (
          <div
            key={idx}
            className="bg-white rounded-2xl p-8 text-center flex flex-col items-center"
          >
            {service.icon}
            <h3 className="text-xl font-semibold mt-4">{service.title}</h3>
          </div>
        ))}
      </div>
    </section>
  );
};

export default ServicesSection;
