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
/*  let mixerFeatured = mixitup('.filter_container .all_view', {
    selectors: {
      target: '.featured_card',
    },
    animation: {
      duration: 300,
    },
  });*/

  const items = document.querySelectorAll('.filter_container .social_tab li');
  items.forEach((item) => {
    item.addEventListener('click', () => {
      items.forEach((e) => {
        //하나만 선택되도록 기존의 효과를 지워준다.
        e.classList.remove('active');
      });
      // 선택한 그 아이만 효과를 추가해준다.
      item.classList.add('active');
      // 선택을 하면 다음으로 넘어갈 수 있는 버튼이 활성화 되도록 한다.
      // document.getElementById('next').style.display = 'block';
    });
  });
});
