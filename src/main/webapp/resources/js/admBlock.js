var admUser = document.getElementsByClassName("admUser");
var su = document.getElementById("su");

function admin() {
    tipo = document.getElementById("f1:tipoUser").value;
    if (tipo === "0" || tipo === "1") {
        admUser.style.display = "none";
    } else if (tipo === "2" || tipo === "3") {
        $(admUser).fadeIn().css("display", "block");
    }
    ;
    if (tipo === "0" || tipo === "1" || tipo === "2") {
        su.style.display = "none";
    } else if (tipo === "3") {
        $(su).fadeIn().css("display", "block");
    }
    ;
}
