<template>
	<div>
		<Header />
		<div id=background-box  :style="{backgroundImage: 'url('+item+')'}">
			<div id=main-text>어떤 집을 찾고 있나요?</div>
			<div id=tabHouse>
				<v-tabs center-active>
					<v-tab>아파트</v-tab>
					<v-tab>빌라, 투룸+</v-tab>
					<v-tab>원룸</v-tab>
					<v-tab>오피스텔</v-tab>
					<v-tab>셰어하우스</v-tab>
				</v-tabs><br>
				<div id=search>
					<input type="text" class="form-control" placeholder="검색 키워드를 입력하세요!" flat none>
					<div id=search-icon>
						<v-btn class="ma-2" color="white"><v-icon>mdi-magnify</v-icon></v-btn>
					</div>
				</div>
			</div>
		</div>
			<!--   소개할게요, 뉴스, 공지사항 영역 시작   -->
    <div class="board_content">
         <article>
            <h2>소개할게요</h2>
            <hr>
            <ul>
               <li>리스트1</li>
               <li>리스트2</li>
               <li>리스트3</li>
               <li>리스트4</li>
               <li>리스트5</li>
            </ul>
         </article>

         <article>
            <div class="more_btn">
               <h2>뉴스</h2>
               <v-btn depressed>
                  더보기
               </v-btn>
            </div>
            <hr>
            <ul>
               <li>리스트1</li>
               <li>리스트2</li>
               <li>리스트3</li>
               <li>리스트4</li>
               <li>리스트5</li>
            </ul>
         </article>

         <article>
            <div class="more_btn">
               <h2>공지사항</h2>
               <v-btn depressed>
                  더보기
               </v-btn>
            </div>
            <hr>
            <ul>
               <li>리스트1</li>
               <li>리스트2</li>
               <li>리스트3</li>
               <li>리스트4</li>
               <li>리스트5</li>
            </ul>
         	</article>
      	</div>
      <!--   소개할게요, 뉴스, 공지사항 영역 끝   -->
	<Footer />
	</div>
</template>

<script>
import Header from '../layouts/Header'
import Footer from '../layouts/Footer'

export default {
    components: { Header, Footer },
    name: 'MainPage',
    data() {
      return {
        item: [
           require('@/assets/img/Interior.jpg'),
        ],
      }
    },
    mounted () {
    },
    computed: {
    },
    methods: {
    }
  }
</script>

<style scoped>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

	* {
		font-family: 'Noto Sans KR', sans-serif;
	}



	#background-box{
		/*width: 1900px;*/
		height: 450px;
		background-size: contain;
		background-repeat: no-repeat;
		background-color:#ffffff;
		border: 0px solid #000000;

	}

	#crawl-box{
		/*width: 1900px;*/
		height: 270px;
		border: 0px solid #000000;
		padding: 40px 0 27px 0;
		display: block;
	}

	.pages{
		text-align: center;
		display: block;
	}

	#search-icon{
		/* Box */
		height: 60px;
		width: 66px;
		margin: 0px;
		padding: 13px 18px 15px 20px;


		/* Positioning */
		position: absolute;
		top: -7px;
		bottom: 0px;
		right: 0px;
		left: 390px;
		float: none;
		display: flex;
		clear: none;
	}

	#tabHouse{
		align-content: center;
		background: 0% 0%;
		background-color: #ffffff;
		height: 174px;
		width: 484px;
		font-size: 16px;
		line-height: 16px;
		display: block;
		background-color: rgba(0, 0, 0, 0);
		background-image: none;
		background-position: 0% 0%;
		background-repeat: repeat;
		margin: 0 auto;

	}

	#search{
		/* Font & Text */
		font-size: 16px;
		font-style: normal;
		font-variant: normal;
		font-weight: 400;
		letter-spacing: normal;
		line-height: 16px;
		text-decoration: none solid rgb(0, 0, 0);
		text-align: start;
		text-indent: 0px;
		text-transform: none;
		vertical-align: baseline;
		white-space: normal;
		word-spacing: 0px;

		/* Color & Background */
		background-color: rgb(242, 242, 242);
		background-image: none;
		background-position: 0% 0%;
		background-repeat: repeat;
		color: rgb(0, 0, 0);

		/* Box */
		height: 60px;
		width: 410px;
		margin: 0px;
		padding: 6px 20px 10px 20px;

		/* Positioning */
		position: relative;
		top: 0px;
		bottom: 0px;
		right: 0px;
		left: 0px;
		float: none;
		display: flex;
		clear: none;
		z-index: 0;

		/* Effects */
		border-top-left-radius: 8px;
		border-top-right-radius: 8px;
		border-bottom-left-radius: 8px;
		border-bottom-right-radius: 8px;
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

/* 소개할게요, 뉴스, 공지사항 영역 시작 */
    .board_content {
      padding: 15px 0;
      width: 1200px;
      margin: 0 auto;
   }

    .board_content:after, .board_content .more_btn:after{
      display: block;
      content: '';
      clear: both;
   }

    .board_content article{
      float: left;
      width: calc(92%/3);
      margin-right: 4%;
   }

    .board_content article:nth-child(3) {
      margin-right: 0;
   }

    .board_content article h2 {
      font-size: 19px;
      padding-bottom: 14px;
   }

    .board_content article .more_btn > h2 {
      float: left;
   }

    .board_content article .more_btn .v-btn {
      float: right;
      font-size: 12px;
      padding: 0;
   }

    .board_content hr {
      height: 1px;
      border: none;
      background-color: #ccc;
   }

    .board_content article ul {
      margin-top: 14px;
   }

    .board_content article ul li {
      padding: 3px 0;
   }
   /* 소개할게요, 뉴스, 공지사항 영역 끝 */
</style>
