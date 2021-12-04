use escuelas;
#select*from facultad
INSERT INTO `escuelas`.`facultad`
(
`descripcion`,
`fecha_registro`)
VALUES
(
'HUMANIDADES',
'2012-09-21');

INSERT INTO `escuelas`.`facultad`
(
`descripcion`,
`fecha_registro`)
VALUES
(
'CIENCIAS',
'2013-09-21');

INSERT INTO `escuelas`.`facultad`
(
`descripcion`,
`fecha_registro`)
VALUES
(
'COMUNICACIONES',
'2014-09-21');
INSERT INTO `escuelas`.`facultad`
(
`descripcion`,
`fecha_registro`)
VALUES
(
'ARQUITECTURA',
'2015-09-21');

INSERT INTO `escuelas`.`escuela`
(
`cant_alumnos`,
`clasificacion`,
`licenciada`,
`recurso_fiscal`,
`fecha_registro`,
`nombre`,
`facultad_id`)
VALUES
(
3,
3,
true,
3.4,
'2015-09-21',
'Escuela a',
1);

INSERT INTO `escuelas`.`escuela`
(
`cant_alumnos`,
`clasificacion`,
`licenciada`,
`recurso_fiscal`,
`fecha_registro`,
`nombre`,
`facultad_id`)
VALUES
(
4,
4,
true,
4.5,
'2016-09-21',
'Escuela b',
2);

INSERT INTO `escuelas`.`escuela`
(
`cant_alumnos`,
`clasificacion`,
`licenciada`,
`recurso_fiscal`,
`fecha_registro`,
`nombre`,
`facultad_id`)
VALUES
(
4,
4,
true,
4.5,
'2016-09-21',
'Escuela c',
3);

INSERT INTO `escuelas`.`escuela`
(
`cant_alumnos`,
`clasificacion`,
`licenciada`,
`recurso_fiscal`,
`fecha_registro`,
`nombre`,
`facultad_id`)
VALUES
(
4,
4,
true,
5.7,
'2017-09-21',
'Escuela d',
4);




