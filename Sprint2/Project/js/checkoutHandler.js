import CartManager from './cartManager.js';
import PriceEngine from './priceEngine.js';

class CheckoutHandler {
    constructor() {
        this.cartManager = new CartManager();
        this.priceEngine = new PriceEngine();
        this.initializeCheckout();
    }

    initializeCheckout() {
        this.renderOrderSummary();
        this.attachFormListeners();
    }

    renderOrderSummary() {
        const summaryElement = document.getElementById('order-summary');
        if (!summaryElement) return;

        const cart = this.cartManager.getCart();
        if (cart.length === 0) {
            window.location.href = 'cart.html';
            return;
        }

        const subtotal = cart.reduce((total, item) => total + (item.price * item.quantity), 0);
        const tax = subtotal * this.priceEngine.taxRate;
        const shipping = this.priceEngine.expressShippingRate;
        const total = subtotal + tax + shipping;

        summaryElement.innerHTML = `
            <h3>Order Summary</h3>
            <div class="summary-items">
                ${cart.map(item => `
                    <div class="summary-item">
                        <span>${item.quantity}x Custom Shoe (${item.style})</span>
                        <span>${this.priceEngine.formatPrice(item.price * item.quantity)}</span>
                    </div>
                `).join('')}
            </div>
            <div class="summary-line">
                <span>Subtotal</span>
                <span>${this.priceEngine.formatPrice(subtotal)}</span>
            </div>
            <div class="summary-line">
                <span>Tax (${(this.priceEngine.taxRate * 100).toFixed(0)}%)</span>
                <span>${this.priceEngine.formatPrice(tax)}</span>
            </div>
            <div class="summary-line">
                <span>Shipping</span>
                <span>${this.priceEngine.formatPrice(shipping)}</span>
            </div>
            <div class="summary-line total">
                <span>Total</span>
                <span>${this.priceEngine.formatPrice(total)}</span>
            </div>
        `;
    }

    attachFormListeners() {
        const form = document.getElementById('checkout-form');
        if (!form) return;

        // Real-time validation
        const inputs = form.querySelectorAll('input');
        inputs.forEach(input => {
            input.addEventListener('blur', () => this.validateField(input));
            input.addEventListener('input', () => this.validateField(input));
        });

        // Form submission
        form.addEventListener('submit', (e) => this.handleSubmit(e));
    }

    validateField(input) {
        const value = input.value.trim();
        let isValid = true;
        let errorMessage = '';

        switch (input.id) {
            case 'name':
                if (value.length < 2) {
                    isValid = false;
                    errorMessage = 'Name must be at least 2 characters long';
                }
                break;

            case 'email':
                const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                if (!emailRegex.test(value)) {
                    isValid = false;
                    errorMessage = 'Please enter a valid email address';
                }
                break;

            case 'phone':
                const phoneRegex = /^\+?[1-9]\d{9,14}$/;
                if (!phoneRegex.test(value.replace(/[\s()-]/g, ''))) {
                    isValid = false;
                    errorMessage = 'Please enter a valid phone number';
                }
                break;

            case 'address':
                if (value.length < 10) {
                    isValid = false;
                    errorMessage = 'Please enter a complete address';
                }
                break;

            case 'city':
                if (value.length < 2) {
                    isValid = false;
                    errorMessage = 'Please enter a valid city name';
                }
                break;

            case 'postal-code':
                const postalRegex = /^[A-Z0-9]{3,10}$/i;
                if (!postalRegex.test(value.replace(/\s/g, ''))) {
                    isValid = false;
                    errorMessage = 'Please enter a valid postal code';
                }
                break;
        }

        this.updateFieldStatus(input, isValid, errorMessage);
        return isValid;
    }

    updateFieldStatus(input, isValid, errorMessage) {
        const errorElement = input.parentElement.querySelector('.error-message');
        if (errorElement) {
            errorElement.textContent = errorMessage;
        }
        input.classList.toggle('invalid', !isValid);
        input.classList.toggle('valid', isValid && input.value.trim() !== '');
    }

    validateForm(form) {
        const inputs = form.querySelectorAll('input[required]');
        let isValid = true;

        inputs.forEach(input => {
            if (!this.validateField(input)) {
                isValid = false;
            }
        });

        return isValid;
    }

    handleSubmit(e) {
        e.preventDefault();
        const form = e.target;

        if (!this.validateForm(form)) {
            return;
        }

        // Collect form data
        const formData = {
            name: form.querySelector('#name').value,
            email: form.querySelector('#email').value,
            phone: form.querySelector('#phone').value,
            address: form.querySelector('#address').value,
            city: form.querySelector('#city').value,
            postalCode: form.querySelector('#postal-code').value,
            items: this.cartManager.getCart(),
            total: this.cartManager.getCartTotal(),
            orderDate: new Date().toISOString(),
            orderId: 'SV-' + Date.now()
        };

        // Save order data
        localStorage.setItem('solevibe_last_order', JSON.stringify(formData));

        // Clear cart
        this.cartManager.clearCart();

        // Redirect to confirmation page
        window.location.href = 'confirmation.html';
    }
}

// Initialize checkout handler when DOM is loaded
document.addEventListener('DOMContentLoaded', () => {
    new CheckoutHandler();
});