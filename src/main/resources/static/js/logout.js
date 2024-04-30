$(document).ready(function () {
        $('#logout').click(function(event) {
            event.preventDefault();

            $.ajax({
                type: 'POST',
                url: '/rest-api/users/logout',
                success: function(response) {
                    alert('로그아웃되었습니다.');
                    window.location.reload();
                },
                error: function(xhr, status, error) {
                    alert('로그아웃 실패: ' + xhr.responseText);
                }
            });
        });
    });