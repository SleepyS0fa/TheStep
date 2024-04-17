<#import "../utility/common.ftlh" as c>
<@c.page>
<link rel="stylesheet" href="/css/lecture-text.css">
<div class='container'>
  <div class='row m-3'>
    <h3 class='h3 text-center'>
      <p>Тема: ${lecture.title}</p>
    </h3>
  </div>
  <hr>
  <div class='shadow-sm row border rounded mb-3 p-3'>
    <p>${lecture.text?no_esc}</p>
  </div>
    <#list lecture.terms as term>
      <div style="display:none" id="${term.term}">
        <p> — ${term.def}</p>
      </div>
    </#list>
  <hr>
  <div class='row'>
    <div>
      <p class='h3 text-end'>${lecture.author.username}</p>
    </div>
  </div>
  <a class='btn btn-primary' href='/lecture'>Назад</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.0/dist/jquery.slim.min.js"></script>
<script>


$(function () {
  $('[data-toggle="popover"]').each(function () {
    let content = $('#'+ $(this).attr('for'));
    $(this).popover({
        trigger: 'focus',
        html: true,
        content: () => {
          return content.html();
        }
    })
  })
})


</script>
</@c.page>