 let index={
		init: function() {
			$("#btn-save").on("click",()=>{
				this.save();
				});
				$("#btn-delete").on("click",()=>{
				this.deleteById();
			});
				$("#btn-update").on("click",()=>{
				this.update();
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
	 }

}


index.init();