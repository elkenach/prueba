var idUser = localStorage.getItem('id');
let img = document.getElementById("publication__img");


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
