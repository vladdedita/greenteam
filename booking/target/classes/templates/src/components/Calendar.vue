<template>
  <div class="calendar">
   <navigation></navigation>
   <router-view></router-view>  
   <div class="calendar-nav">

      <p>Date</p>

      </div>
        <div class="container">
    <table class="table table-striped">



      <tbody>
      <tr v-for="itemDay in days"><th>{{itemDay}}</th>
      <table>
        <tr v-for="item in bookings">
          <td v-if="itemDay == item.date.split(' ')[0]">{{item.serviceName}}</td>
          <td v-if="itemDay == item.date.split(' ')[0]">{{item.userName}}</td>
          <td v-if="itemDay == item.date.split(' ')[0]">{{item.date.split(" ")[1]}}:00</td>

        </tr>
      </table>

      </tr>


      </tbody>
    </table>

  </div>
    </div>
  </template>

  <script>
  import navigation from '@/components/navigation'
  import 'vue-awesome/icons/angle-right'
  import 'vue-awesome/icons/angle-left'
  import Icon from 'vue-awesome/components/Icon'
  import axios from 'axios'
  export default {
    name: 'calendar',
      data() {
        return {

            bookings:'',
            hour:'',
            day:'',
            days:[
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
            ]

        }

      },
    components: {
      navigation, Icon
    }
    ,
     mounted()
     {
         this.checkLoggedIn();
         this.getBookings();
     },
      methods:
          {
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




              },
              getBookings(){
                  axios.get(window.ApiUrl + /getbookings/ + this.$localStorage.get("cpId"))
                      .then((res) =>
                          {
                              this.bookings=res.data;

                              console.log(this.bookings);
                          }
                      ).catch((err)=> {console.log("err ",err)})
              }

          }
  }
  </script>
  <style scoped>
  .calendar-nav{
    display: inline-flex;
    margin-top: 60px;
  }
  p{
    padding: 10px 150px 0 150px;
    color: #C87CE4;
    font-size: 27px;
    font-weight: 600;

  }
  span{
    cursor: pointer;
  }
  .left-btn{
    float: left;
  }
  h6{
    color: #A1A1A1;
    font-size: 15px;
  }
  .fa-icon {
    display: inline-block;
    fill: #818181;
  }

  /*calendar*/
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
  border: 3px solid #FFF;
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
