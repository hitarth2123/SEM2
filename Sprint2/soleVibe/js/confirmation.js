// Get order ID from URL parameters
const urlParams = new URLSearchParams(window.location.search);
const orderId = urlParams.get('orderId');

// Display order ID
document.getElementById('order-id').textContent = orderId || 'N/A';

// Set order date (current date)
const orderDate = new Date();
document.getElementById('order-date').textContent = orderDate.toLocaleDateString('en-US', {
    weekday: 'long',
    year: 'numeric',
    month: 'long',
    day: 'numeric'
});

// Calculate and display estimated delivery date (7-10 business days)
const deliveryDate = new Date(orderDate);
deliveryDate.setDate(deliveryDate.getDate() + 10); // Using max delivery time for display
document.getElementById('delivery-date').textContent = deliveryDate.toLocaleDateString('en-US', {
    weekday: 'long',
    year: 'numeric',
    month: 'long',
    day: 'numeric'
});

// Update cart count (should be 0 after order completion)
const cartCountElement = document.getElementById('cart-count');
if (cartCountElement) {
    cartCountElement.textContent = '0';
}

// Display shipping information if available in localStorage
const displayShippingInfo = () => {
    const shippingDetails = document.getElementById('shipping-details');
    
    // In a real application, you would get this from your backend
    // For demo purposes, we'll create a sample shipping info
    const sampleShippingInfo = {
        name: 'John Doe',
        address: '123 Main Street',
        city: 'Anytown',
        state: 'ST',
        zipCode: '12345',
        email: 'john@example.com'
    };

    shippingDetails.innerHTML = `
        <div class="info-row">
            <span>Name:</span>
            <span>${sampleShippingInfo.name}</span>
        </div>
        <div class="info-row">
            <span>Address:</span>
            <span>${sampleShippingInfo.address}</span>
        </div>
        <div class="info-row">
            <span>City:</span>
            <span>${sampleShippingInfo.city}</span>
        </div>
        <div class="info-row">
            <span>State:</span>
            <span>${sampleShippingInfo.state}</span>
        </div>
        <div class="info-row">
            <span>ZIP Code:</span>
            <span>${sampleShippingInfo.zipCode}</span>
        </div>
        <div class="info-row">
            <span>Email:</span>
            <span>${sampleShippingInfo.email}</span>
        </div>
    `;
};

// Update footer year
const currentYearElement = document.getElementById('current-year');
if (currentYearElement) {
    currentYearElement.textContent = new Date().getFullYear();
}

// Initialize page
document.addEventListener('DOMContentLoaded', () => {
    displayShippingInfo();
});