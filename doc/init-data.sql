INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU)
VALUES (90, '', '系统管理', NULL);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU)
VALUES (1030, '', '功能模块', NULL);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU)
VALUES (1310, '', '配置管理', NULL);
INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU)
VALUES (2210, '', '流程管理', NULL);

INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU)
VALUES (1060, '', '通知公告', 1030);

INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU)
VALUES (230, '', '用户管理', 90);

INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU)
VALUES (231, '', '部门管理', 90);

INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU)
VALUES (232, '', '角色管理', 90);

INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU)
VALUES (233, '', '权限管理', 90);

INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU)
VALUES (234, '', '资源管理', 90);

INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU)
VALUES (235, '', '菜单管理', 90);

INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU)
VALUES (1311, '', '数据字典', 1310);

INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU)
VALUES (5300, '', '历史完成任务', 2210);

INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU)
VALUES (2211, '', '待办任务', 2210);

INSERT INTO sec_menu (ID, DESCRIPTION, NAME, PARENT_MENU)
VALUES (2212, '', '流程定义', 2210);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (5310, '历史完成任务', '/snaker/task/history', 5300);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (1220, '字典查询', '/config/dictionary', 1311);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (1221, '字典编辑', '/config/dictionary/update/**;/config/dictionary/create/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (1222, '字典查看', '/config/dictionary/view/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (1223, '字典删除', '/config/dictionary/delete/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (240, '用户查询', '/security/user', 230);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (241, '部门查询', '/security/org', 231);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (242, '角色查询', '/security/role', 232);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (243, '权限查询', '/security/authority', 233);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (244, '资源查询', '/security/resource', 234);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (245, '菜单查询', '/security/menu', 235);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (2220, '待办任务', '/snaker/task/active', 2211);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (2230, '流程定义', '/snaker/process/list', 2212);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (270, '用户查看', '/security/user/view/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (271, '部门查看', '/security/org/view/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (272, '角色查看', '/security/role/view/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (273, '权限查看', '/security/authority/view/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (274, '资源查看', '/security/resource/view/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (275, '菜单查看', '/security/menu/view/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (276, '用户删除', '/security/user/delete/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (277, '部门删除', '/security/org/delete/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (278, '角色删除', '/security/role/delete/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (279, '权限删除', '/security/authority/delete/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (280, '资源删除', '/security/resource/delete/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (281, '菜单删除', '/security/menu/delete/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (282, '用户编辑', '/security/user/update/**;/security/user/create/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (283, '部门编辑', '/security/org/update/**;/security/org/create/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (284, '角色编辑', '/security/role/update/**;/security/role/create/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (285, '权限编辑', '/security/authority/update/**;/security/authority/create/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (286, '资源编辑', '/security/resource/update/**;/security/resource/create/**', NULL);

INSERT INTO sec_resource (ID, NAME, SOURCE, MENU)
VALUES (287, '菜单编辑', '/security/menu/update/**;/security/menu/create/**', NULL);

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (5320, '历史完成任务', 'HISTORYTASK');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (1240, '字典查询', 'DICTLIST');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (1241, '字典查看', 'DICTVIEW');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (1242, '字典编辑', 'DICTEDIT');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (1243, '字典删除', 'DICTDELETE');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (4091, '流程定义查询', 'PROCESSLIST');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (260, '用户查询', 'USERLIST');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (261, '部门查询', 'ORGLIST');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (262, '角色查询', 'ROLELIST');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (263, '权限查询', 'AUTHORITYLIST');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (264, '资源查询', 'RESOURCELIST');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (265, '菜单查询', 'MENULIST');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (1, '部门编辑', 'ORGEDIT');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (2, '部门查看', 'ORGVIEW');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (4, '部门删除', 'ORGDELETE');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (5, '菜单编辑', 'MENUEDIT');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (6, '菜单查看', 'MENUVIEW');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (8, '菜单删除', 'MENUDELETE');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (9, '角色编辑', 'ROLEEDIT');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (10, '角色查看', 'ROLEVIEW');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (12, '角色删除', 'ROLEDELETE');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (13, '权限编辑', 'AUTHORITYEDIT');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (14, '权限查看', 'AUTHORITYVIEW');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (16, '权限删除', 'AUTHORITYDELETE');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (17, '用户编辑', 'USEREDIT');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (18, '用户查看', 'USERVIEW');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (20, '用户删除', 'USERDELETE');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (21, '资源编辑', 'RESOURCEEDIT');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (22, '资源查看', 'RESOURCEVIEW');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (24, '资源删除', 'RESOURCEDELETE');

INSERT INTO sec_authority (ID, DESCRIPTION, NAME)
VALUES (4090, '待办任务', 'ACTIVETASK');

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (5320, 5310);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (1240, 1220);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (1243, 1223);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (1241, 1222);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (1242, 1221);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (1, 283);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (260, 240);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (261, 241);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (262, 242);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (263, 243);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (264, 244);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (265, 245);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (2, 271);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (4, 277);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (5, 287);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (6, 275);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (8, 281);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (9, 284);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (10, 272);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (12, 278);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (13, 285);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (14, 273);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (16, 279);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (17, 282);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (18, 270);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (20, 276);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (21, 286);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (22, 274);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (24, 280);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (4090, 2220);

INSERT INTO sec_authority_resource (AUTHORITY_ID, RESOURCE_ID)
VALUES (4091, 2230);

INSERT INTO sec_role (ID, DESCRIPTION, NAME)
VALUES (81, '系统管理员', 'Admin');

INSERT INTO sec_role (ID, DESCRIPTION, NAME)
VALUES (300, '普通用户', 'General');

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (300, 5320);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (300, 260);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (300, 261);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (300, 262);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (300, 263);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (300, 264);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (300, 265);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (300, 4090);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 5320);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 1240);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 1241);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 1242);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 1243);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 4091);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 260);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 261);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 262);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 263);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 264);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 265);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 1);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 2);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 4);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 5);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 6);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 8);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 9);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 10);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 12);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 13);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 14);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 16);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 17);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 18);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 20);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 21);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 22);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 24);

INSERT INTO sec_role_authority (ROLE_ID, AUTHORITY_ID)
VALUES (81, 4090);

INSERT INTO sec_user (ID, ADDRESS, AGE, EMAIL, ENABLED, FULLNAME, PASSWORD, SEX, TYPE, USERNAME, ORG, SALT)
VALUES (4700, '', NULL, '', '1', 'test', '04c9b465038988d643c5b65d487ecae219b68ac8', '1', NULL, 'test', NULL, '72c422eb62bffb05');

INSERT INTO sec_user (ID, ADDRESS, AGE, EMAIL, ENABLED, FULLNAME, PASSWORD, SEX, TYPE, USERNAME, ORG, SALT)
VALUES (2410, '', NULL, '', '1', '系统管理员', 'f9e1a0299c2570eb5942fbbda0b2a8ceb2ef9769', '1', NULL, 'admin', NULL, 'e97e0cea2389225f');

INSERT INTO sec_role_user (USER_ID, ROLE_ID)
VALUES (4700, 81);

INSERT INTO sec_role_user (USER_ID, ROLE_ID)
VALUES (2410, 81);

INSERT INTO conf_dictionary (ID, DESCRIPTION, NAME, CN_NAME)
VALUES (1360, '', 'yesNo', '是否');

INSERT INTO conf_dictionary (ID, DESCRIPTION, NAME, CN_NAME)
VALUES (1340, '', 'sex', '性别');

INSERT INTO conf_dictitem (ID, DESCRIPTION, NAME, ORDERBY, DICTIONARY, CODE)
VALUES (1415, '', '是', 1, 1360, '1');

INSERT INTO conf_dictitem (ID, DESCRIPTION, NAME, ORDERBY, DICTIONARY, CODE)
VALUES (1416, '', '否', 2, 1360, '2');

INSERT INTO conf_dictitem (ID, DESCRIPTION, NAME, ORDERBY, DICTIONARY, CODE)
VALUES (1380, '', '男', 1, 1340, '1');

INSERT INTO conf_dictitem (ID, DESCRIPTION, NAME, ORDERBY, DICTIONARY, CODE)
VALUES (1381, '', '女', 2, 1340, '2');

