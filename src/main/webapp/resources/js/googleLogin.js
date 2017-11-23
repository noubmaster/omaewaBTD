/* global admin, bloquear, ifverifica */
var currentPath = window.location.pathname;
var login = document.getElementById("login");
var optionsUser = document.getElementById("optionsUser");
var validacao = "0";
function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    var email = document.getElementById('f:email');
    var idR = document.getElementById('f:idR');
    var idR2 = document.getElementById('f1:idR');
    var nome = document.getElementById('f:nome');
    var perfil = document.getElementById('f:perfil');
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
    validacao = profile.getId();
    if (profile.getId() !== null) {
        login.style.display = "none";
        optionsUser.style.display = "inline";
        console.log('ID: ' + profile.getId());
        email.value = profile.getEmail();
        idR.value = profile.getId();
        idR2.value = profile.getId();
        nome.value = profile.getName();
        perfil.value = profile.getImageUrl();
        document.getElementById('f:registra').click();
        document.getElementById('f1:registra').click();
    }
    setTimeout(admin, 1000);
    setTimeout(bloquear, 1000);
    $('#myModal').modal('hide');
}
function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
        login.style.display = "inline";
        optionsUser.style.display = "none";

    });
    document.getElementById('fodasse:fodasse').click();
    location.reload();
}