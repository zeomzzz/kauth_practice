<template>
  <div id="app" class="container">
    <router-view />
  </div>
</template>
<script>
export default {
  name: "App",
};
</script>
<style>

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}
.text-center {
  text-align: center;
}
/* .container {
  margin: 0px 0px;
} */
#blueBtn {
  width: 100px;
  height: 50px;
  background-color: #148cff;
  font-weight: bold;
  box-shadow: 2px 1px 5px grey;
  display: flex;
  justify-content: center;
  align-items: center;
}
#grayBtn {
  width: 100px;
  height: 50px;
  background-color: gray;
  font-weight: bold;
  box-shadow: 2px 1px 5px grey;
  display: flex;
  justify-content: center;
  align-items: center;
}
#redBtn {
  width: 100px;
  height: 50px;
  background-color: #f02c23;
  font-weight: bold;
  box-shadow: 2px 1px 5px grey;
  display: flex;
  justify-content: center;
  align-items: center;
}
#blueBtn:hover {
  background-color: darkblue;
}
#grayBtn:hover {
  background-color: rgb(57, 57, 57);
}
#redBtn:hover {
  background-color: #b3120a;
}

/* 버튼 한 줄에 간격 두고 정렬하고 싶을 때 사용하기 (밑에 예시코드) */
/* <div class="btnGroup">
      <b-button id="grayBtn" class="btnChild">이전</b-button>
      <b-button id="blueBtn" @click="userCheck" class="btnChild">수정</b-button>
      <b-button id="blueBtn" class="btnChild">회원탈퇴</b-button>
  </div> */
.btnGroup {
  display: flex;
  justify-content: center;
  align-content: center;
}
.btnChild {
  margin: 0 10px;
}
a:hover {
  text-decoration-line: none !important;
}
</style>
