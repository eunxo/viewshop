<script setup lang="ts">
// 필요한 데이터나 로직을 여기에 추가하세요
const userInfo = {
  name: '사용자',
  grade: 'SILVER',
  points: 1200
};
</script>

<template>
  <div class="mypage-container">
    <div class="mypage-content">
      <section class="user-summary">
        <div class="profile-info">
          <div class="avatar">
            <span class="material-symbols-outlined">person</span>
          </div>
          <div class="text">
            <h2>안녕하세요, <strong>{{ userInfo.name }}</strong>님!</h2>
            <p class="grade">회원 등급: <span>{{ userInfo.grade }}</span></p>
          </div>
        </div>
        <div class="user-stats">
          <div class="stat-item">
            <span class="label">포인트</span>
            <span class="value">{{ userInfo.points.toLocaleString() }}P</span>
          </div>
          <div class="stat-item">
            <span class="label">쿠폰</span>
            <span class="value">2장</span>
          </div>
        </div>
      </section>

      <section class="order-status">
        <h3>주문/배송 현황 <span>(최근 3개월)</span></h3>
        <div class="status-grid">
          <div class="status-item">
            <span class="count">0</span>
            <span class="label">입금대기</span>
          </div>
          <div class="status-item">
            <span class="count">1</span>
            <span class="label">결제완료</span>
          </div>
          <div class="status-item">
            <span class="count">0</span>
            <span class="label">배송중</span>
          </div>
          <div class="status-item">
            <span class="count">3</span>
            <span class="label">배송완료</span>
          </div>
        </div>
      </section>

      <nav class="mypage-menu">
        <ul>
          <li>
            <router-link to="/orders">
              <span>주문 내역 조회</span>
              <span class="material-symbols-outlined">chevron_right</span>
            </router-link>
          </li>
          <li>
            <router-link to="/wishlist">
              <span>관심 상품</span>
              <span class="material-symbols-outlined">chevron_right</span>
            </router-link>
          </li>
          <li>
            <router-link to="/profile/edit">
              <span>회원 정보 수정</span>
              <span class="material-symbols-outlined">chevron_right</span>
            </router-link>
          </li>
          <li>
            <router-link to="/qna">
              <span>1:1 문의 내역</span>
              <span class="material-symbols-outlined">chevron_right</span>
            </router-link>
          </li>
        </ul>
      </nav>

      <div class="action-area">
        <button class="logout-btn">로그아웃</button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.mypage-container {
  display: flex;
  justify-content: center;
  padding: 40px 20px;
  background-color: #fff;
  min-height: 80vh;
}

.mypage-content {
  width: 100%;
  max-width: 600px; /* 로그인 박스보다 조금 더 넓게 설정 */
}

/* 사용자 정보 섹션 */
.user-summary {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 30px;
  background-color: #f9f9f9;
  border-radius: 12px;
  margin-bottom: 30px;
}

.profile-info {
  display: flex;
  align-items: center;
  gap: 15px;
}

.avatar {
  width: 60px;
  height: 60px;
  background-color: #eee;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #888;
}

.avatar .material-symbols-outlined {
  font-size: 35px;
}

.text h2 {
  font-size: 20px;
  margin: 0;
  color: #333;
}

.grade {
  font-size: 14px;
  color: #666;
  margin-top: 5px;
}

.grade span {
  color: #579956;
  font-weight: bold;
}

.user-stats {
  text-align: right;
}

.stat-item {
  margin-bottom: 5px;
}

.stat-item .label {
  font-size: 13px;
  color: #888;
  margin-right: 10px;
}

.stat-item .value {
  font-weight: bold;
  color: #333;
}

/* 주문 현황 섹션 */
.order-status {
  margin-bottom: 40px;
}

.order-status h3 {
  font-size: 18px;
  margin-bottom: 20px;
}

.order-status h3 span {
  font-size: 13px;
  color: #999;
  font-weight: normal;
}

.status-grid {
  display: flex;
  justify-content: space-between;
  padding: 20px;
  border: 1px solid #eee;
  border-radius: 8px;
}

.status-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex: 1;
}

.status-item .count {
  font-size: 20px;
  font-weight: bold;
  color: #579956;
  margin-bottom: 5px;
}

.status-item .label {
  font-size: 13px;
  color: #666;
}

/* 메뉴 리스트 */
.mypage-menu ul {
  list-style: none;
  padding: 0;
  border-top: 1px solid #eee;
}

.mypage-menu li {
  border-bottom: 1px solid #eee;
}

.mypage-menu a {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px 10px;
  text-decoration: none;
  color: #333;
  font-size: 16px;
  transition: background 0.2s;
}

.mypage-menu a:hover {
  background-color: #fcfcfc;
}

.mypage-menu .material-symbols-outlined {
  color: #ccc;
}

/* 하단 버튼 */
.action-area {
  margin-top: 40px;
  text-align: center;
}

.logout-btn {
  background: none;
  border: 1px solid #ddd;
  padding: 10px 30px;
  color: #888;
  border-radius: 4px;
  cursor: pointer;
  font-size: 14px;
}

.logout-btn:hover {
  background-color: #f5f5f5;
  color: #666;
}

/* 반응형 모바일 설정 */
@media (max-width: 480px) {
  .user-summary {
    flex-direction: column;
    text-align: center;
    gap: 20px;
  }
  .profile-info {
    flex-direction: column;
  }
  .user-stats {
    text-align: center;
    border-top: 1px solid #eee;
    padding-top: 15px;
    width: 100%;
  }
}
</style>