<template>
  <div class="home">
    <v-btn @click="testClickEvent">Test</v-btn>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Home',
  methods: {
    testClickEvent: function () {
      axios.get('http://localhost:8000/test').then(res => {
        if (res.status === 200) {
          alert(res.data)
        } else {
          console.log('status : ' + res.status + ', data : ' + res.data)
        }
      }).catch(err => {
        console.log(err)
      })
    }
  }
}
</script>
