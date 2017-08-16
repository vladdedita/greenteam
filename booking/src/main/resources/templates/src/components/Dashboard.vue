<template>
	<div class="dashboard">
		<navigation></navigation>
    	<router-view></router-view>
		
		<!-- <div class="add-title">
			<p>Add new service</p>
		</div> -->
		<div class="add-new-serv">
			 <router-link to="/addServ">
			 		<span>
						<icon class="icon-card circle" name="plus-circle" scale="5">
						</icon>
					</span>
				</router-link>
			<p class="new-serv">New service</p>
		</div>

		<div class="container">
			<b-card no-block v-for="service in services">
				<div class="row">
					<div class="col-sm-6 text-left">
						<h2 class="card-title">{{service.name}}</h2>
					</div>
					<div class="col-sm-6 text-right">

						<router-link to="/addServ">
						<span>
							<icon class="icon-card" name="pencil" scale="2"></icon>
						</span>
						</router-link>
						<span @click="deleteService(service.id)">
							<icon class="icon-card" name="trash" scale="2"></icon>
						</span>
					</div>
				</div>

        <div class="card-block">
          <p class="card-text">{{service.body}}
          </p>
        </div>
    		<small slot="footer">
       		<table>
       			<tr class="tab-details">
       				<td class="td-details">{{service.id}}</td>
       				<td class="td-details">{{service.postId}}</td>
       				<td class="td-details">{{service.email}}</td>
       				<td class="td-details"></td>
       			</tr>
       			<tr class="tdata">
       				<td class="td-details">Availability</td>
       				<td class="td-details">Spaces</td>
       				<td class="td-details">Duration</td>
       				<td class="td-details">Price</td>
       			</tr>
       		</table>
     		</small>
  		</b-card>
		</div>
	</div>
</template>

<script>
 import navigation from '@/components/navigation'
 import 'vue-awesome/icons/pencil'
 import 'vue-awesome/icons/trash'
 import 'vue-awesome/icons/plus-circle'
 import Icon from 'vue-awesome/components/Icon'
 import axios from 'axios'

	export default {
	  name: 'dashboard',
	  data() {
			return {
				services: '',
				selectedService: ''
			}
		},
	  components: {
    navigation, Icon
  },
  mounted() {
  	// this.checkLoggedIn();
      //this.getCompanies();
      this.getComments();
    },
  methods: {
  	// checkLoggedIn() {
          
  	// 	if(!this.$localStorage.get('token')) {
  	// 		this.$router.push('/logIn')
  	// 	}
  	// },
  	getServices() {
    		axios.get(window.ApiUrl + "/services").then((res) => {
    			this.services = res.data;
    			console.log("services ", res);
    		})
    		.catch((err) => {
    			console.log("err", err);
    		})
    	},
    	getComments() {
    		axios.get(window.ApiUrlTest + "/posts/1/comments").then((res) => {
    			this.services = res.data;
    			console.log("services ", res);
    		})
    		.catch((err) => {
    			console.log("err", err);
    		})
    	},
    	selectService(service) {
    		this.selectedService = service;
    	},
    	deleteService(id) {
				// + axios call - delete method
				this.services.splice(this.services.indexOf(this.services.find((item) => {
					return item.id === id
				})), 1);
			},
  }

	}
</script>
<style scoped>
	.card {
		margin-bottom: 20px;
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
	}
	
	a:hover{
	text-decoration: none;
	}
	a:focus{
		text-decoration: none;
	}
	.new-serv{
		font-size: 17px;
		color: #4C4C4C;

	}
	.add-new-serv{
		margin-top: 45px;
    width: 20%;
    float: right;
    margin-right: 22%;

	}


	/*.add-title{
		margin-top: 55px;
    color: #DB2FE8;
    font-size: 25px;
    width: 40%;
    float: left;
    margin-left: 10%;
	}*/


	/*Card*/
	.container{
		  margin-top: 15%;
    	width: 50%;
	}
	.circle{
		margin-left: 20px;
		color: #DC2DE9;
	}
	.icon-card{
		cursor: pointer;
	}
</style>