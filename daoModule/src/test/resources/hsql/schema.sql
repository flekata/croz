drop table if exists file_content;
drop table if exists file_index;

create table file_index (id integer identity primary key, file_name varchar(50), unique(file_name));
create table file_content (id integer identity primary key, file_id integer, type varchar(10) not null, value varchar(255) not null, valid boolean);
     
alter table file_content add constraint FK_file_index foreign key (file_id) references file_index(id) on delete cascade;