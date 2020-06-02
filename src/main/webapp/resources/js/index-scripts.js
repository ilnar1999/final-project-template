$(document).ready(function() {
    if (document.getElementById('edit-button')) {
        enableEditMod();
    }

    if (document.getElementById("error-category-name").textContent != "") {
        showCreateCategoryForm();
    }
});

function hideAllPopUps() {
    $("#dark-background").hide();
    $("#create-category").hide();
    $("#delete-category").hide();
    $("#create-car").hide();
    $("#delete-car").hide();
    $("#car-information").hide();
    $("#delete-car").hide();
}

function showCreateCategoryForm() {
    $("#dark-background").show();
    $("#create-category").show();
}

function showDeleteCategoryForm(categoryId, categoryName) {
    let text = "Вы действительно хотите удалить категорию \"" + categoryName + "\"?";
    $("#dark-background").show();
    document.getElementById("confirm-category-remove").innerHTML = text;
    document.getElementById("category-id").setAttribute('value', categoryId);
    $("#delete-category").show();
}

function showCreateCarForm(categoryId) {
    $("#dark-background").show();
    document.getElementById("create-car-category-id").setAttribute('value', categoryId);
    $("#create-car").show();
}

function showDeleteCarForm(carId) {
    hideAllPopUps();
    $("#dark-background").show();
    document.getElementById("delete-car-car-id").setAttribute('value', carId);
    $("#delete-car").show();
}

function showCarInformationForm(id, image, brand, model, price) {
    document.getElementById("car-information-image").setAttribute('src', image);
    document.getElementById("car-brand").innerHTML = `Производитель: ${brand}` ;
    document.getElementById("car-model").innerHTML = `Модель: ${model}`;
    document.getElementById("car-price").innerHTML = `Стоимость: ${price}$`;
    if (document.getElementById("delete-car-button")) {
        document.getElementById("delete-car-button").setAttribute('onclick', `showDeleteCarForm(${id})`);
    }
    $("#dark-background").show();
    $("#car-information").show();
}

function selectImage(path) {
    document.getElementById("changing-car-image").setAttribute('src', path);
}

function enableEditMod() {
    let button = document.getElementById('edit-button');
    let elements = document.getElementsByClassName('edit-element');
    button.style.backgroundColor = '#800';
    button.innerHTML = "Отменить редактирование";
    button.setAttribute('onclick', 'disableEditMod()');
    for (let i = 0; i < elements.length; i++) {
        elements[i].style.display = 'inline';
    }
}

function disableEditMod() {
    let button = document.getElementById('edit-button');
    button.style.backgroundColor = '#555';
    button.innerHTML = "Редактировать";
    button.setAttribute('onclick', 'enableEditMod()');
    hideAllEditElements();
}

function hideAllEditElements() {
    let elements = document.getElementsByClassName('edit-element');
    for (let i = 0; i < elements.length; i++) {
        elements[i].style.display = 'none';
    }
}
