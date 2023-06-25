# kauth_practice

- 막힌 부분 : 프로젝트 전체에 HttpSession 객체 하나만 만들어서 여러 컨트롤러에서 이거 하나에 정보 저정해서 같이 쓰는 방법?
  - @Autowired로 가져와서 쓰면 될 줄 알았는데, 메서드만 바뀌어도 sessionId가 달라지는 것으로 확인 (로그인할 때 session에 넣어도 못 가져다 쓴다)
  - sessionStorage에 올려아 하나? 아니면 다른 객체 만들어서 그냥 한 컨트롤러 안에서만 써야하나.. 그런데 이렇게 하면 session에 값을 왜 저장하나
  - sessionId로 서버에 있는 session 가져다 쓰는 방법이 없나
