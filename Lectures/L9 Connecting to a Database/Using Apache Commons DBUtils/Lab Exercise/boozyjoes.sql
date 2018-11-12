CREATE Database IF NOT EXISTS boozyjoes;
USE boozyjoes;


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `boozyjoes`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Price` double NOT NULL,
  `Description` text NOT NULL,
  `QtyOnHand` int(11) NOT NULL,
  `ReorderQty` int(11) NOT NULL,
  `QtySold` int(5) NOT NULL,
  `Image` text,
  `ABV` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`ID`, `Name`, `Price`, `Description`, `QtyOnHand`, `ReorderQty`, `QtySold`, `Image`, `ABV`) VALUES
(1, '8 Degrees Sunburnt Irish Red', 1.55, 'Like an Irishman on holiday in the Canaries, this beer has a red tint but with a chilled out mellow feel.A traditional Irish style with a twist, it has subtle caramel notes balanced with a pleasant fragrant aroma from New Zealand and Australian hops. Goes really well with roast beef, lamb or a traditional Irish stew, but beware: keep out of direct sunlight.', 66, 100, 651, '1.jpg', '5%'),
(2, 'O\' Haras Irish Stout', 2.5, 'Think of Irish beers and you think of Stout! Drink an O’Hara’s and you are drinking a “True Irish Stout”! Carrying the family name of the brewery founders, this multi-award winning traditional dry Irish stout, deep black colour with a reddish hue when held to the light, pours with a thick creamy head that is almost tan in colour. The Irish Times wrote of O’Hara’s, “...anyone with a stout memory will find that the crispness and lucidity of O’Hara’s evokes the pleasures of nostalgia almost as much as the pleasure of drinking. This award-winning full-bodied and luxuriously smooth dry Irish Stout brings one back to how Irish stouts used to taste”.', 10, 50, 765, '2.jpg', '4.3%'),
(3, 'Tom Crean\'s Premium Irish Lager', 2.99, 'Tom Crean’s Premium Irish Lager is great with music, great with company and great with all kinds of food. Asian, Burgers, Pub Grub and particularily Seafood all work very well with our lager. Crean’s is light on the palatte and highlights the flavours of food without being overpowering.', 100, 100, 112, '3.jpg', '4.3%'),
(4, 'Bo Bristles IPA', 2.55, 'The IPA is the flagship Bo Bristle brew. The recipe was crafted over a number of years by our master brewer. The IPA balances passionfruit & tropical fruit hops with biscuity marris otter malts to create the distinctive Bo Bristle taste. ', 20, 25, 232, NULL, '5%'),
(5, 'Bo Bristles Amber Ale', 2.99, 'Our Amber Ale is the latest brew from the Bo Bristle brewery. It\'s rich amber colour is achieved through a brew of the finest American citrus hops infused with fine malted barley. The result needs to be tasted for itself. ', 40, 55, 232, '5.gif', '5%'),
(6, 'Bo Bristles Pilsner Ale', 2.99, 'A refreshing, medium-full bodied beer using tangy Czech varieties of hops that impart floral aromas and a crisp, bitter finish with a dense, white head…watch this space! ', 20, 50, 232, '6.gif', '5%'),
(7, 'Bo Bristles Red Ale', 2.99, 'A special edition Red Ale which is a medium light to medium body smooth, rich red ale full of flavour with a slight caramel taste. The perfect beer for summer barbecues! ', 40, 55, 234, '7.gif', '5%'),
(8, '8 Degrees Howling Gale Ale', 1.55, 'Like blitzing down the Ballyhouras on your bike with an icy wind in your face, this delivers a refreshing crisp smack around the gills. It pours a pale golden colour and the malty sweetness is well balanced by the American Chinook, Amarillo and Centennial hops.\r\nHowling Gale has a pleasant grapefruit and citrus aroma and goes well with fish, chicken or anything off the barbeque.', 100, 100, 8767, '8.jpg', '5%'),
(9, '8 Degrees Knockmealdown Porter', 1.55, 'Like tackling the Knockmealdowns in a blizzard, this beer is not for wimps. Our evolution of the traditional Irish stout, it resembles a Victorian-era Irish porter and provides complex dark malt characteristics with distinctive espresso flavours. Without the weight of a stout, the porter is well rounded with mellow English hops.', 80, 100, 9331, NULL, '5%'),
(10, '8 Degrees Barefoot Bohemian Pilsner Lager', 1.55, 'Bohemians are creative dreamers who defy convention. Our Bohemian Pilsner is just that, an unorthodox lager with complex biscuity malt, soft rounded bitnerness and a twist of spice from the noble Saaz and Hallertau hops. This crisp and adventurous drop is perfect for a chilled out summer session…bliss. Originally our 2012 Summer seasonal beer, it has been added to our core range due to its immense popularity – some would also argue that we are still waiting for our 2012 summer. This is pilsner like the Czechs intended.', 20, 50, 7651, '10.jpg', '5%'),
(11, '8 Degrees Winters Ale', 2.55, 'We have developed this beer in collaboration with local spice specialists Green Saffron, producing a rich ale that will warm you up from the inside. Crystal and Munich malts are complimented with Fuggles hops, dessicated orange peel, cloves and cinnamon.\r\n\r\nBest sipped s-l-o-w-l-y next to a roaring fire.\r\n\r\nSnow optional.', 10, 30, 3221, '11.jpg', '8%'),
(12, 'Beoir Chorca Dhuibhne Carraig Dubh', 3.5, 'A rich choclate porter', 10, 15, 2311, '12.jpg', '6.5%'),
(13, 'O\'Haras Leann Follain', 2.5, 'O’Hara’s Leann Folláin (”leann folláin” being the Gaelic/Irish phrase meaning wholesome ale or stout) is a full-bodied extra Irish stout launched in 2009 following the very positive feedback to our limited edition O’Hara’s Celebration Extra Stout which was brewed in 2008. We have now included “Leann Folláin” in our 500ml bottle core brand range. O’Hara’s Leann Folláin at 6.0% abv is laden with complex chocolate and coffee flavours balanced by a robust bitterness and delicate spicy aroma imparted from the generous portions of Northdown and Fuggle Hops.', 40, 55, 2342, '13.jpg', '6%'),
(14, 'O\'Haras Curim', 2.5, 'The name “Curim” was inspired by an old Celtic word for beer and echoes the Celtic heritage of the place where Curim is brewed today.\r\nCurim Gold has a higher hop rate than mainstream wheat beers and was critically acclaimed by the late Michael Jackson when he selected it amongst his top 10 favourite wheat beers in the world ', 20, 50, 724, '14.jpg', '6%');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
