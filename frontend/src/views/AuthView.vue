<script setup lang="ts">
import { ref } from 'vue';
import axios from 'axios';

const email = ref('');
const password = ref('');
const keepLoggedIn = ref(true);

const handleLogin = async () => {
  try {
    const response = await axios.post('/api/auth/login', {
      email: email.value,
      password: password.value
    });
    
    if (response.data.success) {
      // 로그인 성공 시 로직 (예: 토큰 저장, 홈으로 이동)
      console.log('로그인 성공:', response.data.token);
    }
  } catch (error) {
    console.error('로그인 중 오류 발생:', error);
  }
};



</script>

<template>
  <div class="auth-container">
    <div class="login-box">
      <h2>로그인</h2>

      <form @submit.prevent="handleLogin">
        <div class="input-group">
          <input 
            type="email" 
            v-model="email" 
            placeholder="이메일" 
            required 
          />
          <input 
            type="password" 
            v-model="password" 
            placeholder="비밀번호" 
            required 
          />
        </div>

        <div class="options">
          <label class="checkbox-container">
            <input type="checkbox" v-model="keepLoggedIn">
            <span class="checkmark"></span>
            로그인 상태 유지
          </label>
        </div>

        <button type="submit" class="login-btn">로그인</button>
      </form>

      <div class="auth-links">
        <router-link to="/auth/signup">회원가입</router-link>
        <router-link to="/auth/find">아이디 · 비밀번호 찾기</router-link>
      </div>

      <div class="divider">
        <span>또는</span>
      </div>

      <button class="non-member-btn">비회원 주문배송 조회</button>
    </div>
  </div>
</template>

<style scoped>
.auth-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 80vh; /* 네비게이션/푸터 고려 여백 */
  background-color: #fff;
  padding: 20px;
}

.login-box {
  width: 100%;
  max-width: 400px;
  position: relative;
  text-align: center;
}

.close-btn {
  position: absolute;
  top: -40px;
  right: 0;
  background: none;
  border: none;
  cursor: pointer;
  color: #ccc;
}

h2 {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 30px;
  color: #333;
}

/* 입력창 스타일 */
.input-group {
  border: 1px solid #ddd;
  border-radius: 4px;
  overflow: hidden;
  margin-bottom: 15px;
}

input[type="email"],
input[type="password"] {
  width: 100%;
  padding: 15px;
  border: none;
  outline: none;
  font-size: 14px;
}

input[type="email"] {
  border-bottom: 1px solid #ddd;
}

/* 체크박스 커스텀 */
.options {
  text-align: left;
  margin-bottom: 20px;
}

.checkbox-container {
  display: flex;
  align-items: center;
  cursor: pointer;
  font-size: 14px;
  color: #333;
  user-select: none;
}

.checkbox-container input {
  display: none;
}

.checkmark {
  width: 20px;
  height: 20px;
  background-color: #eee;
  border-radius: 4px;
  margin-right: 10px;
  display: inline-block;
  position: relative;
}

.checkbox-container input:checked ~ .checkmark {
  background-color: #579956; /* 프로젝트 메인 컬러 적용 */
}

.checkmark:after {
  content: "L";
  position: absolute;
  transform: scaleX(-1) rotate(-35deg);
  left: 6px;
  top: 2px;
  color: white;
  font-weight: bold;
  display: none;
}

.checkbox-container input:checked ~ .checkmark:after {
  display: block;
}

/* 버튼 스타일 */
.login-btn {
  width: 100%;
  padding: 15px;
  background-color: #579956; /* 프로젝트 컨셉 그린 */
  color: white;
  border: none;
  border-radius: 4px;
  font-size: 16px;
  font-weight: bold;
  cursor: pointer;
  margin-bottom: 20px;
}

.auth-links {
  display: flex;
  justify-content: space-between;
  font-size: 14px;
  margin-bottom: 40px;
}

.auth-links a {
  text-decoration: none;
  color: #333;
}

.divider {
  position: relative;
  margin-bottom: 30px;
  border-top: 1px solid #eee;
}

.divider span {
  position: absolute;
  top: -10px;
  left: 50%;
  transform: translateX(-50%);
  background: white;
  padding: 0 15px;
  color: #888;
  font-size: 14px;
}

.non-member-btn {
  width: 100%;
  padding: 15px;
  background-color: #8a99ae;
  color: white;
  border: none;
  border-radius: 4px;
  font-size: 14px;
  cursor: pointer;
}
</style>