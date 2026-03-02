INSERT INTO POLIZA (TIPO, ESTADO, CANON_MENSUAL, PORCENTAJEIPC, FECHA_INICIO, FECHA_FIN, TOMADOR, ASEGURADO, BENEFICIARIO) VALUES
/*COLECTIVAS ACTIVAS (1-10)*/
('COLECTIVA','ACTIVA',1500000,0.08,'2024-01-01','2024-12-31','Inmobiliaria Centro','Arrendatarios Centro','Propietarios Centro'),
('COLECTIVA','ACTIVA',1800000,0.07,'2024-02-01','2025-01-31','Gestión Urbana SAS','Arrendatarios Urbana','Propietarios Urbana'),
('COLECTIVA','ACTIVA',2000000,0.06,'2024-03-01','2025-02-28','Grupo Habitat','Arrendatarios Habitat','Propietarios Habitat'),
('COLECTIVA','ACTIVA',1700000,0.05,'2024-04-01','2025-03-31','Inmobiliaria Norte','Arrendatarios Norte','Propietarios Norte'),
('COLECTIVA','ACTIVA',2100000,0.08,'2024-05-01','2025-04-30','Constructora Capital','Arrendatarios Capital','Propietarios Capital'),
('COLECTIVA','ACTIVA',1400000,0.05,'2024-06-01','2025-05-31','Inversiones Andina','Arrendatarios Andina','Propietarios Andina'),
('COLECTIVA','ACTIVA',2200000,0.09,'2024-07-01','2025-06-30','Administración Plaza','Arrendatarios Plaza','Propietarios Plaza'),
('COLECTIVA','ACTIVA',1600000,0.06,'2024-08-01','2025-07-31','Red Inmobiliaria','Arrendatarios Red','Propietarios Red'),
('COLECTIVA','ACTIVA',1950000,0.07,'2024-09-01','2025-08-31','Corporación Urbana','Arrendatarios Urbana2','Propietarios Urbana2'),
('COLECTIVA','ACTIVA',1750000,0.05,'2024-10-01','2025-09-30','Soluciones Inmobiliarias','Arrendatarios Sol','Propietarios Sol'),

/*COLECTIVAS CANCELADAS (11-15)*/
('COLECTIVA','CANCELADA',1900000,0.07,'2023-01-01','2023-12-31','Torre Norte','Arrendatarios TN','Propietarios TN'),
('COLECTIVA','CANCELADA',2100000,0.08,'2023-02-01','2024-01-31','Edificio Central','Arrendatarios EC','Propietarios EC'),
('COLECTIVA','CANCELADA',1800000,0.06,'2023-03-01','2024-02-28','Conjunto Verde','Arrendatarios CV','Propietarios CV'),
('COLECTIVA','CANCELADA',1600000,0.05,'2023-04-01','2024-03-31','Residencial Sur','Arrendatarios RS','Propietarios RS'),
('COLECTIVA','CANCELADA',2000000,0.07,'2023-05-01','2024-04-30','Parque Residencial','Arrendatarios PR','Propietarios PR'),

/*COLECTIVAS RENOVADAS (16-20)*/
('COLECTIVA','RENOVADA',1550000,0.06,'2023-06-01','2024-05-31','InmoRenovada 1','Arrendatarios R1','Propietarios R1'),
('COLECTIVA','RENOVADA',1650000,0.06,'2023-07-01','2024-06-30','InmoRenovada 2','Arrendatarios R2','Propietarios R2'),
('COLECTIVA','RENOVADA',1750000,0.07,'2023-08-01','2024-07-31','InmoRenovada 3','Arrendatarios R3','Propietarios R3'),
('COLECTIVA','RENOVADA',1850000,0.08,'2023-09-01','2024-08-31','InmoRenovada 4','Arrendatarios R4','Propietarios R4'),
('COLECTIVA','RENOVADA',1950000,0.05,'2023-10-01','2024-09-30','InmoRenovada 5','Arrendatarios R5','Propietarios R5'),

/*INDIVIDUALES ACTIVAS (21-25)*/
('INDIVIDUAL','ACTIVA',900000,0.05,'2024-01-01','2024-12-31','Juan Pérez','Juan Pérez','Carlos Gómez'),
('INDIVIDUAL','ACTIVA',850000,0.04,'2024-02-01','2025-01-31','Laura Díaz','Laura Díaz','Pedro Ruiz'),
('INDIVIDUAL','ACTIVA',780000,0.03,'2024-03-01','2025-02-28','Andrés Castro','Andrés Castro','María León'),
('INDIVIDUAL','ACTIVA',820000,0.04,'2024-04-01','2025-03-31','Sofía Herrera','Sofía Herrera','Diego Molina'),
('INDIVIDUAL','ACTIVA',950000,0.05,'2024-05-01','2025-04-30','Camila Torres','Camila Torres','Jorge Pardo'),

/*INDIVIDUALES CANCELADAS (26-28)*/
('INDIVIDUAL','CANCELADA',700000,0.03,'2023-06-01','2024-05-31','Miguel Rojas','Miguel Rojas','Ana Pérez'),
('INDIVIDUAL','CANCELADA',720000,0.03,'2023-07-01','2024-06-30','Daniela Cruz','Daniela Cruz','Luis Soto'),
('INDIVIDUAL','CANCELADA',680000,0.02,'2023-08-01','2024-07-31','Esteban Ruiz','Esteban Ruiz','Paola Castro'),

/*INDIVIDUALES RENOVADAS (29-30)*/
('INDIVIDUAL','RENOVADA',800000,0.04,'2023-09-01','2024-08-31','Valeria López','Valeria López','Andrés Ríos'),
('INDIVIDUAL','RENOVADA',880000,0.05,'2023-10-01','2024-09-30','Natalia Gómez','Natalia Gómez','Felipe Díaz');


INSERT INTO RIESGO (DESCRIPCION, ESTADO, POLIZA_ID) VALUES
/*COLECTIVAS ACTIVAS*/
('Incendio estructural','ACTIVO',1),
('Inundación','ACTIVO',1),
('Robo zonas comunes','ACTIVO',1),
('Daños eléctricos','ACTIVO',3),
('Vandalismo','ACTIVO',4),
('Fenómenos naturales','ACTIVO',5),
('Daños estructurales','ACTIVO',6),
('Incendio','ACTIVO',7),
('Humedad','ACTIVO',8),
('Filtraciones','ACTIVO',9),
('Daños terceros','ACTIVO',10),

/*COLECTIVAS CANCELADAS*/
('Incendio','CANCELADO',11),
('Inundación','CANCELADO',12),
('Robo','CANCELADO',13),
('Daños eléctricos','CANCELADO',14),
('Vandalismo','CANCELADO',15),

/*COLECTIVAS RENOVADAS*/
('Incendio','ACTIVO',16),
('Inundación','ACTIVO',17),
('Robo','ACTIVO',18),
('Daños eléctricos','ACTIVO',19),
('Vandalismo','ACTIVO',20),

/*INDIVIDUALES (solo 1 riesgo cada una)*/
('Incumplimiento pago','ACTIVO',21),
('Incumplimiento pago','ACTIVO',22),
('Incumplimiento pago','ACTIVO',23),
('Incumplimiento pago','ACTIVO',24),
('Incumplimiento pago','ACTIVO',25),
('Incumplimiento pago','CANCELADO',26),
('Incumplimiento pago','CANCELADO',27),
('Incumplimiento pago','CANCELADO',28),
('Incumplimiento pago','ACTIVO',29),
('Incumplimiento pago','ACTIVO',30);
