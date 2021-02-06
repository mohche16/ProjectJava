let geoLabel = document.querySelector("#geolabel");

let geoPos;

function getLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(setPos);
	geoLabel.innerHTML = "Geolocation is available.";
  } else {
    geoLabel.innerHTML = "Geolocation is not supported by this browser.";
  }
}

let xLongEl = document.querySelector("#xlong");
let yLatEl = document.querySelector("#ylat");
function setPos(position) {
	geoPos = position;
	
	if (xLongEl && yLatEl)
	{
		xLongEl.value = position.coords.latitude;
		yLatEl.value = position.coords.longitude;
	}
	
}

let stopListContainer = document.querySelector("#stopcontainer").getElementsByClassName("stoplist")[0];
let searchBtn = document.querySelector("#searchbtn");

function fieldsEmpty() {
	if (xLongEl.value == "Söker!" || yLatEl.value == "Söker!")
	{
			stopListContainer.insertAdjacentHTML("beforeend", "<h4>Vänligen vänta tills vi har din position!");
			return false;
	 }
}

window.onload = (e) => {
 	getLocation();
};