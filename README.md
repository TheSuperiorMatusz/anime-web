# Animeweb
Animeweb is my side project which I' m doing in my free time. I enjoy watching anime and reading manga in my spare time,
so the idea for manga site came naturally. The project is modeled after [myanimelist](https://myanimelist.net/) and the polish movie site [Filmweb](https://www.filmweb.pl/). 
By creating this project I would like to learn new tools and consolidate the knowledge I have. In the moment I started backend in the near future I will be working on 
front-end side. If you happened to find a bug or want to help me you write in issues tab what's going on.

## Tech Stack
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=plastic&logo=Java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=plastic&logo=spring&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=plastic&logo=Apache%20Maven&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=plastic&logo=postgresql&logoColor=white)

### Required software
- Java 17
- PostgreSQL ***version*** 15


To run PostgreSQL database type:
```bash
  docker run -dp 5432:5432 --name anime_web -e POSTGRES_PASSWORD=123 -d postgres
```