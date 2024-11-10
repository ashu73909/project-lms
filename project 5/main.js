// DOM Elements
const loginSection = document.getElementById('loginSection');
const dashboardSection = document.getElementById('dashboardSection');
const loginForm = document.getElementById('loginForm');
const logoutBtn = document.getElementById('logoutBtn');
const navBtns = document.querySelectorAll('.nav-btn');
const tabContents = document.querySelectorAll('.tab-content');

// Login Handler
loginForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Simple validation (replace with actual authentication)
    if (username && password) {
        loginSection.classList.remove('active');
        dashboardSection.classList.add('active');
    }
});

// Logout Handler
logoutBtn.addEventListener('click', () => {
    dashboardSection.classList.remove('active');
    loginSection.classList.add('active');
    loginForm.reset();
});

// Tab Navigation
navBtns.forEach(btn => {
    btn.addEventListener('click', () => {
        // Update active button
        navBtns.forEach(b => b.classList.remove('active'));
        btn.classList.add('active');

        // Show corresponding tab content
        const tabId = btn.dataset.tab + 'Tab';
        tabContents.forEach(tab => {
            tab.classList.remove('active');
            if (tab.id === tabId) {
                tab.classList.add('active');
            }
        });
    });
});

// Course Progress Animation
document.querySelectorAll('.progress').forEach(progress => {
    const width = progress.style.width;
    progress.style.width = '0';
    setTimeout(() => {
        progress.style.transition = 'width 1s ease-in-out';
        progress.style.width = width;
    }, 100);
});

// Course Enrollment Handler
document.querySelectorAll('.btn-primary').forEach(btn => {
    btn.addEventListener('click', (e) => {
        const action = e.target.textContent;
        if (action === 'Enroll Now') {
            e.target.textContent = 'Enrolled';
            e.target.style.backgroundColor = '#28a745';
        }
    });
});