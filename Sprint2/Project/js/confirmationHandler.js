class ConfirmationHandler {
    constructor() {
        this.orderData = this.loadOrderData();
        this.initializeConfirmation();
    }

    loadOrderData() {
        const orderData = localStorage.getItem('solevibe_last_order');
        return orderData ? JSON.parse(orderData) : null;
    }

    initializeConfirmation() {
        if (!this.orderData) {
            window.location.href = 'index.html';
            return;
        }

        this.renderConfirmation();
        // Clear the order data after displaying
        localStorage.removeItem('solevibe_last_order');
    }

    renderConfirmation() {
        const confirmationContent = document.querySelector('.confirmation-content');
        if (!confirmationContent) return;

        const estimatedDelivery = this.calculateEstimatedDelivery();

        confirmationContent.innerHTML = `
            <div class="success-icon">
                <svg viewBox="0 0 24 24" width="48" height="48">
                    <path fill="currentColor" d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z"/>
                </svg>
            </div>
            <h1>Thank you, ${this.orderData.name}!</h1>
            <p class="confirmation-message">Your custom SoleVibe shoes are on the way.</p>
            
            <div class="order-info">
                <div class="info-group">
                    <label>Order Number:</label>
                    <span>${this.orderData.orderId}</span>
                </div>
                <div class="info-group">
                    <label>Order Date:</label>
                    <span>${new Date(this.orderData.orderDate).toLocaleDateString()}</span>
                </div>
                <div class="info-group">
                    <label>Estimated Delivery:</label>
                    <span>${estimatedDelivery.toLocaleDateString()}</span>
                </div>
            </div>

            <div class="shipping-info">
                <h3>Shipping Information</h3>
                <p>${this.orderData.name}</p>
                <p>${this.orderData.address}</p>
                <p>${this.orderData.city}, ${this.orderData.postalCode}</p>
                <p>${this.orderData.phone}</p>
                <p>${this.orderData.email}</p>
            </div>

            <div class="order-summary">
                <h3>Order Summary</h3>
                ${this.orderData.items.map(item => `
                    <div class="summary-item">
                        <div class="item-details">
                            <span class="item-name">Custom SoleVibe Shoe (${item.style})</span>
                            <span class="item-meta">Size: ${item.size} | Colors: ${item.colors.upper}/${item.colors.sole}</span>
                        </div>
                        <div class="item-quantity">x${item.quantity}</div>
                        <div class="item-price">$${(item.price * item.quantity).toFixed(2)}</div>
                    </div>
                `).join('')}
            </div>

            <div class="next-steps">
                <h3>What's Next?</h3>
                <ul>
                    <li>You'll receive a confirmation email shortly</li>
                    <li>Track your order using the order number above</li>
                    <li>Expect delivery within 5-7 business days</li>
                </ul>
            </div>

            <div class="action-buttons">
                <a href="index.html" class="btn-secondary">Continue Shopping</a>
                <button class="btn-primary" onclick="window.print()">Print Order</button>
            </div>
        `;
    }

    calculateEstimatedDelivery() {
        const deliveryDate = new Date();
        deliveryDate.setDate(deliveryDate.getDate() + 7); // Add 7 days for delivery
        // Skip weekends
        while (deliveryDate.getDay() === 0 || deliveryDate.getDay() === 6) {
            deliveryDate.setDate(deliveryDate.getDate() + 1);
        }
        return deliveryDate;
    }
}

// Initialize confirmation handler when DOM is loaded
document.addEventListener('DOMContentLoaded', () => {
    new ConfirmationHandler();
});