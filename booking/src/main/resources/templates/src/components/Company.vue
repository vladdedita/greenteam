<template>
	<div class="company">
		<div class="navigations-company">
      <nav>
        <h2 id="nav-logo">Booking App</h2>
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
		<div class="company-details">
			<div id='img-logo'>
				<img id="logo-comp" :src="companyPayload.cp_logopath" style="width:140px; height:140px;" alt="logo-company"/>
			</div>
			<div class="details-comp">
				<p class="add-title">{{companyPayload.companies.name}}</p>
				<p class='add-details'>{{companyPayload.companies.description}}</p>
			</div>
		</div>

		<div class="container">

			<b-card no-block v-for="service in companyPayload.services">
			<div class="row">
				<div class="col-sm-6 text-left">
					<h2 class="card-title">{{service.name}}</h2>
				</div>
				<div class="col-sm-6 text-right">
				</div>
			</div>

			<div class="card-block">
				<p class="card-text">
					{{service.description}}
				</p>
			</div>
			<small slot="footer">
				<table>
					<tr class="tab-details">
						<td class="td-details">{{service.available}}</td>
						<td class="td-details">{{service.places}}</td>
						<td class="td-details">{{service.duration}}</td>
						<td class="td-details">{{service.price}}</td>
					</tr>
					<tr class="tdata">
						<td class="td-details">Availability</td>
						<td class="td-details">Spaces</td>
						<td class="td-details">Duration</td>
						<td class="td-details">Price</td>
					</tr>
				</table>
				<b-btn v-b-modal.modal1 id="save" @click="selectService(service)">BOOK NOW</b-btn>
			</small>
		</b-card>
		
		<b-modal id="modal1" ref="my_modal1" hide-footer>
		<div id="client-details" v-show="companyPayload.step == 0">
			<p class="modal-sent">Make your booking</p>
			<p class="info">PERSONAL DETAILS</p>
			<form class="clearfix" @keyup.esc="clearData" @keyup.enter="nextStep">
				<div class="details float-left">
					<label>Name</label>
					<input 
					class="register" 
					type="text"
					v-model="bookingPayload.name"
					v-on:input="$v.bookingPayload.name.$touch"
					v-bind:class="{error: $v.bookingPayload.name.$error, valid: $v.bookingPayload.name.$dirty && !$v.bookingPayload.name.$invalid}"
					placeholder="Name" 
					/>
					<label>Phone number</label>
					<input 
					class="register" 
					type="phone" 
					v-model="bookingPayload.phone"
					v-on:input="$v.bookingPayload.phone.$touch"
					v-bind:class="{error: $v.bookingPayload.phone.$error, valid: $v.bookingPayload.phone.$dirty && !$v.bookingPayload.phone.$invalid}"
					placeholder="Phone number" 
					/>
					<label>Places</label>
					<input
					class="register"
					type="text"
					v-model="bookingPayload.places"

					v-on:input="$v.bookingPayload.places.$touch"
					v-bind:class="{error: $v.bookingPayload.places.$error, valid: $v.bookingPayload.places.$dirty && !$v.bookingPayload.places.$invalid}"

					placeholder="Places"
					/>
				</div>

				<div class="details float-right">
					<label>Email</label>
					<input 
					class="register" 
					type="email"
					v-model="bookingPayload.email"
					v-on:input="$v.bookingPayload.email.$touch"
					v-bind:class="{error: $v.bookingPayload.email.$error, valid: $v.bookingPayload.email.$dirty && !$v.bookingPayload.email.$invalid}"
					placeholder="Email@email.com"
					/>
					<div id="next-button">
						<button 
						type="button" 
						class="btn btn-secondary btn-md" 
						@click="nextStep">Next
					</button>
				</div>
			</div>   
		</form>
	</div>
	<div id="calendar" v-show="companyPayload.step == 1" @keyup.esc="clearData" @keyup.enter="sendBooking">
		<p class="modal-sent">Make your booking</p>
		<p class="info">BOOKING INFORMATION</p>
		<public-booking-schedule></public-booking-schedule>
		<router-view></router-view>
		<button 
		type="button"
		class="btn btn-secondary btn-md" 
		@click="previousStep" 
		id="back">Back
	</button>
	<button 
	type="button" 
	class="btn btn-secondary btn-md" 
	@click="sendBooking">Send booking
