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
        'id|+1': 1000,
        'age|0000-65535': 0,    //0用来确定类型
        'birthday': '@date("yyyy-MM-dd")',    //年月日
        'city': '@city(true)',    //中国城市
        // 'state':true,
        'ip':'@ip',
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
  //ip正则
  // var pattern = /^((25[0-5]|2[0-4]\d|[01]?\d\d?)($|(?!\.$)\.)){4}$/
  // pattern.exec(info.query)
  if(info.query && info.query2){     //是否有内容及校验是否为合法ip
    let temp=[]
    console.log("输入"+info.query+":"+info.query2)

    demo.data.user.map(item=>{
      console.log(item.ip+":"+item.age)
      if(item.ip == info.query && item.age == info.query){
        temp.push(item)
      }
    })
    demo.data.user=temp
    demo.data.total=temp.length
  }
  return demo
})
