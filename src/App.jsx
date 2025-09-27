import React from "react";
import Navbar from "./presentation/components/Navbar";
import HeroSection from "./presentation/components/HeroSection";
import Footer from "./presentation/components/Footer";

const App = () => {
  return (
    <div className="min-h-screen bg-gradient-to-b from-pink-50 to-white text-gray-800">
      {/* Navbar */}
      <Navbar />

      {/* Hero Section */}
      <HeroSection />

      {/* Services Section */}
      <section className="container bg-[var(--color-primary)] mx-auto px-6 min-h-screen flex flex-col items-center justify-center">
        <h2 className="text-4xl font-bold text-center text-pink-900 mb-12">
          Our Services
        </h2>
        <div className="grid md:grid-cols-3 gap-10 mt-30">
          <div className="bg-white rounded-2xl shadow-xl p-8 text-center hover:scale-105 transition-transform">
            <h3 className="text-2xl font-semibold mb-4">Venues</h3>
            <p>
              Discover stunning venues tailored to your style and budget. From
              romantic gardens to luxurious ballrooms.
            </p>
          </div>
          <div className="bg-white rounded-2xl shadow-xl p-8 text-center hover:scale-105 transition-transform">
            <h3 className="text-2xl font-semibold mb-4">Photography</h3>
            <p>
              Capture every precious moment with our professional photographers
              who specialize in weddings.
            </p>
          </div>
          <div className="bg-white rounded-2xl shadow-xl p-8 text-center hover:scale-105 transition-transform">
            <h3 className="text-2xl font-semibold mb-4">Catering</h3>
            <p>
              Delight your guests with curated menus from top chefs, customized
              for your celebration.
            </p>
          </div>
        </div>
      </section>

      {/* Featured Weddings */}
      <section className="bg-pink-50 min-h-screen flex flex-col items-center justify-center">
        <h2 className="text-4xl font-bold text-center text-pink-900 mb-12">
          Featured Weddings
        </h2>
        <div className="flex flex-col md:flex-row gap-8 container mx-auto px-6 mt-30">
          <div className="flex-1 bg-white rounded-2xl shadow-xl overflow-hidden hover:scale-105 transition-transform">
            <img
              src="https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?auto=format&fit=crop&w=800&q=80"
              alt="Wedding 1"
              className="w-full h-64 object-cover"
            />
            <div className="p-6">
              <h3 className="text-2xl font-semibold mb-2">Alice & John</h3>
              <p>Elegant garden wedding in Provence with 120 guests.</p>
            </div>
          </div>
          <div className="flex-1 bg-white rounded-2xl shadow-xl overflow-hidden hover:scale-105 transition-transform">
            <img
              src="https://images.unsplash.com/photo-1506617420156-8e4536971650?auto=format&fit=crop&w=800&q=80"
              alt="Wedding 2"
              className="w-full h-64 object-cover"
            />
            <div className="p-6">
              <h3 className="text-2xl font-semibold mb-2">Sophia & Liam</h3>
              <p>Romantic seaside wedding with a breathtaking sunset ceremony.</p>
            </div>
          </div>
        </div>
      </section>

      {/* Call to Action */}
      <section className="py-20 text-center bg-gradient-to-r from-[var(--color-background)] via-[var(--color-background)] to-[var(--color-background)]">
        <h2 className="text-4xl font-bold text-pink-900 mb-6">
          Start Planning Today
        </h2>
        <p className="text-lg text-pink-800 mb-8">
          Let us help you create unforgettable memories for your special day.
        </p>
        <button className="bg-pink-600 text-white px-8 py-3 rounded-full shadow-lg hover:bg-pink-700 transition-colors">
          Get Started
        </button>
      </section>

      {/* Footer */}
      <Footer />
    </div>
  );
};

export default App;
