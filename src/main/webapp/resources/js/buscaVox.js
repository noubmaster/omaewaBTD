function vozes() {
    console.log("searching");
    var textInput = document.getElementById("busca:txt");


    annyang.addCallback('result', function (phrases) {
        if (phrases[0] === 'search' ||
                phrases[0] === ' search' ||
                phrases[0] === 'none' ||
                phrases[0] === ' none') {
            console.log('search');
            if(phrases[0] === 'none' ||
                phrases[0] === ' none') {
            textInput.value = null;
            }
        } else {
            textInput.value = phrases[0];
            console.log("I think the user said: ", phrases[0]);
            console.log("But then again, it could be any of the following: ", phrases);
        }
    });


}