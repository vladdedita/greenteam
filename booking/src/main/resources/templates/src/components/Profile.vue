<template>
  <div class="profile">

    <navigation></navigation>
    <router-view></router-view>

    <div class="logo">

      <div id="form">
        <img src="../assets/default-logo.png"/> 
      </div>

    <div id="submit">Upload Image</div> 
    <div id="max">(max.140x140px)</div>
  </div>


  <div class="text">
    <form>
      <label>Company name</label>
      <input class="input_log" type="text" name="company name">

      <label>Company description</label>
      <textarea class="detail" name="description" rows="10" cols="30" />
      <div class="space">
         <router-link to="/logIn"><button class="save" id="out" @click="logout">Sign Out</button></router-link>
        <button class="save" id="ok">Save</button>
      </div>
    </form>

  </div>
</div>
</template>

<script>

import navigation from '@/components/navigation';

export default {
  name: 'profile',
  data() {
    // imageData: ""  // we will store base64 format of image in this string
    return {
      msg: 'profilePage',
      user: {
        authenticated: false
      },
    }
  },
  components: {
    navigation: navigation
  },
  methods: {
    logout() {
      localStorage.removeItem('id_token')
      localStorage.removeItem('access_token')
      this.user.authenticated = false
    },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

#submit{
  font-size: 20px;
  color: #484848;
  text-align: center;
  margin-top: 20px;
  margin-left: 17px;
  border: none;
  background-color: #ffffff;
  width: 225px;
}

#max{
  font-size: 17px;
  color: #a0a2a5;
  text-align: center;
  margin-left: 10px;
}
#form{
  margin: auto;
}
.logo{
  width: 19%;
  float: left;
  margin-left: 230px;
  margin-top: 9%;
}
img{
  border: none;
  width: 240px;
  height: 240px;
  border-radius: 100%;
}
.text{
  width: 22%;
  float: right;
  margin-right: 37%;
  margin-top: 9%;
}
form{
  width: 28%;
  margin: auto;
  display: grid;
}
label{
  font-size: 20px;
  color: #484848;
  text-align: left;

}
.input_log{
  width: 360px;
  height: 53px;
  border-radius: 5px;
  border: 1px solid #8A8A8A;
  margin-bottom: 25px;
}
.detail{
  width: 361px;
  height: 100px;
  border-radius: 5px;
  border: 1px solid #8A8A8A;
}
button{
  height: 55px;
  background-color: #DC2DE9;
  color: white;
  font-size: 22px;
  text-align: center;
  font-family: Arial;
  border-radius: 5px;
  border: transparent;
  margin: auto;
  padding: 10px;

}
.save{
  width: 166px;

}
#out{
  background-color: #dee1e5;
  float: left;
  margin-left: 0%;
  display: inline-block;
}
#ok{
  float: right;
  margin-right: 0%;
  display: inline-block;
}
.space{
  margin-top: 30px;
}

</style>
