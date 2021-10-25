<template>
	<header>
		<div class="inner">
			<h1 class="logo">
				<img src="@/assets/img/Interior.jpg">
			</h1>

			<ul class="navbar">
				<li>
					<a href="">
						<span>아파트</span>
						<span>매매/전월세/신축분양</span>
					</a>
				</li>
				<li>
					<a href="">
						<span>빌라, 투룸+</span>
						<span>신축분양/매매/전월세</span>
					</a>
				</li>
				<li>
					<a href="">
						<span>원룸</span>
						<span>전월세</span>
					</a>
				</li>
				<li>
					<a href="">
						<span>오피스텔</span>
						<span>도시형생활주택/전월세</span>
					</a>
				</li>
				<li>
					<a href="">
						<span>셰어하우스</span>
						<span>함께 사는 주거공간</span>
					</a>
				</li>
			</ul>
		</div>
		<div class="right-header">	
			<v-btn text>
				로그인 및 회원가입
			</v-btn>
			<v-btn text float="left" color="indigo" font-size= "16px" font-weight= "400" >
				중개사무소 가입
			</v-btn>
		</div>
	</header>
</template>

<script>
  export default {
    name: "Header"
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
		width: 300px;
		margin-right: 0px;
	}

	header {
		max-height:100px;
		/*max-width:112px;*/
		padding: 15px 20px;
		
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

	ul.navbar li {
		float: left;
		margin-right: 50px;
		color: black;
	}

	ul.navbar li span {
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


	/*#logo{*/
	/*	width: 122px;*/
	/*	height: 60px;*/
	/*	margin: 12px;*/
	/*	object-fit: cover;*/
	/*	background-clip: border-box;*/
	/*}*/

	/*#house-list{*/
	/*	!* Font & Text *!*/
	/*	font-size: 16px;*/
	/*	font-style: normal;*/
	/*	font-variant: normal;*/
	/*	font-weight: 400;*/
	/*	letter-spacing: normal;*/


	/*	!* Color & Background *!*/
	/*	background-attachment: scroll;*/
	/*	background-color: rgba(0, 0, 0, 0);*/
	/*	background-image: none;*/
	/*	background-position: 0% 0%;*/
	/*	background-repeat: repeat;*/
	/*	color: rgb(0, 0, 0);*/

	/*	!* Box *!*/
	/*	height: 79px;*/
	/*	width: 660.594px;*/
	/*	margin: 0px;*/
	/*	padding: 0px;*/
	/*	max-height: none;*/
	/*	min-height: 0px;*/
	/*	max-width: none;*/
	/*	min-width: 0px;*/

	/*}*/

	/*.navMenu {*/
	/*	!* Font & Text *!*/
	/*	font-size: 16px;*/
	/*	font-style: normal;*/
	/*	font-variant: normal;*/
	/*	font-weight: 400;*/
	/*	letter-spacing: normal;*/
	/*	line-height: 18px;*/
	/*	text-decoration: none solid rgb(0, 0, 0);*/
	/*	text-align: left;*/
	/*	text-indent: 0px;*/
	/*	text-transform: none;*/
	/*	white-space: normal;*/
	/*	word-spacing: 0px;*/

	/*	!* Color & Background *!*/
	/*	background-attachment: scroll;*/
	/*	background-color: rgba(0, 0, 0, 0);*/
	/*	background-image: none;*/
	/*	background-position: 0% 0%;*/
	/*	background-repeat: repeat;*/
	/*	color: rgb(0, 0, 0);*/

	/*	!* Box *!*/
	/*	height: 43px;*/
	/*	width: 84.7969px;*/
	/*	margin: 0px;*/
	/*	padding: 19px 15px 17px;*/
	/*	max-height: none;*/
	/*	min-height: 0px;*/
	/*	max-width: none;*/
	/*	min-width: 0px;*/




	/*}*/
</style>
