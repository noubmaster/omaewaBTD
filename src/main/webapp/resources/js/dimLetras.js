dimLetras();
function dimLetras() {
    $("div.panel-body").text(function (index, currentText) {
        return currentText.substr(0, 175) + "...";
    });
}