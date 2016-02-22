/*
Navicat PGSQL Data Transfer

Source Server         : locqal
Source Server Version : 90500
Source Host           : localhost:5432
Source Database       : postgres
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90500
File Encoding         : 65001

Date: 2016-02-17 15:34:47
*/


-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS "public"."address";
CREATE TABLE "public"."address" (
"id" int4 NOT NULL,
"addressline1" varchar(255) COLLATE "default" NOT NULL,
"addressline2" varchar(255) COLLATE "default" NOT NULL,
"pincode_id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for audit_log
-- ----------------------------
DROP TABLE IF EXISTS "public"."audit_log";
CREATE TABLE "public"."audit_log" (
"id" int4 NOT NULL,
"actor_id" int4 NOT NULL,
"created_at" timestamp(6) NOT NULL,
"message" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for cmsession
-- ----------------------------
DROP TABLE IF EXISTS "public"."cmsession";
CREATE TABLE "public"."cmsession" (
"id" int4 NOT NULL,
"title" varchar(255) COLLATE "default" NOT NULL,
"uploader_admin_id" int4 NOT NULL,
"module_id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS "public"."college";
CREATE TABLE "public"."college" (
"max_students" int4 NOT NULL,
"id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS "public"."comment";
CREATE TABLE "public"."comment" (
"id" int4 NOT NULL,
"comment" varchar(255) COLLATE "default",
"reviewer_id" int4 NOT NULL,
"slide_id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS "public"."company";
CREATE TABLE "public"."company" (
"max_students" int4 NOT NULL,
"id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for content_admin
-- ----------------------------
DROP TABLE IF EXISTS "public"."content_admin";
CREATE TABLE "public"."content_admin" (
"id" int4 NOT NULL,
"email" varchar(255) COLLATE "default" NOT NULL,
"gender" varchar(255) COLLATE "default",
"is_verified" bool,
"istar_authorization_token" varchar(255) COLLATE "default",
"mobile" int8,
"name" varchar(255) COLLATE "default" NOT NULL,
"password" varchar(255) COLLATE "default" NOT NULL,
"token_expired" bool,
"token_verified" varchar(255) COLLATE "default",
"user_type" varchar(255) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for content_creator
-- ----------------------------
DROP TABLE IF EXISTS "public"."content_creator";
CREATE TABLE "public"."content_creator" (
"id" int4 NOT NULL,
"email" varchar(255) COLLATE "default" NOT NULL,
"gender" varchar(255) COLLATE "default",
"is_verified" bool,
"istar_authorization_token" varchar(255) COLLATE "default",
"mobile" int8,
"name" varchar(255) COLLATE "default" NOT NULL,
"password" varchar(255) COLLATE "default" NOT NULL,
"token_expired" bool,
"token_verified" varchar(255) COLLATE "default",
"user_type" varchar(255) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for content_reviewer
-- ----------------------------
DROP TABLE IF EXISTS "public"."content_reviewer";
CREATE TABLE "public"."content_reviewer" (
"id" int4 NOT NULL,
"email" varchar(255) COLLATE "default" NOT NULL,
"gender" varchar(255) COLLATE "default",
"is_verified" bool,
"istar_authorization_token" varchar(255) COLLATE "default",
"mobile" int8,
"name" varchar(255) COLLATE "default" NOT NULL,
"password" varchar(255) COLLATE "default" NOT NULL,
"token_expired" bool,
"token_verified" varchar(255) COLLATE "default",
"user_type" varchar(255) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS "public"."course";
CREATE TABLE "public"."course" (
"id" int4 NOT NULL,
"course_name" varchar(255) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for creative_admin
-- ----------------------------
DROP TABLE IF EXISTS "public"."creative_admin";
CREATE TABLE "public"."creative_admin" (
"id" int4 NOT NULL,
"email" varchar(255) COLLATE "default" NOT NULL,
"gender" varchar(255) COLLATE "default",
"is_verified" bool,
"istar_authorization_token" varchar(255) COLLATE "default",
"mobile" int8,
"name" varchar(255) COLLATE "default" NOT NULL,
"password" varchar(255) COLLATE "default" NOT NULL,
"token_expired" bool,
"token_verified" varchar(255) COLLATE "default",
"user_type" varchar(255) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for creative_creator
-- ----------------------------
DROP TABLE IF EXISTS "public"."creative_creator";
CREATE TABLE "public"."creative_creator" (
"id" int4 NOT NULL,
"email" varchar(255) COLLATE "default" NOT NULL,
"gender" varchar(255) COLLATE "default",
"is_verified" bool,
"istar_authorization_token" varchar(255) COLLATE "default",
"mobile" int8,
"name" varchar(255) COLLATE "default" NOT NULL,
"password" varchar(255) COLLATE "default" NOT NULL,
"token_expired" bool,
"token_verified" varchar(255) COLLATE "default",
"user_type" varchar(255) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for government
-- ----------------------------
DROP TABLE IF EXISTS "public"."government";
CREATE TABLE "public"."government" (
"max_students" int4 NOT NULL,
"id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for istar_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."istar_user";
CREATE TABLE "public"."istar_user" (
"id" int4 NOT NULL,
"email" varchar(255) COLLATE "default" NOT NULL,
"gender" varchar(255) COLLATE "default",
"is_verified" bool,
"istar_authorization_token" varchar(255) COLLATE "default",
"mobile" int8,
"name" varchar(255) COLLATE "default" NOT NULL,
"password" varchar(255) COLLATE "default" NOT NULL,
"token_expired" bool,
"token_verified" varchar(255) COLLATE "default",
"user_type" varchar(255) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for learning_objective
-- ----------------------------
DROP TABLE IF EXISTS "public"."learning_objective";
CREATE TABLE "public"."learning_objective" (
"id" int4 NOT NULL,
"obj_type" varchar(255) COLLATE "default" NOT NULL,
"title" varchar(255) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for learning_objective_lesson
-- ----------------------------
DROP TABLE IF EXISTS "public"."learning_objective_lesson";
CREATE TABLE "public"."learning_objective_lesson" (
"lessonid" int4 NOT NULL,
"learning_objectiveid" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for learning_outcome
-- ----------------------------
DROP TABLE IF EXISTS "public"."learning_outcome";
CREATE TABLE "public"."learning_outcome" (
"id" int4 NOT NULL,
"title" varchar(255) COLLATE "default" NOT NULL,
"qualification_pack_id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for lesson
-- ----------------------------
DROP TABLE IF EXISTS "public"."lesson";
CREATE TABLE "public"."lesson" (
"id" int4 NOT NULL,
"dtype" varchar(31) COLLATE "default" NOT NULL,
"duration" int4,
"lesson_type" varchar(255) COLLATE "default" NOT NULL,
"tags" varchar(255) COLLATE "default",
"title" varchar(255) COLLATE "default" NOT NULL,
"session_id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS "public"."module";
CREATE TABLE "public"."module" (
"id" int4 NOT NULL,
"module_name" varchar(255) COLLATE "default" NOT NULL,
"course_id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for national_occupational_standard
-- ----------------------------
DROP TABLE IF EXISTS "public"."national_occupational_standard";
CREATE TABLE "public"."national_occupational_standard" (
"id" int4 NOT NULL,
"code" varchar(255) COLLATE "default" NOT NULL,
"title" varchar(255) COLLATE "default" NOT NULL,
"qualification_pack_id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for national_occupational_standard_learning_objective
-- ----------------------------
DROP TABLE IF EXISTS "public"."national_occupational_standard_learning_objective";
CREATE TABLE "public"."national_occupational_standard_learning_objective" (
"national_occupational_standardid" int4 NOT NULL,
"learning_objectiveid" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS "public"."organization";
CREATE TABLE "public"."organization" (
"id" int4 NOT NULL,
"name" varchar(255) COLLATE "default" NOT NULL,
"org_type" varchar(255) COLLATE "default" NOT NULL,
"address_id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for pincode
-- ----------------------------
DROP TABLE IF EXISTS "public"."pincode";
CREATE TABLE "public"."pincode" (
"id" int4 NOT NULL,
"city" varchar(255) COLLATE "default" NOT NULL,
"country" varchar(255) COLLATE "default" NOT NULL,
"pin" int4,
"state" varchar(255) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for presentaion
-- ----------------------------
DROP TABLE IF EXISTS "public"."presentaion";
CREATE TABLE "public"."presentaion" (
"id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for qualification_pack
-- ----------------------------
DROP TABLE IF EXISTS "public"."qualification_pack";
CREATE TABLE "public"."qualification_pack" (
"id" int4 NOT NULL,
"jobrole" varchar(255) COLLATE "default" NOT NULL,
"qp_code" varchar(255) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for slide
-- ----------------------------
DROP TABLE IF EXISTS "public"."slide";
CREATE TABLE "public"."slide" (
"id" int4 NOT NULL,
"slide_text" varchar(255) COLLATE "default",
"student_notes" varchar(255) COLLATE "default",
"teacher_notes" varchar(255) COLLATE "default",
"presentation_id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS "public"."student";
CREATE TABLE "public"."student" (
"id" int4 NOT NULL,
"email" varchar(255) COLLATE "default" NOT NULL,
"gender" varchar(255) COLLATE "default",
"is_verified" bool,
"istar_authorization_token" varchar(255) COLLATE "default",
"mobile" int8,
"name" varchar(255) COLLATE "default" NOT NULL,
"password" varchar(255) COLLATE "default" NOT NULL,
"token_expired" bool,
"token_verified" varchar(255) COLLATE "default",
"user_type" varchar(255) COLLATE "default" NOT NULL,
"father_name" varchar(255) COLLATE "default" NOT NULL,
"mother_name" varchar(255) COLLATE "default" NOT NULL,
"address_id" int4,
"organization_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for super_admin
-- ----------------------------
DROP TABLE IF EXISTS "public"."super_admin";
CREATE TABLE "public"."super_admin" (
"id" int4 NOT NULL,
"email" varchar(255) COLLATE "default" NOT NULL,
"gender" varchar(255) COLLATE "default",
"is_verified" bool,
"istar_authorization_token" varchar(255) COLLATE "default",
"mobile" int8,
"name" varchar(255) COLLATE "default" NOT NULL,
"password" varchar(255) COLLATE "default" NOT NULL,
"token_expired" bool,
"token_verified" varchar(255) COLLATE "default",
"user_type" varchar(255) COLLATE "default" NOT NULL,
"father_name" varchar(255) COLLATE "default" NOT NULL,
"mother_name" varchar(255) COLLATE "default" NOT NULL,
"address_id" int4,
"organization_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS "public"."task";
CREATE TABLE "public"."task" (
"id" int4 NOT NULL,
"actor_id" int4 NOT NULL,
"item_id" int4 NOT NULL,
"item_type" varchar(255) COLLATE "default" NOT NULL,
"owner_id" int4 NOT NULL,
"review_scheme" varchar(255) COLLATE "default",
"status" varchar(255) COLLATE "default" NOT NULL,
"task_name" varchar(255) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for task_log
-- ----------------------------
DROP TABLE IF EXISTS "public"."task_log";
CREATE TABLE "public"."task_log" (
"id" int4 NOT NULL,
"actor_id" int4,
"changed_status" varchar(255) COLLATE "default" NOT NULL,
"comments" varchar(255) COLLATE "default",
"created_at" timestamp(6) NOT NULL,
"task_id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for task_reviewer
-- ----------------------------
DROP TABLE IF EXISTS "public"."task_reviewer";
CREATE TABLE "public"."task_reviewer" (
"id" int4 NOT NULL,
"status" varchar(255) COLLATE "default" NOT NULL,
"reviewer_id" int4 NOT NULL,
"task_id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table address
-- ----------------------------
ALTER TABLE "public"."address" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table audit_log
-- ----------------------------
ALTER TABLE "public"."audit_log" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table cmsession
-- ----------------------------
ALTER TABLE "public"."cmsession" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table college
-- ----------------------------
ALTER TABLE "public"."college" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table comment
-- ----------------------------
ALTER TABLE "public"."comment" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table company
-- ----------------------------
ALTER TABLE "public"."company" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table content_admin
-- ----------------------------
ALTER TABLE "public"."content_admin" ADD UNIQUE ("email");
ALTER TABLE "public"."content_admin" ADD UNIQUE ("id");

-- ----------------------------
-- Primary Key structure for table content_admin
-- ----------------------------
ALTER TABLE "public"."content_admin" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table content_creator
-- ----------------------------
ALTER TABLE "public"."content_creator" ADD UNIQUE ("email");
ALTER TABLE "public"."content_creator" ADD UNIQUE ("id");

-- ----------------------------
-- Primary Key structure for table content_creator
-- ----------------------------
ALTER TABLE "public"."content_creator" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table content_reviewer
-- ----------------------------
ALTER TABLE "public"."content_reviewer" ADD UNIQUE ("email");
ALTER TABLE "public"."content_reviewer" ADD UNIQUE ("id");

-- ----------------------------
-- Primary Key structure for table content_reviewer
-- ----------------------------
ALTER TABLE "public"."content_reviewer" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table course
-- ----------------------------
ALTER TABLE "public"."course" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table creative_admin
-- ----------------------------
ALTER TABLE "public"."creative_admin" ADD UNIQUE ("email");
ALTER TABLE "public"."creative_admin" ADD UNIQUE ("id");

-- ----------------------------
-- Primary Key structure for table creative_admin
-- ----------------------------
ALTER TABLE "public"."creative_admin" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table creative_creator
-- ----------------------------
ALTER TABLE "public"."creative_creator" ADD UNIQUE ("email");
ALTER TABLE "public"."creative_creator" ADD UNIQUE ("id");

-- ----------------------------
-- Primary Key structure for table creative_creator
-- ----------------------------
ALTER TABLE "public"."creative_creator" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table government
-- ----------------------------
ALTER TABLE "public"."government" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table istar_user
-- ----------------------------
ALTER TABLE "public"."istar_user" ADD UNIQUE ("email");

-- ----------------------------
-- Primary Key structure for table istar_user
-- ----------------------------
ALTER TABLE "public"."istar_user" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table learning_objective
-- ----------------------------
ALTER TABLE "public"."learning_objective" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table learning_objective_lesson
-- ----------------------------
ALTER TABLE "public"."learning_objective_lesson" ADD PRIMARY KEY ("lessonid", "learning_objectiveid");

-- ----------------------------
-- Primary Key structure for table learning_outcome
-- ----------------------------
ALTER TABLE "public"."learning_outcome" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table lesson
-- ----------------------------
ALTER TABLE "public"."lesson" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table module
-- ----------------------------
ALTER TABLE "public"."module" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table national_occupational_standard
-- ----------------------------
ALTER TABLE "public"."national_occupational_standard" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table national_occupational_standard_learning_objective
-- ----------------------------
ALTER TABLE "public"."national_occupational_standard_learning_objective" ADD PRIMARY KEY ("national_occupational_standardid", "learning_objectiveid");

-- ----------------------------
-- Primary Key structure for table organization
-- ----------------------------
ALTER TABLE "public"."organization" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table pincode
-- ----------------------------
ALTER TABLE "public"."pincode" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table presentaion
-- ----------------------------
ALTER TABLE "public"."presentaion" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table qualification_pack
-- ----------------------------
ALTER TABLE "public"."qualification_pack" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table slide
-- ----------------------------
ALTER TABLE "public"."slide" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table student
-- ----------------------------
ALTER TABLE "public"."student" ADD UNIQUE ("email");
ALTER TABLE "public"."student" ADD UNIQUE ("id");

-- ----------------------------
-- Primary Key structure for table student
-- ----------------------------
ALTER TABLE "public"."student" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table super_admin
-- ----------------------------
ALTER TABLE "public"."super_admin" ADD UNIQUE ("email");
ALTER TABLE "public"."super_admin" ADD UNIQUE ("id");

-- ----------------------------
-- Primary Key structure for table super_admin
-- ----------------------------
ALTER TABLE "public"."super_admin" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table task
-- ----------------------------
ALTER TABLE "public"."task" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table task_log
-- ----------------------------
ALTER TABLE "public"."task_log" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table task_reviewer
-- ----------------------------
ALTER TABLE "public"."task_reviewer" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "public"."address"
-- ----------------------------
ALTER TABLE "public"."address" ADD FOREIGN KEY ("pincode_id") REFERENCES "public"."pincode" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."cmsession"
-- ----------------------------
ALTER TABLE "public"."cmsession" ADD FOREIGN KEY ("module_id") REFERENCES "public"."module" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."cmsession" ADD FOREIGN KEY ("uploader_admin_id") REFERENCES "public"."content_admin" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."college"
-- ----------------------------
ALTER TABLE "public"."college" ADD FOREIGN KEY ("id") REFERENCES "public"."organization" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."comment"
-- ----------------------------
ALTER TABLE "public"."comment" ADD FOREIGN KEY ("slide_id") REFERENCES "public"."slide" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."comment" ADD FOREIGN KEY ("reviewer_id") REFERENCES "public"."content_reviewer" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."company"
-- ----------------------------
ALTER TABLE "public"."company" ADD FOREIGN KEY ("id") REFERENCES "public"."organization" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."government"
-- ----------------------------
ALTER TABLE "public"."government" ADD FOREIGN KEY ("id") REFERENCES "public"."organization" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."learning_objective_lesson"
-- ----------------------------
ALTER TABLE "public"."learning_objective_lesson" ADD FOREIGN KEY ("learning_objectiveid") REFERENCES "public"."learning_objective" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."learning_objective_lesson" ADD FOREIGN KEY ("lessonid") REFERENCES "public"."lesson" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."learning_outcome"
-- ----------------------------
ALTER TABLE "public"."learning_outcome" ADD FOREIGN KEY ("qualification_pack_id") REFERENCES "public"."qualification_pack" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."lesson"
-- ----------------------------
ALTER TABLE "public"."lesson" ADD FOREIGN KEY ("session_id") REFERENCES "public"."cmsession" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."module"
-- ----------------------------
ALTER TABLE "public"."module" ADD FOREIGN KEY ("course_id") REFERENCES "public"."course" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."national_occupational_standard"
-- ----------------------------
ALTER TABLE "public"."national_occupational_standard" ADD FOREIGN KEY ("qualification_pack_id") REFERENCES "public"."qualification_pack" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."national_occupational_standard_learning_objective"
-- ----------------------------
ALTER TABLE "public"."national_occupational_standard_learning_objective" ADD FOREIGN KEY ("national_occupational_standardid") REFERENCES "public"."national_occupational_standard" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."national_occupational_standard_learning_objective" ADD FOREIGN KEY ("learning_objectiveid") REFERENCES "public"."learning_objective" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."organization"
-- ----------------------------
ALTER TABLE "public"."organization" ADD FOREIGN KEY ("address_id") REFERENCES "public"."address" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."presentaion"
-- ----------------------------
ALTER TABLE "public"."presentaion" ADD FOREIGN KEY ("id") REFERENCES "public"."lesson" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."slide"
-- ----------------------------
ALTER TABLE "public"."slide" ADD FOREIGN KEY ("presentation_id") REFERENCES "public"."presentaion" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."student"
-- ----------------------------
ALTER TABLE "public"."student" ADD FOREIGN KEY ("address_id") REFERENCES "public"."address" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."student" ADD FOREIGN KEY ("organization_id") REFERENCES "public"."organization" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."super_admin"
-- ----------------------------
ALTER TABLE "public"."super_admin" ADD FOREIGN KEY ("address_id") REFERENCES "public"."address" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."super_admin" ADD FOREIGN KEY ("organization_id") REFERENCES "public"."organization" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "public"."task_reviewer"
-- ----------------------------
ALTER TABLE "public"."task_reviewer" ADD FOREIGN KEY ("task_id") REFERENCES "public"."task" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."task_reviewer" ADD FOREIGN KEY ("reviewer_id") REFERENCES "public"."content_reviewer" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
