<template>
  <div>
    <h2>로그인</h2>

  </div>
</template>

<script>
export default {
  name: "RedirectPage",
  created(){
    // authentication code 추출
    let authCode =  document.location.href.split("=")[1];
    let code = { code : authCode };
    // console.log(code);

    // Axios로 요청 보내기
    this.$store.dispatch("doKakaoLogin", code);
  }
}
</script>

<style>

</style>