// Checkout Form Handling
const checkoutForm = document.getElementById('checkout-form');
const orderSummary = document.getElementById('order-summary');
const cartCountElement = document.getElementById('cart-count');

// Load cart and display order summary
function loadOrderSummary() {
    const cart = JSON.parse(localStorage.getItem('cart') || '[]');
    if (cartCountElement) {
        cartCountElement.textContent = cart.length;
    }

    if (cart.length === 0) {
        window.location.href = 'cart.html';
        return;
    }

    let subtotal = 0;
    orderSummary.innerHTML = '';

    cart.forEach(item => {
        subtotal += item.totalPrice;
        const itemElement = document.createElement('div');
        itemElement.className = 'order-item';
        itemElement.innerHTML = `
            <div class="item-info">
                <img src="${item.image || `images/${item.style}.svg`}" alt="${item.name}">
                <div class="item-details">
                    <h3>${item.name}</h3>
                    <p>Size: US ${item.size}</p>
                    ${item.artwork ? '<p>Custom Artwork Applied</p>' : ''}
                </div>
            </div>
            <div class="item-price">$${item.totalPrice.toFixed(2)}</div>
        `;
        orderSummary.appendChild(itemElement);
    });

    updateTotals(subtotal);
}

// Update order totals
function updateTotals(subtotal) {
    const shipping = 15; // Express shipping
    const tax = subtotal * 0.18; // 18% tax rate
    const total = subtotal + shipping + tax;

    document.getElementById('checkout-subtotal').textContent = `$${subtotal.toFixed(2)}`;
    document.getElementById('checkout-shipping').textContent = `$${shipping.toFixed(2)}`;
    document.getElementById('checkout-tax').textContent = `$${tax.toFixed(2)}`;
    document.getElementById('checkout-total').textContent = `$${total.toFixed(2)}`;
}

// Form validation and formatting
function formatCardNumber(input) {
    let value = input.value.replace(/\D/g, '');
    input.value = value;
}

function formatExpiry(input) {
    let value = input.value.replace(/\D/g, '');
    if (value.length >= 2) {
        value = value.slice(0, 2) + '/' + value.slice(2);
    }
    input.value = value;
}

function formatCVV(input) {
    let value = input.value.replace(/\D/g, '');
    input.value = value;
}

// Add input event listeners for formatting
const cardNumber = document.getElementById('cardNumber');
const expiry = document.getElementById('expiry');
const cvv = document.getElementById('cvv');

cardNumber.addEventListener('input', () => formatCardNumber(cardNumber));
expiry.addEventListener('input', () => formatExpiry(expiry));
cvv.addEventListener('input', () => formatCVV(cvv));

// Form submission handling
checkoutForm.addEventListener('submit', (e) => {
    e.preventDefault();

    // Basic form validation
    const email = document.getElementById('email').value;
    const cardNum = document.getElementById('cardNumber').value;
    const expiryDate = document.getElementById('expiry').value;
    const cvvNum = document.getElementById('cvv').value;

    // if (!email.includes('@')) {
    //     alert('Please enter a valid email address');
    //     return;
    // }

    // if (cardNum.length !== 16) {
    //     alert('Please enter a valid 16-digit card number');
    //     return;
    // }

    // if (!expiryDate.match(/^\d{2}\/\d{2}$/)) {
    //     alert('Please enter a valid expiry date (MM/YY)');
    //     return;
    // }

    // if (cvvNum.length < 3) {
    //     alert('Please enter a valid CVV');
    //     return;
    // }

    // Collect form data
    const formData = new FormData(checkoutForm);
    const orderData = {
        contact: {
            email: formData.get('email'),
            phone: formData.get('phone')
        },
        shipping: {
            firstName: formData.get('firstName'),
            lastName: formData.get('lastName'),
            address: formData.get('address'),
            city: formData.get('city'),
            state: formData.get('state'),
            zipCode: formData.get('zipCode')
        },
        payment: {
            cardName: formData.get('cardName'),
            cardNumber: formData.get('cardNumber').slice(-4), // Only store last 4 digits
            expiry: formData.get('expiry')
        },
        cart: JSON.parse(localStorage.getItem('cart') || '[]'),
        orderDate: new Date().toISOString(),
        orderId: 'SV-' + Date.now()
    };

    // Here you would typically send orderData to your backend
    console.log('Order placed:', orderData);

    // Clear cart and redirect to confirmation page
    localStorage.removeItem('cart');
    window.location.href = `confirmation.html?orderId=${orderData.orderId}`;
});

// Initialize page
document.addEventListener('DOMContentLoaded', loadOrderSummary);