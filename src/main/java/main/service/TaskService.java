package main.service;

import main.model.Task;
import main.model.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService{

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Task createNewTask(String title, String description){
        if (title.length() == 0 || description.length() == 0){
            return null;
        }
        return taskRepository.save(new Task(title, description));
    }

    public Task getTaskById(int id){
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.orElse(null);
    }

    public List<Task> getTasksList(){
        List<Task> tasksList = new ArrayList<>();
        Iterable<Task> taskIterable = taskRepository.findAll();
        taskIterable.forEach(tasksList::add);

        return tasksList;
    }

    public boolean deleteTaskById(int id){
        Task task = getTaskById(id);
        if (task == null){
            return false;
        }
        taskRepository.delete(task);
        return true;
    }

    public boolean updateTaskData(int id, String title, String description, Boolean isDone){
        Task task = getTaskById(id);
        if (task == null){
            return false;
        }

        if (title != null) {
            task.setTitle(title);
        }
        if (description != null) {
            task.setDescription(description);
        }
        if (isDone != null) {
            task.setIsDone(isDone);
        }

        taskRepository.save(task);
        return true;
    }
}
