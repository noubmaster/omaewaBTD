SELECT
	m.nomeMusica,
	count(*) as score
FROM
	score s,
	musica m
WHERE
	s.idMusicaScore = m.idMusica AND
	year(curdate()) = year(s.data) AND
	month(curdate()) = month(s.data)
GROUP BY
	m.idMusica
ORDER BY
	score DESC;
