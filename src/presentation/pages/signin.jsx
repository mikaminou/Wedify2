import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const SignIn = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(""); // for error messages
  const navigate = useNavigate(); // to redirect after login

  const handleSubmit = async (e) => {
  e.preventDefault(); // prevent page reload
  setError(""); // clear previous errors

  try {
    const response = await fetch("http://localhost:5000/api/auth/signin", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email, password }),
    });

    const data = await response.json();

    if (!response.ok) {
      setError(data.message || "Something went wrong");
      return;
    }

    // Save token or user info in localStorage (or context)
    localStorage.setItem("token", data.token);
    localStorage.setItem("user", JSON.stringify(data.user));

    // Redirect to dashboard/home page
    navigate("/dashboard");
  } catch (err) {
    console.error(err);
    setError("Network error. Please try again later.");
  }
};

  return (
    <div className="min-h-screen flex flex-col items-center justify-center bg-gradient-to-br from-pink-100 via-white to-purple-100 relative">
      {/* Logo */}
      <Link
        to="/"
        className="mb-16"
      >
        <h1 className="text-5xl font-serif font-bold">
          Wedify
        </h1>
      </Link>
      {/* Glass Card */}
      <div className="w-full max-w-md bg-white/30 backdrop-blur-xl shadow-xl rounded-2xl p-8 border border-white/40">
        <h2 className="text-3xl font-bold text-center text-[var(--color-text)] mb-6">
          Welcome Back
        </h2>
        <form className="space-y-6 m-6" onSubmit={handleSubmit}>
          <div>
            <label className="block text-sm font-medium text-gray-700 mb-1">
              Email
            </label>
            <input
              type="email"
              placeholder="Enter your email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              className="w-full px-4 py-2 rounded-lg bg-white/60 backdrop-blur-sm border border-gray-200 focus:outline-none focus:ring-2 focus:ring-[var(--color-accent)]"
            />
          </div>
          <div>
            <label className="block text-sm font-medium text-gray-700 mb-1">
              Password
            </label>
            <input
              type="password"
              placeholder="Enter your password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              className="w-full px-4 py-2 rounded-lg bg-white/60 backdrop-blur-sm border border-gray-200 focus:outline-none focus:ring-2 focus:ring-[var(--color-accent)]"
            />
          </div>
          {error && <p className="text-red-500 text-sm mb-2 text-center">{error}</p>}
          <button
            type="submit"
            className="w-full py-3 rounded-lg bg-[var(--color-accent)] text-white font-medium hover:bg-[var(--color-accent-dark)] transition shadow-md"
          >
            Sign In
          </button>
        </form>
        <p className="text-center text-gray-600 mt-6">
          Don’t have an account?{" "}
          <a href="/signup" className="text-[var(--color-accent)] font-semibold hover:underline">
            Sign Up
          </a>
        </p>
      </div>
    </div>
  );
};

export default SignIn;
