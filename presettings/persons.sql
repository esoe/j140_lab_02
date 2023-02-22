USE PersonsDB;

SELECT person.id, person.jobtitle, person.firstnamelastname, person.phone, person.email, COUNT(domains.personid)
FROM person INNER JOIN domains ON domains.personid = person.id
GROUP BY person.id;