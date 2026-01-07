<script setup lang="ts">
</script>

<template>
  <div class="banner-wrapper">
    <img src="@/assets/pit_a_pet3.png" alt="PITA ET 메인 이미지" class="main-img" />
  </div>

  <div class="content-section">
    <div class="text-group">
      <div class="main-text">
        <h5>We reward the happiness<br>
        and love provided by our<br>
        pets with excitement.</h5>
      </div>
      
      <div class="support-text">
        <h6>아이들의 건강 관리에 도움이 되는<br>
        맛있는 고영양 기능 맞춤형 펫푸드,
        <span>PIT A PAT</span></h6>
      </div>
    </div>

    <div class="image-group">
      <img src="@/assets/dog2.png" alt="강아지" class="dog-img" />
    </div>
  </div>
  <div>
    <div class="banner-center">
      <h1 class="main-title">TIME SALE</h1>
      <a href="#" class="view-more-btn">VIEW MORE</a>
    </div>
  </div>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@900&display=swap');

/* 상단 배너 */
.banner-wrapper {
  width: 100%;
  display: block;
}
.main-img {
  width: 100%;
  display: block;
  padding: 0 !important;
}


.content-section {
  display: flex;
  align-items: center; 
  justify-content: space-between; 
  max-width: 1200px;
  margin: 10vh auto; 
  padding: 0 5%;
  font-family: 'Montserrat', sans-serif;
  gap: 2rem;
  background-color:#f6f3f372 ;
}


.text-group {
  flex: 1;
  text-align: left;
}

.main-text {
  display: inline-block;
  transform: scaleY(1.3); 
  transform-origin: top left;
  color: darkgreen;
  margin-bottom: 100px; 
}

.main-text h5 {
  font-size: 2.5rem;
  line-height: 1.1; 
  margin: 0;
  font-weight: 900;
}

.support-text h6 {
  font-size: 0.9rem; 
  font-weight: 500;
  line-height: 1.6;
  color: #888;
}

.support-text span {
  font-weight: bold;
  color: #58a67d;
}


.image-group {
  flex: 1; 
  display: flex;
  justify-content: flex-end;
}

.dog-img {
  width: 250%;
  max-width: 500px; 
  height: auto;
  display: block;
}

.banner-center {
  display: flex;
  flex-direction: column; /* 세로 방향으로 나열 */
  align-items: center;    /* 가로축 중앙 정렬 */
  justify-content: center; /* 세로축 중앙 정렬 */
  padding: 50px;
  background-color: #fff;
}

.main-title {
  /* 이미지의 묵직한 폰트 스타일 */
  font-family: 'Arial Black', sans-serif; 
  color: #5d965a;      /* 이미지와 유사한 중간 톤의 초록색 */
  font-size: 60px;     /* 글씨 크기 */
  font-weight: 500;
  margin: 0 0 30px 0;  /* 아래쪽 버튼과의 간격 */
  letter-spacing: -1px; /* 글자 사이 간격을 좁혀 밀도감 있게 */

  display: inline-block;
  transform: scaleY(1,7);

  letter-spacing: 2px;
}

.view-more-btn {
  background-color: #5d965a;
  color: #ffffff;
  text-decoration: none;
  font-family: 'Arial', sans-serif;
  font-size: 18px;
  font-weight: bold;
  
  /* 버튼 형태: 캡슐 모양 */
  padding: 18px 45px;
  border-radius: 40px; 
  
  /* 마우스 호버 효과 */
  transition: transform 0.2s, background-color 0.2s;
}

.view-more-btn:hover {
  background-color: #4a7a48; /* 마우스 올렸을 때 더 진한 초록색 */
  transform: scale(1.05);     /* 살짝 커지는 효과 */
}


@media (max-width: 768px) {
  .content-section {
    flex-direction: column;
    text-align: center;
  }
  .text-group {
    text-align: center;
  }
  .main-text {
    transform-origin: center;
  }
}
</style>