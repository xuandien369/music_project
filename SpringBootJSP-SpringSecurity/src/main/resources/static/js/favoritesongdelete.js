function deleteFM(songid,userid){
	$( document ).ready(function() {
	    var x = confirm('Bạn có chắc chắn muốn xóa danh sách này ?');
	    if(x){
	        $.ajax({
	            type:'GET',
	             url: "/favoritesong/delete/"+songid,
	             success:function(rs){
	  	           window.location.href='/favoritesong/'+userid;
	             }
	           })
	    }		 
	});
 }