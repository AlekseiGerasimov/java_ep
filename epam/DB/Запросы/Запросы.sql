/*
	Создание базы данных bug_tracker_system
*/

.open bug_tracker_system.db

/*
	Создание 4 таблиц
*/

create table project (
     id_project integer primary key AUTOINCREMENT,
     project_name varchar(40) unique not null,
	 project_description varchar(200)
);

create table users (
     id_user integer primary key AUTOINCREMENT,
     user_name varchar(45) unique not null
);

create table project_to_users(
	id_project int not null references project(id_project),
	id_user int not null references users(id_user)
);

create table issues(
	issue_number integer primary key AUTOINCREMENT,
	issue_description varchar(2000) not null,
	id_project int not null references project(id_project),
	id_user int not null references users(id_user)
);

/*
	Заполнение всех таблиц
*/

insert into project(project_name,project_description) values('Проект 1','Описание проекта 1');
insert into users(user_name) values('Алексей');
insert into project_to_users(id_project,id_user) values(1,1);
insert into issues(id_project,id_user,issue_description) values(1,1,'Описание дефекта пользователя 1 для проекта 1');

/*
	Запрос для всех дефектов по конкретному проекту конкретным пользователем
*/

select i.issue_number,i.issue_description
from issues i inner join project pr
on i.id_project = pr.id_project
			  inner join users u
on i.id_user = u.id_user
where u.user_name = '' and pr.project_name = ''