var audio = document.querySelector("audio");
var stop = document.querySelector("#stop");
var loop = document.querySelector("#loop");
function stopPlay(){
    audio.pause();
    audio.currentTime=0;
}
function loops(){
    if(audio.loop){
        audio.removeAttribute('loop');
        alert('End Loop');
    }
    else{
        audio.loop = true;
        alert('Start Loop');
    }
}
stop.addEventListener('click',stopPlay);
loop.addEventListener('click',loops);