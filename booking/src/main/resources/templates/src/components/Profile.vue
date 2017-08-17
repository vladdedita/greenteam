<template>
  <div class="profile">

    <navigation></navigation>
    <router-view></router-view>

    <div class="logo">

      <div id="form" >
        <label for="file-input">
        <img v-bind:src="companyPayload.cp_logopath" style="cursor:pointer"/>
        </label>
       <!-- <input id="file-input" style="display:none" type="file" formenctype="multipart/form-data"  v-on:change="onFileChange">
       --> <!--<input type="file" id="file-input" :name="uploadFieldName" :disabled="isSaving" @change="filesChange($event.target.name, $event.target.files); fileCount = $event.target.files.length" accept="image/*" class="input-file">
-->
        <picture-input
                id="file-input"
                ref="pictureInput"
                width="500"
                @change="onChange"
                removable="true"
                removeButtonClass="ui red button"
                height="500"
                margin="16"
                size="10"
                accept="image/jpeg, image/png, image/gif"
                buttonClass="ui button primary"
                :customStrings="{
                upload: '<h1>Upload it!</h1>',
                drag: 'Drag and drop your image here'}">

        </picture-input>
        <button v-bind:class="{disabled:!image}">Upload</button>


      </div>

    <div id="submit">Upload Image</div> 
    <div id="max">(max.140x140px)</div>
  </div>


  <div class="text">
    <form @submit.prevent="sendProfile">
      <label>Company name</label>
      <input class="input_log" type="text" name="company name" v-model="companyPayload.cp_name">

      <label>Company description</label>
      <textarea class="detail" name="description" rows="10" cols="30" v-model="companyPayload.cp_desc"/>
      <div class="space">
         <router-link to="/logIn"><button class="save" id="out" @click="logout">Sign Out</button></router-link>
        <button class="save" id="ok" @click="sendProfile">Save</button>
      </div>
    </form>



  </div>
</div>
</template>

<script>

import navigation from '@/components/navigation';
import axios from 'axios';
import PictureInput from 'vue-picture-input'

export default {
  name: 'profile',
  data() {
    // imageData: ""  // we will store base64 format of image in this string
    return {
      msg: 'profilePage',
        companyPayload: {
          cp_id:'',
          cp_name:'',
            cp_desc:'',
            cp_logopath:''
        },
      user: {
        authenticated: true
      },
    }
  },
  components: {
      PictureInput,
    navigation: navigation
  },
    mounted()
    {
        this.checkLoggedIn();
        this.getCompany();
        this.getLogo();


    },
      methods: {
          onChange () {
              console.log('New picture selected!')

              if (this.$refs.pictureInput.image) {
                  console.log('Picture loaded.')
                  this.attemptUpload(this.$refs.pictureInput.image);

              } else {
                  console.log('FileReader API not supported: use the <form>, Luke!')
              }
          },

          logout() {
          localStorage.removeItem('token');
          localStorage.removeItem('email');
          localStorage.removeItem('cpId');
          this.user.authenticated = false
      },
          getCompany() {
              axios.get(window.ApiUrl + "/companies/"+this.$localStorage.get("cpId") )
                  .then((res) => {

                  this.companyPayload.cp_id=res.data.id;
                  this.companyPayload.cp_name=res.data.name;
                  this.companyPayload.cp_desc=res.data.description;

                      console.log("companies ", res);
              })
                  .catch((err) => {
                      console.log("err", err);
                  })
          },
      sendProfile() {
          axios.post(window.ApiUrl + "/updateProfile/" + this.$localStorage.get("cpId"),
              {
                  cp_name: this.companyPayload.cp_name,
                  cp_desc: this.companyPayload.cp_desc,
                  //cp_logopath: this.companyPayload.cp_logopath

              }).then((res) => {
          }).catch((err) => {
          })
      },
          attemptUpload(image) {
              if (image){
                  axios.post(window.ApiUrl +'/uploadlogo/' + this.$localStorage.get("cpId"), {

                     file: image

                  })
                      .then(response=>{
                          if (response.data.success){

                              console.log("Image uploaded successfully ✨");
                          }
                      })
                      .catch(err=>{
                          console.error(err);
                      });
              }
          },
          getLogo()
          {
            axios.get(window.ApiUrl + "/getlogo/" +this.$localStorage.get("cpId"))
                .then((res) => {

                this.companyPayload.cp_logopath=res.data

                }).catch((err)=> {})
          },

          checkLoggedIn() {

              axios.post(window.ApiUrl + "/authorization",
                  {

                      token:this.$localStorage.get('token')

                  })
                  .then((res) => {


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

#submit{
  font-size: 20px;
  color: #484848;
  text-align: center;
  margin-top: 20px;
  margin-left: 17px;
  border: none;
  background-color: #ffffff;
  width: 225px;
}

#max{
  font-size: 17px;
  color: #a0a2a5;
  text-align: center;
  margin-left: 10px;
}
#form{
  margin: auto;
}
.logo{
  width: 19%;
  float: left;
  margin-left: 230px;
  margin-top: 9%;
}
img{
  border: none;
  width: 240px;
  height: 240px;
  border-radius: 100%;
}
.text{
  width: 22%;
  float: right;
  margin-right: 37%;
  margin-top: 9%;
}
form{
  width: 28%;
  margin: auto;
  display: grid;
}
label{
  font-size: 20px;
  color: #484848;
  text-align: left;

}
.input_log{
  width: 360px;
  height: 53px;
  border-radius: 5px;
  border: 1px solid #8A8A8A;
  margin-bottom: 25px;
}
.detail{
  width: 361px;
  height: 100px;
  border-radius: 5px;
  border: 1px solid #8A8A8A;
}
button{
  height: 55px;
  background-color: #DC2DE9;
  color: white;
  font-size: 22px;
  text-align: center;
  font-family: Arial;
  border-radius: 5px;
  border: transparent;
  margin: auto;
  padding: 10px;

}
.save{
  width: 166px;

}
#out{
  background-color: #dee1e5;
  float: left;
  margin-left: 0%;
  display: inline-block;
}
#ok{
  float: right;
  margin-right: 0%;
  display: inline-block;
}
.space{
  margin-top: 30px;
}

</style>
