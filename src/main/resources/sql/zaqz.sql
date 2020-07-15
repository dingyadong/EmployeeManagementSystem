/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/7/15 15:26:29                           */
/*==============================================================*/


drop table if exists Agent;

drop table if exists Boardroom;

drop table if exists Department;

drop table if exists File;

drop table if exists Information;

drop table if exists M_U;

drop table if exists Meeting;

drop table if exists Name_card;

drop table if exists Reader;

drop table if exists Relationship_5;

drop table if exists Reserve;

drop table if exists Scheduling_program;

drop table if exists State;

drop table if exists User;

/*==============================================================*/
/* Table: Agent                                                 */
/*==============================================================*/
create table Agent
(
   user_id2             int not null,
   agent_id2            int not null,
   user_id              int,
   Use_user_id          int,
   primary key (user_id2, agent_id2)
);

/*==============================================================*/
/* Table: Boardroom                                             */
/*==============================================================*/
create table Boardroom
(
   boardroom_id         int not null,
   boardroom_name       varchar(20),
   boardroom_url        varchar(255),
   space                int,
   air_condition        datetime,
   primary key (boardroom_id)
);

/*==============================================================*/
/* Table: Department                                            */
/*==============================================================*/
create table Department
(
   department_id        int not null,
   depatment_name       varchar(20),
   primary key (department_id)
);

/*==============================================================*/
/* Table: File                                                  */
/*==============================================================*/
create table File
(
   file_id              int not null,
   user_id              int,
   Use_user_id          int,
   file_name            varchar(20),
   file_url             varchar(255),
   file_size            int,
   primary key (file_id)
);

/*==============================================================*/
/* Table: Information                                           */
/*==============================================================*/
create table Information
(
   information_id       int not null,
   date                 datetime,
   message              varchar(20),
   primary key (information_id)
);

/*==============================================================*/
/* Table: M_U                                                   */
/*==============================================================*/
create table M_U
(
   user_id              int not null,
   meeting_id           int not null,
   primary key (user_id, meeting_id)
);

/*==============================================================*/
/* Table: Meeting                                               */
/*==============================================================*/
create table Meeting
(
   meeting_id           int not null,
   boardroom_id         int,
   meeting_name         varchar(20),
   meeting_date         date,
   meeting_man          varchar(20),
   meeting_theme        varchar(20),
   primary key (meeting_id)
);

/*==============================================================*/
/* Table: Name_card                                             */
/*==============================================================*/
create table Name_card
(
   name_cardid          int not null,
   user_id              int,
   file_id              int,
   user_name            varchar(20),
   department_name      varchar(20),
   contact              varchar(20),
   post                 varchar(20),
   primary key (name_cardid)
);

/*==============================================================*/
/* Table: Reader                                                */
/*==============================================================*/
create table Reader
(
   user_id1             int not null,
   read_id1             int not null,
   user_id              int,
   Use_user_id          int,
   primary key (user_id1, read_id1)
);

/*==============================================================*/
/* Table: Relationship_5                                        */
/*==============================================================*/
create table Relationship_5
(
   information_id       int not null,
   user_id              int not null,
   primary key (information_id, user_id)
);

/*==============================================================*/
/* Table: Reserve                                               */
/*==============================================================*/
create table Reserve
(
   reserve_id           int not null,
   boardroom_id         int,
   user_id              int,
   reserve_state        varchar(20),
   boardroom_name       varchar(20),
   primary key (reserve_id)
);

/*==============================================================*/
/* Table: Scheduling_program                                    */
/*==============================================================*/
create table Scheduling_program
(
   sp_id                int not null,
   user_id              int,
   date                 datetime,
   object               varchar(255),
   primary key (sp_id)
);

/*==============================================================*/
/* Table: State                                                 */
/*==============================================================*/
create table State
(
   State_id             int not null,
   information_id       int,
   user_id              int,
   sddresser_t          varchar(20),
   sddresser_a          varchar(20),
   consignee_t          varchar(20),
   consignee_a          varchar(20),
   primary key (State_id)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   user_id              int not null,
   boardroom_id         int,
   department_id        int,
   user_name            varchar(20),
   user_sex             varchar(20),
   user_age             varchar(10),
   department_name      varchar(20),
   post                 varchar(20),
   self                 varchar(20),
   hobbies              varchar(20),
   telephone            int,
   email                varchar(20),
   MSN                  int,
   system_role          int,
   password             varchar(20),
   primary key (user_id)
);

alter table Agent add constraint FK_Relationship_12 foreign key (user_id)
      references User (user_id) on delete restrict on update restrict;

alter table Agent add constraint FK_Relationship_13 foreign key (Use_user_id)
      references User (user_id) on delete restrict on update restrict;

alter table File add constraint FK_Relationship_18 foreign key (Use_user_id)
      references User (user_id) on delete restrict on update restrict;

alter table File add constraint FK_Relationship_3 foreign key (user_id)
      references User (user_id) on delete restrict on update restrict;

alter table M_U add constraint FK_Relationship_7 foreign key (user_id)
      references User (user_id) on delete restrict on update restrict;

alter table M_U add constraint FK_Relationship_8 foreign key (meeting_id)
      references Meeting (meeting_id) on delete restrict on update restrict;

alter table Meeting add constraint FK_Relationship_9 foreign key (boardroom_id)
      references Boardroom (boardroom_id) on delete restrict on update restrict;

alter table Name_card add constraint FK_Relationship_19 foreign key (file_id)
      references File (file_id) on delete restrict on update restrict;

alter table Name_card add constraint FK_Relationship_20 foreign key (user_id)
      references User (user_id) on delete restrict on update restrict;

alter table Reader add constraint FK_Relationship_10 foreign key (user_id)
      references User (user_id) on delete restrict on update restrict;

alter table Reader add constraint FK_Relationship_11 foreign key (Use_user_id)
      references User (user_id) on delete restrict on update restrict;

alter table Relationship_5 add constraint FK_Relationship_5 foreign key (information_id)
      references Information (information_id) on delete restrict on update restrict;

alter table Relationship_5 add constraint FK_Relationship_6 foreign key (user_id)
      references User (user_id) on delete restrict on update restrict;

alter table Reserve add constraint FK_Relationship_16 foreign key (user_id)
      references User (user_id) on delete restrict on update restrict;

alter table Reserve add constraint FK_Relationship_17 foreign key (boardroom_id)
      references Boardroom (boardroom_id) on delete restrict on update restrict;

alter table Scheduling_program add constraint FK_Relationship_4 foreign key (user_id)
      references User (user_id) on delete restrict on update restrict;

alter table State add constraint FK_Relationship_14 foreign key (user_id)
      references User (user_id) on delete restrict on update restrict;

alter table State add constraint FK_Relationship_15 foreign key (information_id)
      references Information (information_id) on delete restrict on update restrict;

alter table User add constraint FK_Relationship_1 foreign key (department_id)
      references Department (department_id) on delete restrict on update restrict;

alter table User add constraint FK_Relationship_2 foreign key (boardroom_id)
      references Boardroom (boardroom_id) on delete restrict on update restrict;

