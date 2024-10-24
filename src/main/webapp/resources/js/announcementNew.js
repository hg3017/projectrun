window.addEventListener('DOMContentLoaded', function() {
	// 파일명 세
	const announceFileInput = document.getElementById('fileInput');
	if (announceFileInput) {
		announceFileInput.addEventListener('change', function() {
			document.getElementById('fileName').value = this.files[0].name;
		});
	}
});