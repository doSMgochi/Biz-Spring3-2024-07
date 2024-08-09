document.addEventListener("DOMContentLoaded", function () {
  var menuItems = document.querySelectorAll("nav ul li");

  menuItems.forEach(function (item) {
    var submenu = item.querySelector("ul");

    if (submenu) {
      item.addEventListener("mouseenter", function () {
        submenu.style.maxHeight = submenu.scrollHeight + "px";
        submenu.style.opacity = "1";
        submenu.style.transition = "max-height 0.5s ease, opacity 0.5s ease";
      });

      item.addEventListener("mouseleave", function () {
        submenu.style.maxHeight = "0";
        submenu.style.opacity = "0";
        submenu.style.transition = "max-height 0.5s ease, opacity 0.5s ease";
      });
    }
  });
});
