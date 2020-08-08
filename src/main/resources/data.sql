INSERT INTO projet_6.comment (id, content, created_at, site_id, users_id)
VALUES (7, 'Site très agréable', '2020-08-07 16:59:46', 6, 1);
INSERT INTO projet_6.hibernate_sequence (next_val)
VALUES (14);
INSERT INTO projet_6.hibernate_sequence (next_val)
VALUES (14);
INSERT INTO projet_6.hibernate_sequence (next_val)
VALUES (14);
INSERT INTO projet_6.hibernate_sequence (next_val)
VALUES (14);
INSERT INTO projet_6.hibernate_sequence (next_val)
VALUES (14);
INSERT INTO projet_6.hibernate_sequence (next_val)
VALUES (14);
INSERT INTO projet_6.hibernate_sequence (next_val)
VALUES (14);
INSERT INTO projet_6.roles (id, name)
VALUES (1, 'ROLE_USER');
INSERT INTO projet_6.roles (id, name)
VALUES (2, 'ROLE_ADMIN');
INSERT INTO projet_6.site (id, adresse, contact, created_at, name, update_at, topo_id, users_id)
VALUES (6, 'Courchevel', 'Admin ', '2020-08-07 16:44:52', 'Courchevel', '2020-08-07 16:44:52', 5, 1);
INSERT INTO projet_6.site (id, adresse, contact, created_at, name, update_at, topo_id, users_id)
VALUES (11, '23 Blvd des pyrennées', 'Jean ', '2020-08-08 01:46:46', 'La Mongie Ouest', '2020-08-08 01:46:46', 9, 2);
INSERT INTO projet_6.site (id, adresse, contact, created_at, name, update_at, topo_id, users_id)
VALUES (12, '35 Allée des alpes', 'Michel', '2020-08-08 01:47:20', 'La Mongie Nord', '2020-08-08 01:47:20', 9, 2);
INSERT INTO projet_6.topo (id, available, created_at, description, lieux, name, official_topo, statut_public, update_at,
                           users_id)
VALUES (5, true, '2020-08-07 16:44:08', 'Topo Admin Alpes', 'Alpes', 'Topo Admin 01', true, true, '2020-08-07 16:44:08',
        1);
INSERT INTO projet_6.topo (id, available, created_at, description, lieux, name, official_topo, statut_public, update_at,
                           users_id)
VALUES (9, true, '2020-08-08 01:42:48', 'Topo de la Mongie', 'La Mongie', 'Pyrennées', false, false,
        '2020-08-08 01:42:48', 2);
INSERT INTO projet_6.topo (id, available, created_at, description, lieux, name, official_topo, statut_public, update_at,
                           users_id)
VALUES (10, true, '2020-08-08 01:44:01', 'Topo des Vosges', 'La Bresse & Co', 'Vosges', true, true,
        '2020-08-08 01:44:12', 2);
INSERT INTO projet_6.user_role (user_id, role_id)
VALUES (1, 2);
INSERT INTO projet_6.user_role (user_id, role_id)
VALUES (2, 1);
INSERT INTO projet_6.user_role (user_id, role_id)
VALUES (3, 1);
INSERT INTO projet_6.users (id, created_at, email, name, password, update_at)
VALUES (1, '2020-08-07 15:34:43', 'Admin@Admin.com', 'Admin',
        '$2a$10$RcpC/PrlQ.q42EcJqM6A.u.Am.nPzT0cwLq93VGUPPAS3TxHYCo22', '2020-08-07 15:34:43');
INSERT INTO projet_6.users (id, created_at, email, name, password, update_at)
VALUES (2, '2020-08-07 15:35:08', 'user1@user.com', 'User 1 ',
        '$2a$10$.lATbapsXf6WWr3UCgIOJOK7GlEmwwrLFxjLsE5dcTYbWe6jfjkn.', '2020-08-07 15:35:08');
INSERT INTO projet_6.users (id, created_at, email, name, password, update_at)
VALUES (3, '2020-08-07 15:35:28', 'user2@user.com', 'user 2',
        '$2a$10$ghd0Vam4S7a.X/FGXUnTSuoGrbGPqKekH7A4ChjzT3zbKa71u5AKW', '2020-08-07 15:35:28');
INSERT INTO projet_6.voie (id, created_at, difficulte, longueur, name, update_at, site_id)
VALUES (8, '2020-08-08 01:30:31', 'facile', 250, 'Courchevel Voie 1', '2020-08-08 01:30:31', 6);
INSERT INTO projet_6.voie (id, created_at, difficulte, longueur, name, update_at, site_id)
VALUES (13, '2020-08-08 01:47:50', 'facile', 120, 'Voie Easy', '2020-08-08 01:47:50', 11);