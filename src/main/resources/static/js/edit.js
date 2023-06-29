//マイルストーン編集画面
const editButton = document.getElementById("editMilestone");
const milestoneInput = document.getElementById("milestoneInput");
const dateInput = document.getElementById("dateInput");
const categoryInput = document.getElementById("categoryInput");
const saveMilestoneButton = document.getElementById("saveMilestone");
const defaultStatus = document.getElementsByClassName("defaultStatus");
const changeStatus = document.getElementsByClassName("changeStatus");
const defaultPriority = document.getElementsByClassName("defaultPriority");
const changePriority = document.getElementsByClassName("changePriority");
const changeButton = document.getElementById("changebutton");
const editCancelButton = document.getElementById("editCancelButton");


editButton.addEventListener("click", () => {
  milestoneInput.disabled = false;
  dateInput.disabled = false;
  categoryInput.disabled = false;
  saveMilestoneButton.hidden = false;
  defaultStatus[0].hidden = true;
  changeStatus[0].hidden = false;
  defaultPriority[0].hidden = true;
  changePriority[0].hidden = false;
  changeButton.hidden = false;
});

editCancelButton.addEventListener("click", () => {
  milestoneInput.disabled = true;
  dateInput.disabled = true;
  categoryInput.disabled = true;
  saveMilestoneButton.hidden = true;
  defaultStatus[0].hidden = false;
  changeStatus[0].hidden = true;
  defaultPriority[0].hidden = false;
  changePriority[0].hidden = true;
  changeButton.hidden = true;
});