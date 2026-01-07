
<template>
  <div class="community-container">
    <div v-if="post" class="community-content">
      <header class="board-header">
        <h1>{{ post.title }}</h1>
        <p>{{ post.author }} | {{ post.date }}</p>
      </header>
      
      <div class="post-content">
        {{ post.content }}
      </div>

      <div class="form-actions">
        <button class="cancel-btn" @click="$router.push('/community')">목록으로</button>
      </div>
    </div>
    <div v-else>
      <p>글을 불러오는 중입니다...</p>
    </div>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';

const route = useRoute();
const post = ref(null);

const fetchPostDetail = async () => {
  const id = route.params.id; // 주소창의 id 파라미터 가져오기
  try {
    const response = await axios.get(`http://localhost:8080/api/community/posts/${id}`);
    post.value = response.data;
    console.log("받아온 데이터:", post.value);
  } catch (error) {
    console.error("상세보기 로드 실패:", error);
  }
};

onMounted(() => {
  fetchPostDetail();
});
</script>

<style scoped>
.post-content {
  padding: 40px;
  border: 1px solid #ddd;
  min-height: 300px;
  background: #f9f9f9;
  margin-bottom: 20px;
  white-space: pre-wrap; /* 줄바꿈 유지 */
}
.form-actions { display: flex; justify-content: center; }
.cancel-btn { background: #eee; border: none; padding: 10px 30px; cursor: pointer; }
</style>