# kauth_practice

- 막힌 부분 : 프로젝트 전체에 HttpSession 객체 하나만 만들어서 여러 컨트롤러에서 이거 하나에 정보 저정해서 같이 쓰는 방법이 있는지?
  - @Autowired로 쓰면 될 줄 알았는데, 메서드만 바뀌어도 sessionId가 달라지는 것으로 확인 (로그인할 때 session에 넣어도 못 가져다 쓴다)
