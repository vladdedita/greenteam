<template>
  <div class="logIn">

    <div class="company">
      <div class="navigations-company">
        <nav><router-link to="/">
          <h2 id="nav-logo">

              Booking<b>App</b>

          </h2>
        </router-link>

          <ul class="nav-comp">
            <li class="nav-comp-item">
              <router-link to="/" exact-active-class="active">Companies</router-link>
            </li>
            <li class="nav-comp-item">
              <router-link to="/register" exact-active-class="active">Register</router-link>
            </li>
            <li class="nav-comp-item">
              <router-link to="/logIn" exact-active-class="active-comp">LogIn</router-link>
            </li>
          </ul>
        </nav>
      </div>
    </div>


    <div class="logo"><img src="../assets/logo.png"/></div>
    <p class="hero-title">Booking <span class="apl">App</span></p>

    <form class="clearfix" method="post" @submit.prevent="submitLog">
      <div>
        <label>Email</label>
        <input 
        class="input_log" 
        type="email"
        v-model="userPayload.email"
        v-on:input="$v.userPayload.email.$touch"
        v-bind:class="{error: $v.userPayload.email.$error, valid: $v.userPayload.email.$dirty && !$v.userPayload.email.$invalid}"
        placeholder="Email@email.com"
        />
      </div>
      <div>
        <label>Password</label>
        <input 
        class="input_log" 
        type="password"
        v-model="userPayload.password"
        v-on:input="$v.userPayload.password.$touch"
        v-bind:class="{error: $v.userPayload.password.$error, valid: $v.userPayload.password.$dirty && !$v.userPayload.password.$invalid}"
        />
      </div>
      <button class="log-in" @click="submitLog">LogIn</button>
      <router-link to="/recover"><p class="stil">Recover password</p></router-link>
    </form>
  </div>

</template>

<script>
  import Vue from 'vue'
  import VeeValidate from 'vee-validate'
  import { required, between, numeric, email, alpha, } from 'vuelidate/lib/validators'
  import axios from 'axios'

  export default {
    name: 'logIn',
    data () {
      return {
        userPayload:{
          email: '',
          password: '',
        },
        user: {
          authenticated: false
        },
        formSubmitted: false
      }
    },

  //  login(context, creds, redirect) {
  //   context.$http.post(LogIn_URL, creds, (data) => {
  //     localStorage.setItem('id_token', data.id_token)
  //     localStorage.setItem('access_token', data.access_token)

  //     this.user.authenticated = true

  //     // Redirect to a specified route
  //     if(redirect) {
  //       router.go(redirect)        
  //     }

  //   }).error((err) => {
  //     context.error = err
  //   })
  // },


  methods: {

    submitLog() {


      axios.post(window.ApiUrl + "/login", this.userPayload).then((res) => {
        //token
        this.$localStorage.set('token', res.data);
        this.$localStorage.set('email',this.userPayload.email);
        this.$router.push('/dashboard');

        console.log("res ", res);

      })
      .catch((err) => {
        console.log("err", err);
      })
    },

    checkValidation(){
      var validElements = document.getElementsByClassName('valid');
      if(validElements.length === 2) {
        return true;
      }
      return false;
    },
    clearData(){
      this.email='';
      this.password='';
    }
  },

  validations: {
    userPayload:{
      email: {
        required,
        email
      },
      password: {
        required
      }
    }
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .logo{
    text-align: center;
    margin-top: 115px;
  }
  .hero-title{
    font-size: 65px;
    color: #6880D5;
    text-align: center;
    font-family: Arial,sans-serif;
    margin-top: initial;
    padding-top: 25px;
  }
  .apl{
    color: #96AAF9;
  }
  form{
    width: 28%;
    margin: auto;
    display: grid;
  }
  label{
    font-size: 20px;
    display: -webkit-box;
  }
  button{
    height: 55px;
    background-color: #DC2DE9;
    color: white;
    font-size: 22px;
    text-align: center;
    font-family: Arial;
    display: block;
    border-radius:5px;
    border: transparent;
    margin: auto;
    padding: 10px;
    margin-top: 30px;
  }
  .log-in{
    width: 100%;
    cursor: pointer;
  }
  .bottom-text{
    padding-bottom: 8px;
    margin-top: 15px;
  }
  .error {
    border-color: red;
    background: #FDD;
  }

  .error:focus {
    outline-color: #F99;
  }

  .valid {
    border-color: #5A5;
    background: #EFE;
  }

  .valid:focus {
    outline-color: #8E8;
  }
  .input_log{
    width: 100%;
    height: 53px;
    border-radius: 5px;
    border: 1px solid #8A8A8A;
    margin-bottom: 25px;
  }
  a{
    text-decoration: none;
    color: #474747;
  }
  .stil{
   text-align: center;
   color: #4C4C4C;
   font-size: 17px;
   margin-top: 10px;



 }

  .nav-comp-item{
    list-style-type: none;
    display: inline;
    color: #FFF;
    text-transform: uppercase;
    cursor: pointer;
  }
  .nav-comp{
    background-color: #7B90E0;
    padding: 37px 20px 10px 0;
    font-size: 14px;
    text-align: right;
    word-spacing: 18px;
    margin: 0;
  }
  #nav-logo{
    position: absolute;
    color: #FFF;
    margin: 25px 0 10px 25px;
  }
  .active-comp {
    font-weight: bold;
  }
  a{
    color: #FFF;
  }
  a:hover{
    text-decoration: none;
    color:#fff;
  }
</style>
