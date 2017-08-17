<template>
	<div class="dateCard">
		
		<label for="">Start</label>
 		<input 
 			type="text" 
 			v-model="schedule.start" 
 			@input="updateSchedule()">

 		</br>

 		<label for="">End</label>
 		<input 
 			type="text" 
 			v-model="schedule.end" 
 			@input="updateSchedule()">

	</div>
</template>

<script >
	export default {
		name: 'dateCard',
		data(){
				return {  		
					schedule: {
						start: '7:00',
						end: '18:00'
					}
				}
		},
		methods: {
			updateSchedule() {
				this.$emit('input', {
					start: this.schedule.start,
					end: this.schedule.end
				})
			}
		}
  }

</script>

<style scoped>

	.dateCard{
		border: 1px solid #CCC;
    padding: 10px;
    display: grid;
    width: 95%;
    margin-bottom: 50px;
		}	
	.container{
    width: 40%;
    border: 1px solid #CCC;
  }
  .table td{
    border: none;
  }
  .radio-btn{

  }
  input[type=radio] {
    border: 0px;
    width: 100%;
    height: 1.6em;
    cursor: pointer;
  }
	.table thead th{
		border-color: #FFF;
		text-align: center;
	}
	.table th, .table td {
    padding: 0.20rem;
    vertical-align: top;
    border-top: 1px solid #eceeef;
    border:none;
}

</style>