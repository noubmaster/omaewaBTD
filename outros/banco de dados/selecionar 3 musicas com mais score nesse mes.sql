SELECT
	m.nomeMusica,
	m.idMusica,
	a.capa,
	a.idAlbum,
	a.nomeAlbum,
	ar.nomeArtista,
	ar.idArtista,
	count(*) as score
FROM
	score s,
	musica m,
	album a,
	participa p,
	artista ar
WHERE
	s.idMusicaScore = m.idMusica AND
	m.idAlbumMusica = a.idAlbum AND
	p.Musica_idMusica = m.idMusica AND
	p.Artista_idArtista = ar.idArtista AND
	p.papel = 'Intérprete' AND
	year(curdate()) = year(s.data) AND
	month(curdate()) = month(s.data)
GROUP BY
	m.idMusica
ORDER BY
	score DESC
LIMIT
	3;