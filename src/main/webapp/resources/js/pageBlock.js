var currentPath = window.location.pathname;
var currentPge = window.location.href;
var block = document.getElementById("block");
var loginIfBlock = document.getElementById("loginIfBlock");

function bloquear() {
    if (currentPath === "/omaewa/cadastroT.xhtml" ||
            currentPath === "/omaewa/cadastroT.xhtml#" ||
            currentPath === "/omaewa/cadastroAlbumT.xhtml" ||
            currentPath === "/omaewa/cadastroAlbumT.xhtml#" ||
            currentPath === "/omaewa/cadastroArtistaT.xhtml" ||
            currentPath === "/omaewa/cadastroArtistaT.xhtml#" ||
            currentPath === "/omaewa/cadastroGeneroT.xhtml" ||
            currentPath === "/omaewa/cadastroGeneroT.xhtml#" ||
            currentPath === "/omaewa/cadastroMusicaT.xhtml" ||
            currentPath === "/omaewa/cadastroMusicaT.xhtml#" ||
            currentPath === "/omaewa/manutencaoUser.xhtml" ||
            currentPath === "/omaewa/manutencaoUser.xhtml#") {
        tipo = document.getElementById("f1:tipoUser").value;
        if (tipo === "0") {
            block.style.display = "none";
            loginIfBlock.style.display = "inline";
        } else {
            loginIfBlock.style.display = "none";
            block.style.display = "inline";
        }
    }
    ;
}
bloquear();