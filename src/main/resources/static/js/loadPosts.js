<script>
    $(document).ready(function () {
        // 서버에서 게시물 목록을 가져와서 테이블에 추가하는 함수
        function loadPosts() {
            $.ajax({
                type: 'GET',
                url: '/rest-api/boards/posts',
                success: function (response) {
                    // 서버에서 받아온 JSON 데이터를 이용하여 HTML을 생성하여 테이블에 추가합니다.
                    var posts = response;
                    var tableBody = $('#postTableBody');
                    tableBody.empty(); // 기존 데이터 삭제
                    posts.forEach(function (post) {
                        var createdDate = new Date(post.createdAt);
                        var formattedcreatedDate = ("0" + (createdDate.getFullYear() % 100)).slice(-2) + "-" + ("0" + (createdDate.getMonth() + 1)).slice(-2) + "-" + ("0" + createdDate.getDate()).slice(-2) + " " + ("0" + createdDate.getHours()).slice(-2) + ":" + ("0" + createdDate.getMinutes()).slice(-2);

                        var row = '<tr>' +
                            '<td>' + post.postId + '</td>' +
                            '<td><a href="/boards/post/' + post.postId + '">' + post.postTitle + '</a></td>' +
                            '<td>' + post.userNickname + '</td>' +
                            '<td>' + formattedcreatedDate + '</td>' +
                            '</tr>';
                        tableBody.append(row);
                    });
                },
                error: function (xhr, status, error) {
                    // 오류 발생 시 처리
                    console.error('Failed to load posts:', error);
                }
            });
        }
        // 페이지 로드 시 게시물 목록을 로드합니다.
        loadPosts();
    });
</script>