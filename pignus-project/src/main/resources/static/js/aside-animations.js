var menuElement = document.getElementById('header-dashboard');
var screenWidth = screen.width;
var containerDashboard = document.getElementById('body-dashboard')
var closeElement = document.getElementById('close-menu');
var openElement = document.getElementById('open-menu');
var contentMenuElement = document.getElementById('header-content');

openElement.onclick = function() {  
  containerDashboard.style.overflowY = 'hidden';
  menuElement.style.display = 'block';
  closeElement.style.display = 'block';
  
  if (screenWidth <= '768') {
    menuElement.style.width = '88%';
  } else {
    menuElement.style.width = '342px';
  }
  
  setTimeout(function() {
    contentMenuElement.style.visibility = 'visible';
  }, 50)
}

closeElement.onclick = function() {
  containerDashboard.style.overflowY = 'scroll';
  contentMenuElement.style.visibility = 'hidden';
  closeElement.style.display = 'none';
  
  setTimeout(function() {
    menuElement.style.width = '0';
    menuElement.style.display = 'none';
  }, 50)
}