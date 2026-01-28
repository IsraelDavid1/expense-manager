<a id="readme-top"></a>


[![LinkedIn][linkedin-shield]][linkedin-url]






<h3 align="center">expense-manager</h3>

  <p align="center">
    An expense management application that allows users to track, manage, and analyze personal expenses.
    <br />
    <a href="https://github.com/IsraelDavid1/expense-manager"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://expense-manager-frontend.onrender.com/">View Demo</a>
    &middot;
    <a href="https://github.com/IsraelDavid1/expense-manager/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    &middot;
    <a href="https://github.com/IsraelDavid1/expense-manager/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>




<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#API">API Endpoints</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



## About The Project

This is my first fullstack project and also my first Java web application. The idea came from a personal need to better manage expenses, since manually writing and calculating everything took a lot of time.

The goal of this project is to provide a simple and intuitive way to manage personal finances, allowing users to register expenses, view summaries, and organize their financial data.


### Built With

- `Java`
- `Spring Boot`
- `Flyway`
- `JWT Authentication`
- `AUTH0`
- `PostgreSQL`
- `Lombok`

<p align="right">(<a href="#readme-top">back to top</a>)</p>




## Getting Started

First get a local copy of the backend of this project.
```bash
gh repo clone IsraelDavid1/expense-manager
```

### Prerequesites

- Install Java JDK 21 version in [oracle](https://www.oracle.com/java/technologies/downloads/).
- Have an IDE that work with java, I recommend [Intellij](https://www.jetbrains.com/pt-br/idea/download/?section=windows).
- Have a database manager, I recommend [PostgreSQL](https://www.postgresql.org/).
- Get the frontend repo i made for this [expense-manager-frontend](https://github.com/IsraelDavid1/expense-manager-frontend) or use [Insomnia](https://insomnia.rest/download), [Postman](https://www.postman.com/) or any other platform to test APIs that you like.

### Installation

1. Clone the repo
   ```bash
   gh repo clone IsraelDavid1/expense-manager
   ```
2. Add path/environment variable for:
   - DB_URL
   - DB_USER
   - DB_PASSWORD
   - JWT_SECRET
3. Create a user in your database manager

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Usage

This API allows authenticated users to:
- Register and authenticate users using JWT
- Create, update and delete expenses
- Retrieve all expenses for the authenticated user
- Filter expenses by date range
- Secure all endpoints using role-based access control


## API Endpoints

### Authentication
- POST /auth/register
- POST /auth/login

### Expenses
- GET /expenses
- POST /expenses
- PATCH /expenses/{id}
- DELETE /expenses/{id}
- POST /expenses/date
- GET /expenses/moneyleft

### User

- PATCH /home
- DELETE /home

### Admin

- DELETE /admin/users/{userToDelete}

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## License

Distributed under the project_license. See `LICENSE.txt` for more information.


## Contact

Israel David - israeldiv100@gmail.com

Project Link [https://github.com/IsraelDavid1/expense-manager](https://github.com/IsraelDavid1/expense-manager)

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- Shields.io badges. You can a comprehensive list with many more badges at: https://github.com/inttter/md-badges -->
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/israel-david-da-silva/



