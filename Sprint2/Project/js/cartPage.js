import CartManager from './cartManager.js';
import PriceEngine from './priceEngine.js';

class CartPage {
    constructor() {
        this.cartManager = new CartManager();
        this.priceEngine = new PriceEngine();
        this.initializeCart();
    }

    initializeCart() {
        this.renderCartItems();
        this.updateOrderSummary();
    }

    renderCartItems() {
        const cartItemsContainer = document.getElementById('cart-items');
        if (!cartItemsContainer) return;

        const cart = this.cartManager.getCart();
        if (cart.length === 0) {
            cartItemsContainer.innerHTML = `
                <div class="empty-cart">
                    <h2>Your cart is empty</h2>
                    <p>Start customizing your perfect pair of shoes!</p>
                    <a href="customize.html" class="btn-primary">Start Customizing</a>
                </div>
            `;
            return;
        }

        cartItemsContainer.innerHTML = cart.map(item => this.createCartItemHTML(item)).join('');
        this.attachCartEventListeners();
    }

    createCartItemHTML(item) {
        return `
            <div class="cart-item" data-id="${item.id}">
                <div class="cart-item-image">
                    <img src="${item.imageUrl || 'images/placeholder-shoe.svg'}" alt="Custom Shoe">
                </div>
                <div class="cart-item-details">
                    <h3>Custom SoleVibe Shoe</h3>
                    <p>Style: ${item.style}</p>
                    <p>Size: ${item.size}</p>
                    <p>Colors: ${item.colors.upper} / ${item.colors.sole}</p>
                    <p>Sole Type: ${item.soleType}</p>
                    ${item.customArtwork ? '<p>Custom Artwork: Yes</p>' : ''}
                </div>
                <div class="cart-item-quantity">
                    <button class="quantity-btn minus">-</button>
                    <input type="number" value="${item.quantity}" min="1" max="10" class="quantity-input">
                    <button class="quantity-btn plus">+</button>
                </div>
                <div class="cart-item-price">
                    <p class="unit-price">${this.priceEngine.formatPrice(item.price)}</p>
                    <p class="total-price">${this.priceEngine.formatPrice(item.price * item.quantity)}</p>
                </div>
                <button class="remove-item">Remove</button>
            </div>
        `;
    }

    attachCartEventListeners() {
        document.querySelectorAll('.cart-item').forEach(item => {
            const itemId = parseInt(item.dataset.id);
            const quantityInput = item.querySelector('.quantity-input');

            item.querySelector('.minus').addEventListener('click', () => {
                const newQuantity = parseInt(quantityInput.value) - 1;
                if (newQuantity >= 1) {
                    quantityInput.value = newQuantity;
                    this.updateItemQuantity(itemId, newQuantity);
                }
            });

            item.querySelector('.plus').addEventListener('click', () => {
                const newQuantity = parseInt(quantityInput.value) + 1;
                if (newQuantity <= 10) {
                    quantityInput.value = newQuantity;
                    this.updateItemQuantity(itemId, newQuantity);
                }
            });

            quantityInput.addEventListener('change', (e) => {
                const newQuantity = Math.min(Math.max(1, parseInt(e.target.value)), 10);
                quantityInput.value = newQuantity;
                this.updateItemQuantity(itemId, newQuantity);
            });

            item.querySelector('.remove-item').addEventListener('click', () => {
                this.cartManager.removeItem(itemId);
                this.initializeCart();
            });
        });

        const checkoutButton = document.getElementById('checkout-button');
        if (checkoutButton) {
            checkoutButton.addEventListener('click', () => {
                window.location.href = 'checkout.html';
            });
        }
    }

    updateItemQuantity(itemId, quantity) {
        this.cartManager.updateQuantity(itemId, quantity);
        this.updateOrderSummary();
        this.updateItemTotalPrice(itemId);
    }

    updateItemTotalPrice(itemId) {
        const item = this.cartManager.getCart().find(item => item.id === itemId);
        if (!item) return;

        const cartItem = document.querySelector(`.cart-item[data-id="${itemId}"]`);
        if (cartItem) {
            const totalPriceElement = cartItem.querySelector('.total-price');
            totalPriceElement.textContent = this.priceEngine.formatPrice(item.price * item.quantity);
        }
    }

    updateOrderSummary() {
        const summaryElement = document.getElementById('order-summary');
        if (!summaryElement) return;

        const cart = this.cartManager.getCart();
        const subtotal = cart.reduce((total, item) => total + (item.price * item.quantity), 0);
        const tax = subtotal * this.priceEngine.taxRate;
        const shipping = cart.length > 0 ? this.priceEngine.expressShippingRate : 0;
        const total = subtotal + tax + shipping;

        summaryElement.innerHTML = `
            <h3>Order Summary</h3>
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
            <button id="checkout-button" class="btn-primary" ${cart.length === 0 ? 'disabled' : ''}>
                Proceed to Checkout
            </button>
        `;
    }
}

// Initialize cart page when DOM is loaded
document.addEventListener('DOMContentLoaded', () => {
    new CartPage();
});