//マイルストーン編集画面
const editButton = document.getElementById('editMilestone');
const milestoneInput = document.getElementById('milestoneInput');
const dateInput = document.getElementById('dateInput');
const categoryInput = document.getElementById('categoryInput');
const saveMilestoneButton = document.getElementById('saveMilestone');
const defaultStatus = document.getElementsByClassName('defaultStatus');
const changeStatus = document.getElementsByClassName('changeStatus');
const defaultPriority = document.getElementsByClassName('defaultPriority');
const changePriority = document.getElementsByClassName('changePriority');

editButton.addEventListener('click', () => {
  console.log('click');
  milestoneInput.disabled = false;
  dateInput.disabled = false;
  categoryInput.disabled = false;
  saveMilestoneButton.hidden = false;
  defaultStatus[0].hidden = true;
  changeStatus[0].hidden = false;
});
