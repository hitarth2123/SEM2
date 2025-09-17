class CartManager {
    constructor() {
        this.cartKey = 'solevibe_cart';
        this.cart = this.loadCart();
        this.updateCartCount();
    }

    loadCart() {
        const savedCart = localStorage.getItem(this.cartKey);
        return savedCart ? JSON.parse(savedCart) : [];
    }

    saveCart() {
        localStorage.setItem(this.cartKey, JSON.stringify(this.cart));
        this.updateCartCount();
    }

    addItem(item) {
        this.cart.push({
            ...item,
            id: Date.now(), // Unique identifier for each cart item
            quantity: 1
        });
        this.saveCart();
    }

    removeItem(itemId) {
        this.cart = this.cart.filter(item => item.id !== itemId);
        this.saveCart();
    }

    updateQuantity(itemId, quantity) {
        const item = this.cart.find(item => item.id === itemId);
        if (item) {
            item.quantity = Math.max(1, quantity); // Ensure quantity is at least 1
            this.saveCart();
        }
    }

    getCart() {
        return this.cart;
    }

    getCartTotal() {
        return this.cart.reduce((total, item) => {
            return total + (item.price * item.quantity);
        }, 0);
    }

    clearCart() {
        this.cart = [];
        this.saveCart();
    }

    updateCartCount() {
        const count = this.cart.reduce((total, item) => total + item.quantity, 0);
        const cartCountElement = document.getElementById('cart-count');
        if (cartCountElement) {
            cartCountElement.textContent = count;
            cartCountElement.style.display = count > 0 ? 'block' : 'none';
        }
    }
}

export default CartManager;