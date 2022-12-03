-- SCHEMA: webapp

DROP SCHEMA IF EXISTS webapp cascade;

CREATE SCHEMA IF NOT EXISTS webapp
    AUTHORIZATION postgres;

-- Table: webapp.employee

-- DROP TABLE IF EXISTS webapp.employee;

CREATE TABLE IF NOT EXISTS webapp.employee
(
    emp_id character varying(30) COLLATE pg_catalog."default" NOT NULL,
    emp_rank character varying(100) COLLATE pg_catalog."default",
    trade character varying(100) COLLATE pg_catalog."default",
    emp_btr character varying(100) COLLATE pg_catalog."default",
    emp_name character varying(100) COLLATE pg_catalog."default",
    father_name character varying(100) COLLATE pg_catalog."default",
    blood_group character varying(100) COLLATE pg_catalog."default",
    mother_name character varying(100) COLLATE pg_catalog."default",
    bank_acc_num character varying(100) COLLATE pg_catalog."default",
    nok_details character varying(100) COLLATE pg_catalog."default",
    pan_num character varying(100) COLLATE pg_catalog."default",
    mobile_num_nok character varying(100) COLLATE pg_catalog."default",
    mobile_num_own character varying(100) COLLATE pg_catalog."default",
    aadhaar_num character varying(100) COLLATE pg_catalog."default",
    driving_lic_num character varying(100) COLLATE pg_catalog."default",
    height character varying(100) COLLATE pg_catalog."default",
    weight character varying(100) COLLATE pg_catalog."default",
    life_style_disease character varying(100) COLLATE pg_catalog."default",
    date_of_birth date,
    date_of_entry date,
    trade_cl character varying(100) COLLATE pg_catalog."default",
    civ_qualification character varying(100) COLLATE pg_catalog."default",
    mr character varying(100) COLLATE pg_catalog."default",
    id_card_num character varying(100) COLLATE pg_catalog."default",
    id_card_issuer character varying(100) COLLATE pg_catalog."default",
    id_card_issue_date date,
    leave_encashed character varying(100) COLLATE pg_catalog."default",
    imp_appts_in_service character varying(100) COLLATE pg_catalog."default",
    hobbies character varying(100) COLLATE pg_catalog."default",
    civ_case character varying(100) COLLATE pg_catalog."default",
    family_fued character varying(100) COLLATE pg_catalog."default",
    vehicle character varying(100) COLLATE pg_catalog."default",
    computer_knowledge character varying(100) COLLATE pg_catalog."default",
    misc character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT employee_pkey PRIMARY KEY (emp_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS webapp.employee
    OWNER to postgres;



-- Table: webapp.employee_address

-- DROP TABLE IF EXISTS webapp.employee_address;

CREATE TABLE IF NOT EXISTS webapp.employee_address
(
    id bigserial NOT NULL,
    emp_id character varying(30) COLLATE pg_catalog."default" NOT NULL,
    address_type "char" NOT NULL,
    village character varying(100) COLLATE pg_catalog."default",
    post character varying(100) COLLATE pg_catalog."default",
    tehsil character varying(100) COLLATE pg_catalog."default",
    district character varying(100) COLLATE pg_catalog."default",
    state character varying(100) COLLATE pg_catalog."default",
    pin character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT employee_address_pkey PRIMARY KEY (id),
    CONSTRAINT employee_address_emp_id_fkey FOREIGN KEY (emp_id)
        REFERENCES webapp.employee (emp_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS webapp.employee_address
    OWNER to postgres;



-- Table: webapp.employee_course

-- DROP TABLE IF EXISTS webapp.employee_course;

CREATE TABLE IF NOT EXISTS webapp.employee_course
(
    id bigserial NOT NULL,
    emp_id character varying(30) COLLATE pg_catalog."default" NOT NULL,
    course_name character varying(100) COLLATE pg_catalog."default",
    start_date character varying(100) COLLATE pg_catalog."default",
    end_date character varying(100) COLLATE pg_catalog."default",
    grading character varying(100) COLLATE pg_catalog."default",
    remarks character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT employee_course_info_pkey PRIMARY KEY (id),
    CONSTRAINT employee_course_emp_id_fkey FOREIGN KEY (emp_id)
        REFERENCES webapp.employee (emp_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS webapp.employee_course
    OWNER to postgres;



-- Table: webapp.employee_duty

-- DROP TABLE IF EXISTS webapp.employee_duty;

CREATE TABLE IF NOT EXISTS webapp.employee_duty
(
    id bigserial NOT NULL,
    emp_id character varying(30) COLLATE pg_catalog."default",
    ere_detail character varying(100) COLLATE pg_catalog."default",
    start_date character varying(20) COLLATE pg_catalog."default",
    end_date character varying(20) COLLATE pg_catalog."default",
    remarks character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT employee_duty_info_pkey PRIMARY KEY (id),
    CONSTRAINT employee_duty_emp_id_fkey FOREIGN KEY (emp_id)
        REFERENCES webapp.employee (emp_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS webapp.employee_duty
    OWNER to postgres;



-- Table: webapp.employee_family

-- DROP TABLE IF EXISTS webapp.employee_family;

CREATE TABLE IF NOT EXISTS webapp.employee_family
(
    id bigserial NOT NULL,
    member_name character varying(100) COLLATE pg_catalog."default",
    gender "char",
    age character varying(50) COLLATE pg_catalog."default",
    qualification character varying(100) COLLATE pg_catalog."default",
    emp_id character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT employee_family_info_pkey PRIMARY KEY (id),
    CONSTRAINT employee_family_emp_id_fkey FOREIGN KEY (emp_id)
        REFERENCES webapp.employee (emp_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS webapp.employee_family
    OWNER to postgres;



-- Table: webapp.employee_punishment

-- DROP TABLE IF EXISTS webapp.employee_punishment;

CREATE TABLE IF NOT EXISTS webapp.employee_punishment
(
    id bigserial NOT NULL,
    emp_id character varying(30) COLLATE pg_catalog."default" NOT NULL,
    punishment_awarded character varying(100) COLLATE pg_catalog."default",
    offence character varying(100) COLLATE pg_catalog."default",
    remarks character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT employee_punishment_info_pkey PRIMARY KEY (id),
    CONSTRAINT employee_punishment_emp_id_fkey FOREIGN KEY (emp_id)
        REFERENCES webapp.employee (emp_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS webapp.employee_punishment
    OWNER to postgres;



-- Table: webapp.employee_sports

-- DROP TABLE IF EXISTS webapp.employee_sports;

CREATE TABLE IF NOT EXISTS webapp.employee_sport
(
    id bigserial NOT NULL,
    emp_id character varying(30) COLLATE pg_catalog."default" NOT NULL,
    sport_played character varying(100) COLLATE pg_catalog."default",
    sport_level character varying(100) COLLATE pg_catalog."default",
    remarks character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT employee_sports_pkey PRIMARY KEY (id),
    CONSTRAINT employee_sports_emp_id_fkey FOREIGN KEY (emp_id)
        REFERENCES webapp.employee (emp_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS webapp.employee_sports
    OWNER to postgres;