<template>
  <div>
      <ul class="page-bar" >
        <li v-if="cur>1"><a v-on:click="cur--,firstpage()">首页</a></li>
        <li v-if="cur>1"><a v-on:click="cur--,pageClick()">上一页</a></li>
    
        <li v-if="cur==1"><a class="banclick">首页</a></li>
        <li v-if="cur==1"><a class="banclick">上一页</a></li>
        <li v-for="index in indexs" v-bind:class="{ 'active': cur == index}">
          <a v-on:click="btnClick(index)">{{ index }}</a>
        </li>
        <li v-if="cur!=pageSize"><a v-on:click="cur++,pageClick()">下一页</a></li>
        <li v-if="cur!=pageSize"><a v-on:click="cur++,lastpage()">尾页</a></li>
        <li><a>共<i>{{pageSize}}</i>页</a></li>
      </ul>
  </div>
</template>