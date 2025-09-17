// Product Data Configuration
const productData = {
    // Base product information
    basePrice: 199.99,
    
    // Available styles
    styles: {
        casual: {
            name: 'Casual',
            priceModifier: 0,
            description: 'Everyday comfort with classic style'
        },
        athletic: {
            name: 'Athletic',
            priceModifier: 20,
            description: 'Performance-focused design for active lifestyle'
        },
        formal: {
            name: 'Formal',
            priceModifier: 30,
            description: 'Elegant design for formal occasions'
        }
    },

    // Material options
    materials: {
        leather: {
            name: 'Premium Leather',
            priceModifier: 30,
            description: 'High-quality genuine leather'
        },
        suede: {
            name: 'Soft Suede',
            priceModifier: 25,
            description: 'Luxurious suede finish'
        },
        canvas: {
            name: 'Canvas',
            priceModifier: 0,
            description: 'Durable canvas material'
        }
    },

    // Color options
    colors: {
        upper: [
            { name: 'Classic Black', code: '#000000', priceModifier: 0 },
            { name: 'Rich Brown', code: '#8B4513', priceModifier: 0 },
            { name: 'Deep Red', code: '#8B0000', priceModifier: 10 },
            { name: 'Navy Blue', code: '#000080', priceModifier: 10 }
        ],
        sole: [
            { name: 'White', code: '#FFFFFF', priceModifier: 0 },
            { name: 'Black', code: '#000000', priceModifier: 0 },
            { name: 'Bronze', code: '#C9A87C', priceModifier: 15 }
        ]
    },

    // Size options
    sizes: [
        { us: '6', eu: '39', uk: '5.5' },
        { us: '7', eu: '40', uk: '6.5' },
        { us: '8', eu: '41', uk: '7.5' },
        { us: '9', eu: '42', uk: '8.5' },
        { us: '10', eu: '43', uk: '9.5' },
        { us: '11', eu: '44', uk: '10.5' },
        { us: '12', eu: '45', uk: '11.5' }
    ],

    // Sole types
    soleTypes: {
        standard: {
            name: 'Standard',
            priceModifier: 0,
            description: 'Classic comfort and durability'
        },
        cushioned: {
            name: 'Extra Cushioning',
            priceModifier: 20,
            description: 'Enhanced comfort for long wear'
        },
        performance: {
            name: 'Performance',
            priceModifier: 35,
            description: 'Optimized for athletic activity'
        }
    },

    // Custom artwork options
    customArtwork: {
        maxFileSize: 5242880, // 5MB in bytes
        allowedTypes: ['image/jpeg', 'image/png', 'image/svg+xml'],
        priceModifier: 50,
        placementOptions: ['side', 'heel', 'tongue']
    }
};

// Export the configuration
export default productData;