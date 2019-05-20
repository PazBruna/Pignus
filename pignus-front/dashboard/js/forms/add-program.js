var buttonElement = document.getElementById('add-to-app');
var buttonSubmit = document.getElementsByClassName('btn-form-dash')[1];
buttonSubmit.style.display = 'none';

var containerElement = document.getElementById('app');

var suppArrSectors = [];
var arrSectors = [];
var setoresSelecionados = document.getElementById('select-sectors');

var categoriaSelecionada = document.getElementById('select-category');
var categorySelected = '';

function validaSelecoes() {
  for( var i = 0; i < setoresSelecionados.length; i++ )  {
    if( setoresSelecionados.options[i].selected == true ) {
      suppArrSectors.push(setoresSelecionados[i]);
    }
  }
  arrSectors.push(suppArrSectors);

  for( var i = 0; i < categoriaSelecionada.length; i++ )  {
    if( categoriaSelecionada.options[i].selected == true ) {
      categorySelected = categoriaSelecionada[i].value;
      break;
    }
  }
}

buttonElement.onclick = function() {
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
  for( var i = 0; i < suppArrSectors.length; i++ ) {
    sectorsValues.push(suppArrSectors[i].text);
  }
  var sectorsText = document.createTextNode('Setores: ' + sectorsValues.join(', '));
  listaSetores.appendChild(sectorsText);
  divider.appendChild(listaSetores);
  
  link.setAttribute('href', inputLinkDownload.value);
  link.setAttribute('target', '_blank');
  var linkText = document.createTextNode(inputLinkDownload.value);
  link.appendChild(linkText);
  var linkDownloadText = document.createTextNode('Link de Download: ');
  linkDownload.appendChild(linkDownloadText);
  linkDownload.appendChild(link)
  divider.appendChild(linkDownload);

  containerElement.appendChild(divider);

  
  // Reseting Form
  suppArrSectors = [];
  inputNomePrograma.value = '';
  categoriaSelecionada.selectedIndex = 0;
  for( var i = 0; i < setoresSelecionados.length; i++ )  {
    setoresSelecionados.options[i].selected = false;
  }
  inputLinkDownload.value = '';
  
}