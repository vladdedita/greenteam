<template>
	
	<ul>
		<li v-for="item in schedule">
			<label for="">{{ item }}</label>
			<input type="radio" v-model="selectedDate">
		</li>
	</ul>

</template>


<script>
	export default {
		data() {
			return {
				selectedDate: '',
				schedule: [
					1,
					2,
					3,
					4
				]
			}
		}
	}
</script>


<style scoped>
	
</style>