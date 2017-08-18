<template>
  <div class="register">
    <div class="logo"><img src="../assets/logo.png"/></div>
    <p class="hero-title">Booking <span class="apl">App</span></p>

    <form class="clearfix" @keyup.esc="clearData" @keyup.enter="nextStep" @submit.prevent="submitForm">
      <div>
        <label>Name</label>
        <input 
        class="input_log" 
        type="text"
        v-model="userPayload.name"
        v-on:input="$v.userPayload.name.$touch"
        v-bind:class="{error: $v.userPayload.name.$error, valid: $v.userPayload.name.$dirty && !$v.userPayload.name.$invalid}"
        placeholder="Name" 
        />
      </div>
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
      <button class="log-in" @click="submitForm">REGISTER</button>
      <router-link to="/logIn"><p class="stil">You already have an account?</p></router-link>
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
          name: '',
          email: '',
          password: '',
        },
        formSubmitted: false
      }
    },
    methods: {
      nextStep() {
        if(this.checkValidation()){
          this.step++;
        }
        else{
          alert('You must provide valid information!')
        }
      },
      submitForm() {
        axios.post(window.ApiUrl + "/register",this.userPayload).then((res) => {
          this.submitForm=true;
          console.log("res ", res);
          this.$router.push("/logIn");

        })
        .catch((err) => {
          console.log("err", err);
        })
      },
      previousStep() {
        if(this.step > 0 ) {
          this.step--;
        } 
      },
      checkValidation(){
        var validElements = document.getElementsByClassName('valid');
        if(validElements.length === 3) {
          return true;
        }
        return false;
      },
      clearData(){
        this.name='';
        this.phone='';
        this.email='';
      }
    },

    validations: {
      userPayload:{
        name: {
          required,
          alpha,
        },
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
    border-radius:7px;
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
</style>
