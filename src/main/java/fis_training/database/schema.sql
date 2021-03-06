CREATE TABLE `criminal_case` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `create_at` datetime(6) DEFAULT NULL,
                                 `modified_at` datetime(6) DEFAULT NULL,
                                 `version` int DEFAULT NULL,
                                 `detailed_description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                 `notes` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                 `number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                 `short_description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                 `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                 `case_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                 `lead_investigator` bigint NOT NULL,
                                 PRIMARY KEY (`id`),
                                 KEY `FKkjewmop105nykj0vieyqxjdue` (`lead_investigator`),
                                 CONSTRAINT `FKkjewmop105nykj0vieyqxjdue` FOREIGN KEY (`lead_investigator`) REFERENCES `detective` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `detective` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `create_at` datetime(6) DEFAULT NULL,
                             `modified_at` datetime(6) DEFAULT NULL,
                             `version` int DEFAULT NULL,
                             `armed` bit(1) DEFAULT NULL,
                             `badge_number` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                             `rank` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             `person_id` bigint DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `UK_4y29i3x2ffrsqka03tevdsice` (`badge_number`),
                             KEY `FKc938d75vilp7eohdshlknj66l` (`person_id`),
                             CONSTRAINT `FKc938d75vilp7eohdshlknj66l` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `evidence` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `create_at` datetime(6) DEFAULT NULL,
                            `modified_at` datetime(6) DEFAULT NULL,
                            `version` int DEFAULT NULL,
                            `archived` bit(1) DEFAULT NULL,
                            `item_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `notes` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `case_fk` bigint NOT NULL,
                            `storage_fk` bigint NOT NULL,
                            PRIMARY KEY (`id`),
                            KEY `FKd0lrrh25rt0hcq4wmjxdrpalb` (`case_fk`),
                            KEY `FKewfyrlt0wk4n7yruuk8eixq9p` (`storage_fk`),
                            CONSTRAINT `FKd0lrrh25rt0hcq4wmjxdrpalb` FOREIGN KEY (`case_fk`) REFERENCES `criminal_case` (`id`),
                            CONSTRAINT `FKewfyrlt0wk4n7yruuk8eixq9p` FOREIGN KEY (`storage_fk`) REFERENCES `storage` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `person` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `create_at` datetime(6) DEFAULT NULL,
                          `modified_at` datetime(6) DEFAULT NULL,
                          `version` int DEFAULT NULL,
                          `first_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                          `hiring_date` datetime(6) NOT NULL,
                          `last_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                          `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                          `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `storage` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `create_at` datetime(6) DEFAULT NULL,
                           `modified_at` datetime(6) DEFAULT NULL,
                           `version` int DEFAULT NULL,
                           `location` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                           `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `track_entry` (
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `create_at` datetime(6) DEFAULT NULL,
                               `modified_at` datetime(6) DEFAULT NULL,
                               `version` int DEFAULT NULL,
                               `action` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                               `date` datetime(6) DEFAULT NULL,
                               `reason` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                               `detective_fk` bigint NOT NULL,
                               `evidence_fk` bigint NOT NULL,
                               PRIMARY KEY (`id`),
                               KEY `FKdh1gext60nljqhw71x2yof7mt` (`detective_fk`),
                               KEY `FKhf235yp7v4aq5vdxmibub9j66` (`evidence_fk`),
                               CONSTRAINT `FKdh1gext60nljqhw71x2yof7mt` FOREIGN KEY (`detective_fk`) REFERENCES `detective` (`id`),
                               CONSTRAINT `FKhf235yp7v4aq5vdxmibub9j66` FOREIGN KEY (`evidence_fk`) REFERENCES `evidence` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `working_detective_case` (
                                          `detective_id` bigint NOT NULL,
                                          `case_id` bigint NOT NULL,
                                          PRIMARY KEY (`case_id`,`detective_id`),
                                          KEY `FKogok3ud3eo9p1taswnd5e14j2` (`detective_id`),
                                          CONSTRAINT `FKogok3ud3eo9p1taswnd5e14j2` FOREIGN KEY (`detective_id`) REFERENCES `detective` (`id`),
                                          CONSTRAINT `FKtjlq667q57n2irxj55tva1bbl` FOREIGN KEY (`case_id`) REFERENCES `criminal_case` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;