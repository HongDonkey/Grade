$(function(){
    $.ajax({
        url:'/api_select',
        data: {
        },
        success:function(data) {
            if(data&&data.length) {
                for(var i=0; i<data.length; i++){
                    var item_string = '<tr>';
                    item_string = item_string + '<td>' + data[i]['idx'] + '</td>';
                    item_string = item_string + '<td>' + data[i]['name'] + '</td>';
                    item_string = item_string + '<td>' + data[i]['score'] + '</td>';
                    item_string = item_string + '<td>' + data[i]['created'] + '</td>';
                    item_string = item_string + '<td>' + data[i]['updated'] + '</td>';
                    item_string = item_string + '</tr>';
                    $('tbody').append(item_string)
                }
            }
            
        }

    })

})

