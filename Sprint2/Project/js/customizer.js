import productData from './productData.js';
import PriceEngine from './priceEngine.js';
import CartManager from './cartManager.js';

class Customizer {
    constructor() {
        this.priceEngine = new PriceEngine();
        this.cartManager = new CartManager();
        this.currentConfig = {
            style: 'casual',
            material: 'leather',
            colors: {
                upper: '#000000',
                sole: '#FFFFFF'
            },
            size: null,
            soleType: 'standard',
            customArtwork: null
        };

        this.initializeEventListeners();
        this.updatePreview();
        this.updatePrice();
    }

    /**
     * Initialize all event listeners for customization controls
     */
    initializeEventListeners() {
        // Style selection
        document.querySelectorAll('.style-option').forEach(button => {
            button.addEventListener('click', (e) => {
                const style = e.target.dataset.style;
                this.updateStyle(style);
            });
        });

        // Material selection
        document.querySelectorAll('.material-option').forEach(option => {
            option.addEventListener('click', (e) => {
                const material = e.target.closest('.material-option').dataset.material;
                this.updateMaterial(material);
            });
        });

        // Color selection - Upper
        document.querySelectorAll('.color-section[data-part="upper"] .color-option').forEach(button => {
            button.addEventListener('click', (e) => {
                const color = e.target.style.backgroundColor;
                this.updateColor('upper', color);
            });
        });

        // Color selection - Sole
        document.querySelectorAll('.color-section[data-part="sole"] .color-option').forEach(button => {
            button.addEventListener('click', (e) => {
                const color = e.target.style.backgroundColor;
                this.updateColor('sole', color);
            });
        });

        // Size selection
        const sizeSelect = document.getElementById('shoe-size');
        if (sizeSelect) {
            sizeSelect.addEventListener('change', (e) => {
                this.updateSize(e.target.value);
            });
        }

        // Custom artwork upload
        const artworkInput = document.getElementById('artwork-upload');
        if (artworkInput) {
            artworkInput.addEventListener('change', (e) => {
                this.handleArtworkUpload(e.target.files[0]);
            });
        }

        // Add to cart button
        const addToCartBtn = document.querySelector('.add-to-cart-btn');
        if (addToCartBtn) {
            addToCartBtn.addEventListener('click', () => {
                this.handleAddToCart();
            });
        }
    }

    /**
     * Update the shoe style
     * @param {string} style - The selected style
     */
    updateStyle(style) {
        if (productData.styles[style]) {
            this.currentConfig.style = style;
            this.updateStyleUI(style);
            this.updatePreview();
            this.updatePrice();
        }
    }

    /**
     * Update the material selection
     * @param {string} material - The selected material
     */
    updateMaterial(material) {
        if (productData.materials[material]) {
            this.currentConfig.material = material;
            this.updateMaterialUI(material);
            this.updatePreview();
            this.updatePrice();
        }
    }

    /**
     * Update color selection for a specific part
     * @param {string} part - The part to update (upper/sole)
     * @param {string} color - The selected color
     */
    updateColor(part, color) {
        if (part === 'upper' || part === 'sole') {
            this.currentConfig.colors[part] = color;
            this.updateColorUI(part, color);
            this.updatePreview();
            this.updatePrice();
        }
    }

    /**
     * Update the selected size
     * @param {string} size - The selected size
     */
    updateSize(size) {
        this.currentConfig.size = size;
        this.validateConfiguration();
    }

    /**
     * Handle custom artwork upload
     * @param {File} file - The uploaded file
     */
    handleArtworkUpload(file) {
        if (!file) return;

        // Validate file type
        if (!productData.customArtwork.allowedTypes.includes(file.type)) {
            alert('Please upload a valid image file (JPEG, PNG, or SVG)');
            return;
        }

        // Validate file size
        if (file.size > productData.customArtwork.maxFileSize) {
            alert('File size exceeds the maximum limit of 5MB');
            return;
        }

        // Create preview and update configuration
        const reader = new FileReader();
        reader.onload = (e) => {
            this.currentConfig.customArtwork = {
                data: e.target.result,
                placement: 'side' // Default placement
            };
            this.updateArtworkPreview(e.target.result);
            this.updatePrice();
        };
        reader.readAsDataURL(file);
    }

    /**
     * Update the 3D preview of the shoe
     */
    updatePreview() {
        // This would integrate with a 3D rendering library
        // For now, we'll update the placeholder preview
        const preview = document.querySelector('.preview-canvas');
        if (preview) {
            preview.style.backgroundColor = this.currentConfig.colors.upper;
        }
    }

    /**
     * Update the price display
     */
    updatePrice() {
        const price = this.priceEngine.calculatePrice(this.currentConfig);
        const priceDisplay = document.querySelector('.price-amount');
        if (priceDisplay) {
            priceDisplay.textContent = this.priceEngine.formatPrice(price);
        }

        // Update price breakdown if available
        this.updatePriceBreakdown();
    }

