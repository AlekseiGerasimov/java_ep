/*
	Создание 4 таблиц, последовательностей к ним, связей между таблицами
*/

CREATE SEQUENCE project_id_proj_seq
     INCREMENT BY 1
	 START 1
     NO MAXVALUE
     NO MINVALUE;
create table project (
     id_project integer DEFAULT nextval('project_id_proj_seq') primary key,
     project_name varchar(40) not null,
	 project_description varchar(200)
);

CREATE SEQUENCE user_id_user_seq
     INCREMENT BY 1
	 START 1
     NO MAXVALUE
     NO MINVALUE;
create table users (
     id_user integer DEFAULT nextval('user_id_user_seq') primary key,
     user_name varchar(45)
);

create table project_to_users(
	id_project int not null references Project(id_project),
	id_user int not null references Users(id_user)
);

CREATE SEQUENCE issues_id_issue_seq
     INCREMENT BY 1
	 START 1
     NO MAXVALUE
     NO MINVALUE;
create table issues(
	issue_number integer DEFAULT nextval('issues_id_issue_seq') primary key,
	issue_description varchar(2000) not null,
	id_project int not null references Project(id_project),
	id_user int not null references Users(id_user)
);

