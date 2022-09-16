"use strict";
//selectors section
//Divs

//Inputs
let idInput = document.querySelector("#idInput")
let titleInput = document.querySelector("#titleInput");
let genreInput = document.querySelector("#genreInput");
let releaseYearInput = document.querySelector("#releaseYearInput");
let userRatingInput = document.querySelector("#userRatingInput");

//Buttons - linked to event listeners for when buttons are clicked
let createBtn = document.querySelector("#createBtn");
let updateBtn = document.querySelector("#updateBtn");
let deleteBtn = document.querySelector("#deleteBtn");

//Functions

let printResults = (result) => {
    let entryParent = document.createElement("div");
    entryParent.setAttribute("class","entry-parent");

    let entryDiv = document.createElement("div");
    entryDiv.setAttribute("class", "entry-div");
    entryDiv.textContent = `${result.id} | ${result.title} | ${result.genre} | ${result.releaseYear} | ${result.userRating}`;
    //change to make it more obvious what it is 

    let deleteBtn = document.createElement("button");
    deleteBtn.textContent = "Delete";
    deleteBtn.type = "button";
    deleteBtn.setAttribute("Class", "btn btn-danger btn-sm");
    deleteBtn.setAttribute("onClick", `del(${result.id})`);

    entryParent.appendChild(entryDiv);
    entryParent.appendChild(deleteBtn);
    resultsDiv.appendChild(entryParent);
}
// Create
let create = () => {

    if(!validateFormInputs()){
        alert("Please enter values in all the fields")
        return
    }
    let obj = {
        "title":titleInput.value,
        "genre":genreInput.value,
        "releaseYear": parseInt(releaseYearInput.value),
        "userRating": parseFloat(userRatingInput.value) 
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
        resultsDiv.innerHTML = "";
        let results = response.data;

        for(let result of results) {
            printResults(result);
        }
    }).catch(error => {console.log(error);});
}
// // Get  by id
// let getbyId = () => {
//     axios.get("http://localhost:8080/movies/getbyID/${id}")
//     //promise - .then is for success -.catch is for a fail
        
//     .then(response => {
//             resultsDiv.innerHTML = "";
//             let results = response.data;
//             console.log(response.data);
//             getAll();
//         }).catch(error => console.log(error));
//     }

// update
let update = () => {
    
    let obj = {
        "title":titleInput.value,
        "genre":genreInput.value,
        "releaseYear": parseInt(releaseYearInput.value),
        "userRating": parseFloat(userRatingInput.value)
    }

    axios.put(`http://localhost:8080/movies/update/${idInput.value}`, obj)
    //promise - .then is for success -.catch is for a fail
    .then(response => {
        console.log(response.data);
        getAll();
    }).catch(error => console.log(error));
}
// Delete
let del = (id) => {
    axios.delete(`http://localhost:8080/movies/delete/${id}`)
    //promise - .then is for success -.catch is for a fail
    .then(response => {
        console.log(response.data);
        getAll();
    }).catch(error => console.log(error));
}

let validateFormInputs = () => {
    if (titleInput.value === ""|| genreInput.value === "" || releaseYearInput.value === "" || userRatingInput === "") {
        return false;
    } else {
        return true;
    }
}
//Event Listeners
createBtn.addEventListener("click", create);
updateBtn.addEventListener("click", update);
deleteBtn.addEventListener("click", del);