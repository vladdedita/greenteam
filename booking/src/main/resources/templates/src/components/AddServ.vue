<template>
	<div class="addServ">
		<navigation></navigation>
    	<router-view></router-view>
		
		<div class="add-title">
			<p>Add new service</p>
		</div> 
		<div class="add-new-serv">
			<router-link to="/dashboard"><button class="newService1">+</button></router-link>
			<p class="new-serv">New service</p>
		</div>

		<div class="add-serv-details det">
			<span id="serv-detail">Service details</span>
			<div class="left-side">
				<label>Service name</label>
				<input class="register">
				<label>Service description</label>
				<textarea cols="50" class="detail"></textarea>
			</div>
			<div class=right-side>
				<label>Service duration</label>
				<input class="register">
				<label>Spaces</label>
				<input class="register">
				<label>Price</label>
				<input class="register">
			</div>

		</div>
		<div class="det-card">
			<span id="serv-detail">availability</span>
			<dateCard></dateCard>
	    <router-view></router-view>
	  </div>
	</div>
</template>


<script>
 import navigation from '@/components/navigation'
 import dateCard from '@/components/dateCard'

	export default {
	  	name: 'addServ',
	  	components: {
	    navigation,dateCard
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
			text-decoration: none;
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
	.add-title{
		margin-top: 55px;
    color: #DB2FE8;
    font-size: 25px;
    width: 40%;
    float: left;
    margin-left: 8%;
	}
	label{
			font-size: 20px;
			margin-left: 5px;
			color: #484848;
			text-align: left;
			line-height: 25px;

		}
		.register{
			width: 360px;
			height: 53px;
			border-radius: 5px;
    	border: 1px solid #8A8A8A;
    	margin-bottom: 15px;
		}
		.detail{
			width: 361px;
			height: 160px;
			border-radius: 5px;
    	border: 1px solid #8A8A8A;
    	margin-bottom: 15px;
		}
		.add-serv-details{
    	width: 60%;
    	margin-left: 21%;
		}
		.left-side{
			width: 50%;
			float: left;
			text-align: left;
		}
		.right-side{
			width: 50%;
			float: right;
			text-align: left;
		}
		
		.det{
    	padding-bottom: 43%;
		}
		#serv-detail{
			font-size: 12px;
			color: #BFBFBF;
			float: left;
			text-transform: uppercase;
			margin-right: 50%;
			padding-bottom: 20px;
		}
		.det-card{
			text-align: center;
			width: 60%;
    	margin-left: 21%;
		}
</style>