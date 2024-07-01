
function delete_board(userid,seq) {

	$.ajax({
					url: "/board/boardDelete.do",
					type: "POST",
					data:{
						userid: userid,
						seq: seq
					},
					dataType: "json",
					success: function(response) {
					
						if(response.sessionReset === '0') {
							alert(response.message);
							return window.location.href = "/login/login.do";
						}
						
						alert(response.message);
						window.location.reload();
						
					},
					error: function(status, error) {
						console.log("status : : :"+ status );
						console.log("error : : :"+ error);
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
				
					if(response.sessionReset === '0') {
						alert(response.message);
						return window.location.href = "/login/login.do";
					}
					
					alert(response.message);
					window.location.reload();
					
				},
				error: function(status, error) {
					console.log("status : : :"+ status );
					console.log("error : : :"+ error);
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
