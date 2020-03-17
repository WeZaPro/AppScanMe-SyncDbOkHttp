-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 16, 2020 at 06:47 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_product`
--

CREATE TABLE `tbl_product` (
  `id` int(11) NOT NULL,
  `product_id` varchar(100) NOT NULL,
  `product_name` varchar(400) NOT NULL,
  `product_image` varchar(400) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_product`
--

INSERT INTO `tbl_product` (`id`, `product_id`, `product_name`, `product_image`) VALUES
(1, 'A001', 'Product-001', 'https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/iphone11-red-select-2019?wid=834&hei=1000&fmt=jpeg&qlt=95&op_usm=0.5,0.5&.v=1566956144763'),
(2, 'A002', 'Product-002', 'https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/MXHW2_AV1?wid=1144&hei=1144&fmt=jpeg&qlt=80&op_usm=0.5,0.5&.v=1572398073879'),
(3, 'A003', 'Product-003', 'https://www.lactasoy.com/th/wp-content/uploads/2020/01/lactasoy_prompt_product1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_product_sequence`
--

CREATE TABLE `tbl_product_sequence` (
  `id` int(11) NOT NULL,
  `product_id` varchar(100) NOT NULL,
  `lat` varchar(400) NOT NULL,
  `lon` varchar(400) NOT NULL,
  `token` varchar(400) NOT NULL,
  `dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tb_mem`
--

CREATE TABLE `tb_mem` (
  `mem_id` int(5) NOT NULL,
  `mem_name` varchar(50) NOT NULL,
  `mem_lastname` varchar(50) NOT NULL,
  `age` varchar(3) NOT NULL,
  `image_url` varchar(400) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_mem`
--

INSERT INTO `tb_mem` (`mem_id`, `mem_name`, `mem_lastname`, `age`, `image_url`) VALUES
(1, 'we1', 'la1', '21', 'https://www.lactasoy.com/th/wp-content/uploads/2020/01/lactasoy_prompt_product1.jpg'),
(2, 'we2', 'la2', '42', 'https://acerthailand.com/wp-content/uploads/2016/01/shop-product-image-9-gallery-1.jpg'),
(3, 'we3', 'la3', '43', 'https://acerthailand.com/wp-content/uploads/2016/01/shop-product-image-9-gallery-1.jpg'),
(4, 'we4', 'yu4', '44', 'https://th.canon/media/image/2018/05/03/642e7bbeae5741e3b872e082626c0151_eos6d-mkii-ef-24-70m-l.png'),
(5, 'we5', 'la5', '55', 'https://methodhome.com/wp-content/uploads/laundry_p-v2-500x500.png'),
(6, 'we6', 'la6', '46', 'https://www.lactasoy.com/th/wp-content/uploads/2020/01/lactasoy_prompt_product1.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_product`
--
ALTER TABLE `tbl_product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_product_sequence`
--
ALTER TABLE `tbl_product_sequence`
  ADD KEY `id` (`id`);

--
-- Indexes for table `tb_mem`
--
ALTER TABLE `tb_mem`
  ADD PRIMARY KEY (`mem_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_product`
--
ALTER TABLE `tbl_product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tb_mem`
--
ALTER TABLE `tb_mem`
  MODIFY `mem_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_product_sequence`
--
ALTER TABLE `tbl_product_sequence`
  ADD CONSTRAINT `tbl_product_sequence_ibfk_1` FOREIGN KEY (`id`) REFERENCES `tbl_product` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
