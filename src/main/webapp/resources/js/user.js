var currentPath = window.location.pathname;
var currentPge = window.location.href;
var block = document.getElementById("block");
var loginIfBlock = document.getElementById("loginIfBlock");
var tipo = document.getElementById("f1:tipoUser").value;
var admUser = document.getElementById("admUser");
var idR = document.getElementById('f:idR');
var idR2 = document.getElementById('f1:idR');
var login = document.getElementById("login");
var optionsUser = document.getElementById("optionsUser");
var email = document.getElementById('f:email');
var perfil = document.getElementById('f:perfil');
var idRGet;

if (currentPath === "/memes/faces/cadastroGeneroT.xhtml" ||
        currentPath === "/memes/faces/cadastroGeneroT.xhtml#") {
    if (tipo === "0") {
        block.style.display = "none";
        loginIfBlock.style.display = "inline";
    } else {
        loginIfBlock.style.display = "none";
        block.style.display = "inline";
    }
}
;
function admin() {
    tipo = document.getElementById("f1:tipoUser").value;
    if (tipo === "0") {
        admUser.style.display = "none";
    } else if (tipo === "1" || tipo === "2") {
        admUser.style.display = "inline";
    }
    ;
}

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
        login.style.display = "inline";
        optionsUser.style.display = "none";
    });
    idRGet = null;
    idR.value = idRGet;
    idR2.value = idRGet;
    document.getElementById('fodasse:fodasse').click();
}

function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    if (profile.getId() !== null) {
        idRGet = profile.getId();
        login.style.display = "none";
        optionsUser.style.display = "inline";
        email.value = profile.getEmail();
        idR.value = idRGet;
        idR2.value = idRGet;
        perfil.value = profile.getImageUrl();
        document.getElementById('f:registra').click();
        document.getElementById('f1:registra').click();
    }
    setTimeout(admin, 1000);
    $('#myModal').modal('hide');
}