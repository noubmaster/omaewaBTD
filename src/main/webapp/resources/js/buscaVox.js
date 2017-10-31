function vozes() {
    var textInput = document.getElementById("busca:txt");
    if (annyang) {

        annyang.addCallback('result', function (phrases) {
            console.log("I think the user said: ", phrases[0]);
            textInput.value = phrases[0];
            console.log("But then again, it could be any of the following: ", phrases);

        });

        // Start listening.
        annyang.start();
    }
}