SELECT
	m.nomeMusica,
	count(*) as score
FROM
	score s,
	musica m
WHERE
	s.idMusicaScore = m.idMusica
GROUP BY
	m.idMusica
ORDER BY
	score DESC