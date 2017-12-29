"use strict"

var editFormElem;
var editLegendElem;
var editTextElem;
var editIdElem;

window.onload = function() {
	editFormElem = document.getElementById("editForm");
	editLegendElem = editFormElem.getElementsByTagName("legend")[0];
	editTextElem = document.getElementById("editText");
	editIdElem = document.getElementById("editId");
};

function showform(editId, editText) {
	editIdElem.value = editId;
	if (editId) {
		editLegendElem.textContent = "Editing (ID: " + editId + ")";
	} else {
		editLegendElem.textContent = "Add item";
	}
	editTextElem.value = editText;
	editFormElem.style.display = "block";
}

function hideform() {
	editFormElem.style.display = "none";
}
