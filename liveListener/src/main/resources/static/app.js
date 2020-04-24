var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (msg) {
            // showGreeting(JSON.parse(greeting.body).content);
            showGreeting(JSON.parse(msg.body).title, JSON.parse(msg.body).date, JSON.parse(msg.body).liveState, JSON.parse(msg.body).dateTime);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message,message1,message2,message3) {
    // $("#greetings").append("<tr><td>" + message + "</td></tr>");
    $("#liveInfoBodyListen").append("<tr><td style='color: red'>" + message + "</td><td style='color: red'>" + message1 + "</td><td style='color: red'>" + message2 + "</td><td style='color: red'>" + message3 + "</td></tr>");
    if ($("#liveInfoBodyListen").size > 10) {
        $("#liveInfoBodyListen").html("");
    }
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

