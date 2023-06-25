<template>
  <div>
    <h2>로그인</h2>
      <a href="http://localhost:9999/oauth/authorize">
        <img
          src="../../assets/kakao_login.png"
          class="d-inline-block align-top"
          id="logo"
        />
      </a>
  </div>
</template>

<script>
export default {
  name: "Login",
  methods: {
    // toKakaoLogin() {
    //   this.$store.dispatch("toKakaoLogin");
    // }
    // toKakaoLogin() {
    //   window.location.href = 'https://kauth.kakao.com/oauth/authorize?client_id=56ee308c9dcd70214759634d00cf825a&redirect_uri=http://localhost:8080/oauth/kakao&response_type=code';
    // }
  }
}
</script>

<style>

</style>