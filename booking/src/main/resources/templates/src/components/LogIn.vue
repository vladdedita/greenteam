<template>
	<div class="logIn">
 	
		<div class="logo-side">
			<div class="logo"><img src="../assets/logo.png"/></div>
			<p class="hero-title">Booking <span class="apl">App</span></p>
		</div>
		<form @submit.prevent="validateBeforeSubmit" v-if="!formSubmitted">
          <div class="form-group" :class="{'has-error': errors.has('email') }" >
              <label class="control-label" for="email">Email address</label>
              <input v-model="email" v-validate.initial="email" data-rules="required|email" class="form-control" type="email" placeholder="email@email.com">
              <p class="text-danger" v-if="errors.has('email')">{{ errors.first('email') }}</p>
          </div>
          <div class="form-group" :class="{'has-error': errors.has('password') }">
              <label class="control-label" for="password">Password</label>
              <input v-model="password" v-validate.initial="passwords" data-rules="required|password|min:10" class="form-control" type="password">
              <p class="text-danger" v-if="errors.has('name')">{{ errors.first('name') }}</p>
          </div>
				<button class="log-in">LOGIN</button>
				<p class="stil">Recover password</p>
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
        name: 'logIn',
        data () {
        return {
          email: '',
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
</style>