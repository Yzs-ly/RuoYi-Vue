import request from '@/utils/request'

// 查询数据目录列表
export function listSystem(query) {
  return request({
    url: '/yhq-dm/system/list',
    method: 'get',
    params: query
  })
}

// 查询数据目录详细
export function getSystem(code) {
  return request({
    url: '/yhq-dm/system/' + code,
    method: 'get'
  })
}

// 新增数据目录
export function addSystem(data) {
  return request({
    url: '/yhq-dm/system',
    method: 'post',
    data: data
  })
}

// 修改数据目录
export function updateSystem(data) {
  return request({
    url: '/yhq-dm/system',
    method: 'put',
    data: data
  })
}

// 删除数据目录
export function delSystem(code) {
  return request({
    url: '/yhq-dm/system/' + code,
    method: 'delete'
  })
}
