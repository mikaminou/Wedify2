import React from 'react';

const ServicesSection = () => {
    return (
        <section className="container bg-[var(--color-background)] mx-auto px-6 min-h-screen flex flex-col items-center justify-center">
                <h2 className="text-4xl font-bold text-center text-pink-900 mb-12">
                Our Services
                </h2>
                <div className="grid md:grid-cols-3 gap-10 mt-30">
                    <div className="bg-white rounded-2xl shadow-xl p-8 text-center hover:scale-105 transition-transform">
                        <h3 className="text-2xl font-semibold mb-4">Venues</h3>
                        <p>
                            Discover stunning venues in your region tailored to your style and budget.
                        </p>
                    </div>

                    <div className="bg-white rounded-2xl shadow-xl p-8 text-center hover:scale-105 transition-transform">
                        <h3 className="text-2xl font-semibold mb-4">Photography</h3>
                        <p>
                            Capture every precious moment with our professional photographers who specialize in weddings.
                        </p>
                    </div>

                    <div className="bg-white rounded-2xl shadow-xl p-8 text-center hover:scale-105 transition-transform">
                        <h3 className="text-2xl font-semibold mb-4">Beauty</h3>
                        <p>
                            Professional makeup and hairstyling to help you shine with confidence and elegance.
                        </p>
                    </div>

                    <div className="bg-white rounded-2xl shadow-xl p-8 text-center hover:scale-105 transition-transform">
                        <h3 className="text-2xl font-semibold mb-4">Clothing</h3>
                        <p>
                            From stunning white and and traditional dresses to elegant suits, tailored to your special day.
                        </p>
                    </div>

                    <div className="bg-white rounded-2xl shadow-xl p-8 text-center hover:scale-105 transition-transform">
                        <h3 className="text-2xl font-semibold mb-4">Catering</h3>
                        <p>
                            Delight your guests with curated menus from top chefs, customized for your celebration.
                        </p>
                    </div>

                    <div className="bg-white rounded-2xl shadow-xl p-8 text-center hover:scale-105 transition-transform">
                        <h3 className="text-2xl font-semibold mb-4">DJ & Music</h3>
                        <p>
                            Professional DJs and live music to keep your celebration unforgettable.
                        </p>
                    </div>

                    
                </div>
        </section>
    );
};

export default ServicesSection;