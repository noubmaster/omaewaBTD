SELECT
	m.nomeMusica,
	if(s.idScore is null,0,count(*)) as score
FROM
	musica m
LEFT JOIN
	score s ON m.idMusica = s.idMusicaScore
GROUP BY
	m.idMusica
ORDER BY
	score DESC