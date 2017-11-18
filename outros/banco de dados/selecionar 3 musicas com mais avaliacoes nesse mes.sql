SELECT
	m.nomeMusica,
	m.idMusica,
	a.capa,
	a.idAlbum,
	a.nomeAlbum,
	ar.nomeArtista,
	ar.idArtista,
	count(*) as avaliacao
FROM
	avaliacao av,
	musica m,
	album a,
	participa p,
	artista ar
WHERE
	av.idMusicaAvaliacao = m.idMusica AND
	m.idAlbumMusica = a.idAlbum AND
	p.Musica_idMusica = m.idMusica AND
	p.Artista_idArtista = ar.idArtista AND
	p.papel = 'Intérprete' AND
	year(curdate()) = year(av.data) AND
	month(curdate()) = month(av.data)
GROUP BY
	m.idMusica
ORDER BY
	avaliacao DESC
LIMIT
	3;