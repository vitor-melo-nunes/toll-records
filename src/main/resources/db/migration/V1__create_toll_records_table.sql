CREATE TABLE toll_records_tb (
 toll_record_id bigint(20) NOT NULL AUTO_INCREMENT,
 license_plate_number varchar(19) NOT NULL,
 tag_number varchar(19) NOT NULL,
 tag_validation_code varchar(19) NOT NULL,
 amount decimal(19,2) NOT NULL,
 status varchar(32) NOT NULL,
 creation_date TIMESTAMP NOT NULL,
 update_date TIMESTAMP NOT NULL,

PRIMARY KEY (toll_record_id)
);