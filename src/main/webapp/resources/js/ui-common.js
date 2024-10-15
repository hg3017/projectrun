window.addEventListener('DOMContentLoaded', function () {
  const header = document.querySelector('#header');

  // 헤더 스크롤시 스타일 변경
  window.addEventListener('scroll', function () {
    let _scrollY = this.scrollY;

    if (_scrollY > 50) {
      header.classList.add('fixed');
    } else {
      header.classList.remove('fixed');
    }
  });

// 봐야되는 코드
    document
    .querySelector('#header .sitemap_btn')
    .addEventListener('click', function () {
      this.classList.toggle('on');
      document.querySelector('#header .menu_wrap').classList.toggle('on');
    });

	  	
	
  document.querySelectorAll('#header .menu>li>a').forEach((v) => {
    v.addEventListener('click', function (e) {
      e.preventDefault();
      // a부모에서 li에 넣기
      v.parentElement.classList.toggle('on');

      //li의 형제 li배열애서 on클래스 제거
      // siblings(v.parentElement).forEach((el) => {
      //   el.classList.remove('on');
      // });
    });
  });

  AOS.init({
    duration: 1000,
  });

  let mainCrew = new Swiper('.main_crew .swiper', {
    //모바일
    slidesPerView: 3,
    spaceBetween: 20,
    pagination: {
      el: '.swiper-pagination',
      clickable: true,
    },
    breakpoints: {
      //테블릿
      768: {
        slidesPerView: 4,
        spaceBetween: 20,
      },
      //pc
      1201: {
        slidesPerView: 5,
        spaceBetween: 20,
      },
    },
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
  });

  // mixitup
/*  let mixerFeatured = mixitup('.main_report .all_view', {
    selectors: {
        target: '.featured_card'
    },
    animation: {
        duration: 300
    }
});*/

const linkFeatured = document.querySelectorAll('.filter_container .social_tab li');
items.forEach((item)=>{
  item.addEventListener('click',()=>{
      items.forEach((e)=>{
        //하나만 선택되도록 기존의 효과를 지워준다.
          e.classList.remove('active');
      })
    // 선택한 그 아이만 효과를 추가해준다.
      item.classList.add('active');
    // 선택을 하면 다음으로 넘어갈 수 있는 버튼이 활성화 되도록 한다.
      document.getElementById('next').style.display='block';
  })
});
});

$(function () {
  $('.filter_container .social_tab li').on('click', function (e) {
    // a가 있으므로 기본이벤트막기
    e.preventDefault();
    // 클릭한 li에 active걸고 나머지 형제에서 active제거
    $(this).addClass('active').siblings().removeClass('active');
    // 형제요소중 클릭한 요소의 순서값 찾기
    let idx = $(this).index();

    // 순서값을 연결할 다른그룹요소에 eq()로 연결
    $('.main_menu .swiper_wrap')
      .eq(idx)
      .addClass('on')
      .siblings()
      .removeClass('on');
  });
});
