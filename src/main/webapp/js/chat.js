document.addEventListener("DOMContentLoaded", function() {
    let ws;
    let messages = document.getElementById("messages");

    function openSocket() {
        if (ws !== undefined && ws.readyState !== WebSocket.CLOSED) {
            writeResponse("WebSocket is already opened.");
            return;
        }
        ws = new WebSocket("ws://localhost:8000/echo.do");

        ws.onopen = function(event) {
            if (event.data === undefined) {
                return;
            }
            writeResponse(event.data);
        };

        ws.onmessage = function(event) {
            console.log('writeResponse');
            console.log(event.data)
            writeResponse(event.data);
        };

        ws.onclose = function() {
            writeResponse("대화 종료");
        };
    }

    function send() {
        let text = document.getElementById("messageinput").value + "," + document.getElementById("sender").value;
        ws.send(text);
        document.getElementById("messageinput").value = ""; // 입력 필드 비우기
    }

    function closeSocket() {
        ws.close();
    }

    function writeResponse(text) {
        messages.innerHTML += "<br/>" + text;
    }

    function clearText() {
        messages.innerHTML = ""; // 전체 메시지를 지움
    }

    // 버튼 클릭 이벤트 핸들러 설정
    document.getElementById("openSocketBtn").addEventListener("click", openSocket);
    document.getElementById("closeSocketBtn").addEventListener("click", closeSocket);
    document.getElementById("sendMessageBtn").addEventListener("click", send);
    document.getElementById("clearTextBtn").addEventListener("click", clearText);
});
