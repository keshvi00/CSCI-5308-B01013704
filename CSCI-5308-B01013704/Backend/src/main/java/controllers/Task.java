import java.time.LocalDateTime;

public class Task {
    private int taskId;
    private String title;
    private String description;
    private String assignedTo;
    private TaskStatus status;
    private LocalDateTime dueDate;

    public Task(int taskId, String title, String description, LocalDateTime dueDate) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = TaskStatus.TODO;
    }

    public void assignTo(String teamMember) {
        this.assignedTo = teamMember;
    }

    public void updateStatus(TaskStatus newStatus) {
        if (status == TaskStatus.TODO && newStatus == TaskStatus.IN_PROGRESS) {
            this.status = newStatus;
        } else if (status == TaskStatus.IN_PROGRESS && newStatus == TaskStatus.COMPLETED) {
            this.status = newStatus;
        }
    }

    public boolean isOverdue() {
        return LocalDateTime.now().isAfter(dueDate);
    }

    public String getAssignedTo() { return assignedTo; }
    public TaskStatus getStatus() { return status; }
}
