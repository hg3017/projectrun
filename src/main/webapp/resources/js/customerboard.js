window.addEventListener('DOMContentLoaded', function () {
	
	var radios = document.getElementsByName('category');

	radios.forEach(elem => {
	    if(elem.checked){
	        console.log(elem.value);
	    }
	})
	
	
	});
