# Meetings
### Client 
|command|description|
|---|---|
|`npm install`| Install all dependencies|
|`npm run start`| Run client dev_server on the port: 8089|
|`npm run build`|	Create bundled files|

### Server
* Runs on the port: 8080

***
### Meetings API 


#### Adds booking request to the database table `booking_requests`  
* **URL**

  `api/booking/add`   
* **Method**

  `POST`
* **BODY**
```json
{
    "id": 0,
    "employee": "EMP1",
    "requestTime": "2017-09-03 16:27:32",
    "meetingTime": "2017-09-03 04:09:00",
    "meetingDuration": 1
}
```


#### Adds booking request to the database table `booking_requests`, converts request to meeting and adds it to table `meetings` if it satisfies the conditions.  
* **URL**

  `api/meeting/add/request`   
* **Method**

  `POST`
* **BODY**
```json
{
    "id": 0,
    "employee": "EMP1",
    "requestTime": "2017-09-03 16:27:32",
    "meetingTime": "2017-09-03 04:09:00",
    "meetingDuration": 1
}
```


#### Converts all booking requests to meetings and if they satisfy the conditions adds them (meetings) to the database table `meetings`, does not change the `booking_requests` table.  
* **URL**

  `api/meeting/add/requests/json`   
* **Method**

  `POST`
* **BODY**
```json
[
  {
        "id": 0,
        "employee": "EMP1",
        "requestTime": "2017-09-03 16:27:32",
        "meetingTime": "2017-09-03 00:05:00",
        "meetingDuration": 1
    },
    {
        "id": 0,
        "employee": "EMP2",
        "requestTime": "2017-09-03 16:27:32",
        "meetingTime": "2017-09-03 01:06:00",
        "meetingDuration": 1
    },
    {
        "id": 0,
        "employee": "EMP3",
        "requestTime": "2017-09-03 16:27:32",
        "meetingTime": "2017-09-03 02:07:00",
        "meetingDuration": 1
    },
    {
        "id": 0,
        "employee": "EMP1",
        "requestTime": "2017-09-03 16:27:32",
        "meetingTime": "2017-09-03 03:08:00",
        "meetingDuration": 1
    }
]
```


#### Gets all booking requests ordered by request time from table `booking_requests`, converts them to meetings and adds to `meetings` table.

* **URL**

  `api/meeting/add/requests/db`   
* **Method**

  `POST`
* **BODY**

   `-`

#### Gets all booking requests ordered by request time from table `booking_requests`

* **URL**

  `api/request/all`   
* **Method**

  `GET`


#### Gets all meeting ordered by start time from table `meetings`

* **URL**

  `api/meeting/all`   
* **Method**

  `GET`





