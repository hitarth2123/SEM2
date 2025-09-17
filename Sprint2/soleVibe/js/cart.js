// Cart Management
let cart = [];
let promoApplied = false;
const TAX_RATE = 0.18;

// DOM Elements
const cartItemsContainer = document.getElementById('cart-items');
const emptyCartSection = document.getElementById('empty-cart');
const subtotalElement = document.getElementById('subtotal');
const shippingElement = document.getElementById('shipping');
const taxElement = document.getElementById('tax');
const totalElement = document.getElementById('total');
const cartCountElement = document.getElementById('cart-count');

// Load cart from localStorage
function loadCart() {
    const savedCart = localStorage.getItem('cart');
    if (savedCart) {
        cart = JSON.parse(savedCart);
        updateCartDisplay();
    }
}

// Update cart display
function updateCartDisplay() {
    if (cart.length === 0) {
        cartItemsContainer.style.display = 'none';
        emptyCartSection.style.display = 'block';
        return;
    }

    cartItemsContainer.style.display = 'block';
    emptyCartSection.style.display = 'none';
    cartItemsContainer.innerHTML = '';

    cart.forEach((item, index) => {
        const cartItem = document.createElement('div');
        cartItem.className = 'cart-item';
        cartItem.innerHTML = `
            <div class="item-image">
                <img src="${item.image || `images/${item.style}.svg`}" alt="${item.name}">
            </div>
            <div class="item-details">
                <h3>${item.name}</h3>
                <p>Size: US ${item.size}</p>
                ${item.artwork ? '<p>Custom Artwork Applied</p>' : ''}
                <div class="item-price">$${item.totalPrice.toFixed(2)}</div>
            </div>
            <div class="item-actions">
                <button class="remove-item" onclick="removeItem(${index})">Remove</button>
            </div>
        `;
        cartItemsContainer.appendChild(cartItem);
    });

    updateCartCount();
    calculateTotals();
}

// Remove item from cart
function removeItem(index) {
    cart.splice(index, 1);
    localStorage.setItem('cart', JSON.stringify(cart));
    updateCartDisplay();
}

// Update cart count
function updateCartCount() {
    if (cartCountElement) {
        cartCountElement.textContent = cart.length;
    }
}

// Calculate totals
function calculateTotals() {
    const subtotal = cart.reduce((sum, item) => sum + item.totalPrice, 0);
    const shipping = document.querySelector('input[name="shipping"]:checked').value;
    const shippingCost = parseFloat(shipping);
    const tax = subtotal * TAX_RATE;
    const total = subtotal + shippingCost + tax;

    // Apply promo code discount if active
    let finalTotal = total;
    if (promoApplied) {
        finalTotal = total * 0.9; // 10% discount
    }

    // Update display
    subtotalElement.textContent = `$${subtotal.toFixed(2)}`;
    shippingElement.textContent = `$${shippingCost.toFixed(2)}`;
    taxElement.textContent = `$${tax.toFixed(2)}`;
    totalElement.textContent = `$${finalTotal.toFixed(2)}`;
}

// Promo code handling
const promoInput = document.getElementById('promo-input');
const applyPromoBtn = document.getElementById('apply-promo');

applyPromoBtn.addEventListener('click', () => {
    const promoCode = promoInput.value.trim().toUpperCase();
    if (promoCode === 'SOLEVIBE10' && !promoApplied) {
        promoApplied = true;
        calculateTotals();
        alert('Promo code applied! 10% discount added.');
        promoInput.disabled = true;
        applyPromoBtn.disabled = true;
    } else if (promoApplied) {
        alert('Promo code already applied!');
    } else {
        alert('Invalid promo code.');
    }
});

// Shipping method handling
const shippingOptions = document.querySelectorAll('input[name="shipping"]');
shippingOptions.forEach(option => {
    option.addEventListener('change', calculateTotals);
});

// Checkout handling
const checkoutBtn = document.getElementById('checkout-btn');
checkoutBtn.addEventListener('click', () => {
    if (cart.length === 0) {
        alert('Your cart is empty!');
        return;
    }

    // Here you would typically redirect to a checkout page
    // For now, we'll just simulate the process
    alert('Proceeding to checkout...');
    window.location.href = 'checkout.html';
});

// Initialize cart on page load
document.addEventListener('DOMContentLoaded', loadCart);