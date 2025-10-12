// src/presentation/pages/Home.jsx
import HeroSection from "../components/HeroSection";
import ServicesSection from "../components/ServicesSection";
import Tools from "../components/Tools";
import DiscoverSection from "../components/Discover";
import HowItWorks from "../components/HowItWorks";
import WhyWedify from "../components/WhyWedify";
import { User, Sliders, Heart } from "lucide-react";

const steps = [
  {
    number: 1,
    icon: <User className="mx-auto text-[var(--color-primary)] w-12 h-12 mb-4" />,
    title: "Create Your Account",
    text: "Sign up in minutes and start your personalized wedding planning journey.",
  },
  {
    number: 2,
    icon: <Sliders className="mx-auto text-[var(--color-primary)] w-12 h-12 mb-4" />,
    title: "Set Your Preferences",
    text: "Define your style, budget, and priorities — we’ll tailor services and recommendations just for you.",
  },
  {
    number: 3,
    icon: <Heart className="mx-auto text-[var(--color-primary)] w-12 h-12 mb-4" />,
    title: "Start Planning",
    text: "Book vendors, design your dream wedding, and manage everything seamlessly in one place.",
  },
];

const Home = () => {
  return (
    <>
      {/* Hero Section */}
      <HeroSection />
      {/* Discover Section */}
      <DiscoverSection />

      {/* Services Section */}
      <ServicesSection />

      {/* Tools Section */}
      <Tools />

      {/* Why Wedify Section */}
      <WhyWedify />

      {/* How It Works Section */}
      <HowItWorks />

      

      {/* Call to Action Section */}
      <section className="py-20 text-center bg-black flex flex-col items-center">
        <h2 className="text-4xl font-bold !text-white mb-6">Start Planning Today</h2>
        <p className="text-lg !text-white mb-8">
          Let us help you create unforgettable memories for your special day.
        </p>
        <button
          aria-label="Get started with wedding planning"
          className="bg-[var(--color-accent)] text-[var(--color-button-text)] px-8 py-3 rounded-full shadow-lg hover:bg-[var(--color-button-hover)] transition-colors duration-300"
        >
          Get Started
        </button>
      </section>
    </>
  );
};

export default Home;
