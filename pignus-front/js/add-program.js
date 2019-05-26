// Geradores de ID
var counterDiv = 0;
var counterIcon = 0;

var buttonElement = document.getElementById('add-to-app');
var buttonSubmit = document.getElementsByClassName('btn-form-dash')[1];
var containerElement = document.getElementById('app');
buttonSubmit.style.display = 'none';


var suppArrSectors = [];
var arrSectors = [];
var setoresSelecionados = document.getElementById('select-sectors');

var categoriaSelecionada = document.getElementById('select-category');
var categorySelected = '';

// Validando os valores dos selects
function validaSelecoes() {
  for (var i = 0; i < setoresSelecionados.length; i++) {
    if (setoresSelecionados.options[i].selected == true) {
      suppArrSectors.push(setoresSelecionados[i]);
    }
  }
  arrSectors.push(suppArrSectors);

  for (var i = 0; i < categoriaSelecionada.length; i++) {
    if (categoriaSelecionada.options[i].selected == true) {
      categorySelected = categoriaSelecionada[i].value;
      break;
    }
  }
}

// Array para captura de informação ao Java
var arrToJava = [];
buttonElement.onclick = function () {

  // Cria uma variável de suporte quee sempre reseta quando clicar no botão
  var suppArrToJava = [];
  buttonSubmit.style.display = 'block';

  validaSelecoes();

  var divider = document.createElement('div');

  var nomePrograma = document.createElement('h3');
  var categoriaPrograma = document.createElement('p');
  var listaSetores = document.createElement('p');
  var linkDownload = document.createElement('p');
  var link = document.createElement('a');

  var inputNomePrograma = document.querySelector('input[name=nome-programa]');
  var inputLinkDownload = document.querySelector('input[name=link-download]');

  var nomeProgramaText = document.createTextNode(inputNomePrograma.value);
  nomePrograma.appendChild(nomeProgramaText);
  divider.appendChild(nomePrograma);

  var categoriaProgramaText = document.createTextNode('Categoria: ' + categorySelected);
  categoriaPrograma.appendChild(categoriaProgramaText);
  divider.appendChild(categoriaPrograma);

  var sectorsValues = [];
  for (var i = 0; i < suppArrSectors.length; i++) {
    sectorsValues.push(suppArrSectors[i].text);
  }
  var sectorsText = document.createTextNode('Setores: ' + sectorsValues.join(', '));
  listaSetores.appendChild(sectorsText);
  divider.appendChild(listaSetores);

  link.setAttribute('target', '_blank');
  var linkText = document.createTextNode(inputLinkDownload.value);
  link.setAttribute('href', inputLinkDownload.value);

  // Validando se o usuário digitou com protocolo ou não
  var str = linkText.substringData(0, 4);

  if (str !== 'http') {
    linkText = document.createTextNode('http://' + inputLinkDownload.value);
    link.setAttribute('href', 'http://' + inputLinkDownload.value);
  }

  link.appendChild(linkText);

  var linkDownloadText = document.createTextNode('Link de Download: ');
  linkDownload.appendChild(linkDownloadText);
  linkDownload.appendChild(link)
  divider.appendChild(linkDownload);


  // Remoção de Itens do DOM
  var iconContainer = document.createElement('div');
  var iconElement = document.createElement('i');
  iconContainer.setAttribute('id', 'remove');
  iconContainer.setAttribute('class', 'remove')
  iconContainer.appendChild(iconElement);

  iconElement.setAttribute('class', 'fas fa-trash-alt');
  iconElement.setAttribute('id', counterIcon++);
  divider.appendChild(iconContainer);
  divider.setAttribute('id', `element${counterDiv++}`)


  // Segurando elementos para o Java
  suppArrToJava.push(nomeProgramaText);
  suppArrToJava.push(categorySelected);
  suppArrToJava.push(suppArrSectors);
  suppArrToJava.push(linkText);
  arrToJava.push(suppArrToJava);

  // Escutando quando ocorrerá um evento de click no ícone
  iconContainer.addEventListener('click', function (e) {
    if (window.confirm('Realmente deseja remover este elemento?')) {
      let el = document.getElementById(`element${iconElement.id}`);
      el.parentNode.removeChild(el);
      arrToJava.pop(iconElement.id);
    }
  })

  // Jogando os elementos para a div
  containerElement.appendChild(divider);

  function clearInputs() {
    // Reseting Form

    suppArrSectors = [];
    inputNomePrograma.value = '';
    categoriaSelecionada.selectedIndex = 0;
    for (var i = 0; i < setoresSelecionados.length; i++) {
      setoresSelecionados.options[i].selected = false;
    }
    inputLinkDownload.value = '';
  }

  if (inputNomePrograma.value === '' || inputLinkDownload.value === '' || categorySelected === '' || suppArrSectors.length < 1) {
    containerElement.removeChild(divider);
    clearInputs();
    return;
  } else {
    clearInputs();
  }

}
