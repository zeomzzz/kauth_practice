<template>
    <div class="container">
        <div>
            <h2>{{ kakaoNickname }}님 안녕하세요!</h2>
        </div>
        <div class="ButtonBox">
            <b-button id="logoutButton" variant="info" @click="logout">Logout</b-button>
        </div>
    </div>
</template>

<script>
export default {
  data(){
    return {
      kakaoNickname: '',
    }
  },
  created() {
    this.$store.dispatch("getKakaoNickname");
  }
}
</script>

<style>

</style>