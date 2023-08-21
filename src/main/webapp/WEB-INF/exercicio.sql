CREATE DATABASE ex_views_union;
GO
USE ex_views_union;

CREATE TABLE motorista(
	codigo INT PRIMARY KEY NOT NULL,
	nome VARCHAR(40) NOT NULL,
	naturalidade VARCHAR(40) NOT NULL
)
GO
CREATE TABLE onibus(
	placa CHAR(7) PRIMARY KEY NOT NULL ,
	marca VARCHAR(15) NOT NULL,
	ano INT NOT NULL,
	descricao VARCHAR(20) NOT NULL
)
GO
CREATE TABLE viagem(
	codigo INT PRIMARY KEY NOT NULL,
	onibus CHAR(7) NOT NULL,
	motorista INT NOT NULL,
	hora_saida INT NOT NULL CHECK(hora_saida >= 0),
	hora_chegada INT NOT NULL CHECK(hora_chegada >= 0),
	partida VARCHAR(40) NOT NULL,
	destino VARCHAR(40) NOT NULL,
	FOREIGN KEY(onibus) REFERENCES onibus(placa),
	FOREIGN KEY(motorista) REFERENCES motorista(codigo))

SELECT CAST(codigo AS VARCHAR), nome FROM motorista
UNION
SELECT placa, marca FROM onibus

CREATE VIEW v_motorista AS (
SELECT CAST(codigo AS VARCHAR) AS codigo, nome FROM motorista
UNION
SELECT placa, marca FROM onibus
)

SELECT viagem.codigo, motorista.nome AS 'Motorista',
SUBSTRING(onibus.placa,1,3) + ' - ' + SUBSTRING(onibus.placa,4,4) AS Placa,
onibus.marca,
onibus.ano,
onibus.descricao
FROM viagem, onibus, motorista
WHERE viagem.motorista = motorista.codigo
AND viagem.onibus = onibus.placa


SELECT viagem.codigo,
motorista.nome,
SUBSTRING(onibus.placa,1,3) + ' - ' + SUBSTRING(onibus.placa,4,4) AS Placa,
SUBSTRING(CAST(viagem.hora_saida AS VARCHAR), 1, 2) + ': 00' AS hora_saida,
SUBSTRING(CAST(viagem.hora_chegada AS VARCHAR), 1, 2) + ':00' AS hora_chegada,
viagem.partida,
viagem.destino
FROM viagem, onibus, motorista
WHERE viagem.motorista = motorista.codigo
AND viagem.onibus = onibus.placa

CREATE VIEW v_descricao 
AS
(
SELECT viagem.codigo, motorista.nome AS 'Motorista',
SUBSTRING(onibus.placa,1,3) + ' - ' + SUBSTRING(onibus.placa,4,4) AS Placa,
onibus.marca,
onibus.ano,
onibus.descricao
FROM viagem, onibus, motorista
WHERE viagem.motorista = motorista.codigo
AND viagem.onibus = onibus.placa
)

CREATE VIEW v_descricao_viagem
AS
(
SELECT viagem.codigo,
motorista.nome,
SUBSTRING(onibus.placa,1,3) + ' - ' + SUBSTRING(onibus.placa,4,4) AS Placa,
SUBSTRING(CAST(viagem.hora_saida AS VARCHAR), 1, 2) + ': 00' AS hora_saida,
SUBSTRING(CAST(viagem.hora_chegada AS VARCHAR), 1, 2) + ':00' AS hora_chegada,
viagem.partida,
viagem.destino
FROM viagem, onibus, motorista
WHERE viagem.motorista = motorista.codigo
AND viagem.onibus = onibus.placa
)
