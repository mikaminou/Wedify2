import { Search, CheckSquare, PiggyBank, Users, Monitor, Bookmark } from "lucide-react";

export default function WeddingTools() {
  const tools = [
    {
      title: "Venue Finder",
      description: "Explore thousands of stunning wedding venues to make your day unforgettable.",
      icon: <Search className="w-8 h-8 text-gray-700" />,
      bg: "bg-purple-100"
    },
    {
      title: "Smart Checklist",
      description: "Your personalized wedding to-do list, packed with expert tips.",
      icon: <CheckSquare className="w-8 h-8 text-gray-700" />,
      bg: "bg-green-100"
    },
    {
      title: "Budget Planner",
      description: "Track your wedding expenses effortlessly and stay stress-free.",
      icon: <PiggyBank className="w-8 h-8 text-gray-700" />,
      bg: "bg-red-100"
    },
    {
      title: "Guest Manager",
      description: "Easily organize your guest list and RSVPs in one place.",
      icon: <Users className="w-8 h-8 text-gray-700" />,
      bg: "bg-teal-100"
    },
    {
      title: "Wedding Website",
      description: "Share all your wedding details and keep your guests excited.",
      icon: <Monitor className="w-8 h-8 text-gray-700" />,
      bg: "bg-pink-100"
    },
    {
      title: "Expert Tips",
      description: "Get inspired with professional advice for your dream wedding.",
      icon: <Bookmark className="w-8 h-8 text-gray-700" />,
      bg: "bg-yellow-100"
    }
  ];

  return (
    <section className="py-12 px-6 text-center">
      <h2 className="text-3xl font-bold text-gray-800 mb-10">
        Stress-free wedding planning <br /> starts with our free, personalized tools.
      </h2>
      
      <div className="grid grid-cols-1 md:grid-cols-3 gap-6 max-w-5xl mx-auto mt-20 mb-20">
        {tools.map((tool, index) => (
          <div
            key={index}
            className={`${tool.bg} rounded-2xl p-6 shadow-sm hover:shadow-lg transition`}
          >
            <div className="flex justify-center mb-4">{tool.icon}</div>
            <h3 className="text-xl font-semibold text-gray-800 mb-2">{tool.title}</h3>
            <p className="text-gray-600">{tool.description}</p>
          </div>
        ))}
      </div>
    </section>
  );
}
