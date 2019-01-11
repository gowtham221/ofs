var rsp = {};
var personData;

rsp.createChildren = function () {
    console.log('rsp created');
}

rsp.createView = function(){
    var rspchild = service.doGet('html/rsp.html');
    rsp.setView();
}

rsp.setView = function () {
    rsp.view = service.response;
}

rsp.createPersonPanel = function () {
    service.doGet('html/personpanel.html');
    document.getElementById('details-container').innerHTML = service.response;
    rsp.getPerson();
}

rsp.getPerson = function(){
    service.doGet('assets/person.json');
    personData = JSON.parse(service.response);
    if (personData.length != 0) {
        rsp.AddTable();
        rsp.createPersonList();
        rsp.createInfopanel();
    }
}

rsp.AddTable = function() {
    service.doGet('html/personList.html');
    document.getElementById('person-panel').innerHTML += service.response;
}

rsp.createPersonList = function() {
    for(var i = 0; i< personData.length; i++) {
        service.doGet('html/personTable.html');
        var personTable = service.response;
        personTable = personTable.replace('ID', personData[i].id);
        personTable = personTable.replace('Firstname', personData[i].firstName);
        personTable = personTable.replace('Lastname', personData[i].lastName);
        personTable = personTable.replace('Email', personData[i].email);
        personTable = personTable.replace('DOB', personData[i].birth_date);
        var person = personData[i];
        document.getElementById('personTable').innerHTML += personTable;
    }
}

rsp.listenEvents = function () {

}

rsp.createInfopanel = function () {
    service.doGet('html/personInfo.html');
    var personForm = service.response;
    document.getElementById('person-panel').innerHTML += personForm;
}