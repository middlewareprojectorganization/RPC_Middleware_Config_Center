
/* 是否是公司邮箱*/
export function isWscnEmail(str) {
  const reg = /^[a-z0-9](?:[-_.+]?[a-z0-9]+)*@wallstreetcn\.com$/i;
  return reg.test(str.trim());
}
 
/* 是否是ip*/
export function isIP(str) {
  var reg = /^((25[0-5]|2[0-4]\d|[01]?\d\d?)($|(?!\.$)\.)){4}$/

  // const reg = /^[a-z0-9](?:[-_.+]?[a-z0-9]+)*@wallstreetcn\.com$/i;
  return reg.test(str.trim());
}



/* 合法url*/
export function validateURL(textval) {
  const urlregex = /^(https?|ftp):\/\/([a-zA-Z0-9.-]+(:[a-zA-Z0-9.&%$-]+)*@)*((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]?)(\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])){3}|([a-zA-Z0-9-]+\.)*[a-zA-Z0-9-]+\.(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum|[a-zA-Z]{2}))(:[0-9]+)*(\/($|[a-zA-Z0-9.,?'\\+&%$#=~_-]+))*$/;
  return urlregex.test(textval);
}
 
// 验证是否整数
export function isInteger(rule, value, callback) {
  if (!value) {
    return callback(new Error('输入不可以为空'));
  }
  setTimeout(() => {
    if (!Number(value)) {
      callback(new Error('请输入正整数'));
    } else {
      const re = /^[0-9]*[1-9][0-9]*$/;
      const rsCheck = re.test(value);
      if (!rsCheck) {
        callback(new Error('请输入正整数'));
      } else {
        callback();
      }
    }
  }, 1000);
}
 
 
// 验证是否是[0-1]的小数
export function isDecimal(rule, value, callback) {
  if (!value) {
    return callback(new Error('输入不可以为空'));
  }
  setTimeout(() => {
    if (!Number(value)) {
      callback(new Error('请输入数字'));
    } else {
      if (value < 0 || value > 1) {
        callback(new Error('请输入[0,1]之间的数字'));
      } else {
        callback();
      }
    }
  }, 1000);
}
 
// 验证端口是否在[0,65535]之间
export function isPort(rule, value, callback) {
  if (!value) {
    return callback(new Error('输入不可以为空'));
  }
  setTimeout(() => {
    if (value == '' || typeof(value) == undefined) {
      callback(new Error('请输入端口值'));
    } else {
      /*const re = /^([0-9]|[1-9]\d|[1-9]\d{2}|[1-9]\d{3}|[1-5]\d{4}|6[0-4]\d{3}|65[0-4]\d{2}|655[0-2]\d|6553[0-5])$/;
      const rsCheck = re.test(value);
      if (!rsCheck) {
        callback(new Error('请输入在[0-65535]之间的端口值'));
      } else {
        callback();
      }*/
      if(value >= 0 && value <= 65535){
        callback();
      } else {
        callback(new Error('请输入在[0-65535]之间的端口值'));
      }
    }
  }, 1000);
}
 
/* 小写字母*/
export function validateLowerCase(str) {
  const reg = /^[a-z]+$/;
  return reg.test(str);
}

// 中文校验
export const validateContacts = (rule, value, callback) => {
 if (!value) {
 return callback(new Error('请输入中文'))
 }
 if (!/^[\u0391-\uFFE5A-Za-z]+$/.test(value)) {
 callback(new Error('不可输入特殊字符'))
 } else {
 callback()
 }
}