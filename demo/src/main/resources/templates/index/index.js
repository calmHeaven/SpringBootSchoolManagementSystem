  document.getElementById('registrationForm').addEventListener('submit', function(event) {
            // event.preventDefault(); // Prevent the default form submission

            var formData = new FormData(this); // Get form data
            var jsonObject = {}; // Convert form data to JSON object
            formData.forEach(function(value, key) {
                jsonObject[key] = value;
            });

            // Send form data to backend API
            fetch('api/v1/student', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(jsonObject)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json(); // Parse response body as JSON
            })
            .then(data => {
                console.log('Registration successful:', data);
                alert('Registration successful!');
                // Redirect to another page, show success message, or perform other actions
            })
            .catch(error => {
                console.error('Error registering:', error);
                alert('Error registering: ' + error.message);
                // Handle registration errors or display error messages to the user
            });
        });

        document.getElementById('getButton').addEventListener('click', function() {
            document.getElementById('getForm').style.display = 'block';
        });

        document.getElementById('putButton').addEventListener('click', function() {
            document.getElementById('putForm').style.display = 'block';
        });

        document.getElementById('deleteButton').addEventListener('click', function() {
            document.getElementById('deleteForm').style.display = 'block';
        });

document.getElementById('getForm').addEventListener('submit', function(event) {
    event.preventDefault();
    var studentId = document.getElementById('studentIdGet').value; // Retrieve student ID from input field
    fetch('http://localhost:8080/api/v1/student/' + studentId)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('GET successful:', data);
            alert('GET successful!');
            // Do something with the retrieved data, such as displaying it on the page
        })
        .catch(error => {
            console.error('Error fetching data:', error);
            alert('Error fetching data: ' + error.message);
        });
});

document.getElementById('putForm').addEventListener('submit', function(event) {
    event.preventDefault();
    var studentId = document.getElementById('studentIdPut').value; // Retrieve student ID from input field
    var formData = new FormData(this);
    var jsonObject = {};
    formData.forEach(function(value, key) {
        jsonObject[key] = value;
    });
    fetch('http://localhost:8080/api/v1/student/' + studentId, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonObject)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        console.log('PUT successful:', data);
        alert('PUT successful!');
    })
    .catch(error => {
        console.error('Error updating data:', error);
        alert('Error updating data: ' + error.message);
    });
});

document.getElementById('deleteForm').addEventListener('submit', function(event) {
    event.preventDefault();
    var studentId = document.getElementById('studentIdDelete').value; // Retrieve student ID from input field
    fetch('http://localhost:8080/api/v1/student/' + studentId, {
        method: 'DELETE'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        console.log('DELETE successful:', data);
        alert('DELETE successful!');
    })
    .catch(error => {
        console.error('Error deleting data:', error);
        alert('Error deleting data: ' + error.message);
    });
});
