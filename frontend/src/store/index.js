import Vue from 'vue'
import Vuex from 'vuex'

import state from './states'
import actions from './actions'
import mutations from './mutations'
import getters from './getters'

Vue.use(Vuex)

export default new Vuex.Store({
  state,
  actions,
  mutations,
  getters
})

/*  원래 여기서 설정하지만 그러면 파일 하나에 다 때려박아서 확인하기 힘드니 파일들을 따로 만든다
export default new Vuex.Store({
  state: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
  }
})
*/
