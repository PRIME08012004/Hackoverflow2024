document.querySelector("form").addEventListener("submit", function(event) {
    event.preventDefault(); 
    
    let formData = new FormData(document.querySelector("form"));
    
    fetch("/submit_form", {
        method: "POST",
        body: formData
    })
    .then(response => {
        if (response.ok) {
            alert("Form submited Succeessful!")
            window.location.href = "index2.html";
        } else {
            console.error("Error submitting form");
        }
    })
    .catch(error => {
        console.error("Error:", error);
    });
});
