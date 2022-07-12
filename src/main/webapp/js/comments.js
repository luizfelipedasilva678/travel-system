(function () {
	const registerComment = () => {
		const form = document.getElementById("commentRegisterForm");
		
		form.addEventListener("submit", (e) => {
			e.preventDefault();
			const { target } = e;
			
			const content = target[0].value;
			const idUser  = target[1].value;
			const idExperience = target[2].value;
			
			const formData = new FormData();
			formData.append("content", content);
			formData.append("idUser", idUser);
			formData.append("idExperience", idExperience);
			
			fetch('/travel-system/ControlServlet?action=add&xclass=CommentController', {
				method: "POST",
				body: formData
			})
			.then(resp => {
				if(resp.status === 200) {
					window.location.reload();				
				}
			})
		})	
	}
	
	
	registerComment();
	
})();
