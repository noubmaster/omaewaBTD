//ID Usuario, Música
var idUsuario = document.getElementById('f1:idUsuario').value;
var idMusica = document.getElementById('f1:idMusica').value;
//Avaliação
var avUsuario = document.getElementById('avaliacao:idUser');
var avMusica = document.getElementById('avaliacao:idMus');
//Score
var sUsuario = document.getElementById('score:idUserS');
var sMusica = document.getElementById('score:idMusS');
//ID -> Avaliação
setar();
function setar() {
    avUsuario.value = idUsuario;
    avMusica.value = idMusica;
    // click
    document.getElementById('score:a').click();
    document.getElementById('verfUserAv:a').click();
}
//ID -> Verificaçao user
document.getElementById('verfUserAv:idUserS').value = idUsuario;
//ID -> Score
sUsuario.value = idUsuario;
sMusica.value = idMusica;
// click
document.getElementById('score:a').click();
document.getElementById('verfUserAv:a').click();
