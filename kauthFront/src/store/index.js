import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
// import { codePointAt } from "core-js/core/string";
import router from "../router";

Vue.use(Vuex);

const OAUTH_REST_API = "http://localhost:9999/oauth";

export default new Vuex.Store({
  state: {
  },
  getters: {

  },
  mutations: {
    // GET_KNICKNAME(state, nickname) {

    // }
  },

  actions: {
    doKakaoLogin({ commit }, req) {
      const API_URL = `${OAUTH_REST_API}/kakao`;
      axios({
        url: API_URL,
        method: "GET",
        params: req,
      })
      .then(() => {
        commit;
        router.push( { name: 'Service' } );
      })
      .catch((err) => {
        console.log(err);
      });
    },
    getKakaoNickname({ commit }) {
      const API_URL = `${OAUTH_REST_API}/getknick`;
      axios({
        url: API_URL,
        method: "GET",
      })
      .then((res) => {
        console.log(res.data);
        commit;
      })
      .catch((err) => {
        console.log(err);
      });
    }
  },
  modules: {},
});
