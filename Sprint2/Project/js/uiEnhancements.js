// Testimonial Slider functionality
class TestimonialSlider {
    constructor() {
        this.currentSlide = 0;
        this.testimonials = [
            {
                text: "The customization options are incredible! My shoes are exactly what I wanted.",
                author: "Sarah M.",
                rating: 5
            },
            {
                text: "Outstanding quality and the fit is perfect. Worth every penny!",
                author: "James R.",
                rating: 5
            },
            {
                text: "The attention to detail is amazing. These are now my favorite shoes.",
                author: "Emily K.",
                rating: 5
            }
        ];
        this.initializeSlider();
    }

    initializeSlider() {
        const slider = document.querySelector('.testimonial-slider');
        if (!slider) return;

        // Create slider structure
        this.createSliderStructure(slider);

        // Start auto-rotation
        this.startAutoRotation();

        // Add navigation event listeners
        this.addNavigationListeners();
    }

    createSliderStructure(slider) {
        // Clear existing content
        slider.innerHTML = '';

        // Create slider container
        const sliderContainer = document.createElement('div');
        sliderContainer.className = 'testimonial-container';

        // Create slides
        this.testimonials.forEach((testimonial, index) => {
            const slide = document.createElement('div');
            slide.className = `testimonial-slide ${index === 0 ? 'active' : ''}`;
            
            const stars = '⭐'.repeat(testimonial.rating);
            
            slide.innerHTML = `
                <div class="testimonial-content">
                    <div class="testimonial-rating">${stars}</div>
                    <p class="testimonial-text">${testimonial.text}</p>
                    <p class="testimonial-author">- ${testimonial.author}</p>
                </div>
            `;
            
            sliderContainer.appendChild(slide);
        });

        // Create navigation dots
        const dotsContainer = document.createElement('div');
        dotsContainer.className = 'testimonial-dots';
        
        this.testimonials.forEach((_, index) => {
            const dot = document.createElement('button');
            dot.className = `testimonial-dot ${index === 0 ? 'active' : ''}`;
            dot.setAttribute('aria-label', `Go to testimonial ${index + 1}`);
            dotsContainer.appendChild(dot);
        });

        slider.appendChild(sliderContainer);
        slider.appendChild(dotsContainer);
    }

    startAutoRotation() {
        setInterval(() => this.nextSlide(), 5000);
    }

    addNavigationListeners() {
        const dots = document.querySelectorAll('.testimonial-dot');
        dots.forEach((dot, index) => {
            dot.addEventListener('click', () => this.goToSlide(index));
        });
    }

    nextSlide() {
        this.goToSlide((this.currentSlide + 1) % this.testimonials.length);
    }

    goToSlide(index) {
        const slides = document.querySelectorAll('.testimonial-slide');
        const dots = document.querySelectorAll('.testimonial-dot');

        slides[this.currentSlide].classList.remove('active');
        dots[this.currentSlide].classList.remove('active');

        this.currentSlide = index;

        slides[this.currentSlide].classList.add('active');
        dots[this.currentSlide].classList.add('active');
    }
}

// Sticky navbar functionality
function initStickyNav() {
    const header = document.querySelector('.header');
    const headerHeight = header.offsetHeight;
    let lastScroll = 0;

    window.addEventListener('scroll', () => {
        const currentScroll = window.pageYOffset;

        if (currentScroll <= headerHeight) {
            header.classList.remove('header-hidden');
            return;
        }

        if (currentScroll > lastScroll && !header.classList.contains('header-hidden')) {
            // Scrolling down
            header.classList.add('header-hidden');
        } else if (currentScroll < lastScroll && header.classList.contains('header-hidden')) {
            // Scrolling up
            header.classList.remove('header-hidden');
        }

        lastScroll = currentScroll;
    });
}

// Update footer year
function updateFooterYear() {
    const yearElement = document.querySelector('.footer-bottom p');
    if (yearElement) {
        const currentYear = new Date().getFullYear();
        yearElement.innerHTML = `&copy; ${currentYear} SoleVibe. All rights reserved.`;
    }
}

// Initialize all UI enhancements
document.addEventListener('DOMContentLoaded', () => {
    new TestimonialSlider();
    initStickyNav();
    updateFooterYear();
});