docker rm pg 
docker build . -f Dockerfile-northwind -t pg-service:latest 
docker run --publish 5432:5432 --name pg pg-service:latest
