// index.js

document.addEventListener('DOMContentLoaded', function() {
    // Add event listeners to show/hide CRUD operation forms
    document.getElementById('getButton').addEventListener('click', function() {
        toggleFormVisibility('getForm');
    });
    document.getElementById('putButton').addEventListener('click', function() {
        toggleFormVisibility('putForm');
    });
    document.getElementById('deleteButton').addEventListener('click', function() {
        toggleFormVisibility('deleteForm');
    });

    // Add event listeners for form submissions
    document.getElementById('registrationForm').addEventListener('submit', handleRegistration);
    document.getElementById('getForm').addEventListener('submit', handleGet);
    document.getElementById('putForm').addEventListener('submit', handlePut);
    document.getElementById('deleteForm').addEventListener('submit', handleDelete);

    // Add event listeners for input fields
    document.getElementById('studentIdGet').addEventListener('input', validateGetForm);
    document.getElementById('studentIdDelete').addEventListener('input', validateDeleteForm);
});

// Function to toggle form visibility
function toggleFormVisibility(formId) {
    const form = document.getElementById(formId);
    form.style.display = form.style.display === 'none' ? 'block' : 'none';
}

// Function to handle registration form submission
function handleRegistration(event) {
    event.preventDefault();
    const formData = new FormData(this);
    const jsonObject = {};
    formData.forEach(function(value, key) {
        jsonObject[key] = value;
    });
    // Send form data to backend API
    fetch('http://localhost:8080/api/v1/student/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonObject)
    })
    .then(handleResponse)
    .catch(handleError);
}

// Function to handle GET form submission
function handleGet(event) {
    event.preventDefault();
    const studentId = document.getElementById('studentIdGet').value.trim();
    // Fetch data from backend API
    fetch(`http://localhost:8080/api/v1/student/${studentId}`)
        .then(handleResponse)
        .catch(handleError);
}

// Function to handle PUT form submission
function handlePut(event) {
    event.preventDefault();
    const studentId = document.getElementById('studentIdPut').value.trim();
    const formData = new FormData(this);
    const jsonObject = {};
    formData.forEach(function(value, key) {
        jsonObject[key] = value;
    });
    // Send updated data to backend API
    fetch(`http://localhost:8080/api/v1/student/${studentId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonObject)
    })
    .then(handleResponse)
    .catch(handleError);
}

// Function to handle DELETE form submission
function handleDelete(event) {
    event.preventDefault();
    const studentId = document.getElementById('studentIdDelete').value.trim();
    // Delete data from backend API
    fetch(`http://localhost:8080/api/v1/student/${studentId}`, {
        method: 'DELETE'
    })
    .then(handleResponse)
    .catch(handleError);
}

// Function to handle response from API
function handleResponse(response) {
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    return response.json();
}

// Function to handle errors
function handleError(error) {
    console.error('Error:', error);
    alert('Error: ' + error.message);
}

// Validation functions
function validateGetForm() {
    const studentId = document.getElementById('studentIdGet').value.trim();
    document.getElementById('getStudentButton').disabled = !isValidStudentId(studentId);
}

function validateDeleteForm() {
    const studentId = document.getElementById('studentIdDelete').value.trim();
    document.getElementById('deleteStudentButton').disabled = !isValidStudentId(studentId);
}

// Helper function to validate student ID
function isValidStudentId(studentId) {
    return /^\d+$/.test(studentId);
}
