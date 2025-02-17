UPDATE `person`
SET `birthday` = '2025-01-01 00:00:00'
WHERE `birthday` IS NULL;

ALTER TABLE `person`
MODIFY COLUMN `birthday` DATETIME(6) NOT NULL;