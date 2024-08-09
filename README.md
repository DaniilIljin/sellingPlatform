docker compose:

start: docker compose up --build -d
stop: docker compose down -v   

frontend:

start: npm run dev
end: cntrl + c