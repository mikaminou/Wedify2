import { useState, useEffect } from "react";
import { Menu, X } from "lucide-react";
import { Link } from "react-router-dom";

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
    <nav className="fixed top-0 left-0 w-full z-10 bg-white/70 backdrop-blur-md shadow-sm">
      <div className="container mx-auto flex justify-between items-center px-6 py-4">
        {/* Logo */}
        <h1 className="text-2xl font-bold text-[var(--color-text)] transition-colors duration-300">
          Wedify
        </h1>

        {/* Center Links */}
        <ul className="hidden md:flex gap-8 font-medium mx-auto text-[var(--color-text)]">
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
          <Link
            to="/signin"
            className="text-[var(--color-text)] hover:text-[var(--color-accent)] transition"
          >
            Sign In
          </Link>
          <Link
            to="/signup"
            className="px-4 py-2 rounded-lg bg-[var(--color-button-bg)] !text-white font-medium hover:bg-[var(--color-accent-dark)] transition"
          >
            Sign Up
          </Link>
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
              <Link
                to="/signin"
                className="text-[var(--color-text)] hover:text-[var(--color-accent)] transition"
              >
                Sign In
              </Link>
              <Link
                to="/signup"
                className="w-full px-4 py-2 rounded-lg bg-[var(--color-accent)] text-white font-medium hover:bg-[var(--color-accent-dark)] transition"
              >
                Sign Up
              </Link>
            </div>
          </ul>
        </div>
      )}
    </nav>
  );
};

export default Navbar;
