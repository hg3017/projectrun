
function changeTab(event) {
    event.preventDefault(); // 기본 링크 동작 막기
    const tabLinks = document.querySelectorAll(".social_tab li");
    const tabContents = document.querySelectorAll(".report_wrap .all_view");

    // 탭 활성화 상태 변경
    tabLinks.forEach(tab => tab.classList.remove("active"));
    event.currentTarget.parentNode.classList.add("active");

    // 모든 탭 콘텐츠 숨기기
    tabContents.forEach(content => {
        content.style.display = "none";
    });

    // 선택한 탭 콘텐츠 표시
    const selectedTab = event.currentTarget.getAttribute("data-tab");
    document.querySelector(`.all_view[data-content="${selectedTab}"]`).style.display = "flex";
}

