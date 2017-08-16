<template>

  <div class="recover">
    <div class="logo-side">
      <div class="logo">
        <img src="../assets/logo.png"/>
      </div>
      <p class="hero-title">Booking <span class="apl">App</span></p>
    </div>

    <form>
      <label >Email address</label>
      <input 
      class="input_log"
      v-model="email"
      v-on:input="$v.email.$touch"
      v-bind:class="{error: $v.email.$error, valid: $v.email.$dirty && !$v.email.$invalid}"
      placeholder="Email@email.com"
      >
    </form>

    <div id="space"></div>

    <button class="login">RECOVER</button>

  </div>
</template>

<script>
import { required, email, } from 'vuelidate/lib/validators'

export default {
  name: 'recover',
  data () {
    return {
      msg: 'recoverPage',
      email: '',
    }
  },

  validations: {
    email: {
      required,
      email,
    }
  }

}

</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

    #space{
      border: none;
      height: 20px;
    }

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
      border-radius: 5px;
      border: transparent;
      margin-left: 473px;
      padding: 10px;
    }

    .login{
      width: 361px;
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
</style>
