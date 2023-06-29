$('#login-button').click(function () {
  console.log('clicked');
  $('#login-button').fadeOut('slow', function () {
    $('#container').fadeIn();
    TweenMax.from('#container', 0.4, { scale: 0, ease: Sine.easeInOut });
    TweenMax.to('#container', 0.4, { scale: 1, ease: Sine.easeInOut });
  });
});

$('.close-btn').click(function () {
  TweenMax.from('#container', 0.4, { scale: 1, ease: Sine.easeInOut });
  TweenMax.to('#container', 0.4, {
    left: '0px',
    scale: 0,
    ease: Sine.easeInOut,
  });
  $('#container, #forgotten-container').fadeOut(800, function () {
    $('#login-button').fadeIn(800);
  });
});
