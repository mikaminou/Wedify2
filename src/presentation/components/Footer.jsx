// src/components/Footer.jsx
import React from "react";

const Footer = () => {
  return (
    <footer className="bg-[var(--color-primary)] text-text py-10 mt-20">
      <div className="container mx-auto px-6 text-center">
        <h2 className="text-2xl font-serif font-bold mb-4">Wedify</h2>
        <p className="mb-4 text-text/80">
          Plan your dream wedding effortlessly with Wedify. From venues to
          photographers, we make it simple.
        </p>
        <div className="flex justify-center gap-6 mb-4">
          {/* Example social icons */}
          <a
            href="#"
            className="text-accent hover:text-secondary transition-colors"
          >
            Instagram
          </a>
          <a
            href="#"
            className="text-accent hover:text-secondary transition-colors"
          >
            Facebook
          </a>
          <a
            href="#"
            className="text-accent hover:text-secondary transition-colors"
          >
            Pinterest
          </a>
        </div>
        <p className="text-text/70">
          &copy; {new Date().getFullYear()} Wedify. All rights reserved.
        </p>
      </div>
    </footer>
  );
};

export default Footer;
