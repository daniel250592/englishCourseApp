INSERT INTO user VALUES (9999,1,'admin@email.com','$10$3WxGRWt9sC9KJHKkKJKgZuRkDECGE53qJUsCr1FNfz8LcVDd/79K6','ADMIN','admin');
INSERT INTO user VALUES (9998,1,'user@email.com','$10$3WxGRWt9sC9KJHKkKJKgZuRkDECGE53qJUsCr1FNfz8LcVDd/79K6','USER','user');
INSERT INTO topic VALUES (1,'test topic content','test topic name');
INSERT INTO quiz VALUES (1,1);
INSERT INTO question VALUES(1,'first answer content',1,'fourth answer content',0,'test question','second answer content',0,'third answer content',0);
INSERT INTO question VALUES(2,'first answer content 2',1,'fourth answer content 2',0,'test question 2','second answer content 2',0,'third answer content 2',0);
INSERT INTO quiz_questions VALUES (1,1);
INSERT INTO quiz_questions VALUES (1,2);
INSERT INTO quiz_users VALUES (1,9998);