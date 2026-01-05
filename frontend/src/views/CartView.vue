<script setup lang="ts">
// 장바구니 아이템 개수 (예시)
const cartCount = 0;
</script>

<template>
  <div class="cart-container">
    <header class="cart-header">
      <h1>장바구니 <span class="count">{{ cartCount }}</span></h1>
    </header>

    <hr class="divider">

    <div class="column-labels">
      <div class="product-info">상품 정보</div>
      <div class="quantity">수량</div>
      <div class="price">주문금액</div>
      <div class="delivery">배송 정보</div>
    </div>

    <hr class="divider">

    <div v-if="cartCount === 0" class="empty-cart">
      <div class="icon">🛒</div> <p>장바구니가 비어있습니다.</p>
    </div>
  </div>
</template>

<style scoped>
.cart-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  color: #333;
}

.cart-header h1 {
  font-size: 24px;
  font-weight: bold;
  display: flex;
  align-items: center;
  gap: 10px;
}

.count {
  background-color: #666;
  color: white;
  border-radius: 50%;
  width: 20px;
  height: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 12px;
}

.divider {
  border: 0;
  border-top: 1px solid #eeeeee;
  margin: 10px 0;
}

/* 컬럼 레이아웃: Flexbox 사용 */
.column-labels {
  display: flex;
  padding: 15px 0;
  font-size: 14px;
  color: #888;
  text-align: center;
}

.product-info { flex: 4; text-align: left; } /* 상품 정보 공간을 가장 넓게 */
.quantity { flex: 1; }
.price { flex: 1; }
.delivery { flex: 1; }

/* 빈 장바구니 스타일 */
.empty-cart {
  padding: 100px 0;
  text-align: center;
  color: #ccc;
}

.empty-cart .icon {
  font-size: 60px;
  margin-bottom: 20px;
  opacity: 0.3;
}

.empty-cart p {
  font-size: 16px;
}
</style>