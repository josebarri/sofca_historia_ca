CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- Drop existing tables if needed
DROP TABLE IF EXISTS Dueno CASCADE;
DROP TABLE IF EXISTS mascota CASCADE;
DROP TABLE IF EXISTS paciente CASCADE;
DROP TABLE IF EXISTS Tipo_identificacion CASCADE;
DROP TABLE IF EXISTS ubicacion CASCADE;
DROP TABLE IF EXISTS usuarios CASCADE;

-- Create tables with UUIDs as primary keys
CREATE TABLE Tipo_identificacion (
                                     id_identificacion UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                                     tipo varchar(50) NOT NULL
);

CREATE TABLE ubicacion (
                           id_ubicacion UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                           ciudad varchar(50),
                           direccion varchar(50)
);

CREATE TABLE Dueno (
                       id_dueno UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                       nombre_dueno varchar(50),
                       apellido_dueno varchar(50),
                       telefono varchar(50),
                       num_identificacion varchar(50),
                       identificacion UUID,
                       id_ubicacion UUID,
                       CONSTRAINT fk_identificacion FOREIGN KEY (identificacion) REFERENCES Tipo_identificacion(id_identificacion),
                       CONSTRAINT fk_ubicacion FOREIGN KEY (id_ubicacion) REFERENCES ubicacion(id_ubicacion)
);

CREATE TABLE mascota (
                         id_mascota UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                         fnac_mascota date,
                         nombre_mascota varchar(50),
                         raza varchar(50),
                         especie varchar(50),
                         id_dueno UUID, -- Añadido para mantener la relación con Dueño
                         CONSTRAINT fk_dueno_mascota FOREIGN KEY (id_dueno) REFERENCES Dueno(id_dueno)
);

CREATE TABLE paciente (
                          id_paciente UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                          fecha_registro timestamp DEFAULT CURRENT_TIMESTAMP,
                          id_mascota UUID,
                          CONSTRAINT fk_mascota FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota)
);

CREATE TABLE usuarios (
                         id_user UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                         nombre varchar(50),
                         correo varchar(50),
                         password varchar(50)
);