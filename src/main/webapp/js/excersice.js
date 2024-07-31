
    let selectedTd;
    let table = document.querySelector('table'); // 테이블 요소 선택

    table.onclick = function(event) {
      let target = event.target;

      if (target.tagName != 'TD') return; // 클릭된 요소가 <td>가 아닌 경우 무시

      highlight(target); // 하이라이트 함수 호출

      function highlight(td) {
        if (selectedTd) {
          selectedTd.classList.remove('highlight'); // 이전에 선택된 셀에서 하이라이트 제거
        }
        selectedTd = td;
        selectedTd.classList.add('highlight'); // 현재 선택된 셀에 하이라이트 추가
      }
    }
    
	class Menu {
		
	    constructor(elem) {
	      this._elem = elem;
	      elem.onclick = this.onClick.bind(this); // (*)
	    }

	    save() {
			
	      alert('저장하기');
	    }

	    load() {
	      alert('불러오기');
	    }

	    search() {
	      alert('검색하기');
	    }

	    onClick(event) {
	      let action = event.target.dataset.action;
	      if (action) {
	        this[action]();
	      }
	    };
	  }
	  //let menu = document.getElementById('menu');
	  new Menu(menu);
	  
	  
	 let butn = document.getElementById('sc');
	 butn.onclick = function() {
		alert("안녕");
		let test = butn.dataset.sc
		alert(test);
		
		
		
	 }
	 
	
	 

	 function loadScript(src, callback) {
	 	let script = document.createElement('script');
	 	script.src = src;
		script.onload = () => callback(script);
	
		
	 	document.head.append(script);
	 }
	 
	 loadScript('/js/board.js', function() {
		newFunction();
	 })
	

	 const f1 = (callback) => {
	   setTimeout(function () {
	     console.log("1번주문 완료");
	     callback();
	   }, 1000);
	 };

	 const f2 = (callback2) => {
	   setTimeout(function () {
	     console.log("2번주문 완료");
	     callback2();
	   }, 3000);
	 };

	 const f3 = (callback3) => {
	   setTimeout(function () {
	     console.log("3번주문 완");
	     callback3();
	   }, 2000);
	 };

	 console.log("시작");
	 f1(function() {
	   f2(function() {
	     f3(function() {
	       console.log("끝");
	     });
	   });
	 });

	 
	  
	  
	  
	  
    
