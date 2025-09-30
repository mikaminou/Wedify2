import { useState, useEffect } from "react";
import { Menu, X } from "lucide-react";

const Navbar = () => {
  const [isOpen, setIsOpen] = useState(false);
  const [scrolled, setScrolled] = useState(false);

  const navLinks = ["Home", "About", "Services", "Contact"];

  // Détection du scroll
  useEffect(() => {
    const handleScroll = () => {
      setScrolled(window.scrollY > 50);
    };
    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  return (
    <nav
      className={`fixed top-0 left-0 w-full z-50 transform transition-all duration-500 ${
        scrolled
          ? "bg-white/60 backdrop-blur-md shadow-sm opacity-100 translate-y-0"
          : "bg-transparent opacity-90 -translate-y-1"
      }`}
    >
      <div className="container mx-auto flex justify-between items-center px-6 py-4">
        {/* Logo */}
        <h1 className="text-2xl font-bold text-[var(--color-text)]">Wedify</h1>

        {/* Center Links */}
        <ul className="hidden md:flex gap-8 text-[var(--color-text)] font-medium mx-auto">
          {navLinks.map((link, idx) => (
            <li
              key={idx}
              className="hover:text-[var(--color-accent)] transition-colors duration-300 cursor-pointer"
            >
              {link}
            </li>
          ))}
        </ul>

        {/* Buttons */}
        <div className="hidden md:flex gap-4 items-center">
          <button className="text-[var(--color-text)] hover:text-[var(--color-accent)] transition">
            Sign In
          </button>
          <button className="px-4 py-2 rounded-lg bg-[var(--color-accent)] text-white font-medium hover:bg-[var(--color-accent-dark)] transition">
            Sign Up
          </button>
        </div>

        {/* Mobile menu button */}
        <button
          className="md:hidden text-[var(--color-text)]"
          onClick={() => setIsOpen(!isOpen)}
          aria-label="Toggle menu"
        >
          {isOpen ? <X size={28} /> : <Menu size={28} />}
        </button>
      </div>

      {/* Mobile Menu */}
      {isOpen && (
        <div className="md:hidden bg-white/70 backdrop-blur-md shadow-sm animate-fadeIn">
          <ul className="flex flex-col items-center gap-6 py-6 text-[var(--color-text)] font-medium">
            {navLinks.map((link, idx) => (
              <li
                key={idx}
                className="hover:text-[var(--color-accent)] transition-colors duration-300 cursor-pointer"
              >
                {link}
              </li>
            ))}
            <div className="flex flex-col gap-4 mt-4 w-3/4 items-center">
              <button className="text-[var(--color-text)] hover:text-[var(--color-accent)] transition">
                Sign In
              </button>
              <button className="w-full px-4 py-2 rounded-lg bg-[var(--color-accent)] text-white font-medium hover:bg-[var(--color-accent-dark)] transition">
                Sign Up
              </button>
            </div>
          </ul>
        </div>
      )}
    </nav>
  );
};

export default Navbar;
