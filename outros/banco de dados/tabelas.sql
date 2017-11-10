-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.7.11-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para memes
DROP DATABASE IF EXISTS `memes`;
CREATE DATABASE IF NOT EXISTS `memes` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `memes`;


-- Copiando estrutura para tabela memes.album
DROP TABLE IF EXISTS `album`;
CREATE TABLE IF NOT EXISTS `album` (
  `idAlbum` int(11) NOT NULL AUTO_INCREMENT,
  `nomeAlbum` varchar(45) NOT NULL,
  `ano` year(4) NOT NULL,
  `capa` text NOT NULL,
  PRIMARY KEY (`idAlbum`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela memes.album: ~7 rows (aproximadamente)
DELETE FROM `album`;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` (`idAlbum`, `nomeAlbum`, `ano`, `capa`) VALUES
	(3, '1984', '1984', 'https://img.discogs.com/VEBEIZHNsg9rancLKjBsl5_lVYI=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-949843-1350958465-3823.jpeg.jpg'),
	(5, 'Van Halen II', '1979', 'https://img.discogs.com/0vyzO5jgJb3jZ_zvZ-Jv6Z_M8Gg=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-894184-1329786699.jpeg.jpg'),
	(6, 'Van Halen', '1978', 'https://img.discogs.com/nZg_3NxHuHJDDXdS8dNaPh_-uDc=/fit-in/500x500/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-1466675-1221871159.jpeg.jpg'),
	(7, 'Off the wall', '1979', 'https://img.discogs.com/kf1Lr0secZdOD7FCv-YvAu8ZEvk=/fit-in/600x597/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-120096-1374721428-4864.jpeg.jpg'),
	(8, 'Thriller', '1982', 'https://img.discogs.com/XKsX69yETlBSb_FNVZ9rnyS-3pU=/fit-in/600x593/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-6898470-1429038259-1930.jpeg.jpg'),
	(9, 'News of the World', '1977', 'https://img.discogs.com/Jiwtt1dIc_1gFTSFBafv7kgXEK4=/fit-in/600x606/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-475599-1454715265-7842.jpeg.jpg'),
	(10, 'War', '1983', 'https://img.discogs.com/azJ76FI4uR51Y0Lp7TnKkLR4gno=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-11052113-1508951794-5928.jpeg.jpg');
/*!40000 ALTER TABLE `album` ENABLE KEYS */;


-- Copiando estrutura para tabela memes.artista
DROP TABLE IF EXISTS `artista`;
CREATE TABLE IF NOT EXISTS `artista` (
  `idArtista` int(11) NOT NULL AUTO_INCREMENT,
  `nomeArtista` varchar(45) NOT NULL,
  `foto` text,
  PRIMARY KEY (`idArtista`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela memes.artista: ~11 rows (aproximadamente)
DELETE FROM `artista`;
/*!40000 ALTER TABLE `artista` DISABLE KEYS */;
INSERT INTO `artista` (`idArtista`, `nomeArtista`, `foto`) VALUES
	(1, 'Van Halen', 'https://img.discogs.com/-8n5pk_3i728ntFAf7HrHKj7MrY=/600x588/smart/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/A-94066-1402213359-9569.jpeg.jpg'),
	(2, 'Queen', 'https://img.discogs.com/kBO17UiZ1nch9-xu2HT6ZmQIlZ0=/595x600/smart/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/A-81013-1211978659.jpeg.jpg'),
	(4, 'Michael Jackson', 'https://img.discogs.com/6PFlDzZtBmhq2buIAWnf73zsDAg=/600x607/smart/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/A-15885-1506759724-8583.jpeg.jpg'),
	(5, 'U2', 'https://img.discogs.com/hz0Gf1naowjkOwMJI0Kmnyfb7dQ=/600x600/smart/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/A-6520-1405762997-2378.jpeg.jpg'),
	(6, 'The Kinks', 'https://img.discogs.com/y-0RQ44nawniMMTvQU2frrIv8sg=/600x446/smart/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/A-94078-1394543710-1099.jpeg.jpg'),
	(7, 'Paul McCartney', 'https://img.discogs.com/lEqBmIw-C592XEgCX50dEWIiZJA=/567x703/smart/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/A-35301-1319382618.jpeg.jpg'),
	(8, 'Rod Temperton', 'https://img.discogs.com/9RddHOTerSOKpNEVqFCjd5dpwwo=/189x198/smart/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/A-148175-1173619086.jpeg.jpg'),
	(9, 'Quincy Jones', 'https://img.discogs.com/i32jRUfdZ_uvQvUE8XDN80ptGN0=/600x491/smart/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/A-17546-1451557657-2544.jpeg.jpg'),
	(10, 'James Ingram', 'https://img.discogs.com/YrmO92XAfeEvXS5kDN3ObmrBFzs=/600x747/smart/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/A-4800-1459188983-7175.jpeg.jpg'),
	(11, 'Steve Porcaro', 'https://img.discogs.com/PAGZsD1gZgURcwpsUcHjH3Qx5jA=/369x600/smart/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/A-299163-1146652884.jpeg.jpg'),
	(12, 'John Bettis', 'https://img.discogs.com/KrQ2A-tZMQUjKv71jagW_kkwSz0=/168x168/smart/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/A-617010-1328648662.jpeg.jpg');
/*!40000 ALTER TABLE `artista` ENABLE KEYS */;


-- Copiando estrutura para tabela memes.avaliacao
DROP TABLE IF EXISTS `avaliacao`;
CREATE TABLE IF NOT EXISTS `avaliacao` (
  `idAvaliacao` int(11) NOT NULL AUTO_INCREMENT,
  `nota` int(11) NOT NULL,
  `comentario` varchar(200) NOT NULL,
  `revisao` tinyint(4) DEFAULT NULL,
  `idMusicaAvaliacao` int(11) NOT NULL,
  `idUsuarioAvaliacao` int(11) NOT NULL,
  PRIMARY KEY (`idAvaliacao`),
  KEY `fk_Avaliacao_Musica1_idx` (`idMusicaAvaliacao`),
  KEY `fk_Avaliacao_Usuario1_idx` (`idUsuarioAvaliacao`),
  CONSTRAINT `fk_Avaliacao_Musica1` FOREIGN KEY (`idMusicaAvaliacao`) REFERENCES `musica` (`idMusica`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Avaliacao_Usuario1` FOREIGN KEY (`idUsuarioAvaliacao`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela memes.avaliacao: ~46 rows (aproximadamente)
DELETE FROM `avaliacao`;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
INSERT INTO `avaliacao` (`idAvaliacao`, `nota`, `comentario`, `revisao`, `idMusicaAvaliacao`, `idUsuarioAvaliacao`) VALUES
	(3, 1, '1', 1, 2, 19),
	(4, 100000, 'melhor musica ja criada pelo ser humano', 0, 1, 90),
	(6, 4, 'aaaaa', 0, 1, 15),
	(7, 5, 'eu amo michael jackson <3', 0, 12, 15),
	(8, 4, 'asd', 0, 12, 15),
	(9, 1, 'musicas muito dificil de tocar na bateria', 0, 11, 15),
	(10, 5, 'a', 0, 12, 15),
	(11, 3, 'aa', 0, 12, 15),
	(12, 3, 'a', 0, 12, 15),
	(13, 4, 'aa', 0, 12, 15),
	(17, 4, 'asd', 0, 2, 15),
	(18, 3, 'asdasd', 0, 2, 15),
	(19, 4, 'asdasdada', 0, 2, 15),
	(20, 4, 'asdasdasd', 0, 2, 15),
	(21, 4, 'dw', 0, 2, 15),
	(22, 4, 'dsadawd', 0, 2, 15),
	(23, 4, 'dasdasdad', 0, 2, 15),
	(24, 4, 'asdasdad', 0, 2, 15),
	(25, 5, 'asdasd', 0, 2, 15),
	(26, 5, 'fasfdasdf', 0, 2, 15),
	(27, 1, 'wowowowowow', 0, 2, 15),
	(28, 4, 'asdasd', 0, 2, 15),
	(29, 4, 'asdasdasda', 0, 1, 15),
	(30, 4, 'asdasdasda', 0, 1, 15),
	(31, 4, 'asdasdasda', 0, 1, 15),
	(32, 4, 'asdasdasda', 0, 1, 15),
	(33, 4, 'asdasdasda', 0, 1, 15),
	(34, 5, 'asdasdasd', 0, 1, 15),
	(35, 4, 'asdasd', 0, 11, 15),
	(36, 5, 'dsasdsasd', 0, 11, 15),
	(37, 5, 'asdf', 0, 11, 15),
	(38, 2, 'asd', 0, 11, 15),
	(39, 3, 'asdasd', 0, 11, 15),
	(40, 3, 'asdasd', 0, 11, 15),
	(41, 3, 'asdasd', 0, 11, 15),
	(42, 3, 'asdasd', 0, 11, 15),
	(43, 3, 'asdasd', 0, 11, 15),
	(44, 3, 'asdasd', 0, 11, 15),
	(45, 3, 'asdasd', 0, 11, 15),
	(46, 3, 'asdasd', 0, 11, 15),
	(47, 3, 'asdasd', 0, 11, 15),
	(48, 3, 'asdasd', 0, 11, 15),
	(49, 3, 'asdasd', 0, 11, 15),
	(50, 0, 'asd', 0, 1, 90),
	(51, 5, 'asd', 0, 1, 90),
	(52, 5, 'asd', 0, 1, 15);
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;


-- Copiando estrutura para tabela memes.composicao
DROP TABLE IF EXISTS `composicao`;
CREATE TABLE IF NOT EXISTS `composicao` (
  `Artista_idArtista` int(11) NOT NULL,
  `Musica_idMusica` int(11) NOT NULL,
  PRIMARY KEY (`Artista_idArtista`,`Musica_idMusica`),
  KEY `fk_Artista_has_Musica_Musica1_idx` (`Musica_idMusica`),
  KEY `fk_Artista_has_Musica_Artista1_idx` (`Artista_idArtista`),
  CONSTRAINT `fk_Artista_has_Musica_Artista1` FOREIGN KEY (`Artista_idArtista`) REFERENCES `artista` (`idArtista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Artista_has_Musica_Musica1` FOREIGN KEY (`Musica_idMusica`) REFERENCES `musica` (`idMusica`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela memes.composicao: ~20 rows (aproximadamente)
DELETE FROM `composicao`;
/*!40000 ALTER TABLE `composicao` DISABLE KEYS */;
INSERT INTO `composicao` (`Artista_idArtista`, `Musica_idMusica`) VALUES
	(1, 1),
	(2, 2),
	(5, 11),
	(4, 12),
	(1, 13),
	(1, 14),
	(1, 15),
	(1, 16),
	(1, 17),
	(1, 18),
	(1, 20),
	(1, 21),
	(4, 22),
	(8, 23),
	(4, 24),
	(11, 27),
	(12, 27),
	(9, 28),
	(10, 28),
	(8, 29);
/*!40000 ALTER TABLE `composicao` ENABLE KEYS */;


-- Copiando estrutura para tabela memes.genero
DROP TABLE IF EXISTS `genero`;
CREATE TABLE IF NOT EXISTS `genero` (
  `idGenero` int(11) NOT NULL AUTO_INCREMENT,
  `nomeGenero` varchar(45) NOT NULL,
  PRIMARY KEY (`idGenero`)
) ENGINE=InnoDB AUTO_INCREMENT=271 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela memes.genero: ~50 rows (aproximadamente)
DELETE FROM `genero`;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` (`idGenero`, `nomeGenero`) VALUES
	(65, 'Rock'),
	(218, 'Rock music'),
	(219, 'Hip hop music'),
	(220, 'Blues'),
	(221, 'Folk music'),
	(223, 'Rapping'),
	(224, 'Pop'),
	(225, 'Rhythm and blues'),
	(226, 'Singing'),
	(227, 'Country music'),
	(228, 'Punk rock'),
	(229, 'Classical music'),
	(231, 'Electronic dance music'),
	(232, 'Alternative rock'),
	(233, 'Heavy metal'),
	(234, 'Reggae'),
	(235, 'Classical period'),
	(236, 'Soul music '),
	(237, 'Instrumental '),
	(238, 'Opera '),
	(239, 'Disco '),
	(240, 'Grunge '),
	(241, 'World music '),
	(242, 'Techno '),
	(243, 'Rock and roll '),
	(244, 'Hard rock '),
	(245, 'Independent music '),
	(246, 'Orchestra '),
	(247, 'Funk '),
	(248, 'Music of Latin America '),
	(249, 'Music of the United States '),
	(250, 'New wave '),
	(251, 'Ska '),
	(252, 'Gospel music '),
	(253, 'Progressive rock '),
	(254, 'Electro '),
	(255, 'Dance music '),
	(256, 'Ballad '),
	(257, 'Indie rock '),
	(258, 'Thrash metal '),
	(260, 'Dubstep '),
	(261, 'House music '),
	(262, 'Hardcore punk '),
	(263, 'Big band '),
	(264, 'Psychedelic rock '),
	(265, 'Folk rock '),
	(267, 'Blues rock '),
	(268, 'Pop punk '),
	(269, 'Country pop'),
	(270, 'Metal');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;


-- Copiando estrutura para tabela memes.musica
DROP TABLE IF EXISTS `musica`;
CREATE TABLE IF NOT EXISTS `musica` (
  `idMusica` int(11) NOT NULL AUTO_INCREMENT,
  `nomeMusica` varchar(45) NOT NULL,
  `score` float NOT NULL DEFAULT '0',
  `letra` text NOT NULL,
  `faixa` int(11) DEFAULT NULL,
  `idAlbumMusica` int(11) NOT NULL,
  `idGeneroMusica` int(11) NOT NULL,
  PRIMARY KEY (`idMusica`),
  KEY `fk_Musica_Album1_idx` (`idAlbumMusica`),
  KEY `fk_Musica_Genero1_idx` (`idGeneroMusica`),
  CONSTRAINT `idAlbumMusica` FOREIGN KEY (`idAlbumMusica`) REFERENCES `album` (`idAlbum`),
  CONSTRAINT `idGeneroMusica` FOREIGN KEY (`idGeneroMusica`) REFERENCES `genero` (`idGenero`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela memes.musica: ~21 rows (aproximadamente)
DELETE FROM `musica`;
/*!40000 ALTER TABLE `musica` DISABLE KEYS */;
INSERT INTO `musica` (`idMusica`, `nomeMusica`, `score`, `letra`, `faixa`, `idAlbumMusica`, `idGeneroMusica`) VALUES
	(1, 'Jump', 10003, 'I get up, and nothing gets me down.\r\nYou got it tough. I\'ve seen the toughest all around.\r\nAnd I know, baby, just how you feel.\r\nYou\'ve got to roll with the punches to get to what\'s real\r\nOh can\'t you see me standing here,\r\nI\'ve got my back against the record machine\r\nI ain\'t the worst that you\'ve seen.\r\nOh can\'t you see what I mean?\r\nMight as well jump. Jump!\r\nMight as well jump.\r\nGo ahead, jump. Jump!\r\nGo ahead, jump.\r\nAaa-ohh Hey you! Who said that?\r\nBaby how you been?\r\nYou say you don\'t know, you won\'t know until you begin.\r\nWell can\'t you see me standing here,\r\nI\'ve got my back against the record machine\r\nI ain\'t the worst that you\'ve seen.\r\nOh can\'t you see what I mean?\r\nMight as well jump. Jump!\r\nGo ahead, jump.\r\nMight as well jump. Jump!\r\nGo ahead, jump.\r\n\r\n[Guitar solo]\r\n\r\n[Keyboard solo]\r\n\r\nMight as well jump. Jump!\r\nGo ahead, jump.\r\nGet it and jump. Jump!\r\nGo ahead, jump.', 2, 3, 244),
	(2, 'We Are The Champions', 2, 'I\'ve paid my dues\r\nTime after time\r\nI\'ve done my sentence\r\nBut committed no crime\r\n\r\nAnd bad mistakes\r\nI\'ve made a few\r\nI\'ve had my share of sand\r\nKicked in my face\r\nBut I\'ve come through\r\nAnd we mean to go on and on and on and on\r\n\r\nWe are the champions, my friends\r\nAnd we\'ll keep on fighting\r\n\'Till the end\r\nWe are the champions\r\nWe are the champions\r\nNo time for losers\r\n\'Cause we are the champions of the world\r\n\r\nI\'ve taken my bows\r\nAnd my curtain calls\r\nYou brought me fame and fortune\r\nAnd everything that goes with it\r\nI thank you all\r\n\r\nBut it\'s been no bed of roses\r\nNo pleasure cruise\r\nI consider it a challenge before\r\nThe whole human race\r\nAnd I ain\'t gonna lose\r\nAnd we mean to go on and on and on and on\r\n\r\nWe are the champions, my friends\r\nAnd we\'ll keep on fighting\r\n\'Till the end\r\nWe are the champions\r\nWe are the champions\r\nNo time for losers\r\n\'Cause we are the champions of the world\r\n\r\nWe are the champions, my friends\r\nAnd we\'ll keep on fighting\r\n\'Till the end\r\nWe are the champions\r\nWe are the champions\r\nNo time for losers\r\n\'Cause we are the champions', 2, 9, 244),
	(11, 'Sunday Bloody Sunday', 2, 'I can\'t believe the news today\r\nI can\'t close my eyes, make them go away\r\n\r\nHow long?\r\nHow long must we sing this song?\r\nHow long\r\nHow long?\r\nTonight we can be as one\r\nTonight\r\n\r\nBroken bottles under children\'s feet\r\nAnd bodies strewn across a dead end street\r\nBut I won\'t heed the battle call\r\nIt puts my back up, puts my back up\r\nAgainst the wall!\r\n\r\nSunday bloody sunday\r\nSunday bloody sunday\r\nSunday bloody sunday\r\n\r\nAnd the battles just begun\r\nThere\'s many lost\r\nBut tell me who has won?\r\nThe trenches dug within our hearts\r\nAnd mothers, children, brothers, sisters torn apart\r\n\r\nSunday bloody sunday\r\nSunday bloody sunday\r\n\r\nHow long?\r\nHow long must we sing this song?\r\nHow long\r\nHow long?\r\nCause tonight we can be as one\r\nTonight\r\n\r\nTonight\r\nTonight\r\nTonight\r\nTonight\r\n\r\nWipe the tears of your eyes\r\nWipe your tears away\r\nWipe your tears away\r\nWipe bloodshot eyes\r\n\r\nSunday bloody sunday\r\nSunday bloody sunday\r\nSunday bloody sunday\r\nSunday bloody sunday\r\nSunday bloody sunday\r\nSunday bloody sunday\r\n\r\nAnd it\'s true we are immune\r\nWhen fact is fiction and Tv is reality\r\nAnd today the millions cry\r\nWe eat and drink while tomorrow they die\r\nThe real battle just begun\r\nTo claim the victory Jesus won\r\nOn a sunday, bloody sunday\r\n\r\nSunday bloody sunday\r\nSunday bloody sunday\r\nSunday bloody sunday\r\nSunday bloody sunday\r\nSunday bloody sunday', 1, 10, 228),
	(12, 'Billie Jean', 5, 'She was more like a beauty queen\r\nFrom a movie scene\r\nI said, "Don\'t mind, but what do you mean\r\nI am the one\r\nWho will dance on the floor in the round?"\r\nShe said I am the one\r\nWho will dance on the floor in the round\r\n\r\nShe told me her name was Billie Jean\r\nAs she caused a scene\r\nThen every head turned with eyes that dreamed of being the one\r\nWho will dance on the floor in the round\r\n\r\nPeople always told me, "Be careful of what you do.\r\nAnd don\'t go around breaking young girls\' hearts."\r\nAnd mother always told me, "A-be careful of who you love,\r\nAnd be careful of what you do\r\n\'Cause the lie becomes the truth."\r\n\r\nBillie Jean is not my lover\r\nShe\'s just a girl who claims that I am the one\r\nBut the kid is not my son\r\nShe says I am the one\r\nBut the kid is not my son\r\n\r\nFor forty days and for forty nights\r\nLaw was on her side\r\nBut who can stand\r\nWhen she\'s in demand\r\nHer schemes and plans\r\n\'Cause we danced on the floor in the round\r\nSo take my strong advice\r\nJust remember to always think twice\r\n(Do think twice, do think twice.)\r\n\r\nShe told, "My baby, we\'d danced \'til three."\r\nThen she looked at me\r\nThen showed a photo of a baby cry\r\nHis eyes looked like mine, oh, no\r\nDo a dance on the floor in the round, baby\r\n\r\nA-people always told me, "Be careful of what you do\r\nAnd don\'t go around breaking young girls\' hearts."\r\n(Don\'t break no heart.)\r\nA-but she came and stood right by me\r\nAnd just the smell of sweet perfume\r\nAnd this happened much too soon\r\nAnd she called me to her room\r\n\r\nBillie Jean is not my lover\r\nShe\'s just a girl who claims that I am the one\r\nBut the kid is not my son\r\n(No, no, no, no, no, no, no, no.)\r\nBillie Jean is not my lover\r\nShe\'s just a girl who claims that I am the one\r\nBut the kid is not my son\r\nShe says I am the one\r\nBut the kid is not my son\r\n\r\nShe says I am the one\r\nBut the kid is not my son\r\n\r\nNo, no, no\r\n\r\nBillie Jean is not my lover\r\nShe\'s just a girl who claims that I am the one\r\n(No, there\'s not me, baby.)\r\nBut the kid is not my son\r\n(No, no, no, no, no, no, no.)\r\nShe says I am the one (No, babe.)\r\nBut the kid is not my son, no, no, no\r\n\r\nShe says I am the one\r\nYou know what you did\r\nShe says he is my son\r\nBreaking my heart, babe\r\nShe says I am the one\r\n\r\nBillie Jean is not my lover\r\nBillie Jean is not my lover\r\nBillie Jean is not my lover\r\nShe is the one\r\nBillie Jean is not my lover\r\nShe is the one\r\nDon\'t call me Billie Jean\r\nShe is the one\r\nBillie Jean is not my lover\r\nShe is the one\r\nBillie Jean is not my lover', 6, 8, 224),
	(13, 'Hot For Teacher', 0, '[Spoken:]\r\n"Oh wow, man !" \r\n"Wait a second man. Whaddaya think the teacher\'s gonna look like this year ?" \r\n"My butt, man !" \r\nT-T-Teacher stop that screaming, teacher don\'t you see ? \r\nDon\'t wanna be no uptown fool. \r\nMaybe I should go to hell, but I\'m doin\' well, teacher needs to see me after school. \r\n\r\n[Chorus:]\r\nI think of all the education that I missed. \r\nBut then my homework was never quite like this. \r\nGot it bad, got it bad, got it bad, \r\nI\'m hot for teacher. \r\nI got it bad, so bad, \r\nI\'m hot for teacher. \r\n\r\n[Spoken:]\r\n"Hey, I heard you missed us, we\'re back !" \r\n"I brought my pencil" \r\n"Gimme something to write on, man" \r\nI heard about your lessons, but lessons are so cold. \r\nI know about this school. \r\nLittle girl from cherry lane, how did you get so bold ? \r\nHow did you know that golden rule ? \r\n\r\n[Chorus:]\r\n\r\n[Guitar solo]\r\n\r\n"Oh man, I think the clock is slow" \r\n"I don\'t feel tardy" \r\n"Class dismissed"', 6, 3, 244),
	(14, 'Jamie\'s Cryin', 0, 'She saw the look in his eyes, \'n\' she knew better \r\nHe wanted her tonight, ah, and it was now or never \r\nHe made her feel so sad \r\nOh, whoa, whoa, Jamie\'s cryin\' \r\nOh, whoa, whoa, Jamie\'s cryin\' \r\nNow Jamie wouldn\'t say, "All right", ah, she knew he\'d forget her \r\n\'N\' so they said goodnight, ah, oh, \'n\' now he\'s gone forever \r\nShe want\'s to send him a letter, uh yeah yeah \r\nUh just to try to make herself feel better \r\nIt said "Gimme (gimme a call sometime") \r\nBut she knows what that\'ll get her \r\nOh, whoa, whoa, Jamie\'s cryin\' \r\nOh, whoa, whoa, Jamie\'s cryin\' \r\nNow Jamie\'s been in love before (ahhh) \r\nAnd she knows what love is for (ahhh) \r\nIt should mean, a little, a little more (ahhh) \r\nThan one night stands, whoo \r\nShe want\'s to send him a letter, uh yeah yeah \r\nJust to try to make herself feel better \r\nIt said "Gimme (gimme a call sometime") \r\nBut she knows what that\'ll get her \r\nOh, whoa, whoa, Jamie\'s cryin\' \r\nOh, whoa, whoa, Jamie\'s cryin\' \r\n[Repeat til outro]', 6, 6, 270),
	(15, 'Runnin\' With The Devil', 0, 'I live my life like there\'s no tomorrow\r\nAnd all I\'ve got I had to steal\r\nLeast I don\'t need to beg or borrow\r\nYes, I\'m living at a pace that kills\r\n\r\nRunnin\' with the devil\r\nRunnin\' with the devil\r\nI\'ll tell y\'all about it\r\n\r\nI found the simple life ain\'t so simple\r\nWhen I jumped out on that road\r\nI got no love, no love you\'d call real\r\nAin\'t got nobody waiting at home\r\n\r\nRunnin\' with the devil\r\nGod damn it lady, you know I ain\'t lying to ya\r\nI\'m wanna tell you one time\r\nAah-yeah\r\nRunning with the devil\r\nYes I am\r\nYeah\r\n\r\nWoo\r\nWoo\r\n\r\nYou know I, I found the simple life, weren\'t so simple, no\r\nWhen I jumped out on that road\r\nGot no love, no love you\'d call real\r\nGot nobody waiting at home\r\n\r\nRunnin\' with the devil\r\nRunnin\' with the devil\r\n\r\nRunnin\' with the devil\r\nRunnin\' with the devil\r\n[Repeat and fade]', 1, 6, 233),
	(16, 'Panama', 0, 'Jump back, what\'s that sound ? \r\nHere she comes, full blast and top down. \r\nHot shoe, burnin\' down the avenue. \r\nModel citizen zero discipline \r\nDon\'t you know she\'s coming home with me? \r\nYou\'l lose her in the turn. \r\nI\'ll get her! \r\nPanama, Panama \r\nPanama, Panama \r\nAin\'t nothin\' like it, her shiny machine. \r\nGot the feel for the wheel, keep the moving parts clean. \r\nHot shoe, burnin\' down the avenue, \r\nGot an on-ramp comin\' through my bedroom. \r\nDon\'t you know she\'s coming home with me? \r\nYou\'ll lose her in the turn. \r\nI\'ll get her! \r\nYeah, we\'re runnin\' a little bit hot tonight. \r\nI can barely see the road from the heat comin\' off of it. \r\nAh, you reach down, between my legs, ease the seat back. \r\nShe\'s blinding, I\'m flying, \r\nRight behind the rear-view mirror now. \r\nGot the feeling, power steering, \r\nPistons popping, ain\'t no stopping now! \r\nPanama, Panama \r\nPanama, Panama', 3, 3, 244),
	(17, 'Top Jimmy', 0, 'Some friends of mine, just the other night, \r\nwent to hear this cool cat blow. \r\nThe say he sang so good that the roof fell in, and they didn\'t even stop the show. \r\nThey don\'t remember the place, but they remember the face, and now everybody wanna go. \r\n\r\n[Chorus:]\r\nTop Jimmy cooks, Top Jimmy swings. \r\nHe\'s got the look. Top Jimmy, he\'s the king. \r\nJimmy on the television, famous people laughing with him, \r\nJimmy on the news at five. \r\nJimmy on the radio and even on the video, that baddest cat alive. \r\nDriving all the women crazy, only want Jimmy-baby, \r\nlove it when he rolls his eyes. \r\n\r\n[Chorus]\r\n\r\n[Guitar solo]\r\n\r\nJuke-joint Jimmy is the latest thing, he\'s got the sound that everybody digs. \r\nAnd the joint been jumpin\' when the band been pumpin\' and you know they\'re playing crazy gigs. \r\nWell you ain\'t been living till you\'ve seen the living thing, \r\nTop Jimmy and his Rhythm Pigs \r\n\r\n[Chorus]', 4, 3, 244),
	(18, 'Drop Dead Legs', 0, 'Drop dead legs, pretty smile, hurts my head, gets me wild. \r\nDig that steam, giant butt, makes me scream, I get nuh-nuh-nothing but the shakes over you \r\nAnd nothing else could ever do. \r\n\r\n[Chorus:]\r\nYou know that you want it. \r\nI know what it is. \r\nYou know that you want it, baby, \r\nWhen the night is through, will I still be loving you ? \r\nDig those moves, vam-pire set me loose, get it higher. \r\nThrow my rope, loop-de-loop nice white teeth, Betty Boop. \r\nSet it cool real heavy. \r\nI ain\'t fooled, gettin\' ready. \r\n\r\n[Chorus:]\r\n\r\n[Guitar solo]', 5, 3, 244),
	(19, 'I\'ll Wait', 0, 'You\'ve got me captured, I\'m under your spell. \r\nI guess I\'ll never learn. \r\nI have your picture, yes I know it well. \r\nAnother page is turned. \r\nAre you for real ? It\'s so hard to tell, from just a magazine. \r\nYeah, you just smile and the picture sells, look what that does to me. \r\n\r\n[Chorus:]\r\nI\'ll wait till your love comes down. \r\nI\'m coming straight for your heart. \r\nNo way you can stop me now, as fine as you are. \r\nI wrote a letter and told her these words, that meant a lot to me. \r\nI never sent it, she wouldn\'t have heard, her eyes don\'t follow me. \r\nAnd while she watches I can never be free, such good photography ! \r\n\r\n[Chorus]\r\n\r\n[Guitar solo]\r\n\r\nYou can\'t imagine what your image means. \r\nThe pages come alive. \r\nYour magic greets everyone who reads. \r\nHeart-break in overdrive \r\nAre you for real, it\'s so hard to tell, from just a magazine. \r\nYeah, you just smile and the picture sells, look what that does to me. \r\n\r\n[Chorus]', 7, 3, 244),
	(20, 'Girl Gone Bad', 0, 'Lazy eyes in the summer heat, fresh from outta town. \r\nNow she\'s working on the street, shakin\' poor boys down. \r\n\r\n[Chorus:]\r\nGirl gone bad \r\nGirl gone bad \r\nFound that girl with a lonesome John, but she should\'ve been with me. \r\nGuess that woman fallen in love, she don\'t work for free \r\n\r\n[Chorus]\r\n\r\n[Guitar solo]', 8, 3, 244),
	(21, 'House Of Pain', 0, 'Say you\'re gonna leave me cause I only tie you up. \r\nAlways love you tender but you only like it rough. \r\n?? why you\'re leaving me again. \r\nGonna pack your bags and leave this house of pain. \r\nHeartaches all around me, how many times we cried. \r\nSaid she tried to leave me but her hands were always tied. \r\nIf I had it all to do I\'d do it just the same. \r\nGonna fix it so you never leave this house of pain \r\n\r\n[Guitar solo]', 9, 3, 244),
	(22, 'Wanna Be Startin\' Somethin\'', 0, 'I said you wanna be startin\' somethin\'\r\nYou got to be startin\' somethin\'\r\nI said you wanna be startin\' somethin\'\r\nYou got to be startin\' somethin\'\r\n\r\nAnd too high to get over (yeah, yeah)\r\nAnd too low to get under (yeah, yeah)\r\nYou\'re stuck in the middle (yeah, yeah)\r\nAnd the pain is thunder (yeah, yeah)\r\n\r\nAnd too high to get over (yeah, yeah)\r\nAnd too low to get under (yeah, yeah)\r\nYou\'re stuck in the middle (yeah, yeah)\r\nAnd the pain is thunder (yeah, yeah)\r\n\r\nI took my baby to the doctor\r\nWith a fever, but nothing he found\r\nBy the time this hit the street\r\nThey said she had a breakdown\r\n\r\nSomeone\'s always tryin\'\r\nTo start my baby cryin\'\r\nTalkin\', squealin\', lyin\'\r\nSayin\' you just wanna be startin\' somethin\'\r\n\r\nI said you wanna be startin\' somethin\'\r\nYou got to be startin\' somethin\'\r\nI said you wanna be startin\' somethin\'\r\nYou got to be startin\' somethin\'\r\n\r\nAnd too high to get over (yeah, yeah)\r\nAnd too low to get under (yeah, yeah)\r\nYou\'re stuck in the middle (yeah, yeah)\r\nAnd the pain is thunder (yeah, yeah)\r\n\r\nAnd too high to get over (yeah, yeah)\r\nAnd too low to get under (yeah, yeah)\r\nYou\'re stuck in the middle (yeah, yeah)\r\nAnd the pain is thunder (yeah, yeah)\r\n\r\nYou love to pretend that you\'re good\r\nWhen you\'re always up to no good\r\nYou really can\'t make him hate her\r\nSo your tongue became a razor\r\n\r\nSomeone\'s always tryin\'\r\nTo keep my baby cryin\'\r\nTreacherous, cunnin\', declinin\'\r\nYou got my baby cryin\'\r\n\r\nI said you wanna be startin\' somethin\'\r\nYou got to be startin\' somethin\'\r\nI said you wanna be startin\' somethin\'\r\nYou got to be startin\' somethin\'\r\n\r\nAnd too high to get over (yeah, yeah)\r\nAnd too low to get under (yeah, yeah)\r\nYou\'re stuck in the middle (yeah, yeah)\r\nAnd the pain is thunder (yeah, yeah)\r\n\r\nAnd too high to get over (yeah, yeah)\r\nAnd too low to get under (yeah, yeah)\r\nYou\'re stuck in the middle (yeah, yeah)\r\nAnd the pain is thunder (yeah, yeah)\r\n\r\nYou\'re a vegetable, you\'re a vegetable\r\nStill they hate you, you\'re a vegetable\r\nYou\'re just a buffet, you\'re a vegetable\r\nThey eat off of you, you\'re a vegetable\r\n\r\nBillie Jean is always talkin\'\r\nWhen nobody else is talkin\'\r\nTellin\' lies and rubbin\' shoulders\r\nSo they called her mouth a motor\r\n\r\nSomeone\'s always tryin\'\r\nTo start my baby cryin\'\r\nTalkin\', squealin\', spyin\'\r\nSayin\' you just wanna be startin\' somethin\'\r\n\r\nI said you wanna be startin\' somethin\'\r\nYou got to be startin\' somethin\'\r\nI said you wanna be startin\' somethin\'\r\nYou got to be startin\' somethin\'\r\n\r\nAnd too high to get over (yeah, yeah)\r\nAnd too low to get under (yeah, yeah)\r\nYou\'re stuck in the middle (yeah, yeah)\r\nAnd the pain is thunder (yeah, yeah)\r\n\r\nAnd too high to get over (yeah, yeah)\r\nAnd too low to get under (yeah, yeah)\r\nYou\'re stuck in the middle (yeah, yeah)\r\nAnd the pain is thunder (yeah, yeah)\r\n\r\nYou\'re a vegetable, you\'re a vegetable\r\nStill they hate you, you\'re a vegetable\r\nYou\'re just a buffet, you\'re a vegetable\r\nThey eat off of you, you\'re a vegetable\r\n\r\nIf you can\'t feed your baby (yeah, yeah)\r\nThen don\'t have a baby (yeah, yeah)\r\nAnd don\'t think maybe (yeah, yeah)\r\nIf you can\'t feed your baby (yeah, yeah)\r\n\r\nYou\'ll be always tryin\'\r\nTo stop that child from cryin\'\r\nHustlin\', stealin\', lyin\'\r\nNow baby\'s slowly dyin\'\r\n\r\nI said you wanna be startin\' somethin\'\r\nYou got to be startin\' somethin\'\r\nI said you wanna be startin\' somethin\'\r\nYou got to be startin\' somethin\'\r\n\r\nIt\'s too high to get over (yeah, yeah)\r\nIt\'s too low to get under (yeah, yeah)\r\nYou\'re stuck in the middle (yeah, yeah)\r\nAnd the pain is thunder (yeah, yeah)\r\n\r\nIt\'s too high to get over (yeah, yeah)\r\nAnd too low to get under (yeah, yeah)\r\nYou\'re stuck in the middle (yeah, yeah)\r\nAnd the pain is thunder (yeah, yeah)\r\n\r\nLift your head up high\r\nAnd scream out to the world\r\nI know I am someone\r\nAnd let the truth unfurl\r\n\r\nNo one can hurt you now\r\nBecause you know what\'s true\r\nYes, I believe in me\r\nSo you believe in you\r\n\r\nHelp me sing it,\r\n\r\n[6x]\r\nMa ma se, ma ma sa, ma ma coo sa\r\nMa ma se, ma ma sa, ma ma coo sa\r\n\r\nHelp me sing it!\r\nSing it to the world\r\nSing it out loud\r\nHelp me sing it!\r\n\r\n[8x]\r\nMa ma se, ma ma sa, ma ma coo sa\r\nMa ma se, ma ma sa, ma ma coo sa\r\n\r\n(woo hoo, he he he)\r\nHelp me sing it!\r\n(woo hoo, he he he)\r\nSing it to the world\r\n\r\n[6x]\r\nMa ma se, ma ma sa, ma ma coo sa\r\nMa ma se, ma ma sa, ma ma coo sa\r\n\r\n(woo hoo, he he he)\r\nHelp me sing it baby!\r\nSing it to the world\r\nSing it out loud', 1, 8, 224),
	(23, 'Baby Be Mine', 0, 'I don\'t need no dreams when I\'m by your side\r\nEvery moment takes me to paradise\r\nDarlin\' let me hold you\r\nWarm you in my arms and melt your fears away\r\nShow you all the magic that a perfect love can make\r\nI need you night and day\r\n\r\nSo baby be mine (baby you gotta be mine)\r\nAnd girl I\'ll give you all I got to give\r\nSo baby be my girl (all the time)\r\nAnd we can share this ecstasy\r\nAs long as we believe in love\r\n\r\nI won\'t give you reason to change your mind\r\n(I guess it\'s still you thrill me baby be mine)\r\nYou are all the future that I desire\r\nGirl I need to hold you\r\nShare my feelings in the heat of love\'s embrace\r\nShow you all the passion burning in my heart today\r\nIt\'s never gonna fade\r\n\r\nSo baby be mine (baby you gotta be mine)\r\nAnd girl I\'ll give you all I got to give\r\nSo baby be my girl (all the time)\r\nYou\'re everything this world could be\r\nThe reason that I live\r\n\r\nWon\'t you stay with me until the mornin\' sun\r\nI promise you now that the dawn will be different\r\nLady can\'t you see that heaven\'s just begun\r\nIt\'s livin\' here inside our hearts\r\n\r\nThere\'ll be no more mountains for us to climb\r\n(I can\'t be still you thrill me baby be mine)\r\nThis will be a love lasting for all time\r\nGirl you got to hold me\r\nWe can touch the sky and light the darkest day\r\nHold me only you and I can make sweet love this way\r\nThere\'s no more I can say\r\n\r\nSo baby be mine (baby you gotta be mine)\r\n(tell me that you love me)\r\nAnd girl I\'ll give you all I got to give\r\n(say you\'re thinking of me)\r\nSo baby be mine (all the time)\r\n(show me how it should be)\r\nYou\'re everything this world could be\r\nThe reason that I live\r\n(every night it feels alright)\r\n\r\nBaby be my girl\r\n(tell me that you love me)\r\nAnd girl I\'ll give you all I got to give\r\n(say you\'re thinking of me)\r\nSo baby, be mine, baby, be mine\r\n(show me how it should be)\r\nYou\'re everything this world could be to me\r\n(every night it feels alright)\r\n\r\nC\'mon girl c\'mon girl\r\n(tell me that you love me)\r\n(say you\'re thinking of me)\r\nSo baby be mine\r\n(show me how it should be)\r\nYou\'re everything this world could be to me\r\n(every night it feels alright)', 2, 8, 224),
	(24, 'The Girl Is Mine (with Paul M', 0, '[Michael:]\r\nEvery night she walks right in my dreams\r\nSince I met her from the start\r\nI\'m so proud I am the only one\r\nWho is special in her heart\r\n\r\nThe girl is mine\r\nThe doggone girl is mine\r\nI know she\'s mine\r\nBecause the doggone girl is mine\r\n\r\n[Paul:]\r\nI don\'t understand the way you think\r\nSaying that she\'s yours not mine\r\nSending roses and your silly dreams\r\nReally just a waste of time\r\n\r\nBecause she\'s mine\r\nThe doggone girl is mine\r\nDon\'t waste your time\r\nBecause the doggone girl is mine\r\n\r\n[Paul:]\r\nI love you more than he\r\n(take you anywhere)\r\n\r\n[Michael:]\r\nBut I love you endlessly\r\n(loving we will share)\r\n\r\n[Michael and Paul:]\r\nSo come and go with me\r\nTwo on the town\r\n\r\n[Michael:]\r\nBut we both cannot have her\r\nSo it\'s one or the other\r\nAnd one day you\'ll discover\r\nThat she\'s my girl forever and ever\r\n\r\n[Paul:]\r\nI don\'t build your hopes to be let down\r\n\'Cause I really feel it\'s time\r\n\r\n[Michael:]\r\nI know she\'ll tell you I\'m the one for her\r\n\'Cause she said I blow her mind\r\n\r\nThe girl is mine\r\nThe doggone girl is mine\r\nDon\'t waste your time\r\nBecause the doggone girl is mine\r\n\r\n[Michael and Paul:]\r\nShe\'s mine, she\'s mine\r\nNo, no, no, she\'s mine\r\nThe girl is mine, the girl is mine\r\nThe girl is mine, the girl is mine\r\n\r\n[Paul:]\r\nThe girl is mine (mine, mine) yep she\'s mine (mine, mine)\r\nThe girl is mine (mine, mine) yep she\'s mine (mine, mine)\r\n\r\n[Michael:]\r\nDon\'t waste your time\r\nBecause the doggone girl is mine\r\nThe girl is mine, the girl is mine\r\n\r\n[Paul:]\r\nMichael, we\'re not gonna fight about this, okay?\r\n\r\n[Michael:]\r\nPaul, I think I told you, I\'m a lover not a fighter\r\n\r\n[Paul:]\r\nI\'ve heard it all before, Michael\r\nShe told me that I\'m her forever lover, you know, don\'t you remember?\r\n\r\n[Michael:]\r\nWell, after loving me, she said she couldn\'t love another\r\n\r\n[Paul]\r\nIs that what she said?\r\n\r\n[Michael:]\r\nYes, she said it, you keep dreaming\r\n\r\n[Paul]\r\nI don\'t believe it (mine, mine) no\r\n\r\n[Michael and Paul:]\r\nThe girl is mine (mine, mine)\r\nNo, mine\r\nNo, mine (mine, mine)\r\n\r\n[Paul:]\r\nShe\'s mine mine mine mine mine (mine, mine, mine)\r\n\r\n[Michael:]\r\n\'Cause the girl is mine (mine, mine)\r\n\r\n[Paul:]\r\nNo girl is mine (mine, mine)\r\n\r\n[Fade-out/repeat]', 3, 8, 224),
	(25, 'Thriller', 0, '[Michael Jackson:]\r\nIt\'s close to midnight and something evil\'s lurkin\' in the dark\r\nUnder the moonlight you see a sight that almost stops your heart\r\nYou try to scream but terror takes the sound before you make it\r\nYou start to freeze as horror looks you right between the eyes,\r\nYou\'re paralyzed\r\n\r\n\'Cause this is thriller, thriller night\r\nAnd no one\'s gonna save you from the beast about to strike\r\nYou know it\'s thriller, thriller night\r\nYou\'re fighting for your life inside a killer, thriller tonight\r\n\r\nYou hear the door slam and realize there\'s nowhere left to run\r\nYou feel the cold hand and wonder if you\'ll ever see the sun\r\nYou close your eyes and hope that this is just imagination, girl\r\nBut all the while you hear a creature creepin\' up behind\r\nYou\'re outta time\r\n\r\n\'Cause this is thriller, thriller night\r\nThere ain\'t no second chance against the thing with the forty eyes, girl\r\nThriller, thriller night\r\nYou\'re fighting for your life inside a killer, thriller tonight\r\n\r\nNight creatures call\r\nAnd the dead start to walk in their masquerade\r\nThere\'s no escaping the jaws of the alien this time (they\'re open wide)\r\nThis is the end of your life\r\n\r\nThey\'re out to get you, there\'s demons closing in on every side\r\nThey will possess you unless you change that number on your dial\r\nNow is the time for you and I to cuddle close together\r\nAll through the night I\'ll save you from the terror on the screen,\r\nI\'ll make you see\r\n\r\nThat this is thriller, thriller night\r\n\'Cause I can thrill you more than any ghoul could ever dare try\r\nThriller, thriller night\r\nSo let me hold you tight and share a killer, thriller, chiller\r\nThriller here tonight\r\n\r\n\'Cause this is thriller, thriller night\r\nGirl, I can thrill you more than any ghoul could ever dare try\r\nThriller, thriller night\r\nSo let me hold you tight and share a killer, thriller\r\n\r\nI\'m gonna thrill you tonight\r\n\r\n[Vincent Price:]\r\nDarkness falls across the land\r\nThe midnight hour is close at hand\r\nCreatures crawl in search of blood\r\nTo terrorize y\'all\'s neighborhood\r\nAnd whomsoever shall be found\r\nWithout the soul for getting down\r\nMust stand and face the hounds of hell\r\nAnd rot inside a corpse\'s shell\r\n\r\n[Michael Jackson:]\r\nI\'m gonna thrill you tonight...\r\n\r\n[Vincent Price:]\r\nThe foulest stench is in the air\r\nThe funk of forty thousand years\r\nAnd grisly ghouls from every tomb\r\nAre closing in to seal your doom\r\nAnd though you fight to stay alive\r\nYour body starts to shiver\r\nFor no mere mortal can resist\r\nThe evil of the thriller\r\n\r\n[Into maniacal laugh, in deep echo]', 4, 8, 224),
	(26, 'Beat It', 0, 'They told him, "Don\'t you ever come around here.\r\nDon\'t wanna see your face. You better disappear."\r\nThe fire\'s in their eyes and their words are really clear\r\nSo beat it, just beat it\r\n\r\nYou better run, you better do what you can\r\nDon\'t wanna see no blood, don\'t be a macho man\r\nYou wanna be tough, better do what you can\r\nSo beat it, but you wanna be bad\r\n\r\n[Chorus]\r\nJust beat it, beat it, beat it, beat it\r\nNo one wants to be defeated\r\nShowin\' how funky strong is your fight\r\nIt doesn\'t matter who\'s wrong or right\r\n\r\nJust beat it, beat it [4x]\r\n\r\nThey\'re out to get you, better leave while you can\r\nDon\'t wanna be a boy, you wanna be a man\r\nYou wanna stay alive, better do what you can\r\nSo beat it, just beat it\r\n\r\nYou have to show them that you\'re really not scared\r\nYou\'re playin\' with your life, this ain\'t no truth or dare\r\nThey\'ll kick you, then they beat you, then they\'ll tell you it\'s fair\r\nSo beat it, but you wanna be bad\r\n\r\n[Chorus 2x]\r\nJust beat it, beat it, beat it, beat it\r\nNo one wants to be defeated\r\nShowin\' how funky strong is your fight\r\nIt doesn\'t matter who\'s wrong or right\r\n\r\nJust beat it, beat it, beat it, beat it, beat it\r\n\r\nBeat it, beat it, beat it, beat it\r\nNo one wants to be defeated\r\nShowin\' how funky strong is your fight\r\nIt doesn\'t matter who\'s wrong or right\r\n\r\n[Chorus 3x]\r\nJust beat it, beat it, beat it, beat it\r\nNo one wants to be defeated\r\nShowin\' how funky strong is your fight\r\nIt doesn\'t matter who\'s wrong or right\r\n\r\nJust beat it, beat it\r\nBeat it, beat it, beat it\r\n\r\n', 5, 8, 244),
	(27, 'Human Nature', 0, 'Looking out\r\nAcross the night-time\r\nThe city winks a sleepless eye\r\nHear her voice\r\nShake my window\r\nSweet seducing sighs\r\n\r\nGet me out\r\nInto the night-time\r\nFour walls won\'t hold me tonight\r\nIf this town\r\nIs just an apple\r\nThen let me take a bite\r\n\r\nIf they say, "Why? Why?"\r\nTell \'em that is human nature\r\nWhy, why does he do it that way?\r\nIf they say, "Why? Why?"\r\nTell \'em that is human nature\r\nWhy, why does he do it that way?\r\n\r\nReaching out\r\nTo touch a stranger\r\nElectric eyes are everywhere\r\nSee that girl\r\nShe knows I\'m watching\r\nShe likes the way I stare\r\n\r\nIf they say, "Why? Why?"\r\nJust tell \'em that is human nature\r\nWhy, why does he do it that way?\r\nIf they say, "Why? Why?"\r\n(Do you really like me to be around?)\r\nTell \'em that is human nature\r\nWhy, why does he do it that way?\r\nI like livin\' this way\r\nI like lovin\' this way\r\n\r\nThat way (The way it was.)\r\nThat way (The way it was.)\r\n\r\nLooking out\r\nAcross the morning\r\nThe city\'s heart begins to beat\r\nReaching out\r\nI touch her shoulder\r\nI\'m dreaming of the street\r\n\r\nIf they say, "Why? Why?"\r\nTell \'em that is human nature\r\nWhy, why does he do it that way?\r\nIf they say, "Why? Why?"\r\n(Just tell me you like me to be around.)\r\nOoh, tell \'em\r\nWhy, why does he do it that way?\r\n\r\nIf they say, "Why? Why?"\r\n\r\nWhy, why does he do it that way?\r\nIf they say, "Why? Why?"\r\n(Just tell me you like me to be around.)\r\nOoh, tell \'em\r\nWhy, why does he do it that way?\r\n\r\nAnd they say, "Why? Why?"\r\nOoh, tell \'em\r\nWhy, why does he do it that way?\r\n\r\nThey say, "Why? Why?"\r\n(Just tell me you like me to be around.)\r\nWhy, why does he do it that way?\r\nI like livin\' this way\r\n\r\nThe way\r\nThe way', 7, 8, 224),
	(28, 'P.Y.T. (Pretty Young Thing)', 0, 'You know, you—you make me feel so good inside.\r\nI always wanted a girl just like you.\r\nYou\'re such a P.Y.T. pretty young thing.\r\n\r\nWhere did you come from baby\r\nAnd ooh won\'t you take me there?\r\nRight away won\'t you baby\r\nTender only you\'ve got to be\r\nSpark my nature\r\nSugar fly with me\r\n\r\nDon\'t you know now is the perfect time\r\nWe can make it right\r\nHit the city lights\r\n\r\nThen tonight ease the love and pain\r\nLet me take you to the max\r\n\r\nI want to love you (P.Y.T.)\r\nPretty young thing\r\nYou need some lovin\' (T.L.C.)\r\nTender love, and care\r\nAnd I\'ll take you there\r\nI want to love you (P.Y.T.)\r\nPretty young thing\r\nYou need some lovin\' (T.L.C.)\r\nTender love, and care\r\nAnd I\'ll take you there\r\n\r\nAnywhere you wanna go (Yes, I will.)\r\n\r\nNothin\' can stop this burnin\'\r\nDesire to be with you\r\nGotta get to you baby\r\nWon\'t you come, it\'s emergency\r\nCool my fire yearnin\'\r\nHoney, come set me free\r\n\r\nDon\'t you know now is the perfect time\r\nWe can dim the lights\r\nJust to make it right\r\n\r\nIn the night hit the lovin\' spot\r\nI\'ll give you all that I\'ve got\r\n\r\nI want to love you (P.Y.T.)\r\nPretty young thing\r\nYou need some lovin\' (T.L.C.)\r\nTender love, and care\r\nAnd I\'ll take you there (Yes, I will.)\r\nI want to love you (P.Y.T.)\r\nPretty young thing\r\nYou need some lovin\' (T.L.C.)\r\nTender love, and care\r\nAnd I\'ll take you there\r\n\r\nPretty young things\r\nPretty young things\r\nPretty young things\r\nPretty young things\r\n\r\nPretty young things, repeat after me\r\n[Michael] Say "Na, na, na."\r\n[P.Y.T.\'s] Na, na, na\r\n[Michael] Na, na, na, na\r\n[P.Y.T.\'s] Na, na, na, na\r\n[Michael] Say "Na, na, na."\r\n[P.Y.T.\'s] Na, na, na\r\n[Michael] Na, na, na, na, na\r\n[P.Y.T.\'s] Na, na, na, na, na\r\n[Michael] I\'ll take you there, take you there\r\n\r\nI want to love you (P.Y.T.)\r\nPretty young thing\r\nYou need some lovin\' (T.L.C.)\r\nTender love, and care\r\nAnd I\'ll take you there\r\n\r\nI want to love you (P.Y.T.)\r\nPretty young thing\r\nYou need some lovin\' (T.L.C.)\r\nTender love, and care\r\nAnd I\'ll take you there, take you there\r\n\r\n[Ad-lib and fade-out:]\r\nYou know I think you are really nice.\r\nYou and I could\'ve just put together.\r\nYou\'re such a P.Y.T. Pretty young thing.\r\n\r\nI just wanna love you, you know, it\'s...\r\nI\'d give you all', 8, 8, 224),
	(29, 'The Lady In My Life', 0, 'There\'ll be no darkness tonight\r\nLady our love will shine\r\n(lighting the night)\r\nJust put your trust in my heart\r\nAnd meet me in paradise\r\n(now is the time)\r\nGirl, you\'re every wonder in this world to me\r\nA treasure time won\'t steal away\r\n\r\nSo listen to my heart\r\nLay your body close to mine\r\nLet me fill you with my dreams\r\nI can make you feel alright\r\nAnd baby through the years gonna love you more each day\r\nSo I promise you tonight that you will always be the lady in my life\r\n\r\nLay back in my tenderness\r\nLet\'s make this a night we won\'t forget\r\nGirl, I need your sweet caress, oh\r\nReach out to a fantasy\r\nTwo hearts in a beat of ecstasy\r\nCome to me, girl\r\n\r\nAnd I will keep you warm\r\nThrough the shadows of the night\r\nLet me touch you with my love\r\nI can make you feel so right\r\nAnd baby through the years\r\nEven when we\'re old and gray\r\nI will love you more each day\r\n\'Cause you will always be the lady in my life\r\n\r\nStay with me\r\nI want you to stay with me\r\nI need you by my side\r\nDon\'t you go nowhere\r\n(ooh girl let me keep you warm)\r\nLet me keep you warm\r\n(you are the lady in my life)\r\nYou\'re my lady\r\n(fill you with the sweetest love)\r\nThe sweetest love\r\n(always the lady in my life)\r\nI wanna touch you baby\r\n\r\n(lay back in my tenderness)\r\n(you are the lady in my life)\r\nDoo doo doo\r\n(rock me with your sweet caress)\r\n(always the lady in my life)\r\nYou\'re my lady and I love you girl\r\n\r\n(ooh girl let me keep you warm)\r\n(you are the lady in my life)\r\nDon\'t you go nowhere\r\n(fill you with the sweetest love)\r\nI love you I love you\r\n(always the lady in my life)\r\nI need you I want you, baby\r\n\r\n(lay back in my tenderness)\r\nStay with me\r\n(you are the lady in my life)\r\nDon\'t you go no where\r\n(rock me with your sweet caress)\r\nAnd I love you baby\r\n(always the lady in my life)\r\nWoo\r\n\r\nOoh baby\r\nDon\'t you go nowhere\r\nYou\'re my lady\r\nAll through the night\r\n\r\n(ooh girl let me keep you warm)\r\nI wanna give you all\r\n(you are the lady in my life)\r\nIn my life\r\n(fill you with the sweetest love)\r\nLet me fill you baby\r\n(always the lady in my life)\r\nAll over all over all over\r\n\r\n(lay back in my tenderness)\r\nLay back with me\r\n(you are the lady in my life)\r\nLet me touch you girl\r\n(rock me with your sweet caress)\r\nLay back with me\r\n(always the lady in my life)\r\nAll over [7x]\r\n\r\n(ooh girl let me keep you warm)\r\nBaby\r\n(you are the lady in my life)\r\nWoo\r\n(fill you with the sweetest love)\r\n(always the lady in my life)\r\nYou\'re my lady\r\n\r\n(lay back in my tenderness)\r\nYou\'re my lady baby', 9, 8, 224);
/*!40000 ALTER TABLE `musica` ENABLE KEYS */;


-- Copiando estrutura para tabela memes.participa
DROP TABLE IF EXISTS `participa`;
CREATE TABLE IF NOT EXISTS `participa` (
  `Musica_idMusica` int(11) NOT NULL,
  `Artista_idArtista` int(11) NOT NULL,
  `papel` varchar(12) NOT NULL,
  PRIMARY KEY (`Musica_idMusica`,`Artista_idArtista`),
  KEY `fk_Musica_has_Artista_Artista1_idx` (`Artista_idArtista`),
  KEY `fk_Musica_has_Artista_Musica1_idx` (`Musica_idMusica`),
  CONSTRAINT `fk_Musica_has_Artista_Artista1` FOREIGN KEY (`Artista_idArtista`) REFERENCES `artista` (`idArtista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Musica_has_Artista_Musica1` FOREIGN KEY (`Musica_idMusica`) REFERENCES `musica` (`idMusica`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela memes.participa: ~22 rows (aproximadamente)
DELETE FROM `participa`;
/*!40000 ALTER TABLE `participa` DISABLE KEYS */;
INSERT INTO `participa` (`Musica_idMusica`, `Artista_idArtista`, `papel`) VALUES
	(1, 1, 'Intérprete'),
	(2, 2, 'Intérprete'),
	(11, 5, 'Intérprete'),
	(12, 4, 'Intérprete'),
	(13, 1, 'Intérprete'),
	(14, 1, 'Intérprete'),
	(15, 1, 'Intérprete'),
	(16, 1, 'Intérprete'),
	(17, 1, 'Intérprete'),
	(18, 1, 'Intérprete'),
	(19, 1, 'Intérprete'),
	(20, 1, 'Intérprete'),
	(21, 1, 'Intérprete'),
	(22, 4, 'Intérprete'),
	(23, 4, 'Intérprete'),
	(24, 4, 'Intérprete'),
	(24, 7, 'Participante'),
	(25, 4, 'Intérprete'),
	(26, 4, 'Intérprete'),
	(27, 4, 'Intérprete'),
	(28, 4, 'Intérprete'),
	(29, 4, 'Intérprete');
/*!40000 ALTER TABLE `participa` ENABLE KEYS */;


-- Copiando estrutura para tabela memes.score
DROP TABLE IF EXISTS `score`;
CREATE TABLE IF NOT EXISTS `score` (
  `idScore` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuarioScore` int(11) NOT NULL,
  `idMusicaScore` int(11) NOT NULL,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`idScore`),
  KEY `idUsuarioScore` (`idUsuarioScore`),
  KEY `idMusicaScore` (`idMusicaScore`),
  CONSTRAINT `idMusicaScore` FOREIGN KEY (`idMusicaScore`) REFERENCES `musica` (`idMusica`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idUsuarioScore` FOREIGN KEY (`idUsuarioScore`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela memes.score: ~8 rows (aproximadamente)
DELETE FROM `score`;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` (`idScore`, `idUsuarioScore`, `idMusicaScore`, `data`) VALUES
	(16, 15, 13, '2017-11-10 10:48:19'),
	(17, 15, 1, '2017-11-10 10:54:33'),
	(18, 15, 2, '2017-11-10 10:54:49');
/*!40000 ALTER TABLE `score` ENABLE KEYS */;


-- Copiando estrutura para tabela memes.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `idR` varchar(45) NOT NULL,
  `tipo` tinyint(4) NOT NULL DEFAULT '0',
  `perfil` text NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `idR` (`idR`)
) ENGINE=InnoDB AUTO_INCREMENT=418 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela memes.usuario: ~4 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idUsuario`, `email`, `idR`, `tipo`, `perfil`) VALUES
	(15, 'noubmaster@gmail.com', '114906338798410851834', 2, 'https://lh4.googleusercontent.com/-36es8WyUfY0/AAAAAAAAAAI/AAAAAAAAAMw/KTD0N0D7HzA/s96-c/photo.jpg'),
	(19, 'thenuubgamer@gmail.com', '108493248676886266125', 2, 'https://lh5.googleusercontent.com/-yDJi2MiItnA/AAAAAAAAAAI/AAAAAAAAAAA/ACnBePbqzr0wz0KkYzcoRMi2v_9AINnHjA/s96-c/photo.jpg'),
	(76, 'elishaphp@gmail.com', '107170213645449942722', 1, 'https://lh5.googleusercontent.com/-eTfe1uR0mnE/AAAAAAAAAAI/AAAAAAAAAHw/w1BgcRuJhT0/s96-c/photo.jpg'),
	(90, 'eliseuphp@gmail.com', '112355985130332857702', 0, 'https://lh3.googleusercontent.com/-snpJLNdEd6U/AAAAAAAAAAI/AAAAAAAAAAA/ACnBePbyntDY-nS4Z_lMbSjJToCLirOF7w/s96-c/photo.jpg');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
