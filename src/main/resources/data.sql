-- user 테이블에 데이터 추가
INSERT INTO user (userid, user_email, user_nickname, user_pwd) VALUES (1, 'tmdvy0805@naver.com', '승표', 'asd123');
INSERT INTO user (userid, user_email, user_nickname, user_pwd) VALUES (2, 'tmdvy0801@gmail.com', '돼지밥', 'asd');

-- post 테이블에 게시글 데이터 추가
INSERT INTO post (postid, userid, category, team_name, title, content, created_at) VALUES (1, 1, 'FREE', 'KT', 'TEST1', '첫 번째 게시글 내용입니다.', CURRENT_TIMESTAMP());
INSERT INTO post (postid, userid, category, team_name, title, content, created_at) VALUES (2, 2, 'CHEERING', 'HANWHA', 'TEST2', '두 번째 게시글 내용입니다.', CURRENT_TIMESTAMP());
INSERT INTO post (postid, userid, category, team_name, title, content, created_at) VALUES (3, 1, 'REVIEW', 'DOOSAN', 'TEST3', '세 번째 게시글 내용입니다.', CURRENT_TIMESTAMP());
INSERT INTO post (postid, userid, category, team_name, title, content, created_at) VALUES (4, 2, 'TIP', 'KIA', 'TEST4', '네 번째 게시글 내용입니다.', CURRENT_TIMESTAMP());