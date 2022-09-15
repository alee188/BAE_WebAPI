"use strict";
//selectors section
//Divs

//Inputs

//Buttons - linked to event listeners for when buttons are clicked
let createBtn = document.querySelector("#createBtn");
let updateBtn = document.querySelector("#updateBtn");
let deleteBtn = document.querySelector("#deleteBtn");

// Create
let create = () => {

    let obj = {
        "title":"Jumanji",
        "genre":"adventure",
        "releaseYear": 1995,
        "userRating": 7.0
    }

    axios.post("http://localhost:8080/movies/create", obj)
    //promise - .then is for success -.catch is for a fail
    .then(response => {
        console.log(response.data);
        getAll();
    }).catch(error => console.log(error));
}
// Get All with function expression
let getAll = () => {
    axios.get("http://localhost:8080/movies/getAll")
    //promise - .then is for success -.catch is for a fail
    .then(response => {
        console.log(response.data)
    }).catch(error => console.log(error));
}

// update
let update = () => {
    
    let obj = {
        "title":"Jumanji 2",
        "genre":"adventure",
        "releaseYear": 1996,
        "userRating": 7.0
    }

    axios.put("http://localhost:8080/movies/update/3", obj)
    //promise - .then is for success -.catch is for a fail
    .then(response => {
        console.log(response.data);
        getAll();
    }).catch(error => console.log(error));
}
// Delete
let del = () => {
    axios.delete("http://localhost:8080/movies/delete/2")
    //promise - .then is for success -.catch is for a fail
    .then(response => {
        console.log(response.data);
        getAll();
    }).catch(error => console.log(error));
}

//Event Listeners
createBtn.addEventListener("click", create);
updateBtn.addEventListener("click", update);
deleteBtn.addEventListener("click", del);