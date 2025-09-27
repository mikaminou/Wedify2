import React from "react";
import Navbar from "./presentation/components/Navbar";
import HeroSection from "./presentation/components/HeroSection";
import Footer from "./presentation/components/Footer";
import ServicesSection from "./presentation/components/ServicesSection";
import Tools from "./presentation/components/Tools";
import { User, Sliders, Heart } from "lucide-react";

const App = () => {
  return (
    <div className="min-h-screen bg-gradient-to-b from-purple-50 via-white to-pink-50 text-gray-800">
      {/* Navbar */}
      <Navbar />

      {/* Hero Section */}
      <HeroSection />

      {/* Services Section */}
      <ServicesSection />

      {/* Tools Section */}
      <Tools />  

      {/* How It Works */}
      <section className="bg-gradient-to-r from-purple-50 via-pink-50 to-green-50 py-20 flex flex-col items-center">
        <h2 className="text-4xl font-bold text-center text-gray-800 mb-16">
          How It Works
        </h2>

        <div className="grid gap-12 md:grid-cols-3 container mx-auto mt-20 px-6">
          {/* Step 1 */}
          <div className="bg-white rounded-2xl shadow-lg p-8 text-center hover:scale-105 transition-transform relative">
            <div className="absolute -top-6 left-1/2 transform -translate-x-1/2 bg-[var(--color-secondary)] text-white rounded-full w-12 h-12 flex items-center justify-center text-xl font-bold shadow-md">
              1
            </div>
            <User className="mx-auto text-[var(--color-secondary)] w-12 h-12 mb-4" />
            <h3 className="text-2xl font-semibold mb-4">Create Your Account</h3>
            <p className="text-gray-600">
              Sign up in minutes and start your personalized wedding planning journey.
            </p>
          </div>

          {/* Step 2 */}
          <div className="bg-white rounded-2xl shadow-lg p-8 text-center hover:scale-105 transition-transform relative">
            <div className="absolute -top-6 left-1/2 transform -translate-x-1/2 bg-[var(--color-accent)] text-white rounded-full w-12 h-12 flex items-center justify-center text-xl font-bold shadow-md">
              2
            </div>
            <Sliders className="mx-auto text-[var(--color-accent)] w-12 h-12 mb-4" />
            <h3 className="text-2xl font-semibold mb-4">Set Your Preferences</h3>
            <p className="text-gray-600">
              Define your style, budget, and priorities — we’ll tailor services and recommendations just for you.
            </p>
          </div>

          {/* Step 3 */}
          <div className="bg-white rounded-2xl shadow-lg p-8 text-center hover:scale-105 transition-transform relative">
            <div className="absolute -top-6 left-1/2 transform -translate-x-1/2 bg-[var(--color-primary)] text-white rounded-full w-12 h-12 flex items-center justify-center text-xl font-bold shadow-md">
              3
            </div>
            <Heart className="mx-auto text-[var(--color-primary)] w-12 h-12 mb-4" />
            <h3 className="text-2xl font-semibold mb-4">Start Planning</h3>
            <p className="text-gray-600">
              Book vendors, design your dream wedding, and manage everything seamlessly in one place.
            </p>
          </div>
        </div>
      </section>

      {/* Call to Action */}
      <section className="py-20 text-center bg-gradient-to-r from-purple-50 via-yellow-50 to-pink-50">
        <h2 className="text-4xl font-bold text-gray-800 mb-6">
          Start Planning Today
        </h2>
        <p className="text-lg text-gray-600 mb-8">
          Let us help you create unforgettable memories for your special day.
        </p>
        <button className="!bg-pink-600 text-white px-8 py-3 rounded-full shadow-lg hover:bg-purple-700 transition-colors">
          Get Started
        </button>
      </section>

      {/* Footer */}
      <Footer />
    </div>
  );
};

export default App;
