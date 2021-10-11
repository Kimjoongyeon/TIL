<template>
    <div>
        <Header />
            <body>
                <!--
                <div :style="{'background-image ':require('@/assets/img/nissan_maxima.png'),}">
                </div>
                -->
                <div id=background-box  :style="{backgroundImage: 'url('+item+')'}">
                    <div id=main-text >어떤 집을 찾고 있나요?</div>
                    <div id='tabHouse'>
                        <v-tabs center-active>
                            <v-tab>아파트</v-tab>
                            <v-tab>빌라, 투룸+</v-tab>
                            <v-tab>원룸</v-tab>
                            <v-tab>오피스텔</v-tab>
                        </v-tabs><br>
                    <div id=search>
                        <input type="text" class="form-control" placeholder="검색 키워드를 입력하세요!"> 
                            <v-btn class="ma-2" color="white"><v-icon>Search</v-icon></v-btn>
                    </div> 
                </div>
                </div>
                <div id=crawl-box>
                    <div class=pages>
                        <h5>소개 할게요</h5>
                       <v-divider></v-divider>
                    </div>
                    <div class=pages>
                        <h5>뉴스</h5>
                    </div>
                </div>
            </body>
        <Footer />
    </div>
</template>

<script>
import Header from '../layouts/Header.vue'
import Footer from '../layouts/Footer.vue'
export default {
  components: { Header, Footer },
    name: 'MainPage',
      
    data() {
        return {
            item: [
                require('@/assets/img/Interior.jpg'),
            ],

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

<style>

@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

* {
    font-family: 'Noto Sans KR', sans-serif;
}



#background-box{
    width: 1900px;
    height: 450px;
    background-size: contain;
    background-repeat: no-repeat;
    background-color:#ffffff;
    border: 0px solid #000000;
    
}

#crawl-box{
    width: 1900px;
    height: 270px;
    border: 0px solid #000000;
    padding: 40px 0 27px 0;
    display: block;
}

.pages{
    text-align: center;
    display: block;
}

#tabHouse{
    align-content: center;
    background: 0% 0%;
    background-color: #ffffff;
    height: 174px;
    width: 508px;
    font-size: 16px;
    line-height: 16px;
    display: block;
	background-color: rgba(0, 0, 0, 0);
	background-image: none;
	background-position: 0% 0%;
	background-repeat: repeat;
    margin: 0 129px 0 690px;

}

#search{
    font-size: 16px;
    line-height: 16px;
    background-color: #ffffff;
    background-position: 0% 0%;
    color:  #000000;
    height: 60px;
    width: 438px;
}

#main-text{
    text-align: center;
    line-height: 426px;
    font-size: 40px;
    font-weight: 700;
    background: 0% 0%;
    white-space: pre-wrap;
    text-decoration: none solid rgb(0, 0, 0);
    display: block;
    margin: 0 129px 0 129px;
    height: 276px;
}
</style>
