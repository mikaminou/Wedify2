// src/components/HeroSection.jsx
import React from "react";
import bgVideo from "../../assets/animation.mp4";

const HeroSection = () => {
  return (
    <section className="relative bg-white min-h-screen flex flex-col justify-start overflow-hidden">
      {/* Background video */}
      <video
        autoPlay
        loop
        muted
        playsInline
        className="absolute top-0 left-10 w-full h-full object-cover z-0 scale-x-[-1]"
        
      >
        <source src={bgVideo} type="video/mp4" />
      </video>

      {/* Gradient overlay */}
      <div className="absolute " />
      {/* Content */}
      <div className="relative z-20 container mx-auto px-6 pt-24 md:pt-50">
        <h1 className="text-5xl md:text-6xl font-serif font-bold text-white !mb-5 text-left max-w-2xl">
          Your Dream Wedding Awaits
        </h1>
        <p className="text-xl md:text-2xl text-white/90 max-w-xl mb-8 text-left">
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
