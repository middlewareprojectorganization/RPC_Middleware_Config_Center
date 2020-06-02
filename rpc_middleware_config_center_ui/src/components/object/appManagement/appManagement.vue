<template>
  <div>
    <d2-crud
      :columns="columns"
      :data="data"
      :rowHandle="rowHandle"
      @custom-emit-1="choose"
      @custom-emit-2="cancel"
      @custom-emit-3="detail"/>
      <children :child="child" ref='c1'></children>
      <detail :child2="child2" ref='c2'></detail>
  </div>
</template>

<script>
import children from './components/edit.vue';
import detail from './components/detail.vue';


export default {
  components: {
    children,
    detail,
  },
  data () {
    return {
      child: false,  //配置子组件状态
      child2: false,  //详情查看子组件状态
      columns: [
        {
          title: 'app名称',
          key: 'date'
        }
      ],
      data: [
        {
          date: '2016-05-02',
          status: 'false'   //当前选项是否绑定
        },
        {
          date: '2016-05-04',
          status: 'false'   

        },
        {
          date: '2016-05-01',
          status: 'true'

        },
        {
          date: '2016-05-03',
          status: 'true'
        }
      ],
      rowHandle: {
        custom: [
          {
            text: '选择配置',
            type: 'success',
            size: 'small',
            emit: 'custom-emit-1'
          },
          {
            text: '解绑',
            type: 'warning',
            size: 'small',
            emit: 'custom-emit-2'

          },
          {
            text: '查看详情',
            size: 'small',
            emit: 'custom-emit-3'
          }
        ]
      }
    }
  },
  methods: {
    choose({index,row}){
      var status = this.data[index].status;   
      console.log(this.child);

      if(status == 'true'){
        //已经绑定状态
        alert('请先解绑');
        this.child = false;
      }else{
        this.child = true;
        // alert('可');
        this.$refs.c1.show(true);
        this.data[index].status = "true";
      }

    },
    cancel({index,row}){
      var status = this.data[index].status;   
      console.log(status);
      if(status == 'true'){
        this.data[index].status = "false";
        alert('成功取消绑定');
      }else{
        alert('暂无绑定任何配置');
      }
    },
    detail({index,row}){
      this.$refs.c2.show(true);
    },
  }
}
</script>