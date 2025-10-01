import { Search, CheckSquare, PiggyBank, Users, Monitor, Bookmark } from "lucide-react";

const tools = [
  { title: "Venue Finder", description: "Explore thousands of stunning wedding venues to make your day unforgettable.", icon: <Search className="w-8 h-8 text-[var(--color-accent)]" /> },
  { title: "Smart Checklist", description: "Your personalized wedding to-do list, packed with expert tips.", icon: <CheckSquare className="w-8 h-8 text-[var(--color-accent)]" /> },
  { title: "Budget Planner", description: "Track your wedding expenses effortlessly and stay stress-free.", icon: <PiggyBank className="w-8 h-8 text-[var(--color-accent)]" /> },
  { title: "Guest Manager", description: "Easily organize your guest list and RSVPs in one place.", icon: <Users className="w-8 h-8 text-[var(--color-accent)]" /> },
  { title: "Wedding Website", description: "Share all your wedding details and keep your guests excited.", icon: <Monitor className="w-8 h-8 text-[var(--color-accent)]" /> },
  { title: "Expert Tips", description: "Get inspired with professional advice for your dream wedding.", icon: <Bookmark className="w-8 h-8 text-[var(--color-accent)]" /> },
];

const Tools = () => (
  <section className="py-12 px-6 text-center bg-[var(--color-background)]">
    <h2 className="text-3xl font-handwriting text-[var(--color-dark)] mb-10">
      Stress-free wedding planning starts with our free, personalized tools
    </h2>
    <div className="grid grid-cols-1 md:grid-cols-3 gap-8 max-w-6xl mx-auto mt-12">
      {tools.map((tool, idx) => (
        <div
          key={idx}
          className="bg-white rounded-2xl p-8 shadow-lg hover:shadow-2xl transition-shadow duration-300 flex flex-col items-center text-center"
        >
          <div className="flex justify-center mb-4 p-4 rounded-full bg-[var(--color-primary)]">
            {tool.icon}
          </div>
          <h3 className="text-xl font-semibold text-[var(--color-dark)] mb-2">{tool.title}</h3>
          <p className="text-[var(--color-subtext)]">{tool.description}</p>
        </div>
      ))}
    </div>
  </section>
);

export default Tools;
