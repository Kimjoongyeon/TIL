<template>
	<header>
		<div class="inner">
			<h1 class="logo">
				<img src="@/assets/houseImg/mybang.png" @click="Gomain" height="80px" style="margin-top:-6px" >
			</h1>

			<ul class="navbar">
				<li>
					<a href="/villa">
						<span>빌라, 투룸+</span>
						<span>신축분양/매매/전월세</span>
					</a>
				</li>
				<li>
					<a href="/oneroom">
						<span>원룸</span>
						<span>전월세</span>
					</a>
				</li>
				<li>
					<a href="/officetel">
						<span>오피스텔</span>
						<span>도시형생활주택/전월세</span>
					</a>
				</li>
				<li>
					<a href="">
						<span><router-link to="/roommate">셰어하우스</router-link></span>
						<span>함께 사는 주거공간</span>
					</a>
				</li>
				<li v-if="auth == '사업자'">
					<a @click="goSellerList">
						<span>사업자</span>
						<span>매물 등록 및 확인</span>
					</a>
				</li>
			</ul>
		</div>
		<div class="right-header">
			<v-container>
				<div v-if="isLogin">
					<div class="loginUser">
						<span>
							{{ userInfo.userId }}
						</span>님
						<v-btn @click="gotoMypage" text>마이페이지</v-btn>|
						<v-btn @click="logout" text>로그아웃</v-btn>
					</div>
					<!--<v-btn text><a href="registerInfo">중개사무소<br>가입안내</a></v-btn>-->
				</div>
				<div style="float:left" v-else>
					<v-btn @click="gotoJoin" text>회원가입</v-btn>|
					<v-btn @click="gotoLogin" text>로그인</v-btn>
				</div>
			</v-container>
		</div>
	</header>
</template>

<script>
import { mapActions, mapState } from 'vuex'
  export default {
    name: 'Header',
    data() {
      return {
        userId: null,
				auth: null,
    }
  },
  computed: {
    ...mapState(['session', 'isLogin', 'userInfo'])
  },
  mounted() {
    this.fetchSession(this.$cookies.get('session'))
		if (this.session != null) {
			this.$store.state.isLogin = true
			this.$store.state.userInfo = this.fetchUserInfo(this.$cookies.get('session'))
		}
		setTimeout(() => {
			if (this.userInfo.length != 0) {
				this.auth = this.userInfo.authList[0].auth
			} else {
				this.auth = null
			}
		}, 500)
  },
  methods: {
    ...mapActions(['fetchSession', 'fetchUserInfo']),
    gotoJoin() {
      this.$router.push({name: 'MemberJoinPage'})
    },
    gotoLogin() {
      this.$router.push('/login')
    },
    logout () {
      this.$store.commit('USER_LOGIN', false)
      this.fetchSession(this.$cookies.remove('session'))
      this.$store.commit('FETCH_USER_INFO', [])
      alert("로그아웃 되었습니다!")
      this.$router.push({ name: 'Home' })
    },
    gotoMypage () {
      this.$router.push({ name: 'Mypage' })
    },
		Gomain () {
			this.$router.push({ name: 'Home' })
		},
		goSellerList () {
			this.$router.push({ name: 'SellerHouseListPage' })
		}
  }
}
</script>

<style scoped>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

	* {
		font-family: 'Noto Sans KR', sans-serif;
		margin: 0 auto;
	}

	ol, ul {
		list-style: none;
	}

	a {
		color: #000;
		text-decoration: none;
	}

	.right-header {
		width: 330px;
		margin-right: 0px;
	}

	header {
		max-height:100px;
		width: 1400px;
		padding: 15px 0px;
		/*margin: auto;*/

	}

	header:after {
		content: "";
		display: block;
		clear: both;
	}

	h1 {
		float: left;
		margin-right: 40px;
	}

	h1 > img {
		width: 100px;
	}

	ul.navbar {
		float: left;
		margin-left: 10px;
	}

	ul.navbar li {
		float: left;
		margin-right: 50px;
		color: black;
	}

	ul.navbar li span {
		display: block;
		color: black;
	}

	ul.navbar li span a{
		display: block;
		color: black;
	}

	ul.navbar li span:nth-child(1) {
		font-weight: bold;
		font-size: 20px;
		color: black;
	}

	ul.navbar li span:nth-child(2) {
		font-size: 12px;
		color: black;
	}

	.navbar > li > a >span:hover{
		background:white; color: #98BAE7;
	}

	.right-header .loginUser {
		font-size: 13px;
	}

	.right-header .loginUser > span {
		background: linear-gradient(to top, #a3f5a8 50%, transparent 50%);
	}

	



</style>
s