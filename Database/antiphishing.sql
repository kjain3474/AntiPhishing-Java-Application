--
-- Database: `antiphishing`
--

-- --------------------------------------------------------

--
-- Table structure for table `mail`
--

CREATE TABLE `mail` (
  `mid` int(11) NOT NULL,
  `fr` text NOT NULL,
  `subject` text NOT NULL,
  `date` text NOT NULL,
  `content` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mail`
--

INSERT INTO `mail` (`mid`, `fr`, `subject`, `date`, `content`) VALUES
(0, 'Yash Pilankar <sales@textlocal.in>', 'Thanks for referring your friend to Textlocal!', 'Fri Mar 30 15:05:44 IST 2018', 'multipart/ALTERNATIVE; \r\n	boundary=a2cdb2f187825ea02d2315cbb8fbe1fc0bbea6610b463e5ca871615fa2cf'),
(1, 'kapil jain <kjain3474@gmail.com>', 'null', 'Sat Mar 19 11:22:35 IST 2016', 'multipart/ALTERNATIVE; boundary=001a11464df668cfc5052e6078c8');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `rid` int(11) NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `fname` text NOT NULL,
  `lname` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`rid`, `email`, `password`, `fname`, `lname`) VALUES
(1, 'abc@gmail.com', 'qwerty', 'abc', 'abc'),
(2, 'antiphishing544@gmail.com', '@ntiPhishing', 'yash', 'pilankar');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mail`
--
ALTER TABLE `mail`
  ADD PRIMARY KEY (`mid`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`rid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `rid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
