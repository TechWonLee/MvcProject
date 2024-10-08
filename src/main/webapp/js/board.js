//----excercise.js Test Source-----
function newFunction() {
	alert("연습장페이지로 전환합니다");
}
//-------excercise.js Test Source-----------

//file upload

window.onload = function() {
	// 파일 업로드 버튼 클릭 이벤트
	const btnUpload = document.getElementById('btn-upload');
	if (btnUpload) {
		btnUpload.addEventListener('click', function() {
			document.getElementById('input_file').click();
		});




		let fileCount = 0;
		const totalCount = 10;
		let fileNum = 0;
		let content_files = [];



		// 파일 선택 시 호출되는 이벤트
		const inputFile = document.getElementById('input_file');
		if (inputFile) {
			inputFile.addEventListener('change', function(event) {
				fileCheck(event.target.files);
			});
		}

		function fileCheck(files) {
			let filesArr = Array.from(files);

			if (fileCount + filesArr.length > totalCount) {
				alert("파일은 최대 " + totalCount + "까지 업로드 할 수 있습니다");
				return;
			} else {
				fileCount += filesArr.length;
			}

			filesArr.forEach(function(f, index) {
				let reader = new FileReader();
				reader.onload = function(e) {
					content_files.push(f);
					$('#articlefileChange').append(
						`<div id="file${fileNum}">
                        <font style="font-size:12px">${f.name}</font>
                        <img src="/img/x-image.png" style="width:20px; height:auto; vertical-align: middle; cursor: pointer;"
                             onclick="fileDelete('file${fileNum}')"/>
                    </div>`
					);
					fileNum++;
				};
				reader.readAsDataURL(f);
			});

			console.log(content_files);
			// 초기화
			document.getElementById('input_file').value = "";
		}

		// 파일 부분 삭제 함수
		window.fileDelete = function(fileId) {
			let no = parseInt(fileId.replace(/[^0-9]/g, ""));
			content_files[no].is_delete = true;
			document.getElementById(fileId).remove();
			fileCount--;
			console.log(content_files);
		}

		// submit할 때 files 이름으로 서버에 전달.
		const boardForm = document.getElementById('boardForm');

		boardForm.addEventListener('submit', function(event) {
			event.preventDefault(); // 기본 폼 제출 방지

			let formData = new FormData(boardForm); // FormData에 폼 데이터 추가

			content_files.forEach(file => {
				if (!file.is_delete) {
					formData.append('files', file);
				}
			});

			$.ajax({
				url: boardForm.action,
				type: 'POST',
				data: formData,
				processData: false,
				contentType: false,
				success: function(response) {
					console.log('Form submitted successfully.');
					window.location.href = '/board/boardList.do'; // 성공 시 리다이렉트
				},
				error: function(xhr, status, error) {
					console.error('Error submitting form:', error, status);
					alert('문제가 발생했습니다.');
				}
			});
		});
	};

}



//delete board
function delete_board(userid, seq) {

	$.ajax({
		url: "/board/boardDelete.do",
		type: "POST",
		data: {
			userid: userid,
			seq: seq
		},
		dataType: "json",
		success: function(response) {

			if (response.sessionReset === '0') {
				alert(response.message);
				return window.location.href = "/login/login.do";
			}

			alert(response.message);
			window.location.reload();

		},
		error: function(status, error) {
			console.log("status : : :" + status);
			console.log("error : : :" + error);
			alert(response.message);
			return window.location.href = "/error/error.do";
		}


	})

}



$(document).ready(function() {
	$("#editbutton").on("click", function() {

		document.getElementById('showcontent').style.visibility = 'hidden';
		var boardContent = $('#boardContent').val();
		// jQuery로 동적 textarea 생성
		//$("#content-div").append("<textarea id='content' name='content'rows='10' required></textarea>");
		let newContent = $('<textarea>', {
			id: 'content',
			name: 'content',
			rows: '10',
			required: true,
			text: boardContent
		});
		$('#content-div').append(newContent);


		document.getElementById('BoardTitle').style.display = 'none';
		let title = document.getElementById('title');
		title.classList.remove('hidden-input');
		title.classList.add('visible-input');
		title.focus();

		//자바스크립트로 동적 submit 버튼 생성
		let newSubmit = document.createElement('input');
		newSubmit.type = 'button';
		newSubmit.id = 'button';
		newSubmit.value = '저장';
		newSubmit.className = 'btn-create';

		newSubmit.addEventListener('click', function() {
			//Ajax로 처리해보기 

			let content = document.getElementById('content').value;
			let userid = document.getElementById('userid').value;
			let seq = document.getElementById('seq').value;
			let title = document.getElementById('title').value;

			/*@RequestBody로 서버에서 받을 때 */

			$.ajax({
				url: "/board/boardUpdate.do",
				type: "POST",
				contentType: "application/json",
				data: JSON.stringify({
					content: content,
					userid: userid,
					seq: seq,
					title: title
				}),
				dataType: "json",
				success: function(response) {

					if (response.sessionReset === '0') {
						alert(response.message);
						return window.location.href = "/login/login.do";
					}

					alert(response.message);
					window.location.reload();

				},
				error: function(status, error) {
					console.log("status : : :" + status);
					console.log("error : : :" + error);
					alert(response.message);
					return window.location.href = "/error/error.do";
				}


			})


			/* RequestParam으로 서버에서 받을 때
			
			$.ajax({
				url: "/board/boardUpdate.do",
				type: "POST",
				data: {
					content: content,
					userid: userid,
					seq : seq,
					title: title
				},
				dataType: "json",
				success: function(data, status) {
					alert("완료되었습니다");
					window.reload();
				}
	
			})*/

		});


		let editButton = document.getElementById('editbutton');
		editButton.parentNode.insertBefore(newSubmit, editButton.nextSibling);
		editButton.style.display = 'none';

		/* 		var newSubmit = document.createElement('input');
			newSubmit.setAttribute("button","button")
			newSubmit.setAttribute ='submit';
			button.setAttribute ='Submit';
			button.setAttribute = 'btn-btn-create';
			*/


	});
});

function openChat() {
    window.open("/board/chat-popup.do", "ChatWindow", "width=600,height=400");
}
