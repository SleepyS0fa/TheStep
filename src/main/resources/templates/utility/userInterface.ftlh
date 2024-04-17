<#import "common.ftlh" as c>
<@c.page>

<div class="container">
  <div class='row'>
    <div class='col-6'>
      <p>Аккаунт: ${user.username}</p>
    </div>
    <div class='col-6'>
      <p>${user.email}</p>
    </div>
    <div class='col-6'>
      <p>${user.dateOfCreate}</p>
    </div>
  </div>
  <div>
    <form class="form" method="post" action="/admin/user/${user.id}/changeEmail">
      <input type="hidden" name="id" value="${user.id}">
      <label>Изменить почту</label>
      <input class="form-input" type="email" name="email">
      <button class="btn btn-primary" type="submit">Изменить</button>
      <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>

    <form class="form" method="post" action="/admin/user/${user.id}/addRole">
      <input type="hidden" name="id" value="${user.id}">
        <label>Добавить роль</label>
        <select multiple id="roles" name="roles" class='form-select'>
          <#list roles as role>
            <option value='${role}'>${role}</option>
          </#list>
        </select>
        <button class="btn btn-primary" type="submit">Добавить</button>
      <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>

    <form class="form" method="post" action="/admin/user/${user.id}/changePassword">
      <input type="hidden" name="id" value="${user.id}">
      <label>Изменить пароль</label>
      <input class="form-input" type="password" name="password">
      <button class="btn btn-primary" type="submit">Изменить</button>
      <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.full.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/i18n/ru.js"></script>
<script>
  $( '#roles' ).select2( {
      language: "ru",
      theme: "bootstrap-5",
      width: $( this ).data( 'width' ) ? $( this ).data( 'width' ) : $( this ).hasClass( 'w-100' ) ? '100%' : 'style',
      placeholder: $( this ).data( 'placeholder' ),
      closeOnSelect: true,
  } );
</script>
</@c.page>