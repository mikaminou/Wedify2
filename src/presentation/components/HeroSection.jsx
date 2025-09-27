// src/components/HeroSection.jsx
import React from "react";
import bgImage from "../../assets/bg.jpg";

const HeroSection = () => {
  return (
    <section className="relative min-h-screen flex flex-col items-center justify-center text-center">
      {/* Background image with overlay */}
      <div
        className="absolute inset-0 z-0"
        style={{
          backgroundImage: `url(${bgImage})`,
          backgroundSize: "cover",
          backgroundPosition: "center",
          backgroundRepeat: "no-repeat",
        }}
      />
      {/* Gradient overlay */}
      <div className="absolute inset-0 bg-black/40 z-10" />
      {/* Content */}
      <div className="relative z-20">
        <h1 className="text-5xl md:text-6xl font-serif font-bold text-white mb-6 drop-shadow-lg">
          Your Dream Wedding Awaits
        </h1>
        <p className="text-xl md:text-2xl text-white/90 max-w-xl mb-8 drop-shadow-md">
          Plan your perfect day effortlessly with our curated wedding booking
          services.
        </p>
        <button className="bg-accent text-buttonText px-8 py-3 rounded-xl shadow-xl hover:bg-white hover:text-accent transition-all duration-300">
          Book a Consultation
        </button>
      </div>
    </section>
  );
};

export default HeroSection;
