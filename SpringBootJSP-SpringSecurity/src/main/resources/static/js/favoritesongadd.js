var songidne; 
function ChooseFavorite(songid){
        var content = document.getElementById(songid);
        content.classList.toggle('hidden');
        songidne = songid;
}
 function addFavoriteSong(songid){
	 var id = $(`#select-${songid} option:selected`).val();
	 $( document ).ready(function() {
		 $.ajax({
			 type:'POST',
			  url: "/api/addfavoritesong/"+id+"/"+songid,
			  success:function(rs){
				  alert(rs);
			  }
			})
	 });
 }