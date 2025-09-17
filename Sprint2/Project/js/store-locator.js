document.addEventListener('DOMContentLoaded', function() {
    // Store search functionality
    const searchInput = document.getElementById('store-search-input');
    const searchButton = document.getElementById('store-search-btn');
    const storeList = document.querySelector('.store-list');

    // Sample store data - in a real application, this would come from a backend API
    const stores = [
        {
            name: 'SoleVibe Downtown',
            address: '123 Main Street, New York, NY 10001',
            hours: {
                monSat: '10:00 AM - 9:00 PM',
                sun: '11:00 AM - 6:00 PM'
            },
            phone: '(555) 123-4567',
            features: ['Custom Fitting', 'In-Store Pickup', 'Shoe Care'],
            coordinates: { lat: 40.7128, lng: -74.0060 }
        },
        {
            name: 'SoleVibe Brooklyn',
            address: '456 Atlantic Ave, Brooklyn, NY 11217',
            hours: {
                monSat: '11:00 AM - 8:00 PM',
                sun: '12:00 PM - 6:00 PM'
            },
            phone: '(555) 987-6543',
            features: ['Custom Fitting', 'Shoe Care'],
            coordinates: { lat: 40.6782, lng: -73.9442 }
        },
        {
            name: 'SoleVibe Queens',
            address: '789 Queens Blvd, Queens, NY 11375',
            hours: {
                monSat: '10:00 AM - 9:00 PM',
                sun: '11:00 AM - 7:00 PM'
            },
            phone: '(555) 456-7890',
            features: ['Custom Fitting', 'In-Store Pickup'],
            coordinates: { lat: 40.7282, lng: -73.7949 }
        }
    ];

    // Search functionality
    function searchStores(query) {
        query = query.toLowerCase();
        return stores.filter(store => {
            return store.name.toLowerCase().includes(query) ||
                   store.address.toLowerCase().includes(query);
        });
    }

    // Update store list display
    function updateStoreList(filteredStores) {
        storeList.innerHTML = '';
        
        filteredStores.forEach(store => {
            const storeCard = document.createElement('div');
            storeCard.className = 'store-card';
            
            storeCard.innerHTML = `
                <h3>${store.name}</h3>
                <p class="store-address">${store.address}</p>
                <div class="store-details">
                    <div class="store-hours">
                        <h4>Store Hours</h4>
                        <p>Mon-Sat: ${store.hours.monSat}</p>
                        <p>Sun: ${store.hours.sun}</p>
                    </div>
                    <div class="store-contact">
                        <p>📞 ${store.phone}</p>
                        <button class="directions-btn" onclick="getDirections('${store.address}')">Get Directions</button>
                    </div>
                </div>
                <div class="store-features">
                    ${store.features.map(feature => 
                        `<span class="feature-tag">${feature}</span>`
                    ).join('')}
                </div>
            `;
            
            storeList.appendChild(storeCard);
        });
    }

    // Handle search
    searchButton.addEventListener('click', function() {
        const query = searchInput.value.trim();
        const filteredStores = searchStores(query);
        updateStoreList(filteredStores);
    });

    // Handle enter key in search input
    searchInput.addEventListener('keypress', function(e) {
        if (e.key === 'Enter') {
            const query = searchInput.value.trim();
            const filteredStores = searchStores(query);
            updateStoreList(filteredStores);
        }
    });

    // Get directions function
    window.getDirections = function(address) {
        // Open Google Maps in a new tab with the destination address
        const encodedAddress = encodeURIComponent(address);
        window.open(`https://www.google.com/maps/dir/?api=1&destination=${encodedAddress}`, '_blank');
    };

    // Initialize store list with all stores
    updateStoreList(stores);
});