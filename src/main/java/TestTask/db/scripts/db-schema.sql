create table if not exists public.issue (
    id int identity primary key,
    title varchar(50),
    author varchar(50),
    description varchar(255),
    dateTime date,
    status varchar(50)
);

create table if not exists public.comment (
    id int identity primary key,
    author varchar(50),
    text varchar(255),
    dateTime date,
    status varchar(50),
    issueId int,
    foreign key (issueId) references public.issue(id)
);