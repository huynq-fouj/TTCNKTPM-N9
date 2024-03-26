## Demo

## Technologies

<div style="display: flex; align-items: center; justify-content: center">
<img src="https://user-images.githubusercontent.com/25181517/183897015-94a058a6-b86e-4e42-a37f-bf92061753e5.png" alt="" width="40"/>
<img src="https://github.com/marwin1991/profile-technology-icons/assets/62091613/b40892ef-efb8-4b0e-a6b5-d1cfc2f3fc35" alt="" width="40"/>
<img src="https://user-images.githubusercontent.com/25181517/183898054-b3d693d4-dafb-4808-a509-bab54cf5de34.png" alt="" width="40"/>
<img src="https://user-images.githubusercontent.com/25181517/183891303-41f257f8-6b3d-487c-aa56-c497b880d0fb.png" alt="" width="40"/>
<img src="https://user-images.githubusercontent.com/25181517/117207242-07d5a700-adf4-11eb-975e-be04e62b984b.png" alt="" width="70"/>
<img src="https://user-images.githubusercontent.com/25181517/183896128-ec99105a-ec1a-4d85-b08b-1aa1620b2046.png" alt="" width="70"/>
</div>

## Getting Started
### Download from Github
Clone the repository:
 ```bash
> git clone https://github.com/huynq-fouj/TTCNKTPM-N9
```
### Frontend

Run the development server:
```cmd
cd frontend
```
```
npm install
```
```
npm run dev
```
Open http://localhost:3000 with your browser to see the result.
### Backend

Configure the database by editing the src/main/resources/application.properties file with your MySQL connection details:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306//your-schema-name
spring.datasource.username=your-username
spring.datasource.password=your-password
```
Run the application:
```cmd
cd backend
```
```
# Install the dependencies
mvn clean install
```
```
mvn spring-boot:run
```
Your application will run at http://localhost:8080