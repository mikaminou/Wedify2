import {
  Search,
  CheckSquare,
  PiggyBank,
  Users,
  Monitor,
  Bookmark,
} from "lucide-react";

const tools = [
  {
    title: "Smart Venue Finder",
    description:
      "Discover the perfect wedding venue in any region of Algeria with ease and confidence.",
    icon: <Search className="w-8 h-8 text-[var(--color-highlight)]" />,
  },
  {
    title: "Personalized Checklist",
    description:
      "Plan your wedding step by step with a customized to-do list tailored to your style and preferences.",
    icon: <CheckSquare className="w-8 h-8 text-[var(--color-highlight)]" />,
  },
  {
    title: "Budget & Payment Tracker",
    description:
      "Keep track of all your bookings and payments in one place, staying stress-free and organized.",
    icon: <PiggyBank className="w-8 h-8 text-[var(--color-highlight)]" />,
  },
  {
    title: "Guest & RSVP Manager",
    description:
      "Easily manage your guest list, RSVPs, and communicate with your attendees effortlessly.",
    icon: <Users className="w-8 h-8 text-[var(--color-highlight)]" />,
  },
  {
    title: "Vendor Portfolios",
    description:
      "Explore detailed profiles of trusted vendors, view their work, and book directly online.",
    icon: <Monitor className="w-8 h-8 text-[var(--color-highlight)]" />,
  },
  {
    title: "Expert Recommendations",
    description:
      "Receive smart suggestions for vendors and services based on your preferences and wedding date.",
    icon: <Bookmark className="w-8 h-8 text-[var(--color-highlight)]" />,
  },
];


const Tools = () => (
  <section className="py-12 px-6 mt-20 text-center bg-[var(--color-background)]">
    <h2 className="text-4xl text-[var(--color-text)] mb-10">
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
          <h3 className="text-xl font-semibold text-[var(--color-dark)] mb-2">
            {tool.title}
          </h3>
          <p className="text-[var(--color-subtext)]">{tool.description}</p>
        </div>
      ))}
    </div>
  </section>
);

export default Tools;
