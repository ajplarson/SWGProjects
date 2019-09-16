$(document).ready(function () {
    $("H1").css({ 'text-align': 'center' });
    $("H2").css({ 'text-align': 'center' });
    $("#yellowHeading").append("h2").text('Yellow Team');
    $('div').removeClass('well');
    $('div').addClass('page-header')
    $("#oops").hide();

    $(".blue").css({ 'background-color': 'blue' });
    $(".orange").css({ 'background-color': 'orange' });
    $(".yellow").css({ 'background-color': 'yellow' });
    $(".red").css({ 'background-color': 'red' });
    $('#yellowTeamList').append("<li>Joe</li>");
    $('#yellowTeamList').append("<li>Frank</li>");

    $('#footerPlaceholder').remove();
});