docker exec -it postgres sh -c 'PGPASSWORD=secret psql -U myuser -d mydatabase -c "SELECT * FROM category;"'
