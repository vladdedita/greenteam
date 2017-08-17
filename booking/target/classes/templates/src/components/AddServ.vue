<template>
	<div class="addServ">
		<navigation></navigation>
		<router-view></router-view>

		<form id="addservform">


		<div class="add-title">
			<p>Add new service</p>
		</div> 
		<button 
			type="button"
			class="add-new-serv" 
			@click="addService">
			<span>
				<icon class="icon-card circle" name="floppy-o" scale="3.5">
				</icon>
			</span>

		</br>

		<span class="new-serv">Save changes</span>
		</button>

		<div class="add-serv-details det">
			<span id="serv-detail">Service details</span>
			<div class="left-side">
				<label>Service name</label>


				<input class="register"
				v-model="service.name">


				<label>Service description</label>
				<textarea cols="50" class="detail" v-model="service.description">{{service.description}}</textarea>

			</div>
			<div class=right-side>
				<label>Service duration</label>
				<input class="register" v-model="service.duration">


				<label>Spaces</label>
				<input class="register" v-model="service.places">
				<label>Price</label>
				<input class="register" v-model="service.price" >
			</div>

		</div>

		</form>



		<div class="det-card">
			<span id="serv-detail">availability</span>
			<dateCard v-model="schedule"></dateCard>
			<router-view></router-view>
		</div>
	</div>
</template>


<script>
import navigation from '@/components/navigation'
import dateCard from '@/components/dateCard'
import 'vue-awesome/icons/floppy-o'
import Icon from 'vue-awesome/components/Icon'
import axios from 'axios'

export default {
	name: 'addServ',
	components: {
		navigation,dateCard, Icon
	},
	data(){

		return {
		    service: {

                name: '',
                duration: '',
                description: '',
                places: '',
                price: '',
                idCompany:this.$localStorage.get("cpId"),
                //schedule: {}
            },
            schedule: {
				start: '7:00',
				end: '18:00'
			},

            formSubmitted: false
		}
	},
	mounted()
	{
	    if(window.service) {
            this.service = window.service
        }

	},

	methods: {
		addService() {
			//this.service.schedule = this.schedule;

			if(window.service) {
                axios.put(window.ApiUrl + "/editservice/" + window.service.id, this.service)
                    .then((res) => {
                        this.$router.push({name: 'Dashboard'})
                        this.submitForm = true;
                        window.service=null;
                    })
                    .catch((err) => {
                    })



            }
			else {
                axios.post(window.ApiUrl + "/addservice", this.service)
                    .then((res) => {
                        this.$router.push({name: 'Dashboard'})
                        this.submitForm = true;
                    })
                    .catch((err) => {
                    })
            }
		}
	}
}
</script>
<style scoped>
a:hover{
	text-decoration: none;
}
a:focus{
	text-decoration: none;
}
.new-serv{
	font-size: 17px;
	color: #4C4C4C;
	margin-right: 25px;

}
.add-new-serv{
	margin-top: 45px;
	width: 20%;
	float: right;
	margin-right: 15%;
	    background: #FFF;
    border: none;
    cursor: pointer;

}
.add-title{
	margin-top: 55px;
	color: #DB2FE8;
	font-size: 25px;
	width: 40%;
	float: left;
	margin-left: 8%;
	height: 90px;
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
	height: 155px;
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
.circle{
	margin-right: 25px;
	color: #DC2DE9;
}
</style>