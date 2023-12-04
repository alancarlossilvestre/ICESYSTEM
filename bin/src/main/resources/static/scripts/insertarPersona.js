
 document.addEventListener("DOMContentLoaded", function () {
        var toggleButton = document.getElementById("toggleButton");
        var desplegableSection = document.getElementById("desplegableSection");

        toggleButton.addEventListener("click", function () {
            if (desplegableSection.style.display === "none") {
                desplegableSection.style.display = "block";
            } else {
                desplegableSection.style.display = "none";
            }
        });
    });