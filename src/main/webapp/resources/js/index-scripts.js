$(document).ready(function() {
    hideAllPopUps();

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

function showDeleteCarForm() {
    $("#dark-background").show();
    $("#delete-car").show();
}

function showCarInformationForm(brand, model, price) {
    document.getElementById("car-brand").innerHTML = `Производитель: ${brand}` ;
    document.getElementById("car-model").innerHTML = `Модель: ${model}`;
    document.getElementById("car-price").innerHTML = `Стоимость: ${price}$`;
    $("#dark-background").show();
    $("#car-information").show();
}

function selectImage(path) {
    document.getElementById("changing-car-image").setAttribute('src', path);
}