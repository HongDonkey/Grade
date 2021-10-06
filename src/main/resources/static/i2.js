$(document).on('click', '.submit', function(event){
    var name = $('input[name="name"]').val();
    var score = $('input[name="score"]').val();
    $.ajax({
        url:'/api_input',
        data: {
            'name':name,
            'score':score    
        },
        success:function(data) {
            if(data['message'] == 'success'){
                alert("데이터가 입력되었습니다")
                location.href="/";
            }
            else {
                alert('데이터 입력 실패')

            }
            
        }

    })
})
