<template>
	<div class="dashboard">
		<navigation></navigation>
    	<router-view></router-view>
		
		<!-- <div class="add-title">
			<p>Add new service</p>
		</div> -->
		<div class="add-new-serv">
			 <router-link to="/addServ"><button class="newService1">+</button></router-link>
			<p class="new-serv">New service</p>
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
     		</small>
  		</b-card>
		</div>
	</div>
</template>

<script>
 import navigation from '@/components/navigation'
 import 'vue-awesome/icons/pencil'
 import 'vue-awesome/icons/trash'
 import Icon from 'vue-awesome/components/Icon'

export default {
	name: 'dashboard',
	data() {

	},
	components: {
    	navigation, Icon
 	},
 	methods: {
 		
 	}
}
</script>
<style scoped>
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
	.newService1{
			height: 82px;
			width: 82px;
			border-radius: 100%;
			font-family: Courier;
			font-size: 55px;
			cursor: pointer;
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


</style>