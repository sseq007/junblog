let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
		$("#btn-delete").on("click", () => {
			this.deleteById();
		});
		$("#btn-update").on("click", () => {
			this.update();
		});
		$("#btn-reply-save").on("click", () => {
			this.replySave();
		});
	},
		save: function(){
			//alert('user의 save함수 호출된다');
			let data={
				title: $("#title").val(),
				content: $("#content").val()
			};
			//console.log(data);
			
			$.ajax({
				type:"POST",
				url:"/api/board",
				data:JSON.stringify(data),
				contentType:"application/json; charset=utf-8",
				dataType:"json"
			}).done(function(resp){
				alert("글쓰기가 완료되었습니다");
				//console.log(resp);
				location.href="/";
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
		},
		
	deleteById : function(){
		
		let id=$("#id").text();
		
			//alert('user의 save함수 호출된다');
			$.ajax({
				type:"DELETE",
				url:"/api/board/"+id,
				dataType:"json"
			}).done(function(resp){
				alert("삭제가 완료되었습니다");
				//console.log(resp);
				location.href="/";
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
		},
		
	 update: function() {
		 let id = $("#id").val();

			 let data = {
				 title: $("#title").val(),
				 content: $("#content").val()
			 };
		 //console.log(data);

		 $.ajax({
			 type: "PUT",
			 url: "/api/board/"+id,
			 data: JSON.stringify(data),
			 contentType: "application/json; charset=utf-8",
			 dataType: "json"
		 }).done(function(resp) {
			 alert("글수정이 완료되었습니다");
			 //console.log(resp);
			 location.href = "/";
		 }).fail(function(error) {
			 alert(JSON.stringify(error));
		 });
	 },

	replySave: function() {
		//alert('user의 save함수 호출된다');
		let data = {
			userId: $("#userId").val(),
			boardId: $("#boardId").val(),
			content: $("#reply-content").val()
		};

		$.ajax({
			type: "POST",
			url: `/api/board/${data.boardId}/reply`,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("댓글작성이 완료되었습니다");
			//console.log(resp);
			location.href = `/board/${data.boardId}`;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
	replyDelete: function(boardId, replyId) {
		$.ajax({
			type: "DELETE",
			url: `/api/board/${boardId}/reply/${replyId}`,
			dataType: "json"
		}).done(function(resp) {
			alert("댓글삭제 성공");
			//console.log(resp);s
			location.href = `/board/${boardId}`;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}


}


index.init();