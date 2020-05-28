<!-- <template>
	<div>
		<h1>测试专用</h1>
	</div>
</template>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
<script>
	export default{
		data(){
			return {
				lisg:[],
			}
		}, 
		created(){
			this.$http('/machine/page').then((res) => {
				console.log(res);
			})
		}
	}
</script> -->


<template>
	<div>
		<!-- 表单组件 -->
		<TabTable></TabTable>
	</div>
</template>

<script>
  import TabTable from '@/components/TabTableBlock/TabTable'
    export default {
    	data(){
    		return{

    		}
    	},
	    components: {
        	TabTable
        },
    }

</script>