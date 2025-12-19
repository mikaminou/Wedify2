import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { supabase } from "../../lib/supabaseClient";


const SignUp = () => {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: "",
    confirmPassword: "",
    role: "couple",
  });
  const [loading, setLoading] = useState(false);

  const [error, setError] = useState("");

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");

    if (formData.password !== formData.confirmPassword) {
      return setError("Passwords do not match.");
    }
    try {
      setLoading(true);
      // 1) Create the user in supabase auth
      const { data: signUpData, error: signUpError } = await supabase.auth.signUp({
        email: formData.email,
        password: formData.password,
      });

      if (signUpError) {
        setError(signUpError.message);
        return;
      }

      // 2) Create a profile row in the "profiles" table
      const {error: profileError } = await supabase
        .from("profiles")
        .insert([
          {
            id: signUpData.user.id, // use auth user id
            email: formData.email,
            name: formData.name,
            role: formData.role, // "couple" or "vendor"
          },
        ]);

      if (profileError) {
        setError(profileError.message);
        return;
        }

        alert("Sign up successful! Please check your email to confirm your account.");
        navigate("/signin");

    } catch (err) {
      setError("Something went wrong.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="min-h-screen flex flex-col items-center justify-center bg-gradient-to-br from-gray-300 to-pink-100 relative">
      {/* Logo */}
      <Link to="/" className="mb-16">
        <h1 className="text-5xl font-serif font-bold">Wedify</h1>
      </Link>

      {/* Glass Card */}
      <div className="w-full max-w-md bg-white/30 backdrop-blur-xl shadow-xl rounded-2xl p-8 border border-white/40">
        <h2 className="text-3xl font-bold text-center text-[var(--color-text)] mb-6">
          Create Your Account
        </h2>

        {error && (
          <p className="text-center text-red-500 bg-red-200 p-2 mt-5 rounded mb-4">
            {error}
          </p>
        )}

        <form className="space-y-5 m-6" onSubmit={handleSubmit}>
          <input
            type="text"
            name="name"
            placeholder="Full Name"
            value={formData.name}
            onChange={handleChange}
            className="w-full px-4 py-2 rounded-lg bg-white/60 border border-gray-200 focus:outline-none focus:ring-2 focus:ring-[var(--color-accent)]"
          />
          <input
            type="email"
            name="email"
            placeholder="Email"
            value={formData.email}
            onChange={handleChange}
            className="w-full px-4 py-2 rounded-lg bg-white/60 border border-gray-200 focus:outline-none focus:ring-2 focus:ring-[var(--color-accent)]"
          />
          <input
            type="password"
            name="password"
            placeholder="Password"
            value={formData.password}
            onChange={handleChange}
            className="w-full px-4 py-2 rounded-lg bg-white/60 border border-gray-200 focus:outline-none focus:ring-2 focus:ring-[var(--color-accent)]"
          />
          <input
            type="password"
            name="confirmPassword"
            placeholder="Confirm Password"
            value={formData.confirmPassword}
            onChange={handleChange}
            className="w-full px-4 py-2 rounded-lg bg-white/60 border border-gray-200 focus:outline-none focus:ring-2 focus:ring-[var(--color-accent)]"
          />

          {/* Role Selection */}
          <div className="flex justify-around mt-4">
            <label className="flex items-center space-x-2 cursor-pointer">
              <input
                type="radio"
                name="role"
                value="couple"
                checked={formData.role === "couple"}
                onChange={handleChange}
              />
              <span>I'm a Couple</span>
            </label>
            <label className="flex items-center space-x-2 cursor-pointer">
              <input
                type="radio"
                name="role"
                value="vendor"
                checked={formData.role === "vendor"}
                onChange={handleChange}
              />
              <span>I'm a Vendor</span>
            </label>
          </div>

          <button
            type="submit"
            disabled={loading}
            className="w-full py-3 rounded-lg bg-[var(--color-accent)] text-white font-medium hover:bg-[var(--color-accent-dark)] transition shadow-md"
          >
            {loading ? "Signing Up..." : "Sign Up"}
          </button>
        </form>

        <p className="text-center text-gray-600 mt-6">
          Already have an account?{" "}
          <Link
            to="/signin"
            className="text-[var(--color-accent)] font-semibold hover:underline"
          >
            Sign In
          </Link>
        </p>
      </div>
    </div>
  );
};

export default SignUp;
