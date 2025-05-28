document.addEventListener('DOMContentLoaded', () => {
    const counterElement = document.getElementById('counter');
    const incrementBtn = document.getElementById('increment');
    const decrementBtn = document.getElementById('decrement');
    const resetBtn = document.getElementById('reset');
    
    let count = 0;
    
    function updateCounter() {
        counterElement.textContent = count;
        
        counterElement.className = 'counter';
        if (count > 0) {
            counterElement.classList.add('positive');
        } else if (count < 0) {
            counterElement.classList.add('negative');
        } else {
            counterElement.classList.add('zero');
        }
    }
    
    incrementBtn.addEventListener('click', () => {
        count++;
        updateCounter();
    });
    
    decrementBtn.addEventListener('click', () => {
        if (count > 0) {
            count--;
            updateCounter();
        }
    });
    
    resetBtn.addEventListener('click', () => {
        count = 0;
        updateCounter();
    });
    
    updateCounter();
});
