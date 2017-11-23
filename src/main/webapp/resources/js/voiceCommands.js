/* global validacao */

if (annyang) {
    // Let's define a command.
    console.log(validacao);
    var logar = {
        'login': function () {
            $('#myModal').modal('show');
        }
    };
    var logOut = {
        'sign out': function () {
            console.log('sign out');
            signOut();
        }
    };
    var cSearch = {
        'search': function () {
            document.getElementById("busca:searchss").click();
        }
    };
    var wSearch = {
        'write search': function () {
            vozes();
        }
    };
    // Add our commands to annyang
    annyang.addCommands(cSearch);
    annyang.addCommands(wSearch);
    annyang.addCommands(logar);
    annyang.addCommands(logOut);

    // Start listening.
    annyang.start();
}