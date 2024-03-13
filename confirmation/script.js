document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('feedbackForm');

    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent submitting
        
        if (validateForm()) {
            const formData = new FormData(form);
            fetch('/submit_feedback', {
                method: 'POST',
                body: formData
            })
            .then(response => {
                if (response.ok) {
                    alert("Thanks for feedback");
                    form.reset(); // Reset the form
                } else {
                    alert('Failed to submit feedback. Please try again.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('An error occurred. Please try again.');
            });
        }
    });

    function validateForm() {
        const name = form.elements['name'].value;
        const email = form.elements['email'].value;
        const rating = form.elements['rating'].value;
        const comments = form.elements['comments'].value;

        if (name.trim() === '' || email.trim() === '' || rating.trim() === '' || comments.trim() === '') {
            alert('Please fill in all fields.');
            return false;
        }

        return true;
    }
});
