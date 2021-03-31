/* password1234 4 r */
INSERT INTO OAUTH_CLIENT_DETAILS(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY) VALUES ('spring-security-oauth2-read-client', 'resource-server-rest-api','$2a$04$a8EVPuWimpOtKFq1WZCTkedxe51ZMxaPDgyo/hw0VhT34wrkCR2Jy','read', 'password,authorization_code,refresh_token,implicit,client_credentials', 'USER', 10800, 2592000);
INSERT INTO OAUTH_CLIENT_DETAILS(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY) VALUES ('spring-security-oauth2-read-write-client', 'resource-server-rest-api','$2a$04$a8EVPuWimpOtKFq1WZCTkedxe51ZMxaPDgyo/hw0VhT34wrkCR2Jy','read,write', 'password,authorization_code,refresh_token,implicit,client_credentials', 'USER', 10800, 2592000);


/* Insert Data into admin 12 r */
/* Insert Data into User Table  */
INSERT INTO restaurant_service_oauth.user VALUES(1,1,1,1,1,'$2a$12$IbXB2IvW7bdZpw3yDj6Dku.cZ9Rmdkm0gckXu1e8frymGuTK2k4Ji','admin');
INSERT INTO restaurant_service_oauth.user VALUES(2,1,1,1,1,'$2a$12$IbXB2IvW7bdZpw3yDj6Dku.cZ9Rmdkm0gckXu1e8frymGuTK2k4Ji','user');
INSERT INTO restaurant_service_oauth.user VALUES(3,1,1,1,1,'$2a$12$IbXB2IvW7bdZpw3yDj6Dku.cZ9Rmdkm0gckXu1e8frymGuTK2k4Ji','owner');



/* Insert Data into Role Table  */
insert into restaurant_service_oauth.role values(1,'ROLE_ADMIN');
insert into restaurant_service_oauth.role values(2,'ROLE_USER');
insert into restaurant_service_oauth.role values(3,'ROLE_OWNER');



/* Insert Data into Privilege Table  */
insert into restaurant_service_oauth.privilege values(1,'READ_PRIVILEGE');
insert into restaurant_service_oauth.privilege values(2,'WRITE_PRIVILEGE');
insert into restaurant_service_oauth.privilege values(3,'DELETE_PRIVILEGE');

/* Insert Data into UserRole Table  */
INSERT INTO `restaurant_service_oauth`.`user_role`(`user_id`,`role_id`) VALUES (2,2);
INSERT INTO `restaurant_service_oauth`.`user_role`(`user_id`,`role_id`) VALUES (1,2);
INSERT INTO `restaurant_service_oauth`.`user_role`(`user_id`,`role_id`) VALUES (1,1);
INSERT INTO `restaurant_service_oauth`.`user_role`(`user_id`,`role_id`) VALUES (1,3);
INSERT INTO `restaurant_service_oauth`.`user_role`(`user_id`,`role_id`) VALUES (3,3);

/* Insert Data into RolePrivilege Table  */
insert into restaurant_service_oauth.role_privilege values(1,1);
insert into restaurant_service_oauth.role_privilege values(1,2);
insert into restaurant_service_oauth.role_privilege values(1,3);
insert into restaurant_service_oauth.role_privilege values(2,1);
insert into restaurant_service_oauth.role_privilege values(2,2);
insert into restaurant_service_oauth.role_privilege values(3,1);
insert into restaurant_service_oauth.role_privilege values(3,2);