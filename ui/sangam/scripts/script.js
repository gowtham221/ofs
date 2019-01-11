var validateSignIn;
var timer;

validateSignIn = function () {
var username;
var pwd;
    username = document.getElementById('username').value;
    pwd = document.getElementById('password').value;
    if (username == '' || username == null) {
        alert('Please enter username');
    }
    if (pwd == '' || pwd == null) {
        alert('Please enter password');
    } 
}

var count = 0;
timer = function () {
    document.getElementById('count').innerHTML = ++count;
    setTimeout(timer, 5000);
}

