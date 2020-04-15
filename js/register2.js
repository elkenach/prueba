var idUser = localStorage.getItem('id');
let img = document.getElementById("publication__img");
var formSport = document.getElementById("form");
	
formSport.onsubmit = sendUserSport;

function sendDataUser(){
	let fileInput = document.getElementById("img_profile");
	let imgSource = "";
	var formdata = new FormData();
	formdata.append("description", "nada falta campo");
	formdata.append("file", fileInput.files[0], fileInput.files[0].name);

	var requestOptions = {
		method: 'PUT',
  		body: formdata,
  		redirect: 'follow'
	};

	fetch("http://localhost:8080/v1/users/" + idUser, requestOptions)
	  .then(response => response.text())
	  .then(result => mostrarImg(JSON.parse(result).profilePic))	
	  .catch(error => console.log('error', error));
}

function mostrarImg(imgSource){
	img.src = imgSource;
	
}

function sendDataUserSport(idSport){
	var request = new XMLHttpRequest();
	request.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 201){
			window.location.href="./dashboard.html";
		}
	}
	request.open("POST","http://localhost:8080/v1/userSport" ,true);
	request.setRequestHeader("Content-Type","application/json");
	var data = {
		idUser: idUser,
		idSport: idSport
	}
	request.send(JSON.stringify(data));
}

function sendUserSport(e){
	e.preventDefault();
	let idSportsStorage=[];
	for(let i in formSport.sport){
		if(formSport.sport[i].checked){
			sendDataUserSport(formSport.sport[i].value);
		}
	}
}
