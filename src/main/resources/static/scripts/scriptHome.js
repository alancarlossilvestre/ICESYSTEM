const body = document.querySelector("body"),
	      sidebar = body.querySelector(".sidebar"),
	      toggle = body.querySelector(".toggle"),
	      searchBtn = body.querySelector(".search-box"),
	      modeSwich = body.querySelector(".toggle-switch"),
	      modeText = body.querySelector(".mode-text");
	      
	      toggle.addEventListener("click", ()=>{
			  sidebar.classList.toggle("close");
		  });
		  searchBtn.addEventListener("click", ()=>{
			  sidebar.classList.remove("close");
		  });
		        
	      modeSwich.addEventListener("click", ()=>{
			  body.classList.toggle("dark");
			  if(body.classList.contains("dark")){
				  modeText.innerText = "Modo Claro"
			  }else{
				  modeText.innerText = "Modo Oscuro"
			  }
		  });
    var swiper = new Swiper(".slide-content", {
      slidesPerView: 1,
      spaceBetween: 30,
      loop: true,
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
      },
    });