if (annyang) {
    // Let's define a command.
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
    var back = {
        'return': function () {
            window.history.back();
        }
    };
    var backS = {
        'return home': function () {
            document.location.href = "/omaewa/home.xhtml";
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
    function logado() {
        annyang.removeCommands(logar);
        annyang.addCommands(logOut);
    }
    annyang.addCommands(back);
    annyang.addCommands(backS);

    // Start listening.
    annyang.start();
}