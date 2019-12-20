var main = {
	init : function(){
		var _this = this;
		$('#selPost').on('click', function(){
			location.reload();
		})
		
        $('#btn-save').on('click', function () {
            _this.save();
        });
        
        $('#delPost').on('click', function(){
        	if($('input[type=checkbox]:checked').length > 0){
        		_this.del();
        	}else{
        		alert('선택된 게시글이 없습니다.');
        	}
        });
        
        $('#allCheck').on('click', function(){
        	//만약 전체 선택 체크박스가 체크된상태일경우 
        	if($("#allCheck").prop("checked")) { 
        		//해당화면에 전체 checkbox들을 체크해준다 
        		$("input[type=checkbox]").prop("checked",true); 
        		// 전체선택 체크박스가 해제된 경우 
        		}else {
        			//해당화면에 모든 checkbox들의 체크를해제시킨다. 
        			$("input[type=checkbox]").prop("checked",false); 
        		}
        });
	},
	save : function(){
		var data = {
				title:   $('#title').val(),
				author:  $('#author').val(),
				content: $('#content').val()
		};
	
		$.ajax({
		    type: 'POST',
            url: '/savePosts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
			success: function(){
				alert('글이 등록되었습니다.');
				location.reload();
			},
			error: function(e){
				alert(e)
			}
		});
	},
	del : function(){
		var checkBoxArr =[];
		$('input[name=checkBox]:checked').each(function(){
			checkBoxArr.push($(this).val());
		});
		
		var data = {
				delList: checkBoxArr
		};
		
		$.ajax({
			type: 'POST',
            url: '/delPosts',
            dataType: 'text',
            contentType:'application/json; charset=utf-8',
			data: JSON.stringify(data),
			success: function(){
				alert('게시글이 삭제되었습니다.');
				location.reload();
			},
			error: function(e){
				alert(e.statusText);
			}
		});
	}
	
};

main.init();
