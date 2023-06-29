//ユーザー編集画面
const editButton = document.getElementById("changeUserImage");
const editUserImageForm = document.getElementById("editUserImageForm");
const editCancelButton = document.getElementById("editCancelButton");


editButton.addEventListener("click", () => {
    editUserImageForm.hidden = false;
    editCancelButton.hidden = false;
});

editCancelButton.addEventListener("click", () => {
    editUserImageForm.hidden = true;
    editCancelButton.hidden = true;
});