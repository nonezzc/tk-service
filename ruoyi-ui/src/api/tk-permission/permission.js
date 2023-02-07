import request from '@/utils/request'

// 查询tk权限列表
export function listPermission(query) {
  return request({
    url: '/tk-permission/permission/list',
    method: 'get',
    params: query
  })
}

// 查询tk权限详细
export function getPermission(shopId) {
  return request({
    url: '/tk-permission/permission/' + shopId,
    method: 'get'
  })
}

// 新增tk权限
export function addPermission(data) {
  return request({
    url: '/tk-permission/permission',
    method: 'post',
    data: data
  })
}

// 修改tk权限
export function updatePermission(data) {
  return request({
    url: '/tk-permission/permission',
    method: 'put',
    data: data
  })
}

// 删除tk权限
export function delPermission(shopId) {
  return request({
    url: '/tk-permission/permission/' + shopId,
    method: 'delete'
  })
}
