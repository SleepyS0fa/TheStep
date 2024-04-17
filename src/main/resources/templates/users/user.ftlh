<#import "../utility/common.ftlh" as c>
<@c.page>
  <div>
  </div>
  <div class="container">
    <div class = "row">
      <div class="col-4">
        <img class="rounded-cycle p-2" height="100px" margin="100px" src="/img/account-icon.jpg">
      </div>
      <div class="col">
        <p>${user.username} - <a>Изменить</a></p>
        <p>${user.email} - <a>Изменить</a></p>
        <p><a>Изменить пароль</a></p>
      </div>
    </div>

    <#if lectures??>
      <p class="h4">Мои лекции</p>
      <#list lectures as lecture>
        <div class="card" style="width: 15rem;">
          <div class="card-body d-flex flex-column justify-content-between">
            <h5 class="card-title">${lecture.title}</h5>
            <div class="row">
              <a class = "btn btn-sm btn-primary mb-1" href="/lecture/${lecture.id}/edit">Редактировать</a>
              <form method="post" action="/me/lecture/delete">
                <input type ="hidden" name="id" value="${lecture.id}"></input>
                <input class="btn btn-danger m-1" type="submit" value="Удалить"></input>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
              </form>
            </div>
          </div>
        </div>
      </#list>
    </#if>

  </div>
  <script src="/js/validForm/regist.js"></script>
</@c.page>