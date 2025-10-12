import React, { useState } from "react";
import { motion, AnimatePresence } from "framer-motion";
import {
  Heart,
  Users,
  MessageCircle,
  Calendar,
  Briefcase,
  Star,
} from "lucide-react";

const HowItWorks = () => {
  const [view, setView] = useState("couples");

  const couplesSteps = [
    {
      icon: <Heart className="w-10 h-10 text-pink-500" />,
      title: "Find Your Vendors",
      text: "Discover trusted professionals near you — from photographers to venues.",
    },
    {
      icon: <MessageCircle className="w-10 h-10 text-pink-500" />,
      title: "Chat & Plan",
      text: "Message vendors directly, discuss your vision, and make your dream come true.",
    },
    {
      icon: <Calendar className="w-10 h-10 text-pink-500" />,
      title: "Book & Relax",
      text: "Reserve your date online and enjoy stress-free planning.",
    },
  ];

  const vendorsSteps = [
    {
      icon: <Briefcase className="w-10 h-10 text-purple-500" />,
      title: "Create Your Portfolio",
      text: "Showcase your work beautifully and attract ideal couples.",
    },
    {
      icon: <Users className="w-10 h-10 text-purple-500" />,
      title: "Get Real Bookings",
      text: "Receive confirmed reservations directly from couples.",
    },
    {
      icon: <Star className="w-10 h-10 text-purple-500" />,
      title: "Grow Your Business",
      text: "Build trust, gain exposure, and grow your brand on Wedify.",
    },
  ];

  const steps = view === "couples" ? couplesSteps : vendorsSteps;

  return (
    <section className="relative py-24 px-6 md:px-16 bg-gradient-to-b from-white via-pink-50/50 to-purple-50/50 text-center overflow-hidden">
      {/* Title */}
      <div className="mb-16">
        <h2 className="text-5xl md:text-6xl font-bold text-[var(--color-text)] mb-6">
          How It Works
        </h2>

        {/* Toggle Switch */}
        <div className="relative inline-flex bg-white border border-[var(--color-accent)] rounded-full p-1 shadow-md">
          <button
            onClick={() => setView("couples")}
            className={`px-6 py-2 rounded-full transition-all duration-300 ${
              view === "couples"
                ? "bg-[var(--color-accent)] text-white"
                : "text-[var(--color-accent)]"
            }`}
          >
            For Couples 💍
          </button>
          <button
            onClick={() => setView("vendors")}
            className={`px-6 py-2 rounded-full transition-all duration-300 ${
              view === "vendors"
                ? "bg-[var(--color-accent)] text-white"
                : "text-[var(--color-accent)]"
            }`}
          >
            For Vendors 💼
          </button>
        </div>
      </div>

      {/* Animated Cards */}
      <div className="max-w-6xl mx-auto grid grid-cols-1 md:grid-cols-3 gap-10 mt-12">
        <AnimatePresence mode="wait">
          {steps.map((step, idx) => (
            <motion.div
              key={step.title}
              initial={{ opacity: 0, y: 50 }}
              animate={{ opacity: 1, y: 0 }}
              exit={{ opacity: 0, y: -50 }}
              transition={{ duration: 0.5, delay: idx * 0.1 }}
              className={`p-10 rounded-3xl bg-white border border-transparent hover:border-[var(--color-accent)] transition-all duration-300`}
            >
              <div className="flex justify-center mb-6">{step.icon}</div>
              <h3 className="text-2xl font-semibold text-[var(--color-text)] mb-3">
                {step.title}
              </h3>
              <p className="text-[var(--color-subtext)] leading-relaxed">
                {step.text}
              </p>
            </motion.div>
          ))}
        </AnimatePresence>
      </div>

      {/* Decorative glow */}
      <div className="absolute top-1/2 left-1/2 w-[600px] h-[600px] bg-pink-200/30 blur-[120px] rounded-full -translate-x-1/2 -translate-y-1/2 -z-10" />
    </section>
  );
};

export default HowItWorks;
