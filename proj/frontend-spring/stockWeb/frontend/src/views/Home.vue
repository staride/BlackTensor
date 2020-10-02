<template>
  <div class="home">
    <google-login
      class="big-button"
      :params="params"
      :renderParams="renderParams"
      :onSuccess="LoginSuccess"
      :onFailure="LoginFail"
    >Login</google-login>
    <google-login
      class="big-button"
      :params="params"
      :logoutButton="true"
      :onSuccess="LogoutSuccess"
      :onFailure="LogoutFail"
    >logout</google-login>
  </div>
</template>

<script>
import googleLogin from 'vue-google-login'

export default {
  name: 'Home',
  data: function () {
    return {
      params: {
        client_id: '478884451904-hmq4ib5rdbnkbktohjhc0lb08l04quei.apps.googleusercontent.com'
      },
      renderParams: {
        width: 250,
        height: 50,
        longtitle: true
      }
    }
  },
  components: {
    googleLogin
  },
  methods: {
    LoginSuccess: function (googleUser) {
      console.log(googleUser.getBasicProfile())
    },
    LoginFail: function () {
      alert('login Fail')
    },
    LogoutSuccess: function () {
      alert('logout ok')
    },
    LogoutFail: function () {
      alert('logout Fail')
    }
  }
}
</script>
