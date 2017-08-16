<template>
  <div class="booking">
    <navigation></navigation>
    <router-view></router-view>
    <div class="b-select">

      <b-dropdown id="ddown5" text="Service name" class="m-md-2">
      <b-dropdown-item-button v-for="item in options">{{item.text}}</b-dropdown-item-button>
    </b-dropdown>
    
  </div>
  <div class="container">
    <table class="table table-striped">
      <thead>
        <tr>
          <th>Name</th>
          <th>Email</th>
          <th>Phone No</th>
          <th>Availability</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Default</td>
          <td>def@somemail.com</td>
          <td>Defaultson</td>
          <td>sdaf</td>
        </tr>      
        <tr>
          <td>Success</td>
          <td>john@example.com</td>
          <td>Doe</td>
          <td>sad</td>
        </tr>
        <tr class="danger">
          <td>Danger</td>
          <td>mary@example.com</td>
          <td>Moe</td>
          <td></td>
        </tr>
        <tr class="info">
          <td>Info</td>
          <td>july@example.com</td>
          <td>Dooley</td>
          <td></td>
        </tr>
        <tr class="warning">
          <td>Warning</td>
          <td>bo@example.com</td>
          <td>Refs</td>
          <td></td>
        </tr>
        <tr class="active">
          <td>Active</td>
          <td>act@example.com</td>
          <td>Activeson</td>
          <td></td>
        </tr>
      </tbody>
    </table>
  </div>
</div> 
</template>

<script>
import navigation from '@/components/navigation'
export default {
  name: 'booking',
  components: {
    navigation: navigation
  },
  data() {
    return {
      selected: null,
      options: [
      {
        text: 'Select service',
        value: null
      },
      {
        text: 'This is First option',
        value: 'a'
      }, {
        text: 'Default Selected Option',
        value: 'b'
      }, {
        text: 'This is another option',
        value: 'c'
      }]   
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
