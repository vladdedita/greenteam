<template>
    <div class="register">
      <img src="../assets/logo.png">
        <p class="hero-title">Booking <span class="apl">App</span></p>
        <!-- <form method="POST">
          <label>{{name}}</label>
          <input type="text" class="reg_input" name="cp_name"> 
          <label>{{email}}</label>
          <input  type="email" class="reg_input" name="cp_email" placeholder="email@email.com"> 
          <label>{{password}}</label>
          <input type="password" class="reg_input" name="cp_password"> 
        </form>
        <button class="log-in">REGISTER</button>
        <p class="bottom-text">You already have an account?</p> -->

        <form @submit.prevent="validateBeforeSubmit" v-if="!formSubmitted">
          <div class="form-group" :class="{'has-error': errors.has('name') }">
              <label class="control-label" for="name">Your name</label>
              <input v-model="name" v-validate.initial="name" data-rules="required|alpha|min:3" class="form-control" type="text">
              <p class="text-danger" v-if="errors.has('name')">{{ errors.first('name') }}</p>
          </div>
          <div class="form-group" :class="{'has-error': errors.has('email') }" >
              <label class="control-label" for="email">Email address</label>
              <input v-model="email" v-validate.initial="email" data-rules="required|email" class="form-control" type="email" placeholder="email@email.com">
              <p class="text-danger" v-if="errors.has('email')">{{ errors.first('email') }}</p>
          </div>
          <div class="form-group" :class="{'has-error': errors.has('name') }">
              <label class="control-label" for="name">Password</label>
              <input v-model="name" v-validate.initial="name" data-rules="required|alpha|min:3" class="form-control" type="password">
              <p class="text-danger" v-if="errors.has('name')">{{ errors.first('name') }}</p>
          </div>
              <button class="log-in" type="submit">REGISTER</button>
              <p class="bottom-text">You already have an account?</p>
        </form>
        <div v-else>
          <h1 class="submitted">Form submitted successfully!</h1>
        </div>
        
    </div>
</template>

<script>
  import Vue from 'vue'
  import VeeValidate from 'vee-validate'

  Vue.use(VeeValidate);

  VeeValidate.Validator.extend('passphrase', {
   getMessage: field => 'Sorry dude, wrong pass phrase.',
   validate: value => value.toUpperCase() == 'Demogorgon'.toUpperCase()
  });
    export default {
        name: 'register',
        data () {
        return {
          email: '',
          name: '',
          password: '',
          formSubmitted: false
        }
      },
      methods: {
        validateBeforeSubmit(e) {
            this.$validator.validateAll();
            if (!this.errors.any()) {
                this.submitForm()
            }
          },
        submitForm(){
          this.formSubmitted = true
        }
      }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
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
    background-color: #CA7DE6;
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
</style>
