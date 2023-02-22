USE PersonsDB;
SELECT domains.id, domains.webname, domains.domainname, domains.ip, domains.datereg, domains.countryreg, domains.personid
FROM domains WHERE domains.personid="4";