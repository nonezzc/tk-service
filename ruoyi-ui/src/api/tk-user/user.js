import request from '@/utils/request'

// 查询tk用户列表
export function listUser(query) {
  return request({
    url: '/tk-user/user/list',
    method: 'get',
    params: query
  })
}

// 查询tk用户详细
export function getUser(id) {
  return request({
    url: '/tk-user/user/' + id,
    method: 'get'
  })
}

// 新增tk用户
export function addUser(data) {
  return request({
    url: '/tk-user/user',
    method: 'post',
    data: data
  })
}

// 修改tk用户
export function updateUser(data) {
  return request({
    url: '/tk-user/user',
    method: 'put',
    data: data
  })
}

// 删除tk用户
export function delUser(id) {
  return request({
    url: '/tk-user/user/' + id,
    method: 'delete'
  })
}
