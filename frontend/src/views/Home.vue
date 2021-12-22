<template>
  <div class="home">
    <router-link :to="{ name: 'MainPage' }"
            class="nav-link"
            active-class="active">
        (부동산 페이지 연습)
    </router-link>
  </div>
</template>

<script>


  export default {
    name: 'Home',

    components: {

    },
  }
</script>
