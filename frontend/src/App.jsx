// src/App.jsx
import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import MainLayout from "./presentation/layouts/MainLayout";
import AuthLayout from "./presentation/layouts/AuthLayout";

import Home from "./presentation/pages/Home";
import ServicesSection from "./presentation/components/ServicesSection";
import Tools from "./presentation/components/Tools";

import SignIn from "./presentation/pages/SignIn";
import SignUp from "./presentation/pages/SignUp";

const App = () => {
  return (
    <Routes>
      {/* Public pages with Navbar + Footer */}
      <Route element={<MainLayout />}>
        <Route path="/" element={<Home />} />
        <Route path="/services" element={<ServicesSection />} />
        <Route path="/tools" element={<Tools />} />
      </Route>

      {/* Auth pages without Navbar + Footer */}
      <Route element={<AuthLayout />}>
        <Route path="/signin" element={<SignIn />} />
        <Route path="/signup" element={<SignUp />} />
      </Route>
    </Routes>
  );
};

export default App;
