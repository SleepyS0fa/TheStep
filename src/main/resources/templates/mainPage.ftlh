<#import "macro/common.ftlh" as c>
<@c.page>
<h1>Лекции</h1>
<hr>
<div class = 'container'>
  <div class = 'col'>
    <div class = 'row'>
      <#list lectures as lecture>
        <div class="card" style="width: 15rem;">
          <div class="card-body">
            <h5 class="card-title">${lecture.title}</h5>
              <p class="card-text">${lecture.author}</p>
              <a class = 'btn btn-sm btn-primary' href="/lecture/${lecture.id}">Читать..</a>
          </div>
        </div>
      </#list>
    </div>
  </div>
</div>
<hr>
<a class='btn btn-primary' href='/lecture/create?valTerms=5'>Создать лекцию</a>
</@c.page>
