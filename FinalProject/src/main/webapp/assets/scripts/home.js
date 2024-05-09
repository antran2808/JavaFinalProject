const cardDescription = document.querySelectorAll(".card-description");
cardDescription.forEach(item => {
    item.innerHTML = item.innerHTML.substring(0, 100) + ". . .";
});

