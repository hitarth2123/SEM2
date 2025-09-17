// User Authentication System
const auth = {
  currentUser: null,
  
  init: function() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser')) || null;
    this.updateAuthUI();
  },
  
  register: function(username, email, password) {
    let users = JSON.parse(localStorage.getItem('users')) || [];
    
    if (users.some(user => user.email === email)) {
      return { success: false, message: 'Email already registered' };
    }
    
    const newUser = { username, email, password };
    users.push(newUser);
    localStorage.setItem('users', JSON.stringify(users));
    
    this.login(email, password);
    return { success: true };
  },
  
  login: function(email, password) {
    const users = JSON.parse(localStorage.getItem('users')) || [];
    const user = users.find(u => u.email === email && u.password === password);
    
    if (user) {
      this.currentUser = user;
      localStorage.setItem('currentUser', JSON.stringify(user));
      this.updateAuthUI();
      return { success: true };
    }
    
    return { success: false, message: 'Invalid credentials' };
  },
  
  logout: function() {
    this.currentUser = null;
    localStorage.removeItem('currentUser');
    this.updateAuthUI();
  },
  
  updateAuthUI: function() {
    const loginLinks = document.querySelectorAll('.login-link');
    const logoutLinks = document.querySelectorAll('.logout-link');
    const userElements = document.querySelectorAll('.user-info');
    
    if (this.currentUser) {
      loginLinks.forEach(link => link.style.display = 'none');
      logoutLinks.forEach(link => link.style.display = 'block');
      userElements.forEach(el => {
        el.textContent = this.currentUser.username;
        el.style.display = 'inline';
      });
    } else {
      loginLinks.forEach(link => link.style.display = 'block');
      logoutLinks.forEach(link => link.style.display = 'none');
      userElements.forEach(el => el.style.display = 'none');
    }
  }
};

// Product Rendering System
const products = {
  init: function() {
    this.fetchProducts();
  },
  
  fetchProducts: function() {
    fetch('data/products.json')
      .then(response => response.json())
      .then(data => this.renderProducts(data))
      .catch(error => console.error('Error loading products:', error));
  },
  
  renderProducts: function(products) {
    const productGrids = document.querySelectorAll('.product-grid');
    
    productGrids.forEach(grid => {
      grid.innerHTML = products.map(product => 
        `<div class="product-card">
          <img src="images/${product.id}.jpg" alt="${product.name}">
          <h3>${product.name}</h3>
          <p>$${product.price.toFixed(2)}</p>
          <button class="add-to-cart" data-id="${product.id}">Add to Cart</button>
        </div>`
      ).join('');
    });
    
    // Add event listeners to all add-to-cart buttons
    document.querySelectorAll('.add-to-cart').forEach(button => {
      button.addEventListener('click', (e) => {
        const productId = parseInt(e.target.dataset.id);
        const product = products.find(p => p.id === productId);
        cart.addItem(product);
      });
    });
  }
};

// Cart System
const cart = {
  items: [],
  
  init: function() {
    this.items = JSON.parse(localStorage.getItem('cart')) || [];
    this.updateCartCount();
  },
  
  addItem: function(product) {
    this.items.push(product);
    localStorage.setItem('cart', JSON.stringify(this.items));
    this.updateCartCount();
    alert(`${product.name} added to cart!`);
  },
  
  removeItem: function(index) {
    this.items.splice(index, 1);
    localStorage.setItem('cart', JSON.stringify(this.items));
    this.updateCartCount();
  },
  
  clear: function() {
    this.items = [];
    localStorage.removeItem('cart');
    this.updateCartCount();
  },
  
  updateCartCount: function() {
    const cartCounts = document.querySelectorAll('.cart-count');
    cartCounts.forEach(el => {
      el.textContent = this.items.length;
      el.style.display = this.items.length ? 'inline' : 'none';
    });
  }
};

// Initialize all systems when DOM is loaded
document.addEventListener('DOMContentLoaded', function() {
  auth.init();
  products.init();
  cart.init();
});