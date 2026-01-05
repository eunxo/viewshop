<script setup lang="ts">
import{RouterView}from'vue-router';
import Navbar from './components/navbar.vue';

</script>

<template>
  <header>
    <Navbar />
  </header>
  
  <main class="content-wrapper">
    <RouterView />
  </main>

  <footer>
    <div class="footerr">
    <img src="@/assets/footer.png" alt="footer이미지" class="footer-img" />
    <p class="pet">pit a pet
      <br>© 2024 PITAET Inc. All rights reserved.
      <br>Hosting by imweb
    </p>
    </div>
  </footer>
</template>


<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@900&display=swap');
.content-wrapper {
  padding-top: 80px; 
  min-height: calc(100vh - 80px);
}
.footer-img {
  width: 100%;
  max-width: 690px; 
  height: auto;
  margin-bottom:20px; 
  padding:5%;
}
.footerr{
  background-color:#579956 ;
  display:flex;
}
.pet {
  display: flex;
  align-items: center;
  justify-content: center;
  max-width: 2000px;
  margin: 0px auto;
  padding: 0 40px;
  font-family: 'Montserrat', sans-serif;
  gap: 80px;
  color:white;
  line-height: 1.5;
}
</style>
