// src/presentation/components/Tools.jsx
import { Search, CheckSquare, PiggyBank, Users, Monitor, Bookmark } from "lucide-react";

const tools = [
  { title: "Venue Finder", description: "Explore thousands of stunning wedding venues.", icon: <Search className="w-8 h-8 text-purple-300" />, bg: "bg-purple-100" },
  { title: "Smart Checklist", description: "Your personalized wedding to-do list.", icon: <CheckSquare className="w-8 h-8 text-green-300" />, bg: "bg-green-100" },
  { title: "Budget Planner", description: "Track your wedding expenses effortlessly.", icon: <PiggyBank className="w-8 h-8 text-red-300" />, bg: "bg-red-100" },
  { title: "Guest Manager", description: "Easily organize your guest list and RSVPs.", icon: <Users className="w-8 h-8 text-teal-300" />, bg: "bg-teal-100" },
  { title: "Wedding Website", description: "Share all your wedding details with guests.", icon: <Monitor className="w-8 h-8 text-pink-300" />, bg: "bg-pink-100" },
  { title: "Expert Tips", description: "Get inspired with professional advice.", icon: <Bookmark className="w-8 h-8 text-yellow-300" />, bg: "bg-yellow-100" },
];

const Tools = () => (
  <section className="py-12 px-6 text-center">
    <h2 className="text-3xl font-bold text-[var(--color-text)] mb-10">
      Stress-free wedding planning starts with our free, personalized tools
    </h2>
    <div className="grid grid-cols-1 md:grid-cols-3 gap-6 max-w-5xl mx-auto mt-20 mb-20">
      {tools.map((tool, idx) => (
        <div key={idx} className={`${tool.bg} rounded-2xl p-6 shadow-sm hover:shadow-lg transition duration-300`}>
          <div className="flex justify-center mb-4">{tool.icon}</div>
          <h3 className="text-xl font-semibold text-[var(--color-text)] mb-2">{tool.title}</h3>
          <p className="text-gray-600">{tool.description}</p>
        </div>
      ))}
    </div>
  </section>
);

export default Tools;
