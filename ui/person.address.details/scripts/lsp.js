var lsp = {};

lsp.createChildren = function() {
    console.log('lsp created');
}

lsp.createView = function(){
    service.doGet('html/lsp.html');
    lsp.setView();
}

lsp.setView = function () {
    lsp.view = service.response;
}

lsp.listenEvents = function () {

    document.getElementById('personSelect').setAttribute('onclick', 'lsp.onEntitySelected("person")');
    document.getElementById('addressSelect').setAttribute('onclick', 'lsp.onEntitySelected("address")');
}

lsp.setDefault =  function() {

    var personField = document.getElementById('personSelect');
    personField.addEventListener('click', lsp.onEntitySelected('person'));
}

lsp.onEntitySelected = function (field) {
    em.broadCast('panel', field);
}
