import React from "react";
import { Routes, Route } from "react-router-dom";

import Navbar from "./presentation/components/Navbar";
import HeroSection from "./presentation/components/HeroSection";
import Footer from "./presentation/components/Footer";
import ServicesSection from "./presentation/components/ServicesSection";
import Tools from "./presentation/components/Tools";
import SignUp from "./presentation/pages/signup";
import SignIn from "./presentation/pages/signin";
import { User, Sliders, Heart } from "lucide-react";

const steps = [
  { number: 1, icon: <User className="mx-auto text-[var(--color-primary)] w-12 h-12 mb-4" />, title: "Create Your Account", text: "Sign up in minutes and start your personalized wedding planning journey." },
  { number: 2, icon: <Sliders className="mx-auto text-[var(--color-primary)] w-12 h-12 mb-4" />, title: "Set Your Preferences", text: "Define your style, budget, and priorities — we’ll tailor services and recommendations just for you." },
  { number: 3, icon: <Heart className="mx-auto text-[var(--color-primary)] w-12 h-12 mb-4" />, title: "Start Planning", text: "Book vendors, design your dream wedding, and manage everything seamlessly in one place." },
];

const App = () => {
  return (
    <div className="min-h-screen bg-[var(--color-background)] text-[var(--color-text)]">
      <Navbar />

      <Routes>
        <Route
          path="/"
          element={
            <>
              <HeroSection />
              <ServicesSection />
              <Tools />

              {/* How It Works */}
              <section className="bg-gradient-to-r from-purple-50 via-pink-50 to-green-50 py-20 flex flex-col items-center">
                <h2 className="text-4xl font-bold text-center text-[var(--color-text)] mb-16">How It Works</h2>
                <div className="grid gap-12 md:grid-cols-3 container mx-auto mt-20 px-6">
                  {steps.map((step, idx) => (
                    <div key={idx} className="bg-white rounded-2xl shadow-lg p-8 text-center hover:scale-105 transition-transform duration-300 relative">
                      <div className="absolute -top-6 left-1/2 transform -translate-x-1/2 bg-[var(--color-primary)] text-white rounded-full w-12 h-12 flex items-center justify-center text-xl font-bold shadow-md">
                        {step.number}
                      </div>
                      {step.icon}
                      <h3 className="text-2xl font-semibold mb-4">{step.title}</h3>
                      <p className="text-gray-600">{step.text}</p>
                    </div>
                  ))}
                </div>
              </section>

              {/* Call to Action */}
              <section className="py-20 text-center bg-black flex flex-col items-center">
                <h2 className="text-4xl font-bold !text-white mb-6">Start Planning Today</h2>
                <p className="text-lg !text-white mb-8">
                  Let us help you create unforgettable memories for your special day.
                </p>
                <button aria-label="Get started with wedding planning" className="bg-[var(--color-accent)] text-[var(--color-button-text)] px-8 py-3 rounded-full shadow-lg hover:bg-[var(--color-button-hover)] transition-colors duration-300">
                  Get Started
                </button>
              </section>
            </>
          }
        />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/signin" element={<SignIn />} />
      </Routes>

      <Footer />
    </div>
  );
};

export default App;
