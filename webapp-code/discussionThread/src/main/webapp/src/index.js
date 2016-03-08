/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
	$.ajax({ url: "GetUsername", success: function(result) {
			$("#username").html(result);
			alignMessages(result);
		}
	});

	$('#comment_entry').focus();

})

function alignMessages(username) {
	$.ajax({ url: "GetMessageIndex", success: function(responseJson) {    
			var classes = ['green lighten-1', 'indigo accent-1', 'light-blue accent-2'];
			var i = 0;
			var classAssign = {};
			classAssign[username] = getUserClass();
			var c;

			$.each(responseJson, function(index, item) {
				if (!(item in classAssign)) {
					classAssign[item] = classes[i]
					i = (i + 1) % classes.length;
				}

				c = classAssign[item];

				var li = document.getElementsByTagName('li');
				li[li.length - 1 - index].className += " " + c;
			});
		}
    });
}

function getUserClass() {
	return "offset-l9 offset-m8 offset-s7";
}

