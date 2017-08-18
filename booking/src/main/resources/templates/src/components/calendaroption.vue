<template>
	<div class="calendaroption">
		<div class="b-select">

      <b-dropdown id="ddown5" text="Select day" class="m-md-2">
      <b-dropdown-item-button v-for="item in days">{{item.text}}</b-dropdown-item-button>
    </b-dropdown>
	

		</div>
		<div class="b-select">

      <b-dropdown id="ddown5" text="Select time" class="m-md-2">
      <b-dropdown-item-button v-for="item in hours">{{item.text}}</b-dropdown-item-button>
    </b-dropdown>
		</div>
	</div>
</template>


<script>
	export default {
		name: 'calendaroption',
		data() {
			return {
				days: [
      {
        text: 'Monday',
        value: '0'
      },
      {
        text: 'Tuesday',
        value: '1'
      }, {
        text: 'Wednesday',
        value: '2'
      }, {
        text: 'Thursday',
        value: '3'
      },
      {
        text: 'Friday',
        value: '4'
      },
      {
        text: 'Saturday',
        value: '5'
      },{
        text: 'Sunday',
        value: '6'
      }],
      	hours:[
      	{
      		text: '07:00',
      		value: '7' 
      	},
      	{
      		text: '08:00',
      		value: '8' 
      	},
      	{
      		text: '09:00',
      		value: '9' 
      	},
      	{
      		text: '10:00',
      		value: '10' 
      	},
      	{
      		text: '11:00',
      		value: '11' 
      	},
      	{
      		text: '12:00',
      		value: '12' 
      	},

      	{
      		text: '13:00',
      		value: '13'
      	},
      	{
      		text: '14:00',
      		value: '14'
      	},
      	{
      		text: '15:00',
      		value: '15'
      	},
      	{
      		text: '16:00',
      		value: '16' 
      	},
      	{
      		text: '17:00',
      		value: '17' 
      	},
      	{
      		text: '18:00',
      		value: '18' 
      	},
      	]
			}
		}
	}
</script>


<style scoped>
	.calendaroption{
		display: inline-flex;
	}
	.dropdown-item.active, .dropdown-item:active {
  color: #CD88E7;
  text-decoration: none;
  background-color: #FFF;
  cursor: pointer;
}
</style>