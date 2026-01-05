<script setup lang="ts">
import{RouterLink}from'vue-router';
</script>
<template>
  <nav class="navbar">
    <div class="signin">
      <router-link to="/auth" class="logo-text2">Login</router-link>
    </div>
    <div class="div-center">
      <router-link to="/" class="logo-text">PIT A PAT</router-link>
    </div>
    <div class="nav-right">
      <router-link to="/user" class="icon-link">
        <span class="material-symbols-outlined">person</span>
      </router-link>
      <router-link to="/cart" class="icon-link">
        <span class="material-symbols-outlined">shopping_cart</span>
      </router-link>
      <router-link to="/community" class="icon-link">
    <span class="material-symbols-outlined">forum</span> </router-link>
    </div>
  </nav>
</template>
<style scoped>


@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@900&display=swap');
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1.2rem 2rem;
  background-color: #ffffff; 
  border-bottom: 1px solid #f0f0f0;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1000;
}

.nav-center {
  position: absolute;
  left: 50%;
  transform: translateX(-50%); 
}
.logo-text {
  font-family: 'Montserrat', sans-serif;
  font-size: 1.8rem;
  font-weight: 900; 
  color: darkgreen;
  text-decoration: none;
  letter-spacing: -1px; 
}
.logo-text2 {
  font-family: 'Montserrat', sans-serif;
  font-size: 1.8rem;
  font-weight: 300;
  color: darkgreen;
  text-decoration: none;
  letter-spacing: -1px; 
}
.navbar__logo {
  font-size: 1.5rem;
  font-weight: bold;
  margin-right: 2rem;
}

.nav-right {
  display: flex;
  gap: 1.5rem;
  align-items: center;
}
.icon-link {
  text-decoration: none;
  color: darkgreen;
  display: flex;
  align-items: center;
}
.material-symbols-outlined {
  font-size: 28px; 
  font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24; /* 테두리 형태 아이콘 */
}

.icon-link:hover {
  opacity: 0.7;
}
</style>