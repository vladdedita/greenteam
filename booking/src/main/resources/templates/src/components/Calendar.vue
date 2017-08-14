<template>
  <div class="calendar">
   <navigation></navigation>
   <router-view></router-view>  
    <div class="calendar-nav">
        <span class="left-btn"><icon name="angle-left" aria-hidden="true" scale="3.5"></icon>
          <h6>Prev.week</h6></span>
        <p>Date</p>
        <span><icon name="angle-right" aria-hidden="true" scale="3.5"></icon>
          <h6>Next.week</h6></span>
    </div>
    </div>
</template>

<script>
import navigation from '@/components/navigation'
import 'vue-awesome/icons/angle-right'
import 'vue-awesome/icons/angle-left'
import Icon from 'vue-awesome/components/Icon'
    export default {
      name: 'calendar',
      components: {
      navigation, Icon
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
</style>
