create database bankmanagementsystem;

use bankmanagementsystem;

create table signup(
formno varchar(20) , 
name varchar(30) , 
father_name varchar(30) , 
dob varchar(20) , 
gender varchar(20) , 
email varchar(40) , 
marital varchar(20) , 
address varchar(40) , 
city varchar(25) , 
state varchar (25) ,
pincode varchar (20));

create table signuptwo(
formno varchar(20) ,
religion varchar(20) ,
category varchar(20) ,
income varchar(20) ,
education varchar(20) ,
occupation varchar(20) ,
pan_Number varchar(20) ,
aadhar_Number varchar(20) ,
senior_Citizen varchar(20) ,
existing_Account varchar(20));

create table signupthree(
formno varchar(20) ,
accountType varchar(40) ,
services varchar(100) ,
cardNumber varchar(25) ,
pin varchar(10));

create table login(
formno varchar(20) ,
cardNumber varchar(25) ,
pin varchar(10));

create table accountinfo(
cardNumber varchar(25) ,
pin varchar(10) ,
date varchar(50) ,
type varchar (20) ,
amount varchar (20));

select * from signuptwo;
select * from signup;
select * from signupthree;
select * from login;
select * from accountinfo;

drop table signupthree;
drop table signuptwo;
drop table signup;
drop table login;
drop table accountinfo;
