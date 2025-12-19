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
      icon: <Heart className="w-10 h-10 text-[var(--color-secondary)]" />,
      title: "Find Your Vendors",
      text: "Discover trusted professionals near you — from photographers to venues.",
    },
    {
      icon: <MessageCircle className="w-10 h-10 text-[var(--color-secondary)]" />,
      title: "Chat & Plan",
      text: "Message vendors directly, discuss your vision, and make your dream come true.",
    },
    {
      icon: <Calendar className="w-10 h-10 text-[var(--color-secondary)]" />,
      title: "Book & Relax",
      text: "Reserve your date online and enjoy stress-free planning.",
    },
  ];

  const vendorsSteps = [
    {
      icon: <Briefcase className="w-10 h-10 text-[var(--color-secondary)]" />,
      title: "Create Your Portfolio",
      text: "Showcase your work beautifully and attract ideal couples.",
    },
    {
      icon: <Users className="w-10 h-10 text-[var(--color-secondary)]" />,
      title: "Get Real Bookings",
      text: "Receive confirmed reservations directly from couples.",
    },
    {
      icon: <Star className="w-10 h-10 text-[var(--color-secondary)]" />,
      title: "Grow Your Business",
      text: "Build trust, gain exposure, and grow your brand on Wedify.",
    },
  ];

  const steps = view === "couples" ? couplesSteps : vendorsSteps;

  return (
    <section
      className={`relative py-24 px-6 md:px-16 text-center overflow-hidden transition-colors duration-700 !mb-20 ${
        view === "couples"
          ? "bg-gradient-to-b from-[#fffaf6] to-[#fdf8f3]"
          : "bg-gradient-to-b from-[#fdfcfb] to-[#f8f6f1]"
      }`}
    >
      {/* Title */}
      <div className="mt-16 mb-16">
        <h2 className="text-5xl md:text-6xl font-bold text-[var(--color-text)] !mb-6">
          How It Works
        </h2>

          {/* Toggle Switch */}
          <div className="relative inline-flex gap-4">
              <button
                  onClick={() => setView("couples")}
                  className={`relative z-10 min-w-[140px] px-6 py-3 rounded-full font-medium transition-all duration-300 ${
                      view === "couples"
                          ? "bg-[var(--color-secondary)] text-white shadow-lg"
                          : "bg-transparent text-[var(--color-text)] hover:bg-[var(--color-secondary)]/10"
                  }`}
              >
                  For Couples
              </button>
              <button
                  onClick={() => setView("vendors")}
                  className={`relative z-10 min-w-[140px] px-6 py-3 rounded-full font-medium transition-all duration-300 ${
                      view === "vendors"
                          ? "bg-[var(--color-secondary)] text-white shadow-lg"
                          : "bg-transparent text-[var(--color-text)] hover:bg-[var(--color-secondary)]/10"
                  }`}
              >
                  For Vendors
              </button>
          </div>

      </div>

      {/* Animated Cards */}
      <div className="max-w-6xl mx-auto grid grid-cols-1 md:grid-cols-3 gap-10 mt-12">
        <AnimatePresence mode="wait">
          {steps.map((step, idx) => (
            <motion.div
              key={step.title}
              initial={{ opacity: 0, y: 40 }}
              animate={{ opacity: 1, y: 0 }}
              exit={{ opacity: 0, y: -40 }}
              transition={{ duration: 0.5, delay: idx * 0.1 }}
              className="p-10 rounded-3xl bg-white border border-transparent hover:border-[var(--color-highlight)] hover:shadow-[0_0_20px_rgba(0,0,0,0.05)] transition-all duration-300"
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
      <div className="absolute top-1/2 left-1/2 w-[600px] h-[600px] bg-[var(--color-highlight)]/10 blur-[120px] rounded-full -translate-x-1/2 -translate-y-1/2 -z-10" />
    </section>
  );
};

export default HowItWorks;
