<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
	
	
    Kakao.Auth.login({
        success: function (response) {
            Kakao.API.request({
                url: '/v2/user/me',
                success: function (response) {
                    alert(JSON.stringify(response))
                },
                fail: function (error) {
                    alert(JSON.stringify(error))
                },
            })
        },
        fail: function (error) {
            alert(JSON.stringify(error))
        },
    })
	
	
</script>