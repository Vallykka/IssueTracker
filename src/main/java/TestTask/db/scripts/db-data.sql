merge into issue (id, title, author, description, dateTime, status) key(id) values ('1','newIssue', 'Lila', 'Bla_bla', '2014-01-14', 'CREATED');
merge into issue (id, title, author, description, dateTime, status) key(id) values ('2','newIssue1', 'Lilu', 'Bla_bla', '2014-01-20', 'IN_PROGRESS');
merge into issue (id, title, author, description, dateTime, status) key(id) values ('3','newIssue2', 'Lola', 'Bla_bla', '2014-05-4', 'CLOSED');
merge into issue (id, title, author, description, dateTime, status) key(id) values ('4','newIssue3', 'Lulu', 'Bla_bla', '2014-06-23', 'RESOLVED');
merge into issue (id, title, author, description, dateTime, status) key(id) values ('5','newIssue4', 'Lulu', 'Bla_bla', '2014-07-14', 'CREATED');
merge into comment (id, author, text, dateTime, status, issueId) key(id) values ('1', 'Harold', 'What a wonderful world!', '2014-01-14', 'CREATED', '1');
merge into comment (id, author, text, dateTime, status, issueId) key(id) values ('1', 'Harold', 'What a wonderful world!', '2014-01-14', 'IN_PROGRESS', '2');
merge into comment (id, author, text, dateTime, status, issueId) key(id) values ('1', 'Harold', 'What a wonderful world!', '2014-01-14', 'CREATED', '1');
merge into comment (id, author, text, dateTime, status, issueId) key(id) values ('1', 'Harold', 'What a wonderful world!', '2014-01-14', 'CREATED', '1');
merge into comment (id, author, text, dateTime, status, issueId) key(id) values ('1', 'Harold', 'What a wonderful world!', '2014-01-14', 'CREATED', '1');
merge into comment (id, author, text, dateTime, status, issueId) key(id) values ('1', 'Harold', 'What a wonderful world!', '2014-01-14', 'CREATED', '1');
