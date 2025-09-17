import productData from './productData.js';

class PriceEngine {
    constructor() {
        this.basePrice = productData.basePrice;
        this.taxRate = 0.18; // 18% GST
        this.expressShippingRate = 15; // Express shipping fee
    }

    /**
     * Calculate the total price based on selected options
     * @param {Object} configuration - The complete shoe configuration
     * @returns {number} - The final price
     */
    calculatePrice(configuration) {
        let subtotal = this.basePrice;

        // Add style modifier
        if (configuration.style && productData.styles[configuration.style]) {
            subtotal += productData.styles[configuration.style].priceModifier;
        }

        // Add material modifier
        if (configuration.material && productData.materials[configuration.material]) {
            subtotal += productData.materials[configuration.material].priceModifier;
        }

        // Add color modifiers
        if (configuration.colors) {
            // Upper color
            const upperColor = productData.colors.upper.find(
                color => color.code === configuration.colors.upper
            );
            if (upperColor) {
                subtotal += upperColor.priceModifier;
            }

            // Sole color
            const soleColor = productData.colors.sole.find(
                color => color.code === configuration.colors.sole
            );
            if (soleColor) {
                subtotal += soleColor.priceModifier;
            }
        }

        // Add sole type modifier
        if (configuration.soleType && productData.soleTypes[configuration.soleType]) {
            subtotal += productData.soleTypes[configuration.soleType].priceModifier;
        }

        // Add custom artwork modifier if applicable
        if (configuration.customArtwork) {
            subtotal += productData.customArtwork.priceModifier;
        }

        // Round subtotal
        subtotal = this.roundPrice(subtotal);

        // Calculate tax
        const tax = this.roundPrice(subtotal * this.taxRate);

        // Add shipping if express shipping is selected
        const shipping = configuration.expressShipping ? this.expressShippingRate : 0;

        // Calculate final total
        return this.roundPrice(subtotal + tax + shipping);
    }

    /**
     * Calculate price difference from base price
     * @param {number} currentPrice - The current total price
     * @returns {number} - The price difference
     */
    calculatePriceDifference(currentPrice) {
        return this.roundPrice(currentPrice - this.basePrice);
    }

    /**
     * Round price to two decimal places
     * @param {number} price - The price to round
     * @returns {number} - The rounded price
     */
    roundPrice(price) {
        return Math.round(price * 100) / 100;
    }

    /**
     * Format price for display
     * @param {number} price - The price to format
     * @returns {string} - The formatted price string
     */
    formatPrice(price) {
        return `$${this.roundPrice(price).toFixed(2)}`;
    }

    /**
     * Get the breakdown of price modifications
     * @param {Object} configuration - The complete shoe configuration
     * @returns {Object} - Detailed breakdown of price modifications
     */
    getPriceBreakdown(configuration) {
        const breakdown = {
            basePrice: this.basePrice,
            modifications: [],
            subtotal: this.basePrice,
            tax: 0,
            shipping: 0,
            total: this.basePrice
        };

        // Style modification
        if (configuration.style && productData.styles[configuration.style]) {
            const mod = productData.styles[configuration.style].priceModifier;
            if (mod !== 0) {
                breakdown.modifications.push({
                    name: `Style (${productData.styles[configuration.style].name})`,
                    amount: mod
                });
                breakdown.total += mod;
            }
        }

        // Material modification
        if (configuration.material && productData.materials[configuration.material]) {
            const mod = productData.materials[configuration.material].priceModifier;
            if (mod !== 0) {
                breakdown.modifications.push({
                    name: `Material (${productData.materials[configuration.material].name})`,
                    amount: mod
                });
                breakdown.total += mod;
            }
        }

        // Color modifications
        if (configuration.colors) {
            // Upper color
            const upperColor = productData.colors.upper.find(
                color => color.code === configuration.colors.upper
            );
            if (upperColor && upperColor.priceModifier !== 0) {
                breakdown.modifications.push({
                    name: `Upper Color (${upperColor.name})`,
                    amount: upperColor.priceModifier
                });
                breakdown.total += upperColor.priceModifier;
            }

            // Sole color
            const soleColor = productData.colors.sole.find(
                color => color.code === configuration.colors.sole
            );
            if (soleColor && soleColor.priceModifier !== 0) {
                breakdown.modifications.push({
                    name: `Sole Color (${soleColor.name})`,
                    amount: soleColor.priceModifier
                });
                breakdown.total += soleColor.priceModifier;
            }
        }

        // Sole type modification
        if (configuration.soleType && productData.soleTypes[configuration.soleType]) {
            const mod = productData.soleTypes[configuration.soleType].priceModifier;
            if (mod !== 0) {
                breakdown.modifications.push({
                    name: `Sole Type (${productData.soleTypes[configuration.soleType].name})`,
                    amount: mod
                });
                breakdown.total += mod;
            }
        }

        // Custom artwork modification
        if (configuration.customArtwork) {
            const mod = productData.customArtwork.priceModifier;
            breakdown.modifications.push({
                name: 'Custom Artwork',
                amount: mod
            });
            breakdown.total += mod;
        }

        // Calculate subtotal
        breakdown.subtotal = this.roundPrice(breakdown.total);

        // Calculate tax
        breakdown.tax = this.roundPrice(breakdown.subtotal * this.taxRate);

        // Add shipping if express shipping is selected
        if (configuration.expressShipping) {
            breakdown.shipping = this.expressShippingRate;
        }

        // Calculate final total
        breakdown.total = this.roundPrice(breakdown.subtotal + breakdown.tax + breakdown.shipping);
        return breakdown;
    }
}

export default PriceEngine;