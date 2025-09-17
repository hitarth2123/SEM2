// Contact Form Handling
const contactForm = document.getElementById('contactForm');
if (contactForm) {
    contactForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const formData = new FormData(contactForm);
        const formObject = Object.fromEntries(formData);
        console.log('Form submitted:', formObject);
        // Here you would typically send the data to a server
        alert('Thank you for your message! We will get back to you soon.');
        contactForm.reset();
    });
}

// Product Filtering and Display
const products = [
    {
        id: 1,
        name: 'SoleVibes Runner',
        price: 129.99,
        sport: 'running',
        size: [7, 8, 9, 10],
        image: 'images/runner.svg',
        inventory: 50,
        color: ['red', 'blue', 'black']
    },
    {
        id: 2,
        name: 'SoleVibes Hoops',
        price: 149.99,
        sport: 'basketball',
        size: [8, 9, 10],
        image: 'images/basketball.svg',
        inventory: 35,
        color: ['blue', 'white', 'black']
    },
    {
        id: 3,
        name: 'SoleVibes Trainer',
        price: 89.99,
        sport: 'training',
        size: [7, 8, 9, 10],
        image: 'images/trainer.svg',
        inventory: 65,
        color: ['green', 'gray', 'black']
    }
];

// Cart functionality
let cart = [];
const cartCount = document.getElementById('cart-count');

function updateCartCount() {
    if (cartCount) {
        cartCount.textContent = cart.length;
    }
}

function addToCart(productId) {
    const product = products.find(p => p.id === productId);
    if (product && product.inventory > 0) {
        cart.push(product);
        product.inventory--;
        updateCartCount();
        updateProductDisplay();
    }
}

// Product filtering
const productsGrid = document.getElementById('products-grid');
const sortOptions = document.getElementById('sort-options');

function filterProducts() {
    let filteredProducts = [...products];

    // Get all active filters
    const categoryFilters = document.querySelectorAll('input[type="checkbox"]:checked');
    const selectedSize = document.querySelector('.size-btn.active');
    const selectedPrice = document.querySelector('input[name="price"]:checked');
    const selectedColors = document.querySelectorAll('.color-btn.active');

    // Apply category filters
    if (categoryFilters.length > 0) {
        filteredProducts = filteredProducts.filter(product =>
            Array.from(categoryFilters).some(filter => product.sport === filter.value)
        );
    }

    // Apply size filter
    if (selectedSize) {
        const size = parseInt(selectedSize.textContent);
        filteredProducts = filteredProducts.filter(product =>
            product.size.includes(size)
        );
    }

    // Apply price filter
    if (selectedPrice) {
        filteredProducts = filteredProducts.filter(product =>
            matchPriceRange(product.price, selectedPrice.value)
        );
    }

    // Apply color filters
    if (selectedColors.length > 0) {
        const colors = Array.from(selectedColors).map(btn => 
            window.getComputedStyle(btn).backgroundColor
        );
        filteredProducts = filteredProducts.filter(product =>
            product.color.some(c => colors.includes(c))
        );
    }

    return filteredProducts;
}

function matchPriceRange(price, range) {
    switch(range) {
        case '0-50': return price <= 50;
        case '51-100': return price > 50 && price <= 100;
        case '101-150': return price > 100 && price <= 150;
        case '151+': return price > 150;
        default: return true;
    }
}

function updateProductDisplay() {
    if (!productsGrid) return;

    const filteredProducts = filterProducts();
    
    // Apply sorting
    if (sortOptions) {
        const sortValue = sortOptions.value;
        filteredProducts.sort((a, b) => {
            switch(sortValue) {
                case 'price-low-high': return a.price - b.price;
                case 'price-high-low': return b.price - a.price;
                case 'newest': return b.id - a.id;
                default: return 0;
            }
        });
    }

    productsGrid.innerHTML = '';

    filteredProducts.forEach(product => {
        const productCard = document.createElement('div');
        productCard.className = 'product-card';
        productCard.innerHTML = `
            <div class="product-image-container">
                <img class="product-image product-image-zoom" src="${product.image}" alt="${product.name}">
            </div>
            <div class="product-info">
                <h3>${product.name}</h3>
                <p>$${product.price.toFixed(2)}</p>
                <p>Available: ${product.inventory}</p>
                <button onclick="addToCart(${product.id})" ${product.inventory === 0 ? 'disabled' : ''}>
                    ${product.inventory === 0 ? 'Out of Stock' : 'Add to Cart'}
                </button>
            </div>
        `;
        productsGrid.appendChild(productCard);
    });
}

// Event Listeners for Filters
const filterButtons = document.querySelectorAll('.size-btn, .color-btn');
filterButtons.forEach(btn => {
    btn.addEventListener('click', () => {
        if (btn.classList.contains('size-btn')) {
            document.querySelectorAll('.size-btn').forEach(b => b.classList.remove('active'));
        } else if (btn.classList.contains('color-btn')) {
            btn.classList.toggle('active');
        }
        btn.classList.add('active');
        updateProductDisplay();
    });
});

const categoryCheckboxes = document.querySelectorAll('input[type="checkbox"]');
categoryCheckboxes.forEach(checkbox => {
    checkbox.addEventListener('change', updateProductDisplay);
});

const priceRadios = document.querySelectorAll('input[name="price"]');
priceRadios.forEach(radio => {
    radio.addEventListener('change', updateProductDisplay);
});

if (sortOptions) {
    sortOptions.addEventListener('change', updateProductDisplay);
}

// Initialize product display
document.addEventListener('DOMContentLoaded', () => {
    updateProductDisplay();
    updateCartCount();
});

// Real-time inventory update simulation
setInterval(() => {
    products.forEach(product => {
        if (Math.random() < 0.1 && product.inventory > 0) {
            product.inventory--;
            updateProductDisplay();
        }
    });
}, 5000);