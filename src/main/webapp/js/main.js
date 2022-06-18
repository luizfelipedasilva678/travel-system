(function() {
	menuControl();
	subMenuControl();
	
	function menuControl() {
		const $menuContainer = document.querySelector(".menu-container");

		window.addEventListener("click", (e) => {
			const { target } = e;

			if (target.classList.contains("menu-btn")) {
				$menuContainer.classList.toggle("d-none");
			}

			if (target.classList.contains("menu-btn-close")) {
				$menuContainer.classList.add("d-none");
			}
		})
	}
	
	function subMenuControl() {
		window.addEventListener("click", (e) => {
			const { target } = e;
			
			if(target.classList.contains("menu-container__ul-submenu")) {
				target.nextElementSibling.classList.toggle("d-none");
			}
		})
	}
})();