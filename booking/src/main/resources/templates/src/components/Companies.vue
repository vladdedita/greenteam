<template>
	<div class="companies">
		<div class="company-details">
			<div id='img-logo'><img id="logo-comp" src="../assets/default-logo.png" alt="logo-company"/></div>
			<div class="details-comp">
				 <p class="add-title">{{companies[0].name}}</p>
				 <div class='add-details'>{{companies[0].description}}</div>
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
       		<router-link to="/confirmation"><b-btn v-b-modal.modal1 id="save">BOOK NOW</b-btn></router-link>
     		</small>
  		</b-card>
		</div>





</div>
</template>

<script>
 
	import 'vue-awesome/icons/pencil'
 	import 'vue-awesome/icons/trash'
 	import Icon from 'vue-awesome/components/Icon'
 	import axios from 'axios'
	
	export default {
  	name: 'companies',
  	data() {
  		return {
  			companies: '',
  			services: ''
  		}
  	},
   	components: {
     Icon:Icon
  	},
  	mounted() {
  		this.getCompanies();
  	},
  	methods: {
  		getCompanies() {
  			axios.get(window.ApiUrl + "companies").then((res) => {
  				this.companies = res.data;
  				//this.getServices();
  				console.log("companies ", res);
  			})
  			.catch((err) => {
  				console.log("err", err);
  			})
  		},
  		getServices() {
  			axios.get(window.ApiUrl + "services").then((res) => {
  				this.services = res.data;
  				console.log("services ", res);
  			})
  			.catch((err) => {
  				console.log("err", err);
  			})
  		}
  	}
  	
}
</script>
<style scoped>
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
    color: #DB2FE8;
    font-size: 25px;
    float: left;
	}
	#img-logo{
		width: 30%;
	}
	.add-details{
		display: inline-table;
		text-align: left;
    color: #BABABA;
    font-size: 15px;
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
</style>