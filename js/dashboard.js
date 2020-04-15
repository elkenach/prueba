var idUser = localStorage.getItem('id');
loadUserSport();

function loadUserSport(){
	var request = new XMLHttpRequest();
	request.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200) {
		var response = this.responseText;
		saveLocalStorage(JSON.parse(response));
		}	
	}
	request.open("GET", "http://localhost:8080/v1/users/"+idUser+"/sports",true);
	request.send();
}

function saveLocalStorage(userSports){
	let idSports = [];
	for(let i in userSports){
	    idSports.push(userSports[i].idSport);
	}
	localStorage.setItem('idSport', idSports);
}