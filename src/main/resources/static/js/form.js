document.querySelector("#morebtn").addEventListener("click", function () {
  let term = document.querySelector('#terms');
  let def = document.querySelector('#def');
  let entry = document.createElement('input');
  entry.type = 'text';
  entry.classList.add("form-control", "mt-2");
  entry.name = 'terms';
  term.appendChild(entry);

  entry = document.createElement('input');
  entry.type = 'text';
  entry.classList.add("form-control", "mt-2");
  entry.name = 'def';
  def.appendChild(entry);
})

document.querySelector("#lessbtn").addEventListener("click", function () {
  let term = document.querySelector('#terms').children;
  let def = document.querySelector('#def').children;
  if (document.querySelector('#terms').childElementCount >= 3) {
    term[term.length-1].remove();
    def[def.length-1].remove();
  }
})