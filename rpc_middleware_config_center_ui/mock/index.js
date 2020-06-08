//引入mockjs
import Mock from 'mockjs'
//使用mockjs模拟数据
export default Mock.mock('/api/users', options => {
  let info=JSON.parse(options.body)
  let total=50
  let pagenum=info.pagenum
  let num=(total-info.pagesize*pagenum)<0?Math.abs(total-info.pagesize*pagenum):info.pagesize   //
  console.log(num,'num')
  let pageSize=`user|${num}`    //

  let data={}
  data[pageSize]=[{
        'name': '@cname',
        // 'id|+1': 1,
        'age|0000-9999': 0,    //10-60以内的随机数，0用来确定类型
        'birthday': '@date("yyyy-MM-dd")',    //年月日
        'city': '@city(true)',    //中国城市
        // 'state':true,
        'isMale|1': true
      }]
      data.pagenum=pagenum
      data.total=total
  // console.log(data,'data')
  

  let demo=Mock.mock({
    status: 200,
    message: '获取列表成功',
    data:data
  })
  console.log(demo,'demo')
  if(info.query){
    let temp=[]
    demo.data.user.map(item=>{
      if(item.name==info.query){
        temp.push(item)
      }
    })
    demo.data.user=temp
    demo.data.total=temp.length
  }
  return demo
})
