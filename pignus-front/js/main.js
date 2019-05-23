/*
 * Inserindo o valor digitado nos texto superior
 */
var nomeEmpresa, textNomeEmpresa;
var containerNomeEmpresa_1 = document.getElementById('textEmpresa-1');
var empty = document.createTextNode('')
function getName() {
  nomeEmpresa = document.getElementById('nome-empresa');
  textNomeEmpresa = document.createTextNode(nomeEmpresa.value);
  containerNomeEmpresa_1.appendChild(textNomeEmpresa);
}

/*
 * Barra de Progresso Superior
 */
var progressBar = document.getElementById('progress-bar')

/*
 * Formulários 
 */
var page1 = document.getElementById('sign-up-1');
var page2 = document.getElementById('sign-up-2');
var page3 = document.getElementById('sign-up-3');
var page4 = document.getElementById('sign-up-4');
var page5 = document.getElementById('sign-up-5');
var page6 = document.getElementById('sign-up-6');
var page7 = document.getElementById('sign-up-7');
var page8 = document.getElementById('sign-up-8');


function nextOrPrev(e) {
  var element = e.currentTarget;

  /* 
   * PREVIOUS BUTTONS
   */
  if(element.id === 'prev-form-1') {
    containerNomeEmpresa_1.removeChild(textNomeEmpresa);
    page2.style.display = 'none';
    page1.style.display = 'block'
    progressBar.style.width = '12.5%';
  }
  if(element.id === 'prev-form-2') {
    progressBar.style.width = '25%';
    page3.style.display = 'none';
    page2.style.display = 'block';
  }
  if(element.id === 'prev-form-3') {
    page4.style.display = 'none';
    page3.style.display = 'block';
    progressBar.style.width = '37.5%';
  }
  if(element.id === 'prev-form-4') {
    page5.style.display = 'none';
    page4.style.display = 'block';
    progressBar.style.width = '50%';
  }
  if(element.id === 'prev-form-5') {
    page6.style.display = 'none';
    page5.style.display = 'block';
    progressBar.style.width = '62.5%';
  }
  if(element.id === 'prev-form-6') {
    page7.style.display = 'none';
    page6.style.display = 'block';
    progressBar.style.width = '75%';
  }
  if(element.id === 'prev-form-7') {
    page8.style.display = 'none';
    page7.style.display = 'block';
    progressBar.style.width = '87.5%';
  }

  /*
   * NEXT BUTTONS
   */
  if(element.id === 'next-form-1') {
    getName();
    page1.style.display = 'none';
    page2.style.display = 'block';
    progressBar.style.width = '25%';
  }
  if(element.id === 'next-form-2') {
    page2.style.display = 'none';
    page3.style.display = 'block';
    progressBar.style.width = '37.5%';
  }
  if(element.id === 'next-form-3') {
    page3.style.display = 'none';
    page4.style.display = 'block';
    progressBar.style.width = '50%';
  }
  if(element.id === 'next-form-4') {
    page4.style.display = 'none';
    page5.style.display = 'block';
    progressBar.style.width = '62.5%';
  }
  if(element.id === 'next-form-5') {
    page5.style.display = 'none';
    page6.style.display = 'block';
    progressBar.style.width = '75%';
  }
  if(element.id === 'next-form-6') {
    page6.style.display = 'none';
    page7.style.display = 'block';
    progressBar.style.width = '87.5%';
  }
  if(element.id === 'next-form-7') {
    page7.style.display = 'none';
    page8.style.display = 'block';
    progressBar.style.width = '100%';
  }
}


function flipGeneral() {
  var cardContainer = document.getElementById('card');
  cardContainer.style.transform = "rotateY(0deg)"
}

function flipManager() {
  var cardContainer = document.getElementById('card');
  cardContainer.style.transform = "rotateY(180deg)";
}

function openMenu() {
  var root = document.getElementById('body');
  var closeMenu = document.getElementById('containerMenu');
  var ulElement = document.getElementById('ulElement');
  ulElement.style.visibility = 'visible';
  closeMenu.style.display = 'block';
  root.style.overflowY = 'hidden';
}

function closeMenu() {
  var root = document.getElementById('body');
  var ulElement = document.getElementById('ulElement');
  var closeMenu = document.getElementById('containerMenu');
  ulElement.style.visibility = 'hidden';
  
  setTimeout(function(){ 
    root.style.overflowY = 'scroll';
    closeMenu.style.display = 'none';
  }, 100);
}