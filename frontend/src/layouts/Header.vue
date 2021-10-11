<template>
    <div>
        <header>
            <v-banner>
                <v-toolbar  color="white">
                <div id="logo">
                    <a href="main"><img :src="require(`@/assets/img/logo.jpg`)"></a>
                </div>

                <ul id="house-list">
                    <!--<v-card width="108px" height="43px">-->
                    <a font-color="black" >
                        <span text text-align="left" class="mb-12" color="black" height="26px" width="108px" >
                            아파트<br>
                        <span-small text-align="left">매매/전월세/신축분양</span-small>
                        </span>
                    </a>
                    <!--</v-card>-->

                    <a>
                    <span text text-align="left" color="black" height="26px" width="108" position="#FA880B">빌라, 투룸+<br>
                    <span-small text-align="left">신축분양/매매/전월세</span-small></span>
                    </a>
                    <a>
                    <span text text-align="left" color="black" height="26px" width="33px">원룸<br>
                    <span-small text-align="left">전월세</span-small></span>
                    </a>
                    <a>
                    <span text text-align="left" color="black" height="26px" width="115px">오피스텔<br>
                    <span-small text-align="left">도시형생활주택/전월세</span-small></span>
                    </a>
                </ul>

                <v-spacer></v-spacer>

                <v-toolbar-items class="hidden-sm-and-down">

                <v-btn text>
                    로그인 및 회원가입
                </v-btn>

               

                <v-btn text>
                    중개사무소 가입
                </v-btn>
                </v-toolbar-items>            
                </v-toolbar>
            </v-banner>
        </header>
    </div>
</template>

<script>
export default {
    name: 'Header',
      
    data() {
        return {
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

#header {
    max-height:"50px"; max-width:"112px";
}

#logo{
    width: 122px;
    height: 60px;
    margin: 12px;
    object-fit: cover; 
    background-clip: border-box;
}

#house-list{
    width: 660px;
    height: 79px;
    display: block;
}
</style>