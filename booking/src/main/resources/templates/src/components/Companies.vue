<template>
	<div class="companies">
		<div class="company-details">
			<div id='img-logo'>
				<img id="logo-comp" src="../assets/default-logo.png" alt="logo-company"/>
			</div>
			<div class="details-comp">
				<p class="add-title">Title</p>
				<p class='add-details'>Details</p>
			</div>
		</div>

		<div class="container">
			<b-card no-block>
				<div class="row">
					<div class="col-sm-6 text-left">
						<h2 class="card-title">title</h2>
					</div>
					<div class="col-sm-6 text-right">
						<icon class="icon-card" name="pencil" scale="2"></icon>
						<icon class="icon-card" name="trash" scale="2"></icon>
					</div>
				</div>

				<div class="card-block">
					<p class="card-text">
						Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quae pariatur ducimus illo temporibus, consequatur vitae iusto, ipsa dolor vero. Non ratione natus atque quisquam quam architecto, deserunt minus quibusdam odio.
					</p>
				</div>
				<small slot="footer">
					<table>
						<tr class="tab-details">
							<td class="td-details"></td>
							<td class="td-details"></td>
							<td class="td-details"></td>
							<td class="td-details"></td>
						</tr>
						<tr class="tdata">
							<td class="td-details">Availability</td>
							<td class="td-details">Spaces</td>
							<td class="td-details">Duration</td>
							<td class="td-details">Price</td>
						</tr>
					</table>
					<b-btn v-b-modal.modal1 id="save">BOOK NOW</b-btn>
					<b-modal id="modal1" ref="my_modal1" hide-footer>
						<div id="client-details" v-show="step == 0">
							<p class="modal-sent">Make your booking</p>
							<p class="info">PERSONAL DETAILS</p>
							<form class="clearfix" @keyup.esc="clearData" @keyup.enter="nextStep">
								<div class="details float-left">
									<label>Name</label>
									<input 
									class="register" 
									type="text"
									v-model="name"
									v-on:input="$v.name.$touch"
									v-bind:class="{error: $v.name.$error, valid: $v.name.$dirty && !$v.name.$invalid}"
									placeholder="Name" 
									/>
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

								<div class="details float-right">
									<label>Email</label>
									<input 
									class="register" 
									type="email"
									v-model="email"
									v-on:input="$v.email.$touch"
									v-bind:class="{error: $v.email.$error, valid: $v.email.$dirty && !$v.email.$invalid}"
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
						<div id="calendar" v-show="step == 1" @keyup.esc="clearData" @keyup.enter="sendBooking">
							<p class="modal-sent">Make your booking</p>
							<p class="info">BOOKING INFORMATION</p>
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

						<div id="conf" v-show="step == 2" @keyup.enter="hideModal">
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
				</small>
			</b-card>
		</div>
	</div>
</template>

<script>
	import { required, minLength, maxLength, between, numeric, email, alpha, } from 'vuelidate/lib/validators'

	export default {
		name: 'companies',
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
				this.clearData();
			},
			sendBooking() {
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
	.company-details{
		width: 70%;
		margin-left: 20%;
		display: flex;
		margin-top: 65px;
	}
	.logo-comp{
		width: 170px;
		height: 170px;
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

	}
	.save{
		width: 166px;
		float: left;
		margin: 15px 0 0 10px;
	}
	.close{
		float:right;
	}


	/*Card*/
	.container{
		margin-top: 60px;
		width: 50%;
	}
</style>