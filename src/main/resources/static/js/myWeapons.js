const btn = document.getElementById("loadMyWeapons");
btn.addEventListener("click", renderBoughtWeapons);

const card = document.getElementById("card-container");

function renderBoughtWeapons(event) {
    event.preventDefault();
    btn.style.display = 'none';
    fetch("http://localhost:8080/api/getUserWeapons", {
        method: 'GET',
        redirect: "follow",
    }).then(res => res.json())
        .then(data => {
            if (data.length === 0) {
                card.appendChild(createH1());
            }
            data.forEach(w => card.appendChild(createCard(w)));
        })
        .catch(err => console.log('error', err));
}

function createCard(weaponData) {
    let mainDiv = document.createElement('DIV');
    mainDiv.setAttribute("class", "offer card col-sm-6 col-md-3  col-lg-2 m-1 p-0");
    let cardDiv = document.createElement("DIV");
    cardDiv.setAttribute("class","card-img-top-wrapper");
    let image = document.createElement("IMG");
    image.setAttribute("class", "card-img-top");
    image.setAttribute("width", "100");
    image.setAttribute("height", "100");
    image.src = weaponData.imageUrl;
    cardDiv.appendChild(image);
    let title = document.createElement("DIV");
    title.setAttribute("class", "card-body pb-1");
    let titleH = document.createElement("H5");
    titleH.innerHTML = weaponData.name;
    title.appendChild(titleH);
    cardDiv.appendChild(title);
    mainDiv.appendChild(cardDiv);
    return mainDiv;
}

function createH1() {
    let title = document.createElement("h1")
    title.textContent = "YOU DON'T OWN ANY WEAPONS YET!";
    return title;
}