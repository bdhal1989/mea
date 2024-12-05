-- public.mea_details definition

-- Drop table

-- DROP TABLE public.mea_details;

CREATE TABLE public.mea_details (
	id int8 NOT NULL,
	"version" int8 NULL,
	createdby int8 NULL,
	createddate timestamp NULL,
	lastmodifiedby int8 NULL,
	lastmodifieddate timestamp NULL,
	aadhaar_no varchar(255) NULL,
	accompany_family_member int8 NULL,
	accompany_family_member_female_children int8 NULL,
	action_taken varchar(255) NULL,
	age int8 NULL,
	caller_name varchar(255) NULL,
	caller_relation varchar(255) NULL,
	contact_number_in_india varchar(255) NULL,
	contact_number_india varchar(255) NULL,
	country_code varchar(255) NULL,
	current_contact_number varchar(255) NULL,
	current_country_overseas_indian varchar(255) NULL,
	current_location varchar(255) NULL,
	date_of_birth varchar(255) NULL,
	description varchar(255) NULL,
	email_id varchar(255) NULL,
	gender varchar(255) NULL,
	incident_number varchar(255) NULL,
	incident_type varchar(255) NULL,
	is_passport_valid varchar(255) NULL,
	lat varchar(255) NULL,
	location_in_india varchar(255) NULL,
	location_overseas_indian varchar(255) NULL,
	lon varchar(255) NULL,
	medical_emergency_details varchar(255) NULL,
	name_of_the_family_members varchar(255) NULL,
	no_of_family_members varchar(255) NULL,
	overseas_indian_name varchar(255) NULL,
	passport_expiry_date varchar(255) NULL,
	passport_number varchar(255) NULL,
	physical_passport_availability varchar(255) NULL,
	place_of_birth varchar(255) NULL,
	place_travel_india varchar(255) NULL,
	status varchar(255) NULL,
	submitted_by varchar(255) NULL,
	tracking_link varchar(255) NULL,
	CONSTRAINT mea_details_pkey PRIMARY KEY (id)
);


-- public.family_details definition

-- Drop table

-- DROP TABLE public.family_details;

CREATE TABLE public.family_details (
	id int8 NOT NULL,
	"version" int8 NULL,
	createdby int8 NULL,
	createddate timestamp NULL,
	lastmodifiedby int8 NULL,
	lastmodifieddate timestamp NULL,
	age varchar(255) NULL,
	contact_no varchar(255) NULL,
	email_id varchar(255) NULL,
	family_member_name varchar(255) NULL,
	gender varchar(255) NULL,
	passport_no varchar(255) NULL,
	mea_id int8 NULL,
	CONSTRAINT family_details_pkey PRIMARY KEY (id),
	CONSTRAINT fk57bgu3h3r552jwr8q0lgnkw7f FOREIGN KEY (mea_id) REFERENCES public.mea_details(id)
);

-- public.mea_history_details definition

-- Drop table

-- DROP TABLE public.mea_history_details;

CREATE TABLE public.mea_history_details (
	id int8 NOT NULL,
	"version" int8 NULL,
	createdby int8 NULL,
	createddate timestamp NULL,
	lastmodifiedby int8 NULL,
	lastmodifieddate timestamp NULL,
	current_location varchar(255) NULL,
	incident_number varchar(255) NULL,
	lat varchar(255) NULL,
	lon varchar(255) NULL,
	mea_details_id int8 NULL,
	CONSTRAINT mea_history_details_pkey PRIMARY KEY (id)
);


-- public.mea_history_details foreign keys

ALTER TABLE public.mea_history_details ADD CONSTRAINT fkqgrv8i52rhjgkcrb4991c09l3 FOREIGN KEY (mea_details_id) REFERENCES public.mea_details(id);