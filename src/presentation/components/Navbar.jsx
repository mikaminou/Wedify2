import { useState } from "react";
import { Menu, X } from "lucide-react";

const Navbar = () => {
  const [isOpen, setIsOpen] = useState(false);

  const navLinks = ["Home", "About", "Services", "Contact"];

  return (
    <nav className="top-0 z-50 bg-gradient-to-r from-[var(--color-E6A4B4)] to-[var(--color-background)] shadow-md">
      <div className="container mx-auto flex justify-between items-center px-6 py-4">
        {/* Logo */}
        <h1 className="text-2xl font-bold text-[var(--color-text)]">Wedify</h1>

        {/* Desktop Links */}
        <div className="flex items-center">
          <ul className="hidden md:flex gap-8 text-[var(--color-text)] font-medium">
            {navLinks.map((link, idx) => (
              <li
                key={idx}
                className="hover:text-[var(--color-accent)] transition-colors duration-300 cursor-pointer"
              >
                {link}
              </li>
            ))}
          </ul>
          {/* Mobile menu button */}
          <button
            className="md:hidden text-[var(--color-text)]"
            onClick={() => setIsOpen(!isOpen)}
            aria-label="Toggle menu"
          >
            {isOpen ? <X size={28} /> : <Menu size={28} />}
          </button>
        </div>
      </div>

      {/* Mobile Menu */}
      {isOpen && (
        <div className="md:hidden bg-gradient-to-r from-[var(--color-primary)] to-[var(--color-secondary)] shadow-lg border-t border-[var(--color-accent)]">
          <ul className="flex flex-col items-center gap-6 py-6 text-[var(--color-text)] font-medium">
            {navLinks.map((link, idx) => (
              <li
                key={idx}
                className="hover:text-[var(--color-accent)] transition-colors duration-300 cursor-pointer"
              >
                {link}
              </li>
            ))}
          </ul>
        </div>
      )}
    </nav>
  );
};

export default Navbar;
