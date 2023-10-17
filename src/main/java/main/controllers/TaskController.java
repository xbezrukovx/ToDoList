package main.controllers;

import main.model.Task;
import main.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(
            value="/",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Void> add(
            @RequestBody Task taskBody
    ){
        Task task = taskService.createNewTask(taskBody.getTitle(), taskBody.getDescription());
        if (task != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> get(@PathVariable int id){
        Task task = taskService.getTaskById(id);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Task>> getList(){
        List<Task> result = taskService.getTasksList();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        boolean isDeleted = taskService.deleteTaskById(id);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Void> patch(
            @PathVariable int id,
            @RequestBody Task taskData
    ){
        boolean isUpdated = taskService.updateTaskData(
                id,
                taskData.getTitle(),
                taskData.getDescription(),
                taskData.getIsDone()
        );
        if (!isUpdated) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
