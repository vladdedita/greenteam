<template>
  <div class="booking">
    <navigation></navigation>
    <router-view></router-view>
    <div class="b-select">

      <select id="ddown5" text="Service name" class="m-md-2" v-model="selected">
      <option v-for="item in options" v-bind:value="item.value">{{item.text}}</option>
    </select>
    
  </div>
  <div class="container">
    <table class="table table-striped">
      <thead>
        <tr>
          <th>Service name</th>
          <th>Customer name</th>
          <th>Email</th>
          <th>Phone No</th>
        </tr>
      </thead>

      <tbody>
      <tr v-for="booking in sortings">

        <td>{{booking.serviceName}}</td>
        <td>{{booking.userName}}</td>
        <td>{{booking.email}}</td>
        <td>{{booking.phone}}</td>
      </tr>

      </tbody>
    </table>
  </div>
</div> 
</template>

<script>
import navigation from '@/components/navigation'
import axios from 'axios'
import sortBy from 'lodash'
import orderBy from 'lodash'
export default {
  name: 'booking',
  components: {
    navigation: navigation
  },
  data() {
    return {
      selected: "serviceName",
      options: [
      {
        text: 'Service name',
        value: 'serviceName'
      },
          {
        text: 'Customer name',
        value: 'userName'
      }, {
        text: 'E-mail',
        value: 'email'
      },
      {
      text: 'Phone',
      value: 'phone'
      }],

        bookings:[],
    }
  },
  mounted()
  {

      this.checkLoggedIn();

      //setTimeout(this.checkAuth(),1000);

      this.getBookings();

  },
    computed: {
        sortings:
            function(value) {

            return _.orderBy(this.bookings,this.selected);
        }
    }
    ,
    methods:{
      getBookings(){
          axios.get(window.ApiUrl + /getbookings/ + this.$localStorage.get("cpId"))
              .then((res) =>
                  {
                      this.bookings=res.data;

                      console.log(this.bookings);
                  }
              ).catch((err)=> {console.log("err ",err)})
      },

      checkLoggedIn() {
          axios.post(window.ApiUrl + "/authorization",
              {

                  token:this.$localStorage.get('token')

              })
              .then((res) => {

                  console.log("REEESSSSS", res);
                  if(res.data == true) {

                      this.$localStorage.set('authorized', 'true');
                  }
                  else
                  {
                      this.$localStorage.set('authorized','false');
                      this.$router.push("/logIn");
                  }

              })
              .catch((err) => {
                  this.$localStorage.set('authorized','false');
                  this.$router.push("/logIn");
              })




          }

}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
tr td:first-child {
  padding-left: 200px;
}
tr td:last-child {
  padding-right: 150px;
}
tr th:first-child{
  padding-left: 200px
}
tr th:last-child{
  padding-right: 150px;
}
tbody tr:nth-child(1n) {
  background: #F9EFFB;
}
table tr:nth-child(3n) {
  background: #E7EBF7; 
}
table tr:nth-child(2n) {
  background: #FFF; 
}
.table thead th {
  border: none;
}
.table th, .table td {
  border: none;
}
.table td{
  padding: 7px;
}

th{
  color: #CD88E7;
}
.table{
  width: 100%;
  max-width: 100%;
  margin-bottom: 1rem;
  text-align: left;
}
.container{
  width: 100%;
  padding-left: 0px;
  padding-right: 0px;
}
.form-control{
  width: 20%;
  margin: auto;
}
.b-select{
  margin-left: 170px;
  text-align: left;
  margin-top: 30px;
}
.btn-secondary:active,  {
  background-color: #FFF;

}
.dropdown-item.active, .dropdown-item:active {
  color: #CD88E7;
  text-decoration: none;
  background-color: #FFF;
  cursor: pointer;
}
.m-md-2{
  margin: 1.5rem 2.5rem !important;
}
.btn:first-child{
  cursor: pointer;
}

li{
  list-style-type: none;
  display: inline;
  color: #FFF;
  text-transform: uppercase;
  cursor: pointer;
}
ul{
  background-color: #7B90E0;
  padding: 37px 20px 10px 0;
  font-size: 14px;
  text-align: right;
  word-spacing: 18px;
  margin: 0;
}
h2{
  position: absolute;
  color: #FFF;
  margin: 25px 0 10px 25px;
}
</style>
