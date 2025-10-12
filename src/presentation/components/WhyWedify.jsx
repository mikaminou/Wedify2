import { motion } from "framer-motion";
import { Heart, Sparkles, Users, ShieldCheck } from "lucide-react";
import weddingImg from "../../assets/bg.jpg"; // replace with your best hero-style image

const WhyWedify = () => {
  return (
    <section className="relative overflow-hidden bg-gradient-to-b from-white to-pink-50 py-32">
      <div className="absolute top-0 right-0 w-[600px] h-[600px] bg-pink-200/30 blur-3xl rounded-full -translate-y-1/2 translate-x-1/2" />

      <div className="max-w-7xl mx-auto grid lg:grid-cols-2 gap-16 items-center px-6 md:px-16">
        {/* Image Side */}
        <motion.div
          initial={{ opacity: 0, x: -50 }}
          whileInView={{ opacity: 1, x: 0 }}
          transition={{ duration: 0.8 }}
          viewport={{ once: true }}
          className="relative"
        >
          <img
            src={weddingImg}
            alt="Algerian Wedding"
            className="rounded-[3rem] shadow-xl object-cover w-full h-[600px]"
          />
          <motion.div
            className="absolute -bottom-10 -left-10 bg-white p-6 rounded-3xl shadow-lg"
            initial={{ opacity: 0, y: 30 }}
            whileInView={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.8 }}
          >
            <h4 className="text-xl font-semibold text-[var(--color-text)]">10,000+ Love Stories</h4>
            <p className="text-[var(--color-subtext)]">Wedify brings Algerian couples and dream vendors together every day.</p>
          </motion.div>
        </motion.div>

        {/* Text Side */}
        <motion.div
          initial={{ opacity: 0, x: 50 }}
          whileInView={{ opacity: 1, x: 0 }}
          transition={{ duration: 0.8 }}
          viewport={{ once: true }}
        >
          <h2 className="text-5xl md:text-6xl font-bold text-[var(--color-text)] leading-tight mb-8">
            More than a Platform,<br /> a <span className="text-[var(--color-accent)] font-signature"> love revolution</span>
          </h2>
          <p className="text-lg text-[var(--color-subtext)] mb-12">
            Wedify isn’t just about booking — it’s about creating lasting connections, simplifying planning, and celebrating Algerian love stories beautifully.
          </p>

          <div className="grid grid-cols-2 gap-8">
            <div className="flex items-start gap-4">
              <Heart className="text-[var(--color-accent)] w-7 h-7" />
              <p className="text-[var(--color-text)]">Built for couples in love</p>
            </div>
            <div className="flex items-start gap-4">
              <Users className="text-[var(--color-accent)] w-7 h-7" />
              <p className="text-[var(--color-text)]">Connecting thousands of vendors</p>
            </div>
            <div className="flex items-start gap-4">
              <ShieldCheck className="text-[var(--color-accent)] w-7 h-7" />
              <p className="text-[var(--color-text)]">Secure & transparent</p>
            </div>
            <div className="flex items-start gap-4">
              <Sparkles className="text-[var(--color-accent)] w-7 h-7" />
              <p className="text-[var(--color-text)]">Inspired by true love stories</p>
            </div>
          </div>
        </motion.div>
      </div>
    </section>
  );
};

export default WhyWedify;
