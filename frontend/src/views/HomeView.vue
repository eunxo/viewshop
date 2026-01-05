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