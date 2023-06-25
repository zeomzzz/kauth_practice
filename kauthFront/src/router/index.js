import Vue from "vue";
import VueRouter from "vue-router";
import Main from "../views/Main.vue";
import Login from "@/components/main/Login.vue";
import Service from "@/components/service/Home.vue";
import RedirectPage from "@/components/main/RedirectPage.vue";

Vue.use(VueRouter);

const routes = [
  {
    component: Main,
    path: "/",
    children: [
      {
        name: "Login",
        component: Login,
        path: "/",
      },
      {
        name: "RedirectPage",
        component: RedirectPage,
        path: "oauth/kakao",
      },
    ],
  },
  {
    component: Service,
    name: "Service",
    path: "/home"
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
