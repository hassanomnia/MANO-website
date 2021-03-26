var acc = document.getElementsByClassName("accordion");
var i;
for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("mouseover", function() {
    var panel = this.nextElementSibling;
    panel.style.display = "block";
    panel.addEventListener("mouseover", function() {
        panel.style.display = "block";
    });
    console.log("hee");
  });
  acc[i].addEventListener("mouseout", function() {
    var panel = this.nextElementSibling;
    panel.addEventListener("mouseout", function() {
        panel.style.display = "none";
    });
    panel.style.display = "none";
    console.log("hee");
  });
}