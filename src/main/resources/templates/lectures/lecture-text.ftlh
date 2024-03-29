<#import "/utility/common.ftlh" as c>
<@c.page>

<div class='container'>
  <div class='row m-3'>
    <h3 class='h3 text-center'>
      <p>Тема: ${lecture.title}</p>
    </h3>
  </div>
  <hr>
  <div class='shadow-sm row border rounded mb-3'>
    <p>${lecture.text?no_esc}</p>
  </div>
  <div class='row'>
      <#list lecture.terms as term>
        <div class='row bg-light border rounded-pill m-1 shadow-sm'>
          <p>${term} — ${lecture.def[term?counter-1]}</p>
        </div>
      </#list>
  </div>
  <hr>
  <div class='row'>
    <div>
      <p class='h3 text-end'>${lecture.author}</p>
    </div>
  </div>
  <a class='btn btn-primary' href='/lecture'>Назад</a>
</div>
</@c.page>