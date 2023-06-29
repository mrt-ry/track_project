function updateContent() {
    var selectBox = document.getElementById("categorySelect");
    var selectedCategory = selectBox.value;

    // 選択されたカテゴリを表示内容に反映する
    var contentDivs = document.querySelectorAll(".categoryData");

    contentDivs.forEach(function(td) {
        if (selectedCategory === '' || td.getAttribute("data-category") === selectedCategory) {
            td.parentElement.hidden = false;
        } else {
            td.parentElement.hidden = true;
        }
    });
}

function updateStatus() {
    var selectBox = document.getElementById("statusSelect");
    var selectedstatus = selectBox.value;

    // 選択されたカテゴリを表示内容に反映する
    var contentDivs = document.querySelectorAll(".statusData");

    contentDivs.forEach(function(td) {
        if (selectedstatus === '' || td.getAttribute("data-status") === selectedstatus) {
            td.parentElement.hidden = false;
        } else {
            td.parentElement.hidden = true;
        }
    });
}