    /**
     * Update the price breakdown display
     */
    showSuccess(message) {
        const notification = document.createElement('div');
        notification.className = 'notification success';
        notification.textContent = message;
        document.body.appendChild(notification);
        setTimeout(() => notification.remove(), 3000);
    }

    showError(message) {
        const notification = document.createElement('div');
        notification.className = 'notification error';
        notification.textContent = message;
        document.body.appendChild(notification);
        setTimeout(() => notification.remove(), 3000);
    }

    showFieldError(field, message) {
        const fieldElement = document.querySelector(`[data-field="${field}"]`);
        if (fieldElement) {
            const errorElement = fieldElement.querySelector('.field-error') || 
                               document.createElement('div');
            errorElement.className = 'field-error';
            errorElement.textContent = message;
            if (!fieldElement.querySelector('.field-error')) {
                fieldElement.appendChild(errorElement);
            }
        }
    }

    updateAddToCartButton(isValid = null) {
        const button = document.querySelector('.add-to-cart-btn');
        if (button) {
            if (isValid === null) {
                isValid = this.validateConfiguration();
            }
            button.disabled = !isValid;
            button.classList.toggle('disabled', !isValid);
        }
    }

    getPreviewImageUrl() {
        // In a real implementation, this would capture the current 3D preview
        // For now, return a placeholder image URL
        return 'images/shoe-preview.png';
    }

    updatePriceBreakdown() {
        const breakdown = this.priceEngine.getPriceBreakdown(this.currentConfig);
        const breakdownContainer = document.querySelector('.price-breakdown');
        if (breakdownContainer) {
            // Clear existing breakdown
            breakdownContainer.innerHTML = '';

            // Add base price
            const basePrice = document.createElement('div');
            basePrice.textContent = `Base Price: ${this.priceEngine.formatPrice(breakdown.basePrice)}`;
            breakdownContainer.appendChild(basePrice);

            // Add modifications
            breakdown.modifications.forEach(mod => {
                const modElement = document.createElement('div');
                modElement.textContent = `${mod.name}: +${this.priceEngine.formatPrice(mod.amount)}`;
                breakdownContainer.appendChild(modElement);
            });

            // Add total
            const total = document.createElement('div');
            total.className = 'total-price';
            total.textContent = `Total: ${this.priceEngine.formatPrice(breakdown.total)}`;
            breakdownContainer.appendChild(total);
        }
    }

    /**
     * Update UI elements for style selection
     * @param {string} style - The selected style
     */
    updateStyleUI(style) {
        document.querySelectorAll('.style-option').forEach(button => {
            button.classList.toggle('active', button.dataset.style === style);
        });
    }

    /**
     * Update UI elements for material selection
     * @param {string} material - The selected material
     */
    updateMaterialUI(material) {
        document.querySelectorAll('.material-option').forEach(option => {
            option.classList.toggle('active', option.dataset.material === material);
        });
    }

    /**
     * Update UI elements for color selection
     * @param {string} part - The part being updated (upper/sole)
     * @param {string} color - The selected color
     */
    updateColorUI(part, color) {
        document.querySelectorAll(`.color-section[data-part="${part}"] .color-option`).forEach(button => {
            button.classList.toggle('active', button.style.backgroundColor === color);
        });
    }

    /**
     * Update the artwork preview
     * @param {string} dataUrl - The artwork image data URL
     */
    updateArtworkPreview(dataUrl) {
        const preview = document.querySelector('.artwork-preview');
        if (preview) {
            preview.style.backgroundImage = `url(${dataUrl})`;
            preview.style.display = 'block';
        }
    }

    /**
     * Validate the current configuration
     * @returns {boolean} - Whether the configuration is valid
     */
    validateConfiguration() {
        let isValid = true;
        const requiredFields = ['style', 'material', 'size', 'soleType'];
        
        requiredFields.forEach(field => {
            if (!this.currentConfig[field]) {
                isValid = false;
                this.showFieldError(field, 'This field is required');
            }
        });

        if (!this.currentConfig.colors.upper || !this.currentConfig.colors.sole) {
            isValid = false;
            this.showFieldError('colors', 'Please select both upper and sole colors');
        }

        this.updateAddToCartButton(isValid);
        return isValid;
    }

    /**
     * Add the current configuration to cart
     */
    handleAddToCart() {
        // Validate configuration
        if (!this.validateConfiguration()) {
            return;
        }

        // Get current price
        const price = this.priceEngine.calculatePrice(this.currentConfig);

        // Prepare cart item
        const cartItem = {
            ...this.currentConfig,
            price,
            imageUrl: this.getPreviewImageUrl()
        };

        // Add to cart
        this.cartManager.addItem(cartItem);

        // Redirect to cart page
        window.location.href = 'cart.html';
    }
}

// Initialize customizer when the DOM is loaded
document.addEventListener('DOMContentLoaded', () => {
    new Customizer();
});

export default Customizer;