</button>
</div>

<div id="conf" v-show="companyPayload.step == 2" @keyup.enter="hideModal">
	<div class="modal-card">
		<img class="send-img" src="../assets/PostalCard.png" />
	</div>
	<p class="modal-sent">Your request was sent!
	</p>
	<p class="modal-text">In a couple of seconds a confirmation email will be sent to your email address with all the details for you reservation. Thank you for using our services!
	</p>
	<button 
	type="button" 
	class="btn btn-secondary submit-btn btn-md" 
	@click="hideModal">Close
</button>
</div>
</b-modal>
</div>
</div>
</template>

<script>
import { required, minLength, maxLength, between, numeric, email, alpha, } from 'vuelidate/lib/validators'
import 'vue-awesome/icons/pencil'
import 'vue-awesome/icons/trash'
import Icon from 'vue-awesome/components/Icon'
import PublicBookingSchedule from '@/components/PublicBookingSchedule'
import axios from 'axios'

export default {
	name: 'company',
	data() {
		return {
			companyPayload: {
				companies: '',
				services: [],
				selectedService: '',
				step: 0,
				name: '',
				phone: '',
				email: '',
				places: '',
				checkSubmit: false,
				cp_logopath:''


			},

			bookingPayload: {
				name: '',
				email: '',
				places: '',
				phone: '',

				props: {
					name: {
						required: true,
						minLength: minLength(2),
						maxLength: maxLength(30)
					},
					email: {
						required,
						email
					},
					phone: {
						required,
						numeric,
						minLength: minLength(10),
						maxLength: maxLength(10)
					},
					places: {
						required,
						numeric,
						minLength: minLength(1),
						maxLength: maxLength(10)
					}
				}
			}

		}


	},
	components: {
		Icon: Icon,
		PublicBookingSchedule
	},
	
    components: {
        Icon: Icon
    },
    mounted() {
        this.getServices();
        this.getCompany();
        this.getLogo();
    },
    methods: {
        getCompany() {
            axios.get(window.ApiUrl + "/companies/"+this.$localStorage.get("cpId")).then((res) => {
                this.companyPayload.companies = res.data;
                console.log("companies ", res);
            })
                .catch((err) => {
                    console.log("err", err);
                })
        },
        getLogo()
        {
            axios.get(window.ApiUrl + "/getlogo/" +this.$localStorage.get("cpId"))
                .then((res) => {

                    this.companyPayload.cp_logopath=res.data

                }).catch((err)=> {})
        },

        getServices() {
            axios.get(window.ApiUrl + "/services/" + this.$localStorage.get("cpId")).then((res) => {
                this.companyPayload.services = res.data;
                console.log("services ", res);
            })
                .catch((err) => {
                    console.log("err", err);
                })
        },
        getComments() {
            axios.get(window.ApiUrlTest + "/posts/1/comments").then((res) => {
                this.companyPayload.services = res.data;
                console.log("services ", res);
            })
                .catch((err) => {
                    console.log("err", err);
                })
        },
        selectService(service) {
            this.companyPayload.selectedService = service;
        },
        deleteService(id) {
            // + axios call - delete method
            this.companyService.services.splice(this.companyService.services.indexOf(this.companyService.services.find((item) => {
            	return item.id === id
            })), 1);
          },

          hideModal() {
          	this.companyPayload.step = 0;
          	this.$root.$emit('hide::modal', 'modal1');
          	this.clearData();
          },
          sendBooking() {

            //axios.post(window.ApiUrl + "/addbooking", {id_service:13,date:'111',places:10})
            this.companyPayload.step++;


            this.addBooking();
            this.clearData();


          },
          addBooking(){
          	axios.post(window.ApiUrl + "/addbooking", {

          		Booking: {
          			id_service: 13,
          			date: '111',
          			places: 11
          		},
          		User: {
          			name: this.bookingPayload.name,
          			email: this.bookingPayload.email,
          			phone: this.bookingPayload.phone
          		}

          	}

          	).then( (res)=>{

          	}).catch((err) => {})

          },


		/*

		addService() {
			axios.post(window.ApiUrl + "/addservice", {
				name:this.userPayload.name,
				duration: this.userPayload.duration,
				description:this.userPayload.description,
				places: this.userPayload.places,
				price: this.userPayload.price,
				idCompany: 1
			}).then((res) => {
			    this.submitForm=true;
				// redirect
			})
			.catch((err) => {
				// ii spui ca e prost si nu stie sa salveze un serviciu
			})
		}

		*/



		nextStep() {
			if (this.checkValidation()) {
				this.companyPayload.step++;
			}
			else {
				debugger;
				alert('You must provide valid information!')
			}
		},
		previousStep() {
			if (this.companyPayload.step > 0) {
				this.companyPayload.step--;
			}
		},

		checkValidation() {
			var validElements = document.getElementsByClassName('valid');
			if (validElements.length === 4) {
				return true;
			}
			return false;
		},
		clearData() {
			this.bookingPayload.name = '';
			this.bookingPayload.phone = '';
			this.bookingPayload.email = '';
			this.bookingPayload.places = '';
		}
	},

	validations: {

		bookingPayload: {
			name: {
				required: true,
				minLength: minLength(2),
				maxLength: maxLength(30)
			},
			phone: {
				required,
				numeric,
				minLength: minLength(10),
				maxLength: maxLength(10)
			},
			email: {
				required,
				email
			},
			places: {
				required,
				numeric,
				minLength: minLength(1),
				maxLength: maxLength(10)
			}
		}
	}
}
</script>

