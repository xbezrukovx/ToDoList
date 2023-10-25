# ToDoList
This small application helps create, store, edit, delete tasks. 
The project was created to practice using Spring Boot.
## ✨ Features
- Adding a new task.
- Getting tasks by requesting a task by ID or getting list of tasks.
- Ability to change or delete a task.

## 🛠️ Technologies
- Java
- Spring Boot
- MySQL

## 🔑 API Specification
### Methods
The application has several methods which are given below:
| Method    | URL                           | Description                                         |
| --------- | ----------------------------- | --------------------------------------------------- |
| `GET`     | `/tasks`                      | Returns list of tasks.        |
| `POST`    | `/tasks`                      | Creates a new task.           |
| `GET`     | `/tasks/{id}`                 | Fetches a task by id.         |
| `DELETE`  | `/tasks/{id}`                 | Removes a task by id.         |
| `PATCH`   | `/tasks/{id}`                 | Updates a task information.   |
#### `GET` /tasks
Example of a response:
```
{[
    {
        'id': 1,
        'creationTime': "13-01-2017 17:09:42",
        'isDone': false,
        'title': "Wash a car",
        'description': "Some description"
    }, 
    ...
]}
```
#### `POST` /tasks
Input parameters:
| Type      | Name              | Nullable | Description                    | Example           |
| --------- | ----------------- | -------- | ------------------------------ | ----------------- |
| `String`  | `title`           | `true`   | A task title.                  | Wash a car.       |
| `String`  | `description`     | `true`   | A description of given task.   | Some description. |

#### `GET` /tasks/{id}
Input parameters:
| Type      | Name      | Nullable  | Description         | Example           |
| --------- | --------- | --------- | ------------------- | ----------------- |
| `Integer` | `id`      | `false`   | Task Id             | 1                 |

Example of successful response:
```
{
    'id': 1,
    'creationTime': "13-01-2017 17:09:42",
    'isDone': false,
    'title': "Wash a car",
    'description': "Some description"
}
```

#### `DELETE` /tasks/{id}
Input parameters:
| Type      | Name      | Nullable  | Description         | Example           |
| --------- | --------- | --------- | ------------------- | ----------------- |
| `Integer` | `id`      | `false`   | Task Id             | 1                 |

#### `PATCH` /tasks/{id}
Input parameters:
| Type      | Name          | Nullable  | Description                             | Example           |
| --------- | ------------- | --------- | --------------------------------------- | ----------------- |
| `Integer` | `id`          | `false`   | Task Id.                                | 1                 |
| `Boolean` | `isDone`      | `true`    | Status.                                 | true              |
| `String`  | `title`       | `true`    | A task title.                           | Wash another car  |
| `String`  | `description` | `true`    | A description of given task.            | Another desc.     |

## Author
### 👤 **Denis Bezrukov**
- Email: [ds.bezrukov@icloud.com](mailto:ds.bezrukov@icloud.com)
- Telegram: [@x_bezrukov_x](https://t.me/x_bezrukov_x)
- Github: [@xbezrukovx](https://github.com/xbezrukovx)
