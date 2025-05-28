document.addEventListener('DOMContentLoaded', () => {
    // DOM Elements
    const nav = document.querySelector('.navbar');
    const navToggle = document.querySelector('.nav-toggle');
    const navLinks = document.querySelector('.nav-links');
    const navHeight = nav.offsetHeight;
    let lastScroll = 0;

    // Mobile menu toggle
    const toggleMenu = () => {
        navLinks.classList.toggle('active');
        const icon = navToggle.querySelector('i');
        icon.classList.toggle('fa-bars');
        icon.classList.toggle('fa-times');
    };

    // Close mobile menu when clicking a link
    const closeMobileMenu = () => {
        if (window.innerWidth <= 768) {
            navLinks.classList.remove('active');
            const icon = navToggle.querySelector('i');
            icon.classList.remove('fa-times');
            icon.classList.add('fa-bars');
        }
    };

    // Smooth scroll for anchor links
    const smoothScroll = (e) => {
        e.preventDefault();
        const targetId = e.currentTarget.getAttribute('href');
        if (targetId === '#') return;
        
        const targetElement = document.querySelector(targetId);
        if (targetElement) {
            window.scrollTo({
                top: targetElement.offsetTop - navHeight,
                behavior: 'smooth'
            });
        }
        closeMobileMenu();
    };

    // Event Listeners
    navToggle.addEventListener('click', toggleMenu);

    // Add smooth scroll to all anchor links with href starting with #
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', smoothScroll);
    });

    // Navbar scroll effect
    const handleScroll = () => {
        const currentScroll = window.pageYOffset;
        
        // Add/remove scrolled class based on scroll position
        if (currentScroll > 50) {
            nav.classList.add('scrolled');
        } else {
            nav.classList.remove('scrolled');
        }
        
        // Hide/show navbar on scroll
        if (currentScroll <= 0) {
            nav.style.transform = 'translateY(0)';
            return;
        }
        
        if (currentScroll > lastScroll && currentScroll > navHeight) {
            // Scrolling down
            nav.style.transform = `translateY(-${navHeight}px)`;
        } else {
            // Scrolling up
            nav.style.transform = 'translateY(0)';
        }
        
        lastScroll = currentScroll;
    };

    // Initialize
    if (window.scrollY > 50) {
        nav.classList.add('scrolled');
    }

    // Event Listeners
    window.addEventListener('scroll', handleScroll);
    window.addEventListener('resize', () => {
        if (window.innerWidth > 768) {
            navLinks.classList.remove('active');
            const icon = navToggle.querySelector('i');
            icon.classList.remove('fa-times');
            icon.classList.add('fa-bars');
        }
    });

    // Close menu when clicking outside
    document.addEventListener('click', (e) => {
        if (window.innerWidth <= 768 && 
            !e.target.closest('.navbar') && 
            navLinks.classList.contains('active')) {
            closeMobileMenu();
        }
    });
});

// Add animation to feature cards on scroll
const animateOnScroll = () => {
    const featureCards = document.querySelectorAll('.feature-card');
    
    featureCards.forEach(card => {
        const cardPosition = card.getBoundingClientRect().top;
        const screenPosition = window.innerHeight / 1.3;
        
        if (cardPosition < screenPosition) {
            card.style.opacity = '1';
            card.style.transform = 'translateY(0)';
        }
    });
};

// Set initial styles for feature cards
document.querySelectorAll('.feature-card').forEach(card => {
    card.style.opacity = '0';
    card.style.transform = 'translateY(30px)';
    card.style.transition = 'opacity 0.6s ease, transform 0.6s ease';
});

// Listen for scroll events
window.addEventListener('scroll', animateOnScroll);
// Initial check in case cards are already in view
window.addEventListener('load', animateOnScroll);
