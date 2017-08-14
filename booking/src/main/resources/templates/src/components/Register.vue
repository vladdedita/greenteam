<template>
    <div class="register">
      <div class="logo"><img src="../assets/logo.png"/></div>
        <p class="hero-title">Booking <span class="apl">App</span></p>
       

        <form class="clearfix" @keyup.esc="clearData" @keyup.enter="nextStep">
        <div>
              <label>Name</label>
              <input 
                class="register" 
                type="text"
                v-model="name"
                v-on:input="$v.name.$touch"
                v-bind:class="{error: $v.name.$error, valid: $v.name.$dirty && !$v.name.$invalid}"
                placeholder="Name" 
                />

        </div>
          <div>
              <label>Email</label>
              <input 
              class="register" 
              type="email"
              v-model="email"
              v-on:input="$v.email.$touch"
              v-bind:class="{error: $v.email.$error, valid: $v.email.$dirty && !$v.email.$invalid}"
              placeholder="Email@email.com"
              />
          </div>
          <div id="next-button">
            <button 
            type="button" 
            class="btn btn-secondary btn-md" 

            @click="nextStep"
            >Next</button>
          </div> 
      </form>
    </div>
</template>

<script>
import { required, minLength, maxLength, between, numeric, email } from 'vuelidate/lib/validators'

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
      validations: {
      name: {
      required,
      minLength: minLength(10),
      maxLength: maxLength(10)
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
