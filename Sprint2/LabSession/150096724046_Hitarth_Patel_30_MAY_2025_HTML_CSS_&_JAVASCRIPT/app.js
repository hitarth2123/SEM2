// Product data with mood ratings and reviews
const products = [
    { id: 1, name: 'Laptop Pro', description: 'High-performance laptop for professionals', image: 'https://picsum.photos/300/200?random=1', ratings: { happy: 0, neutral: 0, sad: 0 }, reviews: [] },
    { id: 2, name: 'SmartPhone X', description: 'Latest smartphone with advanced features', image: 'https://picsum.photos/300/200?random=2', ratings: { happy: 0, neutral: 0, sad: 0 }, reviews: [] },
    { id: 3, name: 'Tablet Air', description: 'Lightweight tablet for creative work', image: 'https://picsum.photos/300/200?random=3', ratings: { happy: 0, neutral: 0, sad: 0 }, reviews: [] },
    { id: 4, name: 'Desktop PC', description: 'Powerful desktop for gaming and work', image: 'https://picsum.photos/300/200?random=4', ratings: { happy: 0, neutral: 0, sad: 0 }, reviews: [] },
];

// Chart instances
let moodDistributionChart = null;
let ratingTrendsChart = null;

// Chart colors
const chartColors = {
    happy: '#4CAF50',
    neutral: '#FFC107',
    sad: '#F44336',
    background: getComputedStyle(document.documentElement).getPropertyValue('--chart-bg').trim(),
    text: getComputedStyle(document.documentElement).getPropertyValue('--chart-text').trim()
};

// Mood phrases for each emotion
const moodPhrases = {
    happy: [
        'Love it! 🌟',
        'Absolutely amazing! ✨',
        'Best purchase ever! 🎉',
    ],
    neutral: [
        'It\'s okay 🤔',
        'Could be better 💭',
        'Not bad, not great 📊',
    ],
    sad: [
        'Disappointed 😔',
        'Not what I expected 💔',
        'Needs improvement 📉',
    ],
};

// Tooltip text for mood buttons
const moodTooltips = {
    happy: 'I love it!',
    neutral: 'It\'s okay',
    sad: 'Not satisfied',
};

// State management
let selectedMoods = {};
let lastRatingTime = {};
const RATING_COOLDOWN = 30000; // 30 seconds cooldown
const CHART_UPDATE_INTERVAL = 5000; // 5 seconds for chart updates

