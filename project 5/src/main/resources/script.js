document.addEventListener('DOMContentLoaded', function() {
    // Handle navigation
    const navLinks = document.querySelectorAll('nav a');
    navLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            navLinks.forEach(l => l.classList.remove('active'));
            this.classList.add('active');
        });
    });

    // Handle course buttons
    const courseButtons = document.querySelectorAll('.btn');
    courseButtons.forEach(button => {
        button.addEventListener('click', function() {
            alert('Redirecting to course content...');
        });
    });
});