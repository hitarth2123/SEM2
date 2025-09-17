// Customizer State Management
const customizerState = {
    style: 'runner',
    colors: {
        upper: '#1A1A1A',
        sole: '#FFFFFF'
    },
    size: null,
    artwork: null,
    rotation: 0,
    zoom: 1,
    prices: {
        base: 160.00,
        artwork: 0.00
    }
};

// DOM Elements
const shoeBase = document.getElementById('shoe-base');
const colorOverlay = document.getElementById('color-overlay');
const patternOverlay = document.getElementById('pattern-overlay');
const customArt = document.getElementById('custom-art');

// Style Selection
const styleButtons = document.querySelectorAll('.style-btn');
styleButtons.forEach(btn => {
    btn.addEventListener('click', () => {
        styleButtons.forEach(b => b.classList.remove('active'));
        btn.classList.add('active');
        customizerState.style = btn.dataset.style;
        updateShoePreview();
    });
});

// Color Selection
const colorButtons = document.querySelectorAll('.color-btn');
colorButtons.forEach(btn => {
    btn.addEventListener('click', () => {
        const part = btn.dataset.part;
        const color = window.getComputedStyle(btn).backgroundColor;
        customizerState.colors[part] = color;
        updateShoePreview();
    });
});

// Size Selection
const sizeButtons = document.querySelectorAll('.size-btn');
sizeButtons.forEach(btn => {
    btn.addEventListener('click', () => {
        sizeButtons.forEach(b => b.classList.remove('active'));
        btn.classList.add('active');
        customizerState.size = btn.dataset.size;
    });
});

// Artwork Upload
const artUpload = document.getElementById('art-upload');
artUpload.addEventListener('change', (e) => {
    const file = e.target.files[0];
    if (file) {
        if (file.size > 5 * 1024 * 1024) { // 5MB limit
            alert('File size exceeds 5MB limit');
            return;
        }

        const reader = new FileReader();
        reader.onload = (event) => {
            customizerState.artwork = event.target.result;
            customizerState.prices.artwork = 50.00; // Add artwork fee
            updateShoePreview();
            updatePriceDisplay();
        };
        reader.readAsDataURL(file);
    }
});

// Preview Controls
const rotateLeft = document.getElementById('rotate-left');
const rotateRight = document.getElementById('rotate-right');
const zoomIn = document.getElementById('zoom-in');
const zoomOut = document.getElementById('zoom-out');

rotateLeft.addEventListener('click', () => {
    customizerState.rotation -= 45;
    updateShoePreview();
});

rotateRight.addEventListener('click', () => {
    customizerState.rotation += 45;
    updateShoePreview();
});

zoomIn.addEventListener('click', () => {
    if (customizerState.zoom < 2) {
        customizerState.zoom += 0.1;
        updateShoePreview();
    }
});

zoomOut.addEventListener('click', () => {
    if (customizerState.zoom > 0.5) {
        customizerState.zoom -= 0.1;
        updateShoePreview();
    }
});

// Update Functions
function updateShoePreview() {
    // Update base shoe style
    shoeBase.src = `images/${customizerState.style}.svg`;

    // Apply transformations
    const transform = `rotate(${customizerState.rotation}deg) scale(${customizerState.zoom})`;
    shoeBase.style.transform = transform;
    colorOverlay.style.transform = transform;
    patternOverlay.style.transform = transform;
    customArt.style.transform = transform;

    // Apply colors
    colorOverlay.style.backgroundColor = customizerState.colors.upper;
    shoeBase.style.filter = `brightness(${customizerState.colors.sole === '#FFFFFF' ? 1 : 0.8})`;

    // Apply custom artwork if present
    if (customizerState.artwork) {
        customArt.style.backgroundImage = `url(${customizerState.artwork})`;
        customArt.style.opacity = '0.8';
    }
}

function updatePriceDisplay() {
    const basePrice = document.getElementById('base-price');
    const artPrice = document.getElementById('art-price');
    const totalPrice = document.getElementById('total-price');

    basePrice.textContent = `$${customizerState.prices.base.toFixed(2)}`;
    artPrice.textContent = `$${customizerState.prices.artwork.toFixed(2)}`;
    
    const total = customizerState.prices.base + customizerState.prices.artwork;
    totalPrice.textContent = `$${total.toFixed(2)}`;
}

// Add to Cart
const addToCartBtn = document.getElementById('add-to-cart');
addToCartBtn.addEventListener('click', () => {
    if (!customizerState.size) {
        alert('Please select a size');
        return;
    }

    const customShoe = {
        ...customizerState,
        id: Date.now(), // Unique identifier
        name: `Custom ${customizerState.style.charAt(0).toUpperCase() + customizerState.style.slice(1)}`,
        totalPrice: customizerState.prices.base + customizerState.prices.artwork
    };

    // Get existing cart or initialize new one
    let cart = JSON.parse(localStorage.getItem('cart') || '[]');
    cart.push(customShoe);
    localStorage.setItem('cart', JSON.stringify(cart));

    // Update cart count in header
    const cartCount = document.getElementById('cart-count');
    if (cartCount) {
        cartCount.textContent = cart.length;
    }

    alert('Custom shoe added to cart!');
});

// Initialize preview on page load
document.addEventListener('DOMContentLoaded', () => {
    updateShoePreview();
    updatePriceDisplay();
});