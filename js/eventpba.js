
function getEvents(){
	var requestEvent = new XMLHttpRequest(); //creando objeto 
	requestEvent.onreadystatechange = function(){
		if (this.readyState ==4 && this.status ==200) {
			var responseEvent = this.responseText;
			console.log(JSON.parse(responseEvent));
			displayEvent(JSON.parse(responseEvent));
		}
	}
	requestEvent.open('GET','http://localhost:8080/v1/events',true);
	requestEvent.send();
}

function displayEvent(dataEvents){

	console.log(dataEvents);

	var divContent=document.getElementById("content-event");
	for(let events of dataEvents){
		
		let sectionEvent=document.createElement("section-PBA");
		let divPubCol=document.createElement("div");
		let divPubCont=document.createElement("div");
		let h2=document.createElement("h2");
		let img=document.createElement("img");
		let divPubDesc= document.createElement("div");
		let divPubDescTag= document.createElement("div");
		let a=document.createElement("a");
		let p=document.createElement("p");

		let divCalendar=document.createElement("div");

		let divMapContainer=document.createElement("div");
		let divMapContainerChild=document.createElement("div");
		let divNull1=document.createElement("div");
		let divMap=document.createElement("div");
		let divNull2=document.createElement("div");

		
		h2.innerText=events.name;
		img.src=events.photo;
		a.innerText=events.link;
		p.innerText=events.description;


		sectionEvent.classList.add("publication-PBA");
		divPubCol.classList.add("d-flex");
		divPubCol.classList.add("justify-content-center");
		divPubCont.classList.add("p-5");
		h2.classList.add("publication__h2--title");
		divPubDesc.classList.add("publication__description");
		divPubDescTag.classList.add("publication__description--tag");
		divMapContainer.classList.add("d-flex");
		divMapContainer.classList.add("p-5");
		divMapContainerChild.classList.add("d-flex");
		divMapContainerChild.classList.add("justify-content-between");


		divPubDescTag.appendChild(a);
		divPubDesc.appendChild(divPubDescTag);
		divPubDesc.appendChild(p);
		divPubCont.appendChild(h2);
		divPubCont.appendChild(img);
		divPubCont.appendChild(divPubDesc);
		divPubCol.appendChild(divPubCont);
		divPubCol.appendChild(divCalendar);
		sectionEvent.appendChild(divPubCol);
		sectionEvent.appendChild(divMapContainer);


		console.log(events);
	}



}