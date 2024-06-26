$(document).ready(function() {
	
	var boardContent = $('#boardContent').val();
	$("#editbutton").on("click", function() {
		
		document.getElementById('showcontent').style.visibility = 'hidden';
		
		// jQuery로 동적 textarea 생성
		//$("#content-div").append("<textarea id='content' name='content'rows='10' required></textarea>");
		let newContent = $('<textarea>',{
			id: 'content',
			name: 'content',
			rows: '10',
			required: true,
			text: boardContent
		});
		$('#content-div').append(newContent);


		//자바스크립트로 동적 submit 버튼 생성
		
		let newSubmit = document.createElement('input');
		newSubmit.type='button';
		newSubmit.id ='submit';
		newSubmit.value ='저장';
		newSubmit.className = 'btn-create';
		
		newSubmit.addEventListener('click', function() {
	
			alert("gdgd");
	});
		
		
		let editButton= document.getElementById('editbutton');
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
