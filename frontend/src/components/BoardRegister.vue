<template>
  <div class="register-form">
    <div class="input-group">
      <label>제목</label>
      <input v-model="newPost.title" type="text" placeholder="제목을 입력하세요" />
    </div>
    <div class="input-group">
      <label>작성자</label>
      <input v-model="newPost.author" type="text" placeholder="이름을 입력하세요" />
    </div>
    <div class="input-group">
      <label>내용</label>
      <textarea v-model="newPost.content" rows="10" placeholder="내용을 입력하세요"></textarea>
    </div>
    <div class="form-actions">
      <button class="cancel-btn" @click="$emit('cancel')">취소</button>
      <button class="save-btn" @click="submitPost">등록하기</button>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import axios from 'axios';

const emit = defineEmits(['saved', 'cancel']);

const newPost = ref({
  title: '',
  author: '',
  content: ''
});

const submitPost = async () => {
  if (!newPost.value.title || !newPost.value.content) {
    alert("제목과 내용을 입력해주세요.");
    return;
  }
  
  try {
    // 백엔드의 /api/community/register API 호출
    await axios.post('http://localhost:8080/api/community/register', newPost.value);
    alert("등록되었습니다.");
    emit('saved'); // 부모 컴포넌트(CommunityView)에게 완료 신호 보냄
  } catch (error) {
    alert("등록에 실패했습니다.");
  }
};
</script>

<style scoped>
.register-form { background: #fff; padding: 20px; border: 1px solid #ddd; border-radius: 8px; }
.input-group { margin-bottom: 15px; }
.input-group label { display: block; margin-bottom: 5px; font-weight: bold; }
.input-group input, .input-group textarea { width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 4px; }
.form-actions { display: flex; justify-content: flex-end; gap: 10px; margin-top: 20px; }
.save-btn { background: #579956; color: white; border: none; padding: 10px 20px; cursor: pointer; }
.cancel-btn { background: #eee; color: #333; border: none; padding: 10px 20px; cursor: pointer; }
</style>