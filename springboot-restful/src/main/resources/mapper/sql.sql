MariaDB [springbootdb]>
MariaDB [springbootdb]> select * from city;
+----+-------------+-----------+------------------------------+
| id | province_id | city_name | description                  |
+----+-------------+-----------+------------------------------+
|  1 |           1 | Shang Hai | Most Largest City of China   |
|  2 |           2 | Bei Jing  | Header City of China         |
|  3 |           3 | Xi An     | Most Priceless City of China |
+----+-------------+-----------+------------------------------+
3 rows in set (0.00 sec)

MariaDB [springbootdb]>
MariaDB [springbootdb]>
MariaDB [springbootdb]> alter table city modify id int(16) auto_increment primary key;
Query OK, 0 rows affected (0.04 sec)
Records: 0  Duplicates: 0  Warnings: 0

MariaDB [springbootdb]>
MariaDB [springbootdb]>
MariaDB [springbootdb]> desc city;
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | int(16)      | NO   | PRI | NULL    | auto_increment |
| province_id | int(16)      | YES  |     | NULL    |                |
| city_name   | varchar(32)  | YES  |     | NULL    |                |
| description | varchar(128) | YES  |     | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)

MariaDB [springbootdb]>
MariaDB [springbootdb]>
