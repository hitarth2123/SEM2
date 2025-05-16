function startHeroSlideshow(movies) {
    const heroSection = document.querySelector('.hero-content');
    let currentIndex = 0;

    function updateHero() {
        if (movies.length === 0) return;

        const movie = movies[currentIndex];
        heroSection.innerHTML = `
            <h1 class="hero-title">${movie.title}</h1>
            <p class="hero-description">${movie.overview}</p>
            <img src="${movie.posterPath}" alt="${movie.title}" class="hero-image">
            <div class="hero-buttons">
                <button class="btn btn-play"><i class="fas fa-play"></i> Play</button>
                <button class="btn btn-more"><i class="fas fa-info-circle"></i> More Info</button>
            </div>
        `;

        currentIndex = (currentIndex + 1) % Math.min(movies.length, 4); // Loop through top 4 movies
    }

    updateHero(); // Initial call
    setInterval(updateHero, 5000); // Change every 5 seconds
} 