var clickMe = document.getElementById("click-me-button");
var colorCode = document.getElementById("colorCode");

colorCode.hidden = true;
clickMe.addEventListener("click", function() {
  getRandomColor();
});
 
function getRandomColor(){
  colorCode.hidden = false;
  var color = "#" + Math.floor(Math.random() * 16777215).toString(16);
  document.body.style.backgroundColor = color;
  document.getElementById("colorCode").innerText = color;
  colorCode.innerHTML = color;
}