<style>

.card {
	margin-bottom: 20px;
}
.btn-disabled:{
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
	height: 660px;
	border: none;
	border-radius: 5px;
}
.modal-header{
	border-bottom: none;
	width: 193%;
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
/*Modal form*/
.modal-card{
	height: 130px;
	width: 255px;
	border: none;
	margin: auto;
	margin-top: 20px;
	margin-bottom: 30px;
}
.send-img{
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
.close{
	float:right;
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
	float:left;
}
.btn-secondary:hover{
	background-color: #DC2DE9;
	color: white;
}
.submit-btn{
	margin-left: 33%;
}
#save{
	width: 166px;
	margin:25px 0 0 15px;
}
#back{
	background-color: #dee1e5;
	margin-left: 15%;
}
/*Company details*/
.company-details{
	width: 70%;
	margin-left: 20%;
	display: flex;
	margin-top: 65px;
}
#logo-comp{
	width: 170px;
	height: 170px;
	border-radius: 100%;
	float: left;
}
.details-comp{
	width: 50%;
	margin-top: 35px;
}
.add-title{
	color: #DB2FE8 ;
	font-size: 25px;
	float: left;
}
#img-logo{
	width: 30%;

}
.add-details{
	display: inline-table;
	text-align: left;
	color: #BABABA ;
	font-size: 15px;
}
button{
	height: 55px;
	background-color: #DC2DE9 ;
	color: white;
	font-size: 22px;
	text-align: center;
	font-family: Arial;
	display: block;
	border-radius: 4%;
	border: transparent;
	margin: auto;
	padding: 10px;
	cursor: pointer;
}
.save{
	width: 166px;
	float: left;
	margin: 15px 0 0 10px;
}

/*Card*/
.container{
	margin-top: 60px;
	width: 50%;
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