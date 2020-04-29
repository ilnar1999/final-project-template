$(document).ready(function() {
    hideAllPopUps();
    setAllCheckedAttributesOfCheckboxes();
});

function hideAllPopUps() {
    $("#dark-background").hide();
    $("#delete-user-form").hide();
    $("#change-user-role-form").hide();
}

function showDeleteUserForm(id, login) {
    let text = `Вы действительно хотите удалить пользователя "${login}"?`;
    document.getElementById('delete-user-confirm-question').innerHTML = text;
    document.getElementById('delete-user-form-user-id').setAttribute('value', id);
    $("#dark-background").show();
    $("#delete-user-form").show();
}

function setAllCheckedAttributesOfCheckboxes() {
    let checkboxes = document.getElementsByClassName('role-checkbox');
    let hasThisRole;
    for (let i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].value == "true") {
            hasThisRole = true;
        } else {
            hasThisRole = false;
        }
        checkboxes[i].checked = hasThisRole;
    }
}

function setUserRole(role, login, userId, isChecked) {
    let text;
    let roleAsText = role == "admin" ? "администратора" : "менеджера";

    document.getElementById('change-user-role-form-user-id').setAttribute('value', userId);
    document.getElementById('change-user-role-form-role').setAttribute('value', role);

    if (isChecked) {
        text = `Вы действительно хотите дать пользователю "${login}" права ${roleAsText}?`;
        document.getElementById('change-user-role-form-action').setAttribute('value', "add");
    } else {
        text = `Вы действительно хотите лишить пользователя "${login}" прав ${roleAsText}?`;
        document.getElementById('change-user-role-form-action').setAttribute('value', "delete");
    }

    document.getElementById('change-user-role-confirm-question').innerHTML = text;
    $("#dark-background").show();
    $("#change-user-role-form").show();
}

function changeCheckboxValue() {
    let role = document.getElementById('change-user-role-form-role').value;
    let userId = document.getElementById('change-user-role-form-user-id').value;
    let checkbox = document.getElementById(`checkbox-${role}-${userId}`);
    checkbox.checked = !checkbox.checked;
    hideAllPopUps();
}

function markCurrentUser(id) {
    document.getElementById(`user-row-${id}`).style.backgroundColor = "#eee";
    document.getElementById(`delete-button-${id}`).setAttribute("disabled", "true");
    document.getElementById(`checkbox-Admin-${id}`).setAttribute("disabled", "true");
}