// Initialize charts
function initializeCharts() {
    const moodCtx = document.getElementById('moodDistributionChart').getContext('2d');
    const trendsCtx = document.getElementById('ratingTrendsChart').getContext('2d');

    // Mood Distribution Chart
    moodDistributionChart = new Chart(moodCtx, {
        type: 'doughnut',
        data: {
            labels: ['Happy 😊', 'Neutral 😐', 'Sad 😢'],
            datasets: [{
                data: [0, 0, 0],
                backgroundColor: [chartColors.happy, chartColors.neutral, chartColors.sad],
                borderWidth: 0
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            plugins: {
                legend: {
                    position: 'bottom',
                    labels: {
                        color: chartColors.text,
                        font: {
                            size: 14
                        }
                    }
                }
            }
        }
    });

    // Rating Trends Chart
    ratingTrendsChart = new Chart(trendsCtx, {
        type: 'line',
        data: {
            labels: [],
            datasets: [
                {
                    label: 'Happy',
                    data: [],
                    borderColor: chartColors.happy,
                    backgroundColor: chartColors.happy + '40',
                    fill: true,
                    tension: 0.4
                },
                {
                    label: 'Neutral',
                    data: [],
                    borderColor: chartColors.neutral,
                    backgroundColor: chartColors.neutral + '40',
                    fill: true,
                    tension: 0.4
                },
                {
                    label: 'Sad',
                    data: [],
                    borderColor: chartColors.sad,
                    backgroundColor: chartColors.sad + '40',
                    fill: true,
                    tension: 0.4
                }
            ]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                x: {
                    grid: {
                        color: chartColors.text + '20'
                    },
                    ticks: {
                        color: chartColors.text
                    }
                },
                y: {
                    beginAtZero: true,
                    grid: {
                        color: chartColors.text + '20'
                    },
                    ticks: {
                        color: chartColors.text
                    }
                }
            },
            plugins: {
                legend: {
                    position: 'bottom',
                    labels: {
                        color: chartColors.text,
                        font: {
                            size: 14
                        }
                    }
                }
            }
        }
    });
}

// Update mood distribution chart
function updateMoodDistributionChart() {
    const totalMoods = products.reduce((acc, product) => {
        acc.happy += product.ratings.happy;
        acc.neutral += product.ratings.neutral;
        acc.sad += product.ratings.sad;
        return acc;
    }, { happy: 0, neutral: 0, sad: 0 });

    moodDistributionChart.data.datasets[0].data = [
        totalMoods.happy,
        totalMoods.neutral,
        totalMoods.sad
    ];
    moodDistributionChart.update();
}

// Update rating trends chart
function updateRatingTrendsChart() {
    const timeLabels = [];
    const happyData = [];
    const neutralData = [];
    const sadData = [];

    // Get all reviews sorted by timestamp
    const allReviews = products.flatMap(product => product.reviews)
        .sort((a, b) => a.timestamp - b.timestamp);

    // Group reviews by hour
    const reviewsByHour = allReviews.reduce((acc, review) => {
        const hour = new Date(review.timestamp).getHours();
        if (!acc[hour]) {
            acc[hour] = { happy: 0, neutral: 0, sad: 0 };
        }
        acc[hour][review.mood]++;
        return acc;
    }, {});

    // Create data points for the last 24 hours
    const now = new Date();
    for (let i = 23; i >= 0; i--) {
        const hour = (now.getHours() - i + 24) % 24;
        const hourData = reviewsByHour[hour] || { happy: 0, neutral: 0, sad: 0 };
        timeLabels.push(`${hour}:00`);
        happyData.push(hourData.happy);
        neutralData.push(hourData.neutral);
        sadData.push(hourData.sad);
    }

    ratingTrendsChart.data.labels = timeLabels;
    ratingTrendsChart.data.datasets[0].data = happyData;
    ratingTrendsChart.data.datasets[1].data = neutralData;
    ratingTrendsChart.data.datasets[2].data = sadData;
    ratingTrendsChart.update();
}

// Load saved data from localStorage
function loadSavedData() {
    const savedProducts = localStorage.getItem('products');
    if (savedProducts) {
        const parsedProducts = JSON.parse(savedProducts);
        products.forEach((product, index) => {
            if (parsedProducts[index]) {
                product.ratings = parsedProducts[index].ratings;
                product.reviews = parsedProducts[index].reviews;
            }
        });
    }

    const savedTheme = localStorage.getItem('theme');
    if (savedTheme) {
        document.documentElement.setAttribute('data-theme', savedTheme);
        updateChartsTheme();
    }
}

// Update charts theme
function updateChartsTheme() {
    chartColors.background = getComputedStyle(document.documentElement).getPropertyValue('--chart-bg').trim();
    chartColors.text = getComputedStyle(document.documentElement).getPropertyValue('--chart-text').trim();

    if (moodDistributionChart && ratingTrendsChart) {
        [moodDistributionChart, ratingTrendsChart].forEach(chart => {
            // Update legend colors
            chart.options.plugins.legend.labels.color = chartColors.text;

            // Update grid and tick colors for line chart
            if (chart.config.type === 'line') {
                chart.options.scales.x.grid.color = chartColors.text + '20';
                chart.options.scales.x.ticks.color = chartColors.text;
                chart.options.scales.y.grid.color = chartColors.text + '20';
                chart.options.scales.y.ticks.color = chartColors.text;
            }

            chart.update();
        });
    }
}

// Save data to localStorage
function saveData() {
    localStorage.setItem('products', JSON.stringify(products));
}

// Format relative time
function formatRelativeTime(timestamp) {
    const now = Date.now();
    const diff = now - timestamp;
    const seconds = Math.floor(diff / 1000);
    const minutes = Math.floor(seconds / 60);
    const hours = Math.floor(minutes / 60);
    const days = Math.floor(hours / 24);

    if (days > 0) return `${days} day${days > 1 ? 's' : ''} ago`;
    if (hours > 0) return `${hours} hour${hours > 1 ? 's' : ''} ago`;
    if (minutes > 0) return `${minutes} minute${minutes > 1 ? 's' : ''} ago`;
    return 'Just now';
}

// Create product card with keyboard accessibility
function createProductCard(product) {
    const card = document.createElement('div');
    card.className = 'product-card';
    card.setAttribute('tabindex', '0'); // Make card focusable

    const img = document.createElement('img');
    img.src = product.image;
    img.alt = product.name;
    img.loading = 'lazy'; // Enable lazy loading for images

    const title = document.createElement('h3');
    title.textContent = product.name;

    const description = document.createElement('p');
    description.textContent = product.description;

    const averageMood = document.createElement('div');
    averageMood.className = 'average-mood';
    averageMood.textContent = calculateAverageMood(product.ratings);

    const totalRatings = document.createElement('div');
    totalRatings.className = 'total-ratings';
    const ratingsCount = Object.values(product.ratings).reduce((a, b) => a + b, 0);
    totalRatings.textContent = `${ratingsCount} ${ratingsCount === 1 ? 'rating' : 'ratings'}`;

    const moodContainer = document.createElement('div');
    moodContainer.className = 'mood-container';
    moodContainer.setAttribute('role', 'radiogroup');
    moodContainer.setAttribute('aria-label', 'Select mood rating');

    Object.entries(moodTooltips).forEach(([mood, tooltip], index) => {
        const button = document.createElement('button');
        button.className = 'mood-button';
        button.setAttribute('data-mood', mood);
        button.setAttribute('data-product-id', product.id);
        button.setAttribute('role', 'radio');
        button.setAttribute('aria-checked', 'false');
        button.setAttribute('tabindex', '0');
        button.setAttribute('aria-label', tooltip);
        button.textContent = mood === 'happy' ? '😊' : mood === 'neutral' ? '😐' : '😢';

        // Add keyboard navigation
        button.addEventListener('keydown', (e) => {
            const buttons = moodContainer.querySelectorAll('.mood-button');
            const currentIndex = Array.from(buttons).indexOf(e.target);

            switch (e.key) {
                case 'ArrowLeft':
                case 'ArrowUp':
                    e.preventDefault();
                    const prevIndex = (currentIndex - 1 + buttons.length) % buttons.length;
                    buttons[prevIndex].focus();
                    break;
                case 'ArrowRight':
                case 'ArrowDown':
                    e.preventDefault();
                    const nextIndex = (currentIndex + 1) % buttons.length;
                    buttons[nextIndex].focus();
                    break;
                case ' ':
                case 'Enter':
                    e.preventDefault();
                    handleMoodSelection(product.id, mood);
                    break;
            }
        });

        moodContainer.appendChild(button);
    });

    const reviewsButton = document.createElement('button');
    reviewsButton.className = 'reviews-button';
    reviewsButton.textContent = 'View Reviews';
    reviewsButton.onclick = () => openReviewsModal(product.id);
    reviewsButton.setAttribute('aria-label', `View reviews for ${product.name}`);

    card.appendChild(img);
    card.appendChild(title);
    card.appendChild(description);
    card.appendChild(averageMood);
    card.appendChild(totalRatings);
    card.appendChild(moodContainer);
    card.appendChild(reviewsButton);

    return card;
}

// Modified handleMoodSelection function
function handleMoodSelection(productId, mood) {
    const timestamp = Date.now();
    const cooldownRemaining = lastRatingTime[productId] ? 
        RATING_COOLDOWN - (timestamp - lastRatingTime[productId]) : 0;

    if (cooldownRemaining > 0) {
        showNotification(`Please wait ${Math.ceil(cooldownRemaining / 1000)} seconds before rating again`);
        return;
    }

    const buttons = document.querySelectorAll(`.mood-button[data-product-id="${productId}"]`);
    buttons.forEach(button => {
        const isSelected = button.dataset.mood === mood;
        button.classList.toggle('selected', isSelected);
        button.setAttribute('aria-checked', isSelected);
    });

    handleRatingSubmission(productId, mood);
}

// Handle mood selection
function handleMoodSelection(event) {
    const button = event.target.closest('.mood-button');
    if (!button) return;

    const productId = button.dataset.productId;
    const mood = button.dataset.mood;
    const product = products.find(p => p.id === parseInt(productId));

    if (!product) return;

    // Check cooldown
    if (lastRatingTime[productId] && Date.now() - lastRatingTime[productId] < RATING_COOLDOWN) {
        const remainingTime = Math.ceil((RATING_COOLDOWN - (Date.now() - lastRatingTime[productId])) / 1000);
        showNotification(`Please wait ${remainingTime} seconds before rating again`);
        return;
    }

    const container = button.closest('.product-card');
    const moodButtons = container.querySelectorAll('.mood-button');
    moodButtons.forEach(btn => btn.classList.remove('selected'));
    button.classList.add('selected');

    selectedMoods[productId] = mood;
    const submitButton = container.querySelector('.submit-rating');
    submitButton.disabled = false;

    const phraseElement = container.querySelector('.mood-phrase');
    const randomPhrase = moodPhrases[mood][Math.floor(Math.random() * moodPhrases[mood].length)];
    phraseElement.textContent = randomPhrase;
}

// Handle rating submission
// Pagination settings
const ITEMS_PER_PAGE = 6;
let currentPage = 1;

// Loading spinner functions
function showLoading() {
    document.querySelector('.loading-overlay').style.display = 'flex';
}

function hideLoading() {
    document.querySelector('.loading-overlay').style.display = 'none';
}

// Create pagination controls
function createPaginationControls() {
    const totalPages = Math.ceil(products.length / ITEMS_PER_PAGE);
    const paginationContainer = document.getElementById('paginationContainer');
    paginationContainer.innerHTML = '';

    // Previous button
    const prevButton = document.createElement('button');
    prevButton.textContent = '← Previous';
    prevButton.disabled = currentPage === 1;
    prevButton.addEventListener('click', () => {
        if (currentPage > 1) {
            currentPage--;
            renderProducts();
        }
    });

    // Current page indicator
    const currentPageSpan = document.createElement('span');
    currentPageSpan.className = 'current-page';
    currentPageSpan.textContent = `${currentPage} / ${totalPages}`;

    // Next button
    const nextButton = document.createElement('button');
    nextButton.textContent = 'Next →';
    nextButton.disabled = currentPage === totalPages;
    nextButton.addEventListener('click', () => {
        if (currentPage < totalPages) {
            currentPage++;
            renderProducts();
        }
    });

    paginationContainer.appendChild(prevButton);
    paginationContainer.appendChild(currentPageSpan);
    paginationContainer.appendChild(nextButton);
}

// Modified renderProducts function with pagination
function renderProducts(searchQuery = '') {
    showLoading();
    const productsContainer = document.getElementById('productsContainer');
    productsContainer.innerHTML = '';

    const filteredProducts = products.filter(product =>
        product.name.toLowerCase().includes(searchQuery.toLowerCase()) ||
        product.description.toLowerCase().includes(searchQuery.toLowerCase())
    );

    const startIndex = (currentPage - 1) * ITEMS_PER_PAGE;
    const endIndex = startIndex + ITEMS_PER_PAGE;
    const paginatedProducts = filteredProducts.slice(startIndex, endIndex);

    paginatedProducts.forEach(product => {
        const productCard = createProductCard(product);
        productsContainer.appendChild(productCard);
    });

    createPaginationControls();
    setTimeout(hideLoading, 500); // Simulate loading delay
}

// Language support
const translations = {
    en: {
        happy: ['Love it! 🌟', 'Absolutely amazing! ✨', 'Best purchase ever! 🎉'],
        neutral: ['It\'s okay 🤔', 'Could be better 💭', 'Not bad, not great 📊'],
        sad: ['Disappointed 😔', 'Not what I expected 💔', 'Needs improvement 📉'],
        tooltips: {
            happy: 'I love it!',
            neutral: 'It\'s okay',
            sad: 'Not satisfied'
        },
        notifications: {
            ratingSubmitted: 'Rating submitted: ',
            waitCooldown: 'Please wait {seconds} seconds before rating again',
            resetConfirm: 'Are you sure you want to reset all ratings? This action cannot be undone.',
            resetSuccess: 'All ratings have been reset',
            notificationTitle: 'New Rating',
            notificationBody: 'A new {mood} rating was submitted for {product}'
        }
    },
    es: {
        happy: ['¡Me encanta! 🌟', '¡Increíble! ✨', '¡La mejor compra! 🎉'],
        neutral: ['Está bien 🤔', 'Podría ser mejor 💭', 'Ni bueno ni malo 📊'],
        sad: ['Decepcionado 😔', 'No es lo que esperaba 💔', 'Necesita mejorar 📉'],
        tooltips: {
            happy: '¡Me encanta!',
            neutral: 'Está bien',
            sad: 'No satisfecho'
        },
        notifications: {
            ratingSubmitted: 'Calificación enviada: ',
            waitCooldown: 'Por favor espera {seconds} segundos antes de calificar nuevamente',
            resetConfirm: '¿Estás seguro de que quieres reiniciar todas las calificaciones? Esta acción no se puede deshacer.',
            resetSuccess: 'Todas las calificaciones han sido reiniciadas',
            notificationTitle: 'Nueva Calificación',
            notificationBody: 'Se ha enviado una nueva calificación {mood} para {product}'
        }
    }
};

let currentLanguage = 'en';

// Language switcher function
function switchLanguage(lang) {
    if (translations[lang]) {
        currentLanguage = lang;
        moodPhrases.happy = translations[lang].happy;
        moodPhrases.neutral = translations[lang].neutral;
        moodPhrases.sad = translations[lang].sad;
        Object.assign(moodTooltips, translations[lang].tooltips);
        renderProducts(); // Re-render to update tooltips
        return true;
    }
    return false;
}

// Browser notifications
let notificationsEnabled = false;

async function enableNotifications() {
    try {
        const permission = await Notification.requestPermission();
        notificationsEnabled = permission === 'granted';
        return notificationsEnabled;
    } catch (error) {
        console.error('Error requesting notification permission:', error);
        return false;
    }
}

function showBrowserNotification(productId, mood) {
    if (!notificationsEnabled) return;

    const product = products.find(p => p.id === productId);
    if (!product) return;

    const t = translations[currentLanguage].notifications;
    const title = t.notificationTitle;
    const body = t.notificationBody
        .replace('{mood}', mood)
        .replace('{product}', product.name);

    new Notification(title, {
        body,
        icon: product.image
    });
}

// Modified handleRatingSubmission function
function handleRatingSubmission(productId, mood) {
    const timestamp = Date.now();
    const cooldownRemaining = lastRatingTime[productId] ? 
        RATING_COOLDOWN - (timestamp - lastRatingTime[productId]) : 0;

    const t = translations[currentLanguage].notifications;

    if (cooldownRemaining > 0) {
        showNotification(t.waitCooldown.replace('{seconds}', Math.ceil(cooldownRemaining / 1000)));
        return;
    }

    const product = products.find(p => p.id === productId);
    if (!product) return;

    product.ratings[mood]++;
    const randomPhrase = moodPhrases[mood][Math.floor(Math.random() * moodPhrases[mood].length)];
    product.reviews.push({ mood, timestamp, text: randomPhrase });

    saveToLocalStorage();
    updateMoodDistributionChart();
    updateRatingTrendsChart();
    updateDashboardStats();
    renderProducts();

    showNotification(t.ratingSubmitted + randomPhrase);
    showBrowserNotification(productId, mood);

    lastRatingTime[productId] = timestamp;
}

// Initialize notifications on page load
document.addEventListener('DOMContentLoaded', () => {
    if ('Notification' in window) {
        enableNotifications();
    }
});

// Open reviews modal
function openReviewsModal(productId) {
    const product = products.find(p => p.id === productId);
    if (!product) return;

    const modal = document.getElementById('reviewsModal');
    const reviewsList = modal.querySelector('.reviews-list');
    const modalTitle = modal.querySelector('h2');
    modalTitle.textContent = `Reviews for ${product.name}`;

    function renderReviews(filterMood = 'all') {
        const filteredReviews = filterMood === 'all' 
            ? product.reviews 
            : product.reviews.filter(review => review.mood === filterMood);

        reviewsList.innerHTML = filteredReviews
            .sort((a, b) => b.timestamp - a.timestamp)
            .map(review => `
                <div class="review-item">
                    <div class="review-mood">${review.mood === 'happy' ? '😊' : review.mood === 'neutral' ? '😐' : '😢'}</div>
                    <div class="review-details">
                        <div>${review.phrase}</div>
                        <div class="review-time">${formatRelativeTime(review.timestamp)}</div>
                    </div>
                </div>
            `).join('') || '<p>No reviews yet</p>';
    }

    // Set up filter buttons
    const filterButtons = modal.querySelectorAll('.filter-button');
    filterButtons.forEach(button => {
        button.addEventListener('click', () => {
            filterButtons.forEach(btn => btn.classList.remove('active'));
            button.classList.add('active');
            renderReviews(button.dataset.mood);
        });
    });

    // Initial render with all reviews
    renderReviews();

    // Show modal
    modal.style.display = 'flex';
}

// Close modal when clicking outside or on close button
document.addEventListener('click', (event) => {
    const modal = document.getElementById('reviewsModal');
    if (event.target === modal || event.target.classList.contains('close-modal')) {
        modal.style.display = 'none';
    }
});

// Update dashboard statistics
function updateDashboard() {
    const totalRatings = products.reduce((sum, product) => 
        sum + Object.values(product.ratings).reduce((a, b) => a + b, 0), 0);

    const allRatings = products.reduce((acc, product) => {
        Object.entries(product.ratings).forEach(([mood, count]) => {
            acc[mood] = (acc[mood] || 0) + count;
        });
        return acc;
    }, {});

    const popularMood = Object.entries(allRatings).reduce((a, b) => 
        (a[1] > b[1] ? a : b), ['none', 0])[0];

    const overallMood = calculateAverageMood(allRatings);

    document.getElementById('totalRatings').textContent = totalRatings;
    document.getElementById('popularMood').textContent = popularMood === 'none' ? '-' : 
        popularMood === 'happy' ? '😊' : 
        popularMood === 'neutral' ? '😐' : '😢';
    document.getElementById('overallMood').textContent = overallMood;
}

// Theme toggle
document.getElementById('themeToggle').addEventListener('click', () => {
    const currentTheme = document.documentElement.getAttribute('data-theme');
    const newTheme = currentTheme === 'light' ? 'dark' : 'light';
    document.documentElement.setAttribute('data-theme', newTheme);
    localStorage.setItem('theme', newTheme);
    updateChartsTheme();
});

// Reset ratings
document.getElementById('resetRatings').addEventListener('click', () => {
    if (!confirm('Are you sure you want to reset all ratings? This action cannot be undone.')) return;

    products.forEach(product => {
        product.ratings = { happy: 0, neutral: 0, sad: 0 };
        product.reviews = [];
    });
    selectedMoods = {};
    lastRatingTime = {};
    saveData();
    updateDashboard();
    updateMoodDistributionChart();
    updateRatingTrendsChart();
    renderProducts();
    showNotification('All ratings have been reset');
});

// Search functionality
document.getElementById('searchInput').addEventListener('input', (e) => {
    currentPage = 1; // Reset to first page when searching
    renderProducts(e.target.value);
});

// Show notification
function showNotification(message) {
    const notification = document.getElementById('notification');
    notification.textContent = message;
    notification.classList.add('show');
    setTimeout(() => notification.classList.remove('show'), 3000);
}

// Event listeners
document.addEventListener('click', handleMoodSelection);
document.addEventListener('click', handleRatingSubmission);

// Initialize
loadSavedData();
initializeCharts();
updateDashboard();
renderProducts(); // Initial render with pagination

// Periodic chart updates
setInterval(() => {
    updateMoodDistributionChart();
    updateRatingTrendsChart();
}, CHART_UPDATE_INTERVAL);

// Cross-tab/window synchronization
window.addEventListener('storage', (e) => {
    if (e.key === 'productRatings') {
        const storedData = JSON.parse(e.newValue);
        if (storedData) {
            products.forEach((product, index) => {
                Object.assign(product.ratings, storedData[index].ratings);
                product.reviews = storedData[index].reviews;
            });
            updateMoodDistributionChart();
            updateRatingTrendsChart();
            updateDashboardStats();
            renderProducts();
        }
    } else if (e.key === 'theme') {
        const newTheme = e.newValue;
        document.documentElement.setAttribute('data-theme', newTheme);
        updateChartsTheme();
    }
});

// Modified saveToLocalStorage function
function saveToLocalStorage() {
    const dataToStore = products.map(product => ({
        ratings: product.ratings,
        reviews: product.reviews
    }));
    localStorage.setItem('productRatings', JSON.stringify(dataToStore));
}

// Modified loadSavedData function
function loadSavedData() {
    const savedTheme = localStorage.getItem('theme');
    if (savedTheme) {
        document.documentElement.setAttribute('data-theme', savedTheme);
        updateChartsTheme();
    }

    const savedData = localStorage.getItem('productRatings');
    if (savedData) {
        const storedData = JSON.parse(savedData);
        products.forEach((product, index) => {
            if (storedData[index]) {
                Object.assign(product.ratings, storedData[index].ratings);
                product.reviews = storedData[index].reviews;
            }
        });
    }
}