<#import "/utility/common.ftlh" as c>
<@c.page>
  <h1 class='text-center'>Лекции</h1>
  <div class = 'container'>
    <hr>
    <div class = 'row'>
      <form action='/lecture' method='get'>
        <input type='text' name='search'></input>
        <button type='submit' class='btn btn-secondary'>Поиск</button>
      </form>
    </div>
    <hr>
    <div class = 'row'>
      <#list lectures as lecture>
          <div class="card" style="width: 15rem;">
            <div class="card-body">
              <h5 class="card-title">${lecture.title}</h5>
              <p class="card-text">${lecture.author}</p>
              <a class = 'btn btn-sm btn-primary' href="/lecture/${lecture.id}">Читать..</a>
            </div>
          </div>
      <#else>
        <h4 class='m-2'>Для вас лекций еще нет</h4>
      </#list>
    </div>
    <hr>
    <a class='btn btn-primary' href='/lecture/create'>Создать лекцию</a>
  </div>
</@c.page>