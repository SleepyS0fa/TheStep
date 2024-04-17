<#import "../utility/common.ftlh" as c>
<@c.page>
  <div class='container'>
    <div class='row m-2'>
     <p>Группы</p>
     <form class='m-2' method='POST' action='/admin/create/group/'>
      <input type='text' class='form-control' id='name' name='name'></input>
      <button type='submit' class='btn btn-primary mt-2'>Создать группу</button>
      <input type="hidden" name="_csrf" value="${_csrf.token}">
     </form>
    </div>

    <div class='row m-2'>
      <p>Пользователи</p>
     <#list users as user>
      <p>${user.username} - <#list user.roles as role>${role} </#list> - ${user.email} - <a href='/admin/user/${user.id}'>перейти..</a></p>
     </#list>
    </div>

    <div class='row m-2'>
      <p>Еще..</p>

    </div>
  </div>
</@c.page>