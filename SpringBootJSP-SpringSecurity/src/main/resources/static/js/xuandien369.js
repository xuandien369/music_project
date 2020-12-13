function Init(){
	var amee = document.getElementById("FMidne").value;
	fetch('/api/details/'+amee)
	.then(function(response){
	       return response.json();
	})
	.then(function(data){
		var listSong = data;
		var StopPlay = document.getElementById("stop");
		var audio = document.querySelector("audio");
		var namesong = document.getElementById("songname")
		var singer = document.querySelector("#singer");
		var listSongFE = document.querySelector(".listSongFE");
		var next = document.querySelector("#next");
		var stop = document.querySelector("#stop");
		var prev = document.querySelector("#prev");
		var loop = document.querySelector("#loop");
		var xuandien369 = document.getElementsByClassName('xuandien369');
		renderListSong(listSong);
		var index=0;
		function nextSong(){
		    index=(index+1)%listSong.length;
		    renderListChooseSong(index);
		    loadSong(listSong[index]);
		    audio.play();  
		}
		function renderListChooseSong(number) {
		    var listSongHTML = listSong.map(function (data,indexx){
		        return (number===indexx) ?` <a href="#" class="currentSong xuandien369" id="${indexx}">${data.name}-${data.singer}</a>&ensp;<a href="#"><i class="fas fa-trash"></i></a><br><br>`
		        :` <a href="#" class="xuandien369" id="${indexx}">${data.name}-${data.singer}</a>&ensp;<a href="#"><i class="fas fa-trash"></i></a><br><br>`;
		    });
		    listSongFE.innerHTML=listSongHTML.join('');
			for (var i in Array.from(xuandien369)) {
				xuandien369[i].onclick = function(e){
//					console.log(typeof e.target.id);
					chooseSong(parseInt(e.target.id))
				}
			};
		}
		function loadSong(song){

		    namesong.textContent=song.name;
		    singer.innerHTML=`<i>${song.singer}</i>`;
		    audio.setAttribute('src',`/MusicStorage/${song.sourceName}`)
		}
		function stopPlay(){
		    audio.pause();
		    audio.currentTime=0;
		}
		function prevSong(){
		    if(index>0){
		        index=(index-1)%listSong.length;
		        renderListChooseSong(index);
		        loadSong(listSong[index]);
		        audio.play(); 
		    }
		    else {
		        index=listSong.length-1;
		        renderListChooseSong(index);
		        loadSong(listSong[index]);
		        audio.play(); 
		    }
		}
		function chooseSong(songIndex){
		    index=songIndex; 
		    renderListChooseSong(songIndex);
		    loadSong(listSong[index]);
		    audio.play(); 
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
		function renderListSong(hehe) {
		    var listSongHTML = hehe.map(function(data,indexne){
		        return (0===indexne) ?` <a href="#" class="currentSong xuandien369" id="${indexne}">${data.name}-${data.singer}</a>&ensp;<a href="#"><i class="fas fa-trash"></i></a><br><br>`
		        :` <a href="#" class="xuandien369" id="${indexne}">${data.name}-${data.singer}</a>&ensp;<a href="#"><i class="fas fa-trash"></i></a><br><br>`;
		    });
		    listSongFE.innerHTML=listSongHTML.join('');
			for (var i in Array.from(xuandien369)) {
				xuandien369[i].onclick = function(e){
					chooseSong(parseInt(e.target.id))
				}
			};
			loadSong(listSong[0]);
		}
		next.addEventListener('click',nextSong);
		stop.addEventListener('click',stopPlay);
		prev.addEventListener('click',prevSong);
		loop.addEventListener('click',loops);
		audio.addEventListener('ended',nextSong);
	})}
Init();
