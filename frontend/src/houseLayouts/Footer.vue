<template>
	<div>
		<footer align="center"><br/>
			<v-card flat tile class="white white--text text-center">
				<v-card-text class="black--text pt-0">
					회사소개 | 채용정보 | 이용약관 | 개인정보 처리방침 | 위치기반 서비스 이용약관 | 중개사 사이트 바로가기
				</v-card-text>

				<v-card-text text-align="center" class="black--text pt-0">
					상호 : 내방  |  대표 : 1조  |  사업자등록번호: 111-11-11111<br>
					주소 : 서울특별시 강남구 테헤란로 000, 9층(강남구, XX타워) (우 : 00000)<br>
					팩스 : 02-123-4567  | 통신판매업 신고번호 : 0000-0000-0000<br>
					서비스 이용문의 : 0000-0000  |  이메일 : 1111111  |  서비스제휴문의 : partnership@MyBang.com
				</v-card-text>

				<v-card-text>
					<v-btn v-for="icon in icons" :key="icon" class="mx-4 black--text blue--background" icon>
						<v-icon size="24px">
							{{ icon }}
						</v-icon>
					</v-btn>
				</v-card-text>
				<v-card-text class="black--text">
					<strong>Copyright © MyBang. All Rights Reserved.</strong>
				</v-card-text>
			</v-card>
		</footer>
	</div>
</template>

<script>
  export default {
    name: 'Footer',

    data() {
      return {
        icons: [
          'mdi-facebook',
          'mdi-twitter',
          'mdi-linkedin',
          'mdi-instagram',
        ],
        // item: [
        //   require('@/assets/img/Interior.jpg'),
        // ],
        /*
				{
				icon: 'mdi-facebook',
				//text: '메인페이지',
				name: 'main_page',
				route: '/'
				},
				{
				icon: 'mdi-facebook',
				//text: '프로젝트 리스트',
				name: 'game_List',
				route: '/'
				},
				{
				icon: 'mdi-facebook',
				//text: '뉴스',
				name: 'daum_Crawl',
				route: '/'
				}
		]
		*/
        /*
          isLogin: false,
          nav_drawer: false,
          group: false,
          loginLinks: [
                {
                text: '회원가입/로그인',
                name: 'MemberLoginPage',
                route: '/login'
                },
            ],
        */

      }
    },
    mounted () {
      /*
			// this.fetchSession()
			this.$store.state.session = this.$cookies.get("user")
			if (this.$store.state.session != null) {
					this.isLogin = true
			}
			*/
    },
    computed: {
    },
    methods: {
      /*
					logout () {
							this.$cookies.remove("user")
							this.isLogin = false
							this.$store.state.session = null
							alert('로그아웃 처리되었습니다 ')
							this.$router.go();
					},
					fundingUpload() {
							this.isLogin = true
					},
					fundingUploadFail() {
							this.isLogin = false
							alert('로그인이 필요합니다')
							this.$router.push("login")
					}
					*/
    },
    watch: {
      /*
			group () {
					this.nav_drawer = false
			}
			*/
    }
  }
</script>

<style scoped>

	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

	* {
		font-family: 'Noto Sans KR', sans-serif;
	}
</style>
