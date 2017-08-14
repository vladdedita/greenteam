<template>
<div class="confirmation">

  <b-btn v-b-modal.modal1 id="save">BOOK NOW</b-btn>

  <!-- Modal Component -->
  <b-modal id="modal1" ref="my_modal1" hide-footer="true">

    <div id="client-details" v-show="step == 0">
      <div class="modal-sent">Make your booking</div>
      <div class="info">PERSONAL DETAILS</div>
 
      <form class="clearfix" @keyup.esc="clearData" @keyup.enter="nextStep">
      <div class="details float-left">
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
        <div >
              <label>Phone number</label>
              <input 
                class="register" 
                type="phone" 
                v-model="phone"
                v-on:input="$v.phone.$touch"
                v-bind:class="{error: $v.phone.$error, valid: $v.phone.$dirty && !$v.phone.$invalid}"
                placeholder="Phone number" 
                />
         </div>
      </div>
         
      <div class="details float-right">
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
      </div>   
      </form>

    </div>

    <div id="calendar" v-show="step == 1" @keyup.enter="sendBooking">

      <div class="modal-sent">Make your booking</div>
      <div class="info">BOOKING INFORMATION</div>
        
      <button 
      type="button"
      class="btn btn-secondary btn-md" 
      @click="previousStep" 
      id="back"
      >Back</button>

      <button 
      type="button" 
      class="btn btn-secondary btn-md" 
      @click="sendBooking"
      >Send booking</button>

    </div>

    <div id="conf" v-show="step == 2" @keyup.enter="hideModal">
      <div class="modal-card">
        <img src="../assets/PostalCard.png" />
      </div>
      <div class="modal-sent">Your request was sent!
      </div>
      <div class="modal-text">In a couple of seconds a confirmation email will be sent to your email address with all the details for you reservation. Thank you for using our services!
      </div>
      
      <button 
      type="button" 
      class="btn btn-secondary submit-btn btn-md" 
      >Close</button>
    </div>

  </b-modal>
</div>  
</template>

<script>
import { required, minLength, maxLength, between, numeric, email, alpha, } from 'vuelidate/lib/validators'



export default {
  name: 'confirmation',
  data() {
    return {
      step:0,
      msg: 'test',
      name: '',
      phone: '',
      email: '',
      checkSubmit: false
    }
  },
  methods: {
    hideModal() {
     this.step = 0;
     this.$root.$emit('hide::modal', 'modal1');
   },
   sendBooking() {
    //server request
    // this.nextStep();
    this.step++;

   },
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
   // checkValidation(){
   //  var invalidElements = document.getElementsByClass('error');
   //  if(invalidElements.length) {
   //    this.checkSubmit = false;
   //  } else {
    
   //  }
   // },

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
    name: {
      required,
      alpha,
    },
    phone: {
      required,
      numeric,
      minLength: minLength(10),
      maxLength: maxLength(10)
    },
    email: {
      required,
      email,
    },
  }

  
}
</script>

<style>
  .btn-disabled: {
    cursor: not-allowed;
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
  .clearfix{
    display: table;
    width: 100%;
  }
  .modal-dialog{
    width: 1100px;
    height: 650px;
    margin-left: 7%;
    margin-right: 7%;
    margin-top: 205px;
    margin-bottom: 520px;
  }
  .modal-content{
    width: 1100px;
    height: 650px;
    border: none;
    border-radius: 5px;
  }
  .modal-header{
    border-bottom: none;
  }
  .info{
    font-size: 17px;
    color: #a0a2a5;
    text-align: center;
    margin: auto;
    margin-bottom: 90px;
  }
  .details{
    display: inline-block;
    width:380px;
    height:210px;
    margin-top: 30px;
  }
  #next-button{
    margin-top: 36px;
    margin-right: 9px; 
  }
  form{
    width: 760px;
    margin: auto;
    padding-left: 130px;
    padding-right: 130px;
  }
  label{
    font-size: 20px;
    color: #484848;
    float: left;
    margin-left: 12px;
  }
  .register{
    width: 360px;
    height: 53px;
    border-radius: 5px;
    border: 1px solid #8A8A8A;
  }
  .modal-card{
    height: 130px;
    width: 255px;
    border: none;
    margin: auto;
    margin-top: 20px;
    margin-bottom: 30px;
  }
  img{
    height: 130px;
    width: 255px;
  }
  .modal-sent{
    color: #DC2DE9;
    font-size: 30px;
    text-align: center;
    font-family: Arial;
    margin-top: 20px;
  }
  .modal-text{
    font-size: 20px;
    color: #484848;
    text-align: center;
    font-family: Arial;
    padding-right: 160px;
    padding-left: 160px;
    margin-top: 35px;
    margin-bottom: 85px;
  }
  .btn-secondary{
    height: 55px;
    width: 365px;
    background-color: #DC2DE9;
    color: white;
    font-size: 22px;
    text-align: center;
    font-family: Arial;
    border-radius: 5px;
    border: transparent;
    padding: 10px;
    margin-left: 11px;
  }
  .btn-secondary:hover{
    background-color: #DC2DE9;
    color: white;
  }
  #save{
    width: 166px;
  }
  #back{
    background-color: #dee1e5;
  }
  
</style>