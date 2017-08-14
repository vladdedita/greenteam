<template>
	<div class="logIn">   
		<div class="logo-side">
			<div class="logo">
        <img src="../assets/logo.png"/>
      </div>
			<p class="hero-title">Booking <span class="apl">App</span></p>
		</div>
		<form class="clearfix" @keyup.esc="clearData" @keyup.enter="nextStep">
      <div>
        <label>Email</label>
        <input 
        class="input_log" 
        type="email"
        v-model="email"
        v-on:input="$v.email.$touch"
        v-bind:class="{error: $v.email.$error, valid: $v.email.$dirty && !$v.email.$invalid}"
        placeholder="Email@email.com"
        />
      </div>
      <div>
        <label>Password</label>
        <input 
        class="input_log" 
        type="password"
        v-model="password"
        v-on:input="$v.password.$touch"
        v-bind:class="{error: $v.password.$error, valid: $v.password.$dirty && !$v.password.$invalid}"
        />
      </div>
      <button class="log-in" @click="nextStep">LOGIN
      </button>
      <router-link to="/recover"><p class="stil">Recover password</p></router-link>
    </form>
  </div>
</template>

<script>
  import Vue from 'vue'
  import VeeValidate from 'vee-validate'
  import { required, between, numeric, email, alpha, } from 'vuelidate/lib/validators'

  export default {
    name: 'logIn',
    data () {
      return {
        email: '',
        password: '',
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
   email: {
     required,
     email
   },
   password: {
     required
   }
 }

}
</script>

<style scoped>
  .logo-side{
   margin: auto;
 }
 .logo{
   text-align: center;
   margin-top: 115px;
 }
 .hero-title{
   font-size: 65px;
   color: #7E59D9;
   text-align: center;
   font-family: Arial,sans-serif;
   margin-top: initial;
   padding-top: 25px;
 }
 .apl{
   color: #A68CFD;

 }
 form{
   width: 28%;
   margin: auto;
   display: grid;
 }
 label{
   font-size: 20px;
   padding-bottom: 10px;
   color: #484848;
   text-align: left;
   display: -webkit-box;

 }
 .input_log{
   width: 360px;
   height: 53px;
   border-radius: 5px;
   border: 1px solid #8A8A8A;
   margin-bottom: 25px;
 }
 button{
   height: 55px;
   background-color: #DC2DE9;
   color: white;
   font-size: 22px;
   text-align: center;
   font-family: Arial;
   display: block;
   border-radius: 4%;
   border: transparent;
   margin: auto;
   padding: 10px;
   margin-top: 25px;

 }
 .log-in{
   width: 100%;
   cursor: pointer;
 }
 .stil{
   text-align: center;
   color: #4C4C4C;
   font-size: 17px;
   margin-top: 10px;
 }
 /*Form style*/
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
a{
  text-decoration: none;
  color: #474747;
}

</style>