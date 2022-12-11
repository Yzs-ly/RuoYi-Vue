import request from '@/utils/request'

// 查询数据目录列表
export function listDirectory(query) {
  return request({
    url: '/yhq-dm/directory/list',
    method: 'get',
    params: query
  })
}

// 查询数据目录详细
export function getDirectory(code) {
  return request({
    url: '/yhq-dm/directory/' + code,
    method: 'get'
  })
}

// 新增数据目录
export function addDirectory(data) {
  return request({
    url: '/yhq-dm/directory',
    method: 'post',
    data: data
  })
}

// 修改数据目录
export function updateDirectory(data) {
  return request({
    url: '/yhq-dm/directory',
    method: 'put',
    data: data
  })
}

// 删除数据目录
export function delDirectory(code) {
  return request({
    url: '/yhq-dm/directory/' + code,
    method: 'delete'
  })
}
