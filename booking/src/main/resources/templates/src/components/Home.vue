<template>
	<div class="home">
		<div class="navigations-company">
      <nav>
        <h2 id="nav-logo">Booking App</h2>
        <ul class="nav-comp">
          <li class="nav-comp-item">
            <router-link to="/home" exact-active-class="active">Companies</router-link>
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
		<div class="company-container">
			<p id="companies-title">Companies List</p>
			<b-card no-block v-for="company in companies">
			<div class="row">
				<div class="col-sm-6 text-left">
					<h2 class="card-title">{{company.name}}</h2>
				</div>
				
			</div>

			<div class="card-block">
				<p class="card-text">
					{{company.body}}
				</p>
			</div>
			<small slot="footer">
				
				<button id="select-company" @click="selectCompany(company)">Select Company</button>
			</small>
		</b-card>
</div>
</div>
</template>

<script>

import axios from 'axios'

export default {
	name: 'home',
	data() {
		return {
			companies: '',
			selectedCompany: ''
			
		}
	},
	mounted() {
      //this.getCompanies();
      this.getComments();
    },
    methods: {
   
    	getCompanies() {
    		axios.get(window.ApiUrl + "/companies").then((res) => {
    			this.companies = res.data;
    			console.log("companies ", res);
    		})
    		.catch((err) => {
    			console.log("err", err);
    		})
    	},
    	getComments() {
    		axios.get(window.ApiUrlTest + "/posts/1/comments").then((res) => {
    			this.companies = res.data;
    			console.log("companies ", res);
    		})
    		.catch((err) => {
    			console.log("err", err);
    		})
    	},
    	selectCompany(company) {
    		this.selectedCompany = company;
    	},
    		
		}

		
	}
	</script>

	<style>

	.card {
		margin-bottom: 20px;
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
	
	#select-company{
		width: 200px;
		float: right;
	}

	button{
		height: 55px;
		background-color: #DC2DE9 ;
		color: white;
		font-size: 22px;
		text-align: center;
		font-family: Arial;
		display: block;
		border-radius: 5px;
		border: transparent;
		margin: auto;
		padding: 10px;

	}
	.save{
		width: 166px;
		float: left;
		margin: 15px 0 0 10px;
	}
	#companies-title{
		font-size: 35px;
		color: #DC2DE9;
		text-align: center;
		font-weight: bold;
	}
	
	/*Card*/
	.company-container{
		margin-top: 60px;
		width: 50%;
		margin-left: 25%;
	}
	/*Navigation*/
	.active-comp {
    font-weight: bold;
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

  a{
    color: #FFF;
  }
  a:hover{
    text-decoration: none;
		color:#fff;
  }
	</style>

	