<script setup lang="ts">
import { onMounted, ref } from 'vue';
import axios from 'axios';
import { RouterLink } from 'vue-router'; // 명시적으로 추가

// 데이터 구조 정의 (TypeScript 오류 방지)
interface Post {
  id: number;
  title: string;
  author: string;
  date: string;
  status: string;
}

const posts = ref<Post[]>([]); // 타입을 Post 배열로 지정

const fetchPosts = async () => {
  try {
    // 1. 서버가 켜져 있는지 확인
    // 2. vite.config.ts의 proxy 설정에 의해 /api -> http://localhost:8080 으로 전달됨
    const response = await axios.get('/api/community/posts');
    posts.value = response.data;
  } catch (error) {
    console.error('데이터를 가져오는데 실패했습니다. 서버 상태를 확인하세요:', error);
  }
};

onMounted(() => {
  fetchPosts();
});
</script>

<template>
  <div class="community-container">
    <div class="community-content">
      <header class="board-header">
        <h1>문의게시판</h1>
        <p>PIT A PAT에게 궁금한 점을 남겨주세요.</p>
      </header>

      <div class="board-controls">
        <div class="search-bar">
          <input type="text" placeholder="검색어를 입력하세요" />
          <span class="material-symbols-outlined">search</span>
        </div>
        <button class="write-btn">문의하기</button>
      </div>

      <div class="board-list">
        <div class="list-header">
          <span class="col-id">번호</span>
          <span class="col-title">제목</span>
          <span class="col-author">작성자</span>
          <span class="col-date">날짜</span>
          <span class="col-status">상태</span>
        </div>

        <div v-for="post in posts" :key="post.id" class="list-item">
          <span class="col-id">{{ post.id }}</span>
          <div class="col-title">
            <router-link :to="`/community/${post.id}`">
              {{ post.title }}
            </router-link>
            <span class="mobile-info">{{ post.author }} | {{ post.date }}</span>
          </div>
          <span class="col-author pc-only">{{ post.author }}</span>
          <span class="col-date pc-only">{{ post.date }}</span>
          <span class="col-status">
            <span :class="['status-badge', post.status === '답변완료' ? 'done' : 'waiting']">
              {{ post.status }}
            </span>
          </span>
        </div>
      </div>

      <div class="pagination">
        <button class="active">1</button>
        <button>2</button>
        <button>3</button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.community-container {
  display: flex;
  justify-content: center;
  padding: 120px 20px 60px; /* 네비게이션 바 겹침 방지를 위해 상단 패딩 확보 */
  min-height: 80vh;
}

.community-content {
  width: 100%;
  max-width: 1000px;
}

.board-header {
  text-align: center;
  margin-bottom: 50px;
}

.board-header h1 {
  font-size: 28px;
  font-weight: bold;
  color: #333;
}

.board-header p {
  color: #888;
  margin-top: 10px;
}

/* 컨트롤 영역 */
.board-controls {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
}

.search-bar {
  display: flex;
  align-items: center;
  border-bottom: 1px solid #ddd;
  padding: 5px 0;
}

.search-bar input {
  border: none;
  outline: none;
  padding: 5px 10px;
  width: 200px;
}

.search-bar .material-symbols-outlined {
  color: #888;
  cursor: pointer;
}

.write-btn {
  background-color: #579956;
  color: white;
  border: none;
  padding: 10px 25px;
  border-radius: 4px;
  font-weight: bold;
  cursor: pointer;
}

/* 리스트 스타일 */
.board-list {
  border-top: 2px solid #333;
}

.list-header {
  display: flex;
  padding: 15px 10px;
  background-color: #f9f9f9;
  font-weight: bold;
  font-size: 14px;
  text-align: center;
  border-bottom: 1px solid #eee;
}

.pc-only { display: block; }

.list-item {
  display: flex;
  padding: 20px 10px;
  border-bottom: 1px solid #eee;
  align-items: center;
  text-align: center;
  font-size: 14px;
}

.list-item:hover {
  background-color: #fcfcfc;
}

/* 컬럼별 너비 조절 */
.col-id { width: 60px; color: #999; }
.col-title { flex: 1; text-align: left; padding-left: 20px; }
.col-title a { text-decoration: none; color: #333; font-weight: 500; }
.col-author { width: 100px; }
.col-date { width: 120px; color: #888; }
.col-status { width: 100px; }

.mobile-info { display: none; }

/* 상태 배지 */
.status-badge {
  padding: 4px 8px;
  border-radius: 12px;
  font-size: 11px;
}

.status-badge.done {
  background-color: #eef7ee;
  color: #579956;
}

.status-badge.waiting {
  background-color: #f5f5f5;
  color: #888;
}

/* 페이지네이션 */
.pagination {
  display: flex;
  justify-content: center;
  margin-top: 40px;
  gap: 5px;
}

.pagination button {
  width: 35px;
  height: 35px;
  border: 1px solid #ddd;
  background-color: white;
  cursor: pointer;
  border-radius: 4px;
}

.pagination button.active {
  background-color: #579956;
  color: white;
  border-color: #579956;
}

/* 반응형 모바일 */
@media (max-width: 768px) {
  .pc-only { display: none; }
  .list-header { display: none; }
  .col-id { display: none; }
  .col-status { width: 80px; }
  .col-title { padding-left: 0; }
  .mobile-info {
    display: block;
    font-size: 12px;
    color: #999;
    margin-top: 5px;
  }
}
</style>