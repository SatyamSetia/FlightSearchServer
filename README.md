# FlightSearchServer

MySQL workbench 8.0 is used in this project. And below are the required sql queries to run before running this project.

**creating database:**

CREATE DATABASE `flightdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;`


**creating table with name flights_table:**

CREATE TABLE `flights_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flight_no` varchar(45) NOT NULL,
  `departure_loc` varchar(45) NOT NULL,
  `arrival_loc` varchar(45) NOT NULL,
  `valid_till` date NOT NULL,
  `flight_dep_time` time NOT NULL,
  `flight_arr_time` time NOT NULL,
  `fare` float NOT NULL,
  `seat_availability` varchar(1) NOT NULL,
  `travel_class` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


**inserting data into table:**

INSERT INTO `flightdb`.`flights_table`
(`id`,
`flight_no`,
`departure_loc`,
`arrival_loc`,
`valid_till`,
`flight_dep_time`,
`flight_arr_time`,
`fare`,
`seat_availability`,
`travel_class`)
VALUES
('1', 'AI277', 'DEL', 'MUB', '2013-12-05', '06:00:00', '10:10:00', '5500', 'Y', 'E'
),
('2', 'AI279', 'MUB', 'HYD', '2013-12-07', '12:00:00', '14:00:00', '3500', 'Y', 'EB'
),
('3', 'AI289', 'DEL', 'MUB', '2013-12-10', '08:00:00', '11:30:00', '6000', 'Y', 'EB'
),
('4', 'AI290', 'DEL', 'MUB', '2013-12-25', '02:30:00', '05:00:00', '3000', 'Y', 'E'
),
('5', 'AI291', 'DEL', 'MUB', '2013-12-18', '00:30:00', '01:30:00', '7000', 'Y', 'EB'
);


**creating table with name currency_table:**

CREATE TABLE `currency_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(45) NOT NULL,
  `country_code` varchar(45) NOT NULL,
  `conversion_rate` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


**inserting data into currency_table:**

INSERT INTO `flightdb`.`currency_table`
(`id`,
`country_name`,
`country_code`,
`conversion_rate`)
VALUES
('1', 'India', 'IN', '1'
),
('2', 'USA', 'US', '0.014'
),
('3', 'Australia', 'AU', '0.019'
),
('4', 'Pakistan', 'PK', '1.69'
